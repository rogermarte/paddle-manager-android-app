package es.rogermartinez.paddlemanager.search.datasource.ddbb.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class PlayersSearchResultDDBBModel {
    private List<PlayerDDBBModel> players = new ArrayList<>();

    public PlayersSearchResultDDBBModel(List<PlayerDDBBModel> players){
        this.players = players;
    }

    public List<PlayerDDBBModel> getPlayers(){
        return players;
    }

}
