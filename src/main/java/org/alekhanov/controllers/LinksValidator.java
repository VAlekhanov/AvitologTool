package org.alekhanov.controllers;

import org.alekhanov.entities.Link;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LinksValidator {
    public LinksValidator() {
    }

    public boolean check(Link link) {
        if (null != link.getLink()) {
            if (null != link.getName()) {
                if (null != link.getIcon()) {
                    return true;
                }
                // TODO: 21.04.2022     Загрузка иконки по умолчанию
//                link.setIcon(defaultImageIcon());
                return true;
            }
            // TODO: 21.04.2022   Загрузка имени по умолчанию
//            link.setName(nameDetecting());
            return true;
        }
        return false;
    }

    private ImageIcon defaultImageIcon() {
        return null;
    }

    private String nameDetecting() {
        return null;
    }

    public List<Link> readTxtFile() {
        List<Link> links = new ArrayList();
        return links;
    }

    public List<Link> readWordFile() {
        List<Link> links = new ArrayList();
        return links;
    }

}
