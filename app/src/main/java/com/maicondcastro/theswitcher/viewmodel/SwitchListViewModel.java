package com.maicondcastro.theswitcher.viewmodel;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

import com.maicondcastro.theswitcher.R;
import com.maicondcastro.theswitcher.adapter.SwitchListAdapter;
import com.maicondcastro.theswitcher.model.Division;
import com.maicondcastro.theswitcher.util.Singleton;

public class SwitchListViewModel extends ViewModel implements SwitchListAdapter.SwitchListListener {

    public final ObservableArrayList<Division> divisions = new ObservableArrayList<>();
    private NavController navigation;


    public void setup(NavController navigation) {
        this.navigation = navigation;
        if(divisions.size() == 0) {
            divisions.add(new Division("Kitchen", false));
            divisions.add(new Division("Living room", false));
            divisions.add(new Division("Master bedroom", false));
            divisions.add(new Division("Guest's bedroom", false));
        }
    }

    private void click(Division division) {
        Singleton.getInstance().setDivision(division);
        navigation.navigate(R.id.switchDetailFragment);
    }

    @Override
    public void onItemClick(Division division) {
        click(division);
    }

    @Override
    public void onCheck(Division division) {
        divisions.set(divisions.indexOf(division), division);
    }
}
