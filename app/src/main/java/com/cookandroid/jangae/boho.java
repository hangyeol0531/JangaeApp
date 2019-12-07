package com.cookandroid.jangae;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class boho extends Activity {
    TextView tv1;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boho);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        tv1 = (TextView)findViewById(R.id.nameline);
        tv1.setText(name + "님 환영합니다!!!");

    }
}
