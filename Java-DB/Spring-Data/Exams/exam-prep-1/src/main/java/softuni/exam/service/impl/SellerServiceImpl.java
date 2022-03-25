package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerSeedRootDTO;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {

    private static final String SELLERS_FILE_PATH = "src/main/resources/files/xml/sellers.xml";

    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {

        StringBuilder outputMsg = new StringBuilder();

        xmlParser.fromFile(SELLERS_FILE_PATH, SellerSeedRootDTO.class)
                .getSellers()
                .stream()
                .filter(sellerSeedDTO -> {

                    boolean isValid = validationUtil.isValid(sellerSeedDTO);

                    outputMsg.append(isValid ? String.format("Successfully import seller %s - %s", sellerSeedDTO.getLastName(), sellerSeedDTO.getEmail())
                            : "Invalid seller").append(System.lineSeparator());


                    return isValid;
                }).map(sellerSeedDTO -> modelMapper.map(sellerSeedDTO, Seller.class))
                .forEach(sellerRepository::save);

        return outputMsg.toString();
    }

    @Override
    public Seller finById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }
}
