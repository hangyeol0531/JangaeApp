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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class loginActivity extends Activity {
    Button btn1, btn2;
    private static final String TAG = "login Activity";
    private FirebaseAuth mAuth;
    private String datastring;
    private String name;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.login).setOnClickListener(onClickListener);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    }
    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.login:
                    login();
                    Log.e("클릭", "클릭");
                    break;
            }
        }
    };

    private void login(){
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

                                ///
                                final FirebaseFirestore db = FirebaseFirestore.getInstance();
                                final DocumentReference docRef = db.collection("users").document(user.getUid());
                                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            DocumentSnapshot document = task.getResult();
                                            if (document.exists()) {
                                                Log.d(TAG, "DocumentSnapshot data: " + document.getData().get("position"));
                                                datastring = (String) document.getData().get("position").toString().trim();
                                                name = (String) document.getData().get("name").toString().trim();
                                                Log.d("Tag", datastring);
                                                if(datastring.equals("장애인")){
                                                    Intent listViewIntent = new Intent(getApplicationContext(), fl1.class);
                                                    listViewIntent.putExtra("name",name);
                                                    startActivity(listViewIntent);
                                                }
                                                else if(datastring.equals("보호자")){
                                                    Intent listViewIntent = new Intent(getApplicationContext(), fl2.class);
                                                    listViewIntent.putExtra("name",name);
                                                    startActivity(listViewIntent);
                                                }else if(datastring.equals("상담사")){
                                                    Intent listViewIntent = new Intent(getApplicationContext(), fl3.class);
                                                    listViewIntent.putExtra("name",name);
                                                    startActivity(listViewIntent);
                                                }
                                            } else {
                                                Log.d(TAG, "No such document");
                                            }
                                        } else {
                                            Log.d(TAG, "get failed with ", task.getException());
                                        }
                                    }
                                });
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
