package com.maicondcastro.theswitcher.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.maicondcastro.theswitcher.activity.MainActivity;
import com.maicondcastro.theswitcher.databinding.SwitchDetailFragmentBinding;
import com.maicondcastro.theswitcher.util.Singleton;
import com.maicondcastro.theswitcher.viewmodel.SwitchDetailViewModel;

public class SwitchDetailFragment extends Fragment {

    private SwitchDetailViewModel viewModel;

    @Override
    public void onStart() {
        super.onStart();
        viewModel.load();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        SwitchDetailFragmentBinding binding = SwitchDetailFragmentBinding.inflate(inflater, container, false);
        viewModel = ViewModelProviders.of(this).get(SwitchDetailViewModel.class);
        binding.setViewModel(viewModel);
        if(MainActivity.actionBar != null) {
            MainActivity.actionBar.setTitle(Singleton.getInstance().getDivision().getName());
            MainActivity.actionBar.setDisplayHomeAsUpEnabled(true);
        }
        return binding.getRoot();
    }
}
