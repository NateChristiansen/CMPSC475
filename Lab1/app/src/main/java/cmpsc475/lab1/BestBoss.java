package cmpsc475.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BestBoss extends AppCompatActivity {
    int tries = 3;
    Intent checker;
    TextView triesLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_boss);
        checker = new Intent(this, QuestionAnswer.class);
        triesLabel = (TextView) findViewById(R.id.tries);
    }

    public void tryAnswer(View view) {
        String ans = ((RadioButton)findViewById(((RadioGroup)findViewById(R.id.radios)).getCheckedRadioButtonId())).getText().toString();
        checker.putExtra("Answer", ans);
        startActivityForResult(checker, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        boolean correct = data == null ? false : data.getBooleanExtra("Correct", false);
        if (correct) {
            findViewById(R.id.radios).setEnabled(false);
            findViewById(R.id.gobutton).setEnabled(false);
        }
        else {
            tries--;
            triesLabel.setText(String.valueOf(tries));
            if (tries == 0) {
                findViewById(R.id.radios).setEnabled(false);
                findViewById(R.id.gobutton).setEnabled(false);
            }
        }
    }

    public void quit(View view) {
        finish();
    }
}
