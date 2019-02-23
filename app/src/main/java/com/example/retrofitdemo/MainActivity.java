package com.example.retrofitdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.retrofitdemo.adapter.RecylerAdapter;
import com.example.retrofitdemo.service.APIClient;
import com.example.retrofitdemo.service.BaseResponse;
import com.example.retrofitdemo.service.Employee;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getDataFromServer();
    }

    private void getDataFromServer() {
        final Call<List<Employee>> employeecall= APIClient.getClient().getAllEmployee();
        employeecall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                List<Employee> employees= response.body();
                //converting to string object
                //String responceJson=new Gson().toJson(employees);
                //toast(responceJson);
                RecylerAdapter adapter=new RecylerAdapter(employees);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
            toast(t.getMessage());
            }
        });

    }



}
