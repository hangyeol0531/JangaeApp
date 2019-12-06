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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Member;

public class addinformation extends Activity {
    Button btn1;
    private static final String TAG = "addinformation Activity";
    private FirebaseAuth mAuth;
    private String position;

    @Override
protected void onCreate(Bundle saveInstanceState){
    super.onCreate(saveInstanceState);
    setContentView(R.layout.addinfrormation);

    btn1 = (Button)findViewById(R.id.register);
        Intent intent = getIntent();
        position =  position = intent.getStringExtra("position");
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            profileUpdate();
        }
        });
    }
    private void spreadmsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    private void profileUpdate(){
        String name = ((EditText)findViewById(R.id.nameEditText)).getText().toString();
        String address = ((EditText)findViewById(R.id.addEditText)).getText().toString();
        String call = ((EditText)findViewById(R.id.callEditText)).getText().toString();
        String birth = ((EditText)findViewById(R.id.birthEditText)).getText().toString();

        if(name.length() > 0 && address.length() > 0 && call.length() >0 && birth.length() > 0){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            Memberinfo memberinfo = new Memberinfo(name, birth, call, address, position);
            if(user != null) {
                db.collection("users").document(user.getUid()).set(memberinfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                spreadmsg("회원가입 성공");
                                Intent listViewIntent = new Intent(getApplicationContext(), completeActivity.class);
                                startActivity(listViewIntent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                spreadmsg("회원가입 실패");
                            }
                        });
            }
        }else{
            spreadmsg("회원정보를 입력해주세요");
        }

    }
}
