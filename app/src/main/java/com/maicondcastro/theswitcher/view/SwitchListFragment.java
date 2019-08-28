package com.maicondcastro.theswitcher.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maicondcastro.theswitcher.R;
import com.maicondcastro.theswitcher.activity.MainActivity;
import com.maicondcastro.theswitcher.adapter.SwitchListAdapter;
import com.maicondcastro.theswitcher.databinding.SwitchListFragmentBinding;
import com.maicondcastro.theswitcher.model.Division;
import com.maicondcastro.theswitcher.viewmodel.SwitchListViewModel;

import java.util.ArrayList;

public class SwitchListFragment extends Fragment {

    private SwitchListViewModel viewModel;

    @Override
    public void onStart() {
        super.onStart();
        viewModel.setup(NavHostFragment.findNavController(this));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        SwitchListFragmentBinding binding = SwitchListFragmentBinding.inflate(inflater, container, false);
        viewModel = ViewModelProviders.of(this).get(SwitchListViewModel.class);
        binding.setViewModel(viewModel);
        binding.recyclerView.setAdapter(new SwitchListAdapter(new ArrayList<Division>(), viewModel));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if(MainActivity.actionBar != null) {
            MainActivity.actionBar.setTitle(getString(R.string.title_main));
            MainActivity.actionBar.setDisplayHomeAsUpEnabled(false);
        }
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
