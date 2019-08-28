package com.maicondcastro.theswitcher.viewmodel;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

import com.maicondcastro.theswitcher.R;
import com.maicondcastro.theswitcher.adapter.SwitchListAdapter;
import com.maicondcastro.theswitcher.model.Division;

public class SwitchListViewModel extends ViewModel implements SwitchListAdapter.SwitchListListener {

    public final ObservableArrayList<Division> divisions = new ObservableArrayList<>();
    private NavController navigation;


    public void setup(NavController navigation) {
        this.navigation = navigation;
        if(divisions.size() == 0) {
            divisions.add(new Division(1, "Kitchen", false));
            divisions.add(new Division(2, "Living room", false));
            divisions.add(new Division(3, "Master bedroom", false));
            divisions.add(new Division(4, "Guest's bedroom", false));
            SwitchDetailViewModel.division.set(divisions.get(0));
        }
    }

    private void click(Division division) {
        SwitchDetailViewModel.division.set(division);
        SwitchDetailViewModel.division.notifyChange();
        if(navigation != null) {
            navigation.navigate(R.id.switchDetailFragment);
        }
    }

    @Override
    public void onItemClick(Division division) {
        click(division);
    }

    @Override
    public void onCheck(Division division) {
        divisions.set(divisions.indexOf(division), division);
        Division d = SwitchDetailViewModel.division.get();
        if(d != null && d.getId() == division.getId()) {
            SwitchDetailViewModel.division.set(division);
            SwitchDetailViewModel.division.notifyChange();
        }
    }
}
