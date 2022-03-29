package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDTO;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TeamServiceImpl implements TeamService {

    private static final String TEAM_FILE_PATH = "/Users/denisdanailov/IdeaProjects/exam-prep-2/skeleton/src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final TownService townService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public TeamServiceImpl(TeamRepository teamRepository, TownService townService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.teamRepository = teamRepository;
        this.townService = townService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAM_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder outputMsg = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamSeedDTO[].class))
                .filter(teamSeedDTO -> {
                    boolean isValid = validationUtil.isValid(teamSeedDTO);

                    outputMsg.append(isValid ? String.format("Successfully imported Team %s - %o", teamSeedDTO.getName(), teamSeedDTO.getFanBase())
                            : "Invalid Team").append(System.lineSeparator());
                    return isValid;
                }).map(teamSeedDTO -> {
                    Team team = modelMapper.map(teamSeedDTO, Team.class);

                    team.setTown(townService.findByName(teamSeedDTO.getTownName()));

                    return team;
                })
                .forEach(teamRepository::save);

        return outputMsg.toString().trim();
    }

    @Override
    public Team findByName(String name) {
        return this.teamRepository.findByName(name);
    }
}
