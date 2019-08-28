package com.maicondcastro.theswitcher.util;

import androidx.databinding.ObservableField;

import com.maicondcastro.theswitcher.model.Division;

public class Singleton {

    private boolean tablet;
    private static Singleton instance = null;

    private Singleton() {
        tablet = false;
    }

    public static Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }

    public boolean isTablet() {
        return tablet;
    }

    public void setTablet(boolean tablet) {
        this.tablet = tablet;
    }
}
