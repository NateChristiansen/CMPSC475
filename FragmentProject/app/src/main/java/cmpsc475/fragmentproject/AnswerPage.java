package cmpsc475.fragmentproject;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnswerPage extends AppCompatActivity implements Answers.OnFragmentInteractionListener{

    String correctAns = "Slave Knight Gael";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answerpage);
        View cor = findViewById(R.id.correct);
        View incor = findViewById(R.id.incorrect);

        if (getIntent().getStringExtra("Choice").equals(correctAns)) {
            cor.setVisibility(View.VISIBLE);
            incor.setVisibility(View.GONE);
        }
        else {
            cor.setVisibility(View.GONE);
            incor.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
