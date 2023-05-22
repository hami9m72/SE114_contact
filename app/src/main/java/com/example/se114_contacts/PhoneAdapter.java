package com.example.se114_contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.FoodViewHolder> {

    private List<phone> phoneList;

    public PhoneAdapter(List<phone> phoneList) {
        this.phoneList = phoneList;
    }
    public void setFilteredList(List<phone> filteredList) {
        this.phoneList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_item,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        phone p = phoneList.get(position);
        if (p == null) return;

        holder.tvName.setText(p.getName());
        holder.tvPhone.setText(p.getPhone());
    }

    @Override
    public int getItemCount() {
        if (phoneList != null)
            return phoneList.size();
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvPhone;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textViewName);
            tvPhone = itemView.findViewById(R.id.textViewPhone);
        }


    }
}
