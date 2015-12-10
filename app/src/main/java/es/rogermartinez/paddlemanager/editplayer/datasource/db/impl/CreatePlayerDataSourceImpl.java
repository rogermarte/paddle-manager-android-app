package es.rogermartinez.paddlemanager.editplayer.datasource.db.impl;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.editplayer.datasource.CreatePlayerDataSource;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayerDDBBModel;

public class CreatePlayerDataSourceImpl implements CreatePlayerDataSource {

    private Dao<PlayerDDBBModel, String> playerDao;

    @Inject
    public CreatePlayerDataSourceImpl(Dao<PlayerDDBBModel, String> playerDao){
        this.playerDao = playerDao;
    }

    @Override
    public void createPlayer(Player player) {
        try {
            playerDao.create(mapperPlayer(player));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PlayerDDBBModel mapperPlayer(Player player) {
        PlayerDDBBModel p = new PlayerDDBBModel(player.getId(), player.getName(), player.getSurname(), player.getLevel());
        return p;
    }
}
