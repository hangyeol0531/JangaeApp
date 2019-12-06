package com.cookandroid.jangae;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class register_job_checkActivity extends Activity {
    Button btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_job_check);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(register_job_checkActivity.this, register1.class);
                listViewIntent.putExtra("position","장애인");
                startActivity(listViewIntent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(register_job_checkActivity.this, register2.class);
                listViewIntent.putExtra("position","보호자");
                startActivity(listViewIntent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(register_job_checkActivity.this, register2.class);
                listViewIntent.putExtra("position","상담사");
                startActivity(listViewIntent);
            }
        });
    }}
