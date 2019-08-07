package com.elijah.apps.mypharmacy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    EditText mPhone,mEmail,mPassword;
    Button mSignUp;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mPhone = findViewById(R.id.edtPhone);
        mEmail = findViewById(R.id.edtEmail);
        mPassword = findViewById(R.id.edtPassword);
        mSignUp = findViewById(R.id.btnSignup);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Signing Up");
        dialog.setMessage("Please wait....");

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //RECEIVE DATA FROM THE USER
                String phone=mPhone.getText().toString().trim();
                String email=mEmail.getText().toString();
                String password=mPassword.getText().toString();
                long time = System.currentTimeMillis();
                String myTime = String.valueOf(time);

            //CHECK IF THE USER IS SUBMITTING EMPTY FIELDS
            if (phone.isEmpty() || email.isEmpty()|| password.isEmpty()){
                Toast.makeText(SignUpActivity.this, "You cannot submit empty fields", Toast.LENGTH_SHORT).show();
            }else {
            //PROCEED TO SAVE DATA
            //CREATE TABLE
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users/"+myTime);
                //COLUMN NAMES
                    Item x = new Item(phone,email,password,myTime);
            //SAVING DIALOG
                    dialog.show();
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        dialog.dismiss();
                        //Display message if signed up successfully
                        if (task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(SignUpActivity.this,LoginActivity.class);
                            startActivity(login);
                        }else {
                            Toast.makeText(SignUpActivity.this, "Signing Up Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                mPhone.setText("");
                mEmail.setText("");
                mPassword.setText("");

            }
            }
        });




    }
}
