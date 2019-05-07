package com.example.implicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnEmail;
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = findViewById(R.id.editTextMessage);
        btnEmail = findViewById(R.id.buttonEmail);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The action you want this intent to do
                //ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                //Put essentials like

                //EMAIL ADDRESS
                email.putExtra(Intent.EXTRA_EMAIL , new String[]{"jason_lim@rp.edu.sg"});

                //SUBJECT
                email.putExtra(Intent.EXTRA_SUBJECT,"Test Email from C347");

                //BODY TEXT
                email.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText());

                // MIME type indicates email
                email.setType("message/rfc8222");
                //CreateChooser shows user a list of app that can handle this mime type which is emao;
                startActivity(Intent.createChooser(email , "Choose an Email client :"));

            }
        });

    }
}
