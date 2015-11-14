package es.rogermartinez.paddlemanager.listplayers.domain.model;

/**
 * Created by roger.martinez on 9/11/15.
 */
public class ListPlayersListModel {
    private String name;
    private String surname;
    private int position;
    private float level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
