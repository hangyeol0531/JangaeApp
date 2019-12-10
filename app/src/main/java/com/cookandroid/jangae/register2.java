package com.cookandroid.jangae;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register2 extends Activity {
    Button btn1;
    private static final String TAG = "register Activity";
    private FirebaseAuth mAuth;
    private String position;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.register02);
        Intent intent = getIntent();
        position = intent.getStringExtra("position");

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        btn1 = findViewById(R.id.register);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singup();
            }
        });

    }

    private void singup(){
        String email = ((EditText)findViewById(R.id.idEditText)).getText().toString().trim();
        String password = ((EditText)findViewById(R.id.pwEditText)).getText().toString().trim();
        String repassword = ((EditText)findViewById(R.id.repwEditText)).getText().toString().trim();
        if(password.length() > 0 && repassword.length() > 0 && email.length() > 0) {
            if (password.equals(repassword) && (password.length()) >= 6 ) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    spreadmsg("정보입력창으로 이동합니다.");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent listViewIntent = new Intent(getApplicationContext(), addinformation.class);
                                    listViewIntent.putExtra("position",position);
                                    startActivity(listViewIntent);
                                    finish();
                                    //성공 했을때 로직
                                } else {
                                    if (task.getException() != null) {
                                        spreadmsg(task.getException().toString());
                                    }
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    //실패 했을때 로직
                                }
                            }
                        });
            } else {
                spreadmsg("비밀번호가 일치하지 않거나 6글자 이하입니다.");
            }
        }else{
            spreadmsg("값이 모두 입력되지 않았습니다");
        }
    }
    private void spreadmsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
