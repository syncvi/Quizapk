package com.example.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    public static final String KEY_EXTRA_ANSWER_SHOWN = "quizlet.answerShown";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        boolean correctAnswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);
        Button showCorrectAnswerButton = findViewById(R.id.show_correct_answer_button);
        Button goBackButton = findViewById(R.id.go_back_button);
        TextView answerTextView = findViewById(R.id.textView);

        /*goBackButton.setOnClickListener((v) -> {
            finish();
        });*/

        showCorrectAnswerButton.setOnClickListener(v -> {
            int answer = correctAnswer ? R.string.button_true : R.string.button_false;
            answerTextView.setText(answer);
            setAnswerShownResult(true);
        });

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onBackPressed();}
        });

    }

    private void setAnswerShownResult(boolean answerWasShown) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOWN, answerWasShown);
        setResult(RESULT_OK, resultIntent);
    }

}