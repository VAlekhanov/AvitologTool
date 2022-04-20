package org.alekhanov.controllers;

import org.alekhanov.entities.Link;

import javax.swing.*;

public class LinksValidator {
    public LinksValidator() {
    }

    public boolean check(Link link) {
        if (null != link.getLink()) {
            if (null != link.getName()) {
                if (null != link.getIcon()) {
                    return true;
                }
//                Загрузка иконки по умолчанию
//                link.setIcon(defaultImageIcon());
                return true;
            }
//            Загрузка имени по умолчанию
//            link.setName(nameDetecting());
            return true;
        }
        return false;
    }

    private ImageIcon defaultImageIcon(){
        return null;
    }

    private String nameDetecting(){
        return null;
    }

}
