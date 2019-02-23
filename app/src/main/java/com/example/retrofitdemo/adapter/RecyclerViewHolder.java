package com.example.retrofitdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.retrofitdemo.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView id,name,address,phonenumber,salary;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        id=itemView.findViewById(R.id.emp_id);
        name=itemView.findViewById(R.id.emp_name);
        address=itemView.findViewById(R.id.emp_address);
        phonenumber=itemView.findViewById(R.id.emp_contact);
        salary=itemView.findViewById(R.id.emp_salary);
    }
}
