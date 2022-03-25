package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PictureSeedDTO;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String FILE_PICTURES_PATH = "src/main/resources/files/json/pictures.json";

    private final PictureRepository pictureRepository;
    private final CarService carService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, CarService carService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.carService = carService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(FILE_PICTURES_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        PictureSeedDTO[] pictureSeedDTOS = gson.fromJson(readPicturesFromFile(), PictureSeedDTO[].class);

        StringBuilder outputMsg = new StringBuilder();

        Arrays.stream(pictureSeedDTOS)
                .filter(pictureSeedDTO -> {
                    boolean isValid = validationUtil.isValid(pictureSeedDTO);

                    outputMsg.append(isValid ? String.format("Successfully import picture - %s",pictureSeedDTO.getName())
                            : "Invalid picture").append(System.lineSeparator());

                    return isValid;

                }).map(pictureSeedDTO -> {
                   Picture picture = modelMapper.map(pictureSeedDTO, Picture.class);
                   picture.setCar(carService.findById(pictureSeedDTO.getCar()));

                   return picture;

                })
                .forEach(pictureRepository::save);

        return outputMsg.toString();
    }
}
