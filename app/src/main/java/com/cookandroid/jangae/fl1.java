package com.cookandroid.jangae;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class fl1 extends AppCompatActivity {

    Button btn1, btn2, btn3;
    TextView tv1;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fl1);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        tv1 = (TextView)findViewById(R.id.nameline);

        tv1.setText(name + "님 환영합니다!!!");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "현재 위치 입니다.",
                        Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(getApplicationContext(), fl2.class);
                startActivity(listViewIntent);
                finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(getApplicationContext(), fl3.class);
                startActivity(listViewIntent);
                finish();
            }
        });
    }


    public void onButton1Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
        Uri.parse("http://m.shinhan.ac.kr/community/notice/view.php?idx=5033&board_id=NACOMM11&category=")); startActivity(intent);
    }

    public void onButton2Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
        Uri.parse("https://m.blog.naver.com/PostView.nhn?blogId=chungong1&logNo=221270206131&proxyReferer=https%3A%2F%2Fwww.google.com%2F")); startActivity(intent);
    }
}

