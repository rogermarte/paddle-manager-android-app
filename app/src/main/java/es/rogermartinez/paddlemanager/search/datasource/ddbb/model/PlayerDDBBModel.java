package es.rogermartinez.paddlemanager.search.datasource.ddbb.model;

import android.support.annotation.NonNull;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import es.rogermartinez.paddlemanager.base.domain.model.Player;

/**
 * Created by roger.martinez on 13/11/15.
 */
@DatabaseTable(tableName = "player")
public class PlayerDDBBModel {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField
    private String name = "";

    @DatabaseField
    private String surname = "";

    @DatabaseField
    private int level = 0;

    public PlayerDDBBModel(){

    }

    public PlayerDDBBModel(long id, String name, String surname, int level){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
