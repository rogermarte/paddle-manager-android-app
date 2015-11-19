package es.rogermartinez.paddlemanager.base.datasource.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayerDDBBModel;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "paddlemanager.db";
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the SimpleData table
    private Dao<PlayerDDBBModel, String> playersDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable
     * statements here to create the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, PlayerDDBBModel.class);
           } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This is called when your application is upgraded and it has a higher version number.
     * This allows you to adjust the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion,
                          int newVersion) {

    }

    public void clearAllTables(){
        clearTable(PlayerDDBBModel.class);
    }

    public void clearTable(Class dbClass) {
        try {
            TableUtils.clearTable(connectionSource, dbClass);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't clean table", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or
     * just  give the cached value.
     */
    public Dao<PlayerDDBBModel, String> getPlayersDao() throws SQLException {
        if (playersDao == null) {
            playersDao = getDao(PlayerDDBBModel.class);
        }
        return playersDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        playersDao = null;
    }
}
