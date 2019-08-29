package com.maicondcastro.theswitcher.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.maicondcastro.theswitcher.databinding.ItemListSwitchBinding;
import com.maicondcastro.theswitcher.model.Division;

import java.util.List;

public class SwitchListAdapter extends RecyclerView.Adapter<SwitchListAdapter.ViewHolder> {

    private List<Division> divisionList;
    private SwitchListListener listener;


    public SwitchListAdapter(List<Division> divisionList, SwitchListListener listener) {
        this.divisionList = divisionList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemListSwitchBinding binding = ItemListSwitchBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(divisionList.get(position));
    }

    @Override
    public int getItemCount() {
        return divisionList.size();
    }

    private void replaceItems(List<Division> items) {
        divisionList = items;
        notifyDataSetChanged();
    }

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Division> items) {
        if(items != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter instanceof SwitchListAdapter) {
                ((SwitchListAdapter) adapter).replaceItems(items);
            }
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemListSwitchBinding binding;

        ViewHolder(ItemListSwitchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final Division division) {
            binding.setDivision(division);
            binding.setOnClick(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(division);
                }
            });
            binding.setOnChecked(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    division.setActive(((Switch)v).isChecked());
                    listener.onCheck(division);
                }
            });
            binding.executePendingBindings();
        }
    }

    public interface SwitchListListener {
        void onItemClick(Division division);
        void onCheck(Division division);
    }
}
