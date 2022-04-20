package org.alekhanov.entities;

import javax.swing.*;

public class Link {
    private String link;
    ImageIcon icon;
    String name;

    public Link() {

    }

    public Link(String link, ImageIcon icon, String name) {
        this.link = link;
        this.icon = icon;
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
