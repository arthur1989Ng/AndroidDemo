package com.example.nian.androiddemo.MyGridView;

import java.io.Serializable;

/**
 * Created by nian on 01/03/16.
 */
public class ItemModel implements Serializable {
    private String name;
    private String icon;

    public ItemModel() {

    }

    public ItemModel(String name, String icon) {

        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "name " + name + " icon " + icon;
    }
}
