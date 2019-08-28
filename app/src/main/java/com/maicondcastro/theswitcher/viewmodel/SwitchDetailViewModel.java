package com.maicondcastro.theswitcher.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.maicondcastro.theswitcher.model.Division;
import com.maicondcastro.theswitcher.util.Singleton;

public class SwitchDetailViewModel extends ViewModel {

    public final ObservableField<Division> division = new ObservableField<>();

    public void load() {
        division.set(Singleton.getInstance().getDivision());
    }
}
