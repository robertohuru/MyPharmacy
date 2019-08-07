package com.elijah.apps.mypharmacy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentsActivity extends AppCompatActivity {
    Button mbtnPesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        mbtnPesa = findViewById(R.id.btnPesa);
        mbtnPesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent simToolKitLaunchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if(simToolKitLaunchIntent != null) {
                    startActivity(simToolKitLaunchIntent);
                }

            }

        });
    }
}
