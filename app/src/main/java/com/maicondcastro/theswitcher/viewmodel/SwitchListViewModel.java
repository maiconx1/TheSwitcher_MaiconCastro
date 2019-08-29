package com.maicondcastro.theswitcher.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.AndroidViewModel;
import androidx.navigation.NavController;

import com.maicondcastro.theswitcher.R;
import com.maicondcastro.theswitcher.adapter.SwitchListAdapter;
import com.maicondcastro.theswitcher.data.DivisionRepository;
import com.maicondcastro.theswitcher.model.Division;

public class SwitchListViewModel extends AndroidViewModel implements SwitchListAdapter.SwitchListListener {

    public ObservableArrayList<Division> divisions = new ObservableArrayList<>();
    private NavController navigation;
    private DivisionRepository repository;

    public SwitchListViewModel(@NonNull Application application) {
        super(application);
    }

    public void setup(NavController navigation) {
        this.navigation = navigation;
        new Thread(new Runnable() {
            public void run() {
                initDb();
            }
        }).start();
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
        repository.update(division);
    }

    private void initDb() {
        repository = new DivisionRepository(getApplication());
        divisions = repository.getDivisions();
        if(divisions.size() == 0) {
            repository.insert(new Division(1, "Kitchen", false));
            repository.insert(new Division(2, "Living room", false));
            repository.insert(new Division(3, "Master bedroom", false));
            repository.insert(new Division(4, "Guest's bedroom", false));

            divisions = repository.getDivisions();
            divisions.notify();
            SwitchDetailViewModel.division.set(divisions.get(0));
        }
    }
}
