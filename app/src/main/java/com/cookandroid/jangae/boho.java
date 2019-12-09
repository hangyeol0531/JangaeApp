package com.cookandroid.jangae;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

    public void onButton1Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://m.shinhan.ac.kr/community/notice/view.php?idx=5033&board_id=NACOMM11&category=")); startActivity(intent);
    }

    public void onButton2Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://m.blog.naver.com/PostView.nhn?blogId=chungong1&logNo=221270206131&proxyReferer=https%3A%2F%2Fwww.google.com%2F")); startActivity(intent);
    }
}
