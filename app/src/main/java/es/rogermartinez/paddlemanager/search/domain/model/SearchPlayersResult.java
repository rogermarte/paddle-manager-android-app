package es.rogermartinez.paddlemanager.search.domain.model;

import java.util.ArrayList;
import java.util.List;

import es.rogermartinez.paddlemanager.base.domain.model.Player;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class SearchPlayersResult {
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
