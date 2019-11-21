package com.cookandroid.jangae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);

        btn1 = (Button)findViewById(R.id.login);
        btn2 = (Button)findViewById(R.id.register);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(getApplicationContext(), register_job_checkActivity.class);
                startActivity(listViewIntent);
            }
        });
    }
}
