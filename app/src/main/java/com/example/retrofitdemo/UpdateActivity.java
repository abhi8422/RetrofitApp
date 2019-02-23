package com.example.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitdemo.service.APIClient;
import com.example.retrofitdemo.service.Employee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
EditText ID,NAME,ADD,PHONE,SALARY,DESIGNATION,SEARCHID;
     String id,name,add,phone,salary,designation,searchid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();

    }

    private void init() {
        ID=findViewById(R.id.edtID);
        NAME=findViewById(R.id.edtNAME);
        ADD=findViewById(R.id.edtADD);
        PHONE=findViewById(R.id.edtPHONE);
        SALARY=findViewById(R.id.edtSALARY);
        DESIGNATION=findViewById(R.id.edtDESIGNATION);
        SEARCHID=findViewById(R.id.edt_search);
    }

    public void UpdateEmployee(View view) {
        id=ID.getText().toString().trim();
        name=NAME.getText().toString().trim();
        add=ADD.getText().toString().trim();
        phone=PHONE.getText().toString().trim();
        salary=SALARY.getText().toString().trim();
        designation=DESIGNATION.getText().toString().trim();



    }

    public void ShowEmployee(View view) {
        searchid=SEARCHID.getText().toString().trim();
        Call<Employee> employeeCall= APIClient.getClient().findEmployee(searchid);
        employeeCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Employee employee=response.body();
                String StringID=String.valueOf(employee.getId());
                String StringSALARY=String.valueOf(employee.getSalary());
                ID.setText(StringID);
                NAME.setText(employee.getName());
                ADD.setText(employee.getAddress());
                PHONE.setText(employee.getPhoneNumber());
                SALARY.setText(StringSALARY);
                DESIGNATION.setText(employee.getDesignation());
                Toast.makeText(UpdateActivity.this,"find",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {

            }
        });
    }
}
