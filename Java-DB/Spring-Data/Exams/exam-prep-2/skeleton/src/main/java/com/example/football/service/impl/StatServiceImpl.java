package com.example.football.service.impl;

import com.example.football.models.dto.StatRootDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    private static final String STATS_FILE_PATH = "/Users/denisdanailov/IdeaProjects/exam-prep-2/skeleton/src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public StatServiceImpl(StatRepository statRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder outputMsg = new StringBuilder();

        xmlParser.fromFile(STATS_FILE_PATH, StatRootDTO.class)
                .getStats()
                .stream()
                .filter(statDTO -> {
                    boolean isValid = validationUtil.isValid(statDTO);

                    outputMsg.append(isValid ? String.format("Successfully imported Stat  - %.2f - %.2f", statDTO.getPassing(), statDTO.getShooting(), statDTO.getEndurance())
                            : "Invalid Stat").append(System.lineSeparator());

                    return isValid;
                }).map(statDTO -> modelMapper.map(statDTO, Stat.class))
                .forEach(statRepository::save);


        return outputMsg.toString().trim();
    }

    @Override
    public Stat findById(long id) {
        return this.statRepository.findById(id).orElse(null);
    }
}














