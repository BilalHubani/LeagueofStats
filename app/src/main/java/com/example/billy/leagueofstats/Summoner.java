package com.example.billy.leagueofstats;

/**
 * Created by Billy on 27/02/2017.
 */

public class Summoner {
    private String id;
    private String name;
    private String iconId;
    private String lvl;

    public Summoner() {
    }

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

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return "Summoner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconId='" + iconId + '\'' +
                ", lvl='" + lvl + '\'' +
                '}';
    }
}
