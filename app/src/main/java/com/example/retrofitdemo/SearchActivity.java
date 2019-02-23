package com.example.retrofitdemo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.retrofitdemo.service.APIClient;
import com.example.retrofitdemo.service.Employee;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends BaseActivity {
Button findBtn;
EditText searchedt;
String empID;
TextView txtName,txtId,txtPhone,txtAddress,txtSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initalization();
        Toast.makeText(this,empID,Toast.LENGTH_SHORT).show();
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empID= String.valueOf(searchedt.getText());
                searchEmployee(empID);
                Toast.makeText(SearchActivity.this,empID,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initalization() {
        searchedt=findViewById(R.id.edt_empid);
        findBtn=findViewById(R.id.btn_find);
        txtId=findViewById(R.id.emp_id);
        txtName=findViewById(R.id.emp_name);
        txtPhone=findViewById(R.id.emp_phone);
        txtAddress=findViewById(R.id.emp_address);
        txtSalary=findViewById(R.id.emp_salary);
    }

    public void searchEmployee(final String empid){
        Call call=APIClient.getClient().findEmployee(empid);
        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Employee employee=response.body();
                String responceJson=new Gson().toJson(employee);
                toast(responceJson);
                showDataOnScreen(employee);
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                toast(t.getMessage());
            }
        });
    }

    private void showDataOnScreen(Employee employee) {
        String ID=String.valueOf(employee.getId());
        String SALARY=String.valueOf(employee.getSalary());
        txtId.setText(ID);
        txtName.setText(employee.getName());
        txtPhone.setText(employee.getPhoneNumber());
        txtAddress.setText(employee.getAddress());
        txtSalary.setText(SALARY);
    }

}
