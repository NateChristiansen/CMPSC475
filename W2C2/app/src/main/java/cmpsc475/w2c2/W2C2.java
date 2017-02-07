package cmpsc475.w2c2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class W2C2 extends AppCompatActivity {

    private Counter counter;
    private TextView countview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w2_c2);
        counter = new Counter();
        countview = (TextView) findViewById(R.id.textView2);
        CheckBox box = (CheckBox) findViewById(R.id.negbox);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                counter.negatives = isChecked;
                if (counter.getCount() < 0) {
                    counter.sub(1);
                    countview.setText(counter.getCount().toString());
                }
            }
        });
    }

    public void countTap(View view){
        RadioGroup group = (RadioGroup) findViewById(R.id.rgroup);
        int id = group.getCheckedRadioButtonId();
        RadioButton b = (RadioButton) findViewById(id);
        int amt = Integer.parseInt(b.getText().toString());
        counter.add(amt);
        countview.setText(counter.getCount().toString());
    }

    public void countMin(View view){
        RadioGroup group = (RadioGroup) findViewById(R.id.rgroup);
        int id = group.getCheckedRadioButtonId();
        RadioButton b = (RadioButton) findViewById(id);
        int amt = Integer.parseInt(b.getText().toString());
        counter.sub(amt);
        countview.setText(counter.getCount().toString());
    }
}
