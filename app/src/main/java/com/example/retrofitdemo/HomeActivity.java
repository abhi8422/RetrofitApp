package com.example.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
Button btnShow,btnFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnShow=findViewById(R.id.Show_btn);
        btnFind=findViewById(R.id.Find_btn);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(HomeActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.Add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,AddActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.Update_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,UpdateActivity.class);
                startActivity(i);
            }
        });
    }
}
