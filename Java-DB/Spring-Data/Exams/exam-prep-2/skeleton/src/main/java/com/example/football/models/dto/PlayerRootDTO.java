package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerRootDTO {

    @XmlElement(name = "player")
    List<PLayerDTO> players;

    public List<PLayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PLayerDTO> players) {
        this.players = players;
    }
}
