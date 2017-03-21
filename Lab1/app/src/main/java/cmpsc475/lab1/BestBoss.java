package cmpsc475.lab1;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BestBoss extends AppCompatActivity {
    int tries = 3;
    Intent checker;
    TextView triesLabel;
    Menu menu;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.defaultcolor:
                setBackground(R.color.colorDefault);
                break;
            case R.id.bluecolor:
                setBackground(R.color.colorPrimary);
                break;
            case R.id.purplecolor:
                setBackground(R.color.colorPurple);
                break;
            case R.id.tries2:
                changeTries(2);
                break;
            case R.id.tries3:
                changeTries(3);
                break;
            case R.id.tries4:
                changeTries(4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setBackground(int colorid) {
        int c = getResources().getColor(colorid, null);
        getWindow().getDecorView().setBackgroundColor(c);
    }

    private void changeTries(int t) {
        if (tries == 0 || !findViewById(R.id.gobutton).isEnabled()) return;

        tries = t;
        triesLabel.setText(String.valueOf(tries));
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
