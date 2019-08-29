package com.maicondcastro.theswitcher.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.maicondcastro.theswitcher.R;
import com.maicondcastro.theswitcher.model.Division;

public class SwitchDetailViewModel extends ViewModel {

    public static ObservableField<Division> division = new ObservableField<>();
    public final int backIcon = R.drawable.ic_arrow_back;
}
