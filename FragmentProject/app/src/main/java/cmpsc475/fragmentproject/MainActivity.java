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
    boolean correct;
    int tries = 3;
    TextView triesLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        triesLabel = (TextView) findViewById(R.id.tries);
    }

    public void quit(View view) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            findViewById(R.id.a).setVisibility(View.GONE);
            findViewById(R.id.q).setVisibility(View.VISIBLE);
        }
        if (!correct) {
            tries--;
            triesLabel.setText(String.valueOf(tries));
        }
    }

    public void tryAnswer(View view) {
        String ans = ((RadioButton)findViewById(((RadioGroup)findViewById(R.id.radios)).getCheckedRadioButtonId())).getText().toString();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            findViewById(R.id.q).setVisibility(View.GONE);
            findViewById(R.id.a).setVisibility(View.VISIBLE);
        }
        RelativeLayout cor = (RelativeLayout) findViewById(R.id.correct);
        RelativeLayout incor = (RelativeLayout) findViewById(R.id.incorrect);
        correct = correctAns.equals(ans);
        cor.setVisibility(correct ? View.VISIBLE : View.GONE);
        incor.setVisibility(correct ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
