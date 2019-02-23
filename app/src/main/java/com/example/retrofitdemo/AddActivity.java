package com.example.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitdemo.service.APIClient;
import com.example.retrofitdemo.service.BaseResponse;
import com.example.retrofitdemo.service.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {
EditText idedt,nameedt,addedt,phoneedt,salaryedt,designationedt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
    }

    private void init() {
        idedt=findViewById(R.id.edt_id);
        nameedt=findViewById(R.id.edt_name);
        addedt=findViewById(R.id.edt_address);
        phoneedt=findViewById(R.id.edt_phone);
        salaryedt=findViewById(R.id.edt_salary);
        designationedt=findViewById(R.id.edt_designation);

    }

    public void AddData(View view) {
        String name=nameedt.getText().toString().trim();
        String address=addedt.getText().toString().trim();
        String phone=phoneedt.getText().toString().trim();
        String salary=salaryedt.getText().toString().trim();
        Integer Salary=Integer.parseInt(salary);
        String designation=designationedt.getText().toString().trim();
        Employee employee=new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setPhoneNumber(phone);
        employee.setSalary(Salary);
        employee.setDesignation(designation);
        addDataToServer(employee);
    }

    private void addDataToServer(Employee employee) {
        Call<BaseResponse> baseResponseCall= APIClient.getClient().addEmployee(employee);
        baseResponseCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                BaseResponse baseResponse=response.body();

                Toast.makeText(AddActivity.this,baseResponse.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });
    }
}
