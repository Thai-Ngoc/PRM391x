package com.example.prm391x_quizapp_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    CheckBox ans1_1, ans1_2, ans1_3, ans1_4, ans1_5, ans1_6, ans1_7, ans1_8, ans1_9;

    EditText ans2, ans4, ans5, ans8, ans10;

    RadioButton ans3, ans6, ans7, ans9;

    Button calScore;

    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ans1_1 = (CheckBox)findViewById(R.id.ans1_1);
        ans1_2 = (CheckBox)findViewById(R.id.ans1_2);
        ans1_3 = (CheckBox)findViewById(R.id.ans1_3);
        ans1_4 = (CheckBox)findViewById(R.id.ans1_4);
        ans1_5 = (CheckBox)findViewById(R.id.ans1_5);
        ans1_6 = (CheckBox)findViewById(R.id.ans1_6);
        ans1_7 = (CheckBox)findViewById(R.id.ans1_7);
        ans1_8 = (CheckBox)findViewById(R.id.ans1_8);
        ans1_9 = (CheckBox)findViewById(R.id.ans1_9);
        calScore = (Button)findViewById(R.id.calScore);

        ans2 = (EditText)findViewById(R.id.ans2);

        ans3 = (RadioButton)findViewById(R.id.ans3);

        ans4 = (EditText)findViewById(R.id.ans4);

        ans5 = (EditText)findViewById(R.id.ans5);

        ans6 = (RadioButton)findViewById(R.id.ans6);

        ans7 = (RadioButton)findViewById(R.id.ans7);

        ans8 = (EditText)findViewById(R.id.ans8);

        ans9 = findViewById(R.id.ans9);

        ans10 = (EditText)findViewById(R.id.ans10);

        calScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = result();
                String end = "Điểm: " + result + "/10";
                Toast.makeText(getApplicationContext(), end, Toast.LENGTH_LONG).show();
            }
        });
    }

    int result(){
        score = 0;
        score = (ans1_3.isChecked() && ans1_4.isChecked() && ans1_6.isChecked() && ans1_9.isChecked() && !ans1_1.isChecked() && !ans1_2.isChecked() && !ans1_5.isChecked() && !ans1_7.isChecked() && !ans1_8.isChecked()) ? score + 1 : score;
        score = (ans2.equals("Đại Ngu")) ? score + 1 : score;
        score = (ans3.isChecked()) ? score + 1 : score;
        score = (ans4.equals("Vườn không nhà trống")) ? score + 1 : score;
        score = (ans5.equals("Lý Chiêu Hoàng")) ? score + 1 : score;
        score = (ans6.isChecked()) ? score + 1 : score;
        score = (ans7.isChecked()) ? score + 1 : score;
        score = (ans8.equals("Nam quốc sơn hà")) ? score + 1 : score;
        score = (ans9.isChecked()) ? score + 1 : score;
        score = (ans10.equals("Bình Ngô đại cáo")) ? score + 1 : score;

        return score;
    }
}