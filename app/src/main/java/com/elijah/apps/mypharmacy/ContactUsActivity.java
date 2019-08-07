package com.elijah.apps.mypharmacy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactUsActivity extends AppCompatActivity {
    Button mbtnEmail,mbtnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_contact_us);
        mbtnEmail= findViewById(R.id.btnEmail);
        mbtnCall = findViewById(R.id.btnCall);
        mbtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","otienoelijah99@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello Sir....");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            }
        });
        mbtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);

            }
        });


    }
}

