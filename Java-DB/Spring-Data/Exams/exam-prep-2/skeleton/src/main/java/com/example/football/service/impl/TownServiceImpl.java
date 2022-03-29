package com.example.football.service.impl;

import com.example.football.models.dto.TownSeedDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
public class TownServiceImpl implements TownService {

    private static final String TEAMS_FILE_PATH = "/Users/denisdanailov/IdeaProjects/exam-prep-2/skeleton/src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {

        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder outputMsg = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownSeedDTO[].class))
                .filter(townSeedDTO -> {
                    boolean isValid = validationUtil.isValid(townSeedDTO);

                    outputMsg.append(isValid ? String.format("Successfully imported Town %s - %o", townSeedDTO.getName(), townSeedDTO.getPopulation())
                            : "Invalid Town").append(System.lineSeparator());

                    return isValid;
                })
                .map(townSeedDTO ->

                        modelMapper.map(townSeedDTO, Town.class))
                .forEach(townRepository::save);


        return outputMsg.toString().trim();
    }

    @Override
    public Town findByName(String name) {
        return townRepository.findByName(name);
    }
}
