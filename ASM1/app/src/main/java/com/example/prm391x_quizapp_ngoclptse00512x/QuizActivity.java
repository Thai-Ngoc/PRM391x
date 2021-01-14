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

    private CheckBox mAns1_1, mAns1_2, mAns1_3, mAns1_4, mAns1_5, mAns1_6, mAns1_7, mAns1_8, mAns1_9;

    private EditText mAns2, mAns4, mAns5, mAns8, mAns10;

    private RadioButton mAns3, mAns6, mAns7, mAns9;

    private Button mCalScore;

    private int mScore = 0;

    void initView() {
        //event checkbox
        mAns1_1 = findViewById(R.id.ans1_1);
        mAns1_2 = findViewById(R.id.ans1_2);
        mAns1_3 = findViewById(R.id.ans1_3);
        mAns1_4 = findViewById(R.id.ans1_4);
        mAns1_5 = findViewById(R.id.ans1_5);
        mAns1_6 = findViewById(R.id.ans1_6);
        mAns1_7 = findViewById(R.id.ans1_7);
        mAns1_8 = findViewById(R.id.ans1_8);
        mAns1_9 = findViewById(R.id.ans1_9);

        //event edit text
        mAns2 = findViewById(R.id.ans2);

        //event radio button
        mAns3 = findViewById(R.id.ans3);

        //event edit text
        mAns4 = findViewById(R.id.ans4);

        //event edit text
        mAns5 = findViewById(R.id.ans5);

        //event radio button
        mAns6 = findViewById(R.id.ans6);

        //event radio button
        mAns7 = findViewById(R.id.ans7);

        //event edit text
        mAns8 = findViewById(R.id.ans8);

        //event radio button
        mAns9 = findViewById(R.id.ans9);

        //event edit text
        mAns10 = findViewById(R.id.ans10);

        //event button
        mCalScore = findViewById(R.id.calScore);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initView();

        mCalScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = result();
                String end = "Điểm: " + result + "/10";
                Toast.makeText(getApplicationContext(), end, Toast.LENGTH_LONG).show(); //show score
            }
        });
    }

    int result(){ //calculate score
        mScore = 0;
        mScore = (mAns1_3.isChecked() && mAns1_4.isChecked() && mAns1_6.isChecked() && mAns1_9.isChecked() && !mAns1_1.isChecked() && !mAns1_2.isChecked() && !mAns1_5.isChecked() && !mAns1_7.isChecked() && !mAns1_8.isChecked()) ? mScore + 1 : mScore;
        mScore = (mAns2.equals("Đại Ngu")) ? mScore + 1 : mScore;
        mScore = (mAns3.isChecked()) ? mScore + 1 : mScore;
        mScore = (mAns4.equals("Vườn không nhà trống")) ? mScore + 1 : mScore;
        mScore = (mAns5.equals("Lý Chiêu Hoàng")) ? mScore + 1 : mScore;
        mScore = (mAns6.isChecked()) ? mScore + 1 : mScore;
        mScore = (mAns7.isChecked()) ? mScore + 1 : mScore;
        mScore = (mAns8.equals("Nam quốc sơn hà")) ? mScore + 1 : mScore;
        mScore = (mAns9.isChecked()) ? mScore + 1 : mScore;
        mScore = (mAns10.equals("Bình Ngô đại cáo")) ? mScore + 1 : mScore;

        return mScore;
    }
}