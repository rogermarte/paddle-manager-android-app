package es.rogermartinez.paddlemanager.search.datasource.ddbb.sqllite;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.search.datasource.ddbb.SearchPlayersDDBB;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayerDDBBModel;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayersSearchResultDDBBModel;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class SearchPlayersDDBBSqlLite implements SearchPlayersDDBB {

    private Dao<PlayerDDBBModel, String> playerDao;

    @Inject
    public SearchPlayersDDBBSqlLite(Dao<PlayerDDBBModel, String> playerDao){
        this.playerDao = playerDao;
    }

    @Override
    public PlayersSearchResultDDBBModel search(QueryPlayer queryPlayer) {
        List<PlayerDDBBModel> players = new ArrayList<>();
        try {
            players = playerDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PlayersSearchResultDDBBModel playersSearchResultDDBBModel = new PlayersSearchResultDDBBModel(players);
        return playersSearchResultDDBBModel;
    }
}
