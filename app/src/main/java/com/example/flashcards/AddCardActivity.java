package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);




       findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((((EditText) findViewById(R.id.editQuestion)).getText().toString().isEmpty() ||
                        ((EditText) findViewById(R.id.editAnswer)).getText().toString().isEmpty()
                )) {
                    Toast.makeText(getApplicationContext(), "Please Fill All Fields", Toast.LENGTH_SHORT).show();

                } else {

                    String question = ((EditText) findViewById(R.id.editQuestion)).getText().toString();
                    String answer = ((EditText) findViewById(R.id.editAnswer)).getText().toString();

                    Intent data = new Intent(); // data goes in here
                    data.putExtra("question", question); // key 'question' is added into the intent
                    data.putExtra("answer", answer); // key 'answer' is added into the intent
                    setResult(RESULT_OK, data); // set result code and bundle data for response
                    finish(); // closes this activity and pass data to the original activity that launched this activity
                }
            }
        });

    }
}
