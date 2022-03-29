package com.example.football.service.impl;

import com.example.football.models.dto.PlayerRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "/Users/denisdanailov/IdeaProjects/exam-prep-2/skeleton/src/main/resources/files/xml/players.xml";

    private final ModelMapper modelMapper;
    private final PlayerRepository playerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;


    public PlayerServiceImpl(ModelMapper modelMapper, PlayerRepository playerRepository, XmlParser xmlParser, ValidationUtil validationUtil, TownService townService, TeamService teamService, StatService statService) {
        this.modelMapper = modelMapper;
        this.playerRepository = playerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder outputMsg = new StringBuilder();

        PlayerRootDTO pLayerRootDTO = xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerRootDTO.class);

        xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerRootDTO.class).
                getPlayers().stream()
                .filter(pLayerDTO -> {
                    boolean isValid = validationUtil.isValid(pLayerDTO);

                    outputMsg.append(isValid ? String.format("Successfully imported Player %s %s - %s", pLayerDTO.getFirstName(), pLayerDTO.getLastName(), pLayerDTO.getPosition())
                            : "Invalid Player").append(System.lineSeparator());

                    return isValid;
                }).map(pLayerDTO -> {
                    Player player = modelMapper.map(pLayerDTO, Player.class);

                    player.setTown(townService.findByName(pLayerDTO.getTown().getName()));
                    player.setTeam(teamService.findByName(player.getTeam().getName()));
                    player.setStat(statService.findById(player.getStat().getId()));
                    return player;

                }).forEach(playerRepository::save);

        return outputMsg.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        LocalDate before = LocalDate.of(2003, 1, 1);
        LocalDate after = LocalDate.of(1995, 1, 1);

        List<Player> players =
                this.playerRepository.findByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(after, before);

        return players
                .stream()
                .map(Player::toString)
                .collect(Collectors.joining("\n"));

    }
}




















