package com.example.retrofitdemo.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.service.Employee;
import java.util.List;
public class RecylerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

List<Employee> employeesList;

    public RecylerAdapter(List<Employee> employeesList) {

        this.employeesList = employeesList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_employee,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        Employee employee=employeesList.get(i);
        String id= String.valueOf(employee.getId());
        String salary=String.valueOf(employee.getSalary());
        recyclerViewHolder.id.setText(id);
        recyclerViewHolder.name.setText(employee.getName());
        recyclerViewHolder.phonenumber.setText(employee.getPhoneNumber());
        recyclerViewHolder.address.setText(employee.getAddress());
        recyclerViewHolder.salary.setText(salary);
    }

    @Override
    public int getItemCount() {
        return employeesList.size();
    }
}
