package es.rogermartinez.paddlemanager.search.datasource;

import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.base.datasource.dao.DatabaseHelper;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.SearchPlayersDDBB;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayerDDBBModel;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.sqllite.SearchPlayersDDBBSqlLite;
import es.rogermartinez.paddlemanager.search.datasource.impl.SearchPlayerDataSourceFromBBDD;
import es.rogermartinez.paddlemanager.search.datasource.mapper.QueryPlayerDDBBMapper;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;

/**
 * Created by roger.martinez on 13/11/15.
 */
@Module(complete = false, library = true)
public class SearchPlayerDataSourceModule {
    private static final String LOGTAG = "SearchPlayerDSModule";

    @Provides
    public SearchPlayerDataSource provideSeachDataSource(SearchPlayerDataSourceFromBBDD searchDataSource) {
        return searchDataSource;
    }

    @Provides
    public SearchPlayersDDBB provideSearchPlayersDDBB(SearchPlayersDDBBSqlLite searchPlayersDDBBSqlLite) {
        return searchPlayersDDBBSqlLite;
    }

    @Singleton
    @Provides
    public Map<QueryPlayer, QueryPlayer> provideSearchPlayersCache() {
        return new ConcurrentHashMap<QueryPlayer, QueryPlayer>();
    }

    @Provides
    public Dao<PlayerDDBBModel, String> provideSearchDDBBDao(DatabaseHelper dbHelper){
        try {
            return dbHelper.getPlayersDao();
        } catch (SQLException e){
            Log.d(LOGTAG, "error providing search dao", e);
        }
        return null;
    }

    @Provides
    public QueryPlayerDDBBMapper provideQueryPlayerMapper() {
        return new QueryPlayerDDBBMapper();
    }
}
