package com.cookandroid.jangae;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class register01 extends Activity {
    Button btn1;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.register);
        btn1 = (Button)findViewById(R.id.register);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(getApplicationContext(), completeActivity.class);
                startActivity(listViewIntent);
            }
        });
    }
}


//public class loginActivity extends Activity {
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.login);
//    }
//}
