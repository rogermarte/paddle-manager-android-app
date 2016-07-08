package es.rogermartinez.paddlemanager.search.datasource.impl;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.SearchPlayers;
import es.rogermartinez.paddlemanager.search.datasource.SearchPlayerDataSource;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.SearchPlayersDDBB;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayerDDBBModel;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayersSearchResultDDBBModel;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;
import es.rogermartinez.paddlemanager.search.domain.model.SearchPlayersResult;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class SearchPlayerDataSourceFromBBDD implements SearchPlayerDataSource {

    private SearchPlayersDDBB searchPlayersDDBB;

    @Inject
    public SearchPlayerDataSourceFromBBDD(SearchPlayersDDBB searchPlayersDDBB){
        this.searchPlayersDDBB = searchPlayersDDBB;
    }

    @Override
    public SearchPlayersResult search(QueryPlayer queryPlayer) {
        PlayersSearchResultDDBBModel playersSearchResultDDBBModel = searchPlayersDDBB.search(queryPlayer);
        SearchPlayersResult result = new SearchPlayersResult();
        for (PlayerDDBBModel player: playersSearchResultDDBBModel.getPlayers()){
            Player p = convert(player);
            result.getPlayers().add(p);
        }
        return result;
    }

    private Player convert(PlayerDDBBModel player) {
        Player p = new Player();
        p.setName(player.getName());
        p.setLevel(player.getLevel());
        p.setId(player.getId());
        p.setComment(player.getComment());
        p.setSex(player.getSex());
        p.setPosition(player.getPosition());
        return p;
    }
}
