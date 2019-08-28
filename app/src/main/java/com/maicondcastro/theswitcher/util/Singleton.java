package com.maicondcastro.theswitcher.util;

import com.maicondcastro.theswitcher.model.Division;

public class Singleton {

    private Division division;
    private static Singleton instance = null;

    private Singleton() {
        division = new Division("", false);
    }

    public static Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
