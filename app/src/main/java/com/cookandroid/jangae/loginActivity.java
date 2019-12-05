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

public class loginActivity extends Activity {
    Button btn1;
    private static final String TAG = "login Activity";
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.login).setOnClickListener(onClickListener);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.login:
                    singup();
                    Log.e("클릭", "클릭");
                    break;
            }
        }
    };

    private void singup(){
        String email = ((EditText)findViewById(R.id.idEditText)).getText().toString().trim();
        String password = ((EditText)findViewById(R.id.pwEditText)).getText().toString().trim();
        if(password.length() > 0 && email.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                spreadmsg("로그인이 성공적입니다.");
                                Intent listViewIntent = new Intent(getApplicationContext(), fl1.class);
                                startActivity(listViewIntent);
                            } else {
                                spreadmsg("로그인이 실패적입니다.");
                                if (task.getException() != null) {
                                    spreadmsg(task.getException().toString());
                                }
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                            }

                            // ...
                        }
                    });
        }else{
            spreadmsg("값이 모두 입력되지 않았습니다");
        }
    }
    private void spreadmsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
