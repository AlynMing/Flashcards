package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //TextView text = (TextView) findViewById(R.id.option1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });


        findViewById(R.id.option1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.option1).setBackgroundColor(Color.RED);
                //text.setTextColor(Color.WHITE);
            }
        });

        findViewById(R.id.option2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.option2).setBackgroundColor(Color.RED);
            }
        });

        findViewById(R.id.option3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.option3).setBackgroundColor(Color.RED);
            }
        });

        findViewById(R.id.option4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.option4).setBackgroundColor(Color.GREEN);
            }
        });

        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);

                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 100) && (resultCode == RESULT_OK)) {
            String q = data.getExtras().getString("question");
            String a = data.getExtras().getString("answer");

            TextView Question = findViewById(R.id.flashcard_question);
            Question.setText(q);

            TextView Answer = findViewById(R.id.answer);
            Answer.setText(a);


            TextView one = findViewById(R.id.option1);
            one.setText("");
            TextView two = findViewById(R.id.option2);
            two.setText("");
            TextView three = findViewById(R.id.option3);
            three.setText("");
            TextView four = findViewById(R.id.option4);
            four.setText("");


            Snackbar.make(findViewById(R.id.flashcard_question),
                    "Card created successfully",
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

}
