package cmpsc475.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class QuestionAnswer extends AppCompatActivity {
    String correctAns = "Ludwig";
    boolean correct = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);
        String ans = getIntent().getStringExtra("Answer");
        correct = correctAns.equals(ans);
        RelativeLayout cor = (RelativeLayout) findViewById(R.id.correct);
        RelativeLayout incor = (RelativeLayout) findViewById(R.id.incorrect);
        cor.setVisibility(correct ? View.VISIBLE : View.GONE);
        incor.setVisibility(correct ? View.GONE : View.VISIBLE);
    }

    public void quit(View view) {
        Intent i = new Intent();
        i.putExtra("Correct", correct);
        setResult(RESULT_OK, i);
        finish();
    }
}
