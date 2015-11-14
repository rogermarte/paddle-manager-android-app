package es.rogermartinez.paddlemanager.base.domain.model;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class Player {
    private String id = "";
    private String name = "";
    private String surname = "";
    private int level = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
