package cmpsc475.fragmentproject;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Answers.OnFragmentInteractionListener, Questions.OnFragmentInteractionListener {

    String correctAns = "Slave Knight Gael";
    View cor, incor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cor = findViewById(R.id.correct);
        incor = findViewById(R.id.incorrect);
    }

    public void tryAnswer(View view) {
        String ans = ((RadioButton)findViewById(((RadioGroup)findViewById(R.id.radios)).getCheckedRadioButtonId())).getText().toString();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent i = new Intent(this, AnswerPage.class);
            i.putExtra("Choice", ans);
            startActivity(i);
        }
        else {
            if (ans.equals(correctAns)) {
                cor.setVisibility(View.VISIBLE);
                incor.setVisibility(View.GONE);
            }
            else {
                cor.setVisibility(View.GONE);
                incor.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
