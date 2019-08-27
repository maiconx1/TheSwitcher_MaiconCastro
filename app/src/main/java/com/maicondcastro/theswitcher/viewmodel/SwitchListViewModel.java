package com.maicondcastro.theswitcher.viewmodel;

import android.database.Observable;

import androidx.lifecycle.ViewModel;

import com.maicondcastro.theswitcher.model.Division;

import java.util.List;

public class SwitchListViewModel extends ViewModel {
    Observable<List<Division>> divisions;
}
