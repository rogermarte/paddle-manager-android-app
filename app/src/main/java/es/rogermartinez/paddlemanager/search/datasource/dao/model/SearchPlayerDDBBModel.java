package es.rogermartinez.paddlemanager.search.datasource.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by roger.martinez on 13/11/15.
 */
@DatabaseTable(tableName = "search")
public class SearchPlayerDDBBModel {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String name = "";
    @DatabaseField
    private String surname = "";

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
}
