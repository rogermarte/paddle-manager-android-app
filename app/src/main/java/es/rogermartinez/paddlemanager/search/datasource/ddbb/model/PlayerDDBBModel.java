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
    private int level = 0;

    @DatabaseField
    private int sex = 0;

    @DatabaseField
    private int position = 0;

    @DatabaseField
    private String comment = "";

    public PlayerDDBBModel(){

    }

    public PlayerDDBBModel(long id, String name, int level, int sex, int position, String comment){
        this.id = id;
        this.name = name;
        this.level = level;
        this.sex = sex;
        this.position = position;
        this.comment = comment;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
