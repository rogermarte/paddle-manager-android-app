package es.rogermartinez.paddlemanager.base.domain.model;

import java.io.Serializable;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class Player implements Serializable {
    private long id;
    private String name = "";
    private int level = 0;
    private int sex = 0;
    private int position = 0;
    private String comment = "";

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
