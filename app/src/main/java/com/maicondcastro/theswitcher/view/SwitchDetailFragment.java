package com.maicondcastro.theswitcher.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.maicondcastro.theswitcher.R;
import com.maicondcastro.theswitcher.databinding.SwitchDetailFragmentBinding;
import com.maicondcastro.theswitcher.viewmodel.SwitchDetailViewModel;

public class SwitchDetailFragment extends Fragment {

    private SwitchDetailViewModel viewModel;

    @Override
    public void onStart() {
        super.onStart();
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
        if(!getResources().getBoolean(R.bool.isTablet)) {
            binding.toolbar.setNavigationIcon(viewModel.backIcon);
            binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getActivity() != null) {
                        getActivity().onBackPressed();
                    }
                }
            });
        }
        return binding.getRoot();
    }
}
