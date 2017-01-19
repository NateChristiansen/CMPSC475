package cmpsc475.w2c2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    }

    public void countTap(View view){
        counter.add();
        countview.setText(counter.getCount().toString());
    }

    public void countMin(View view){
        counter.sub();
        countview.setText(counter.getCount().toString());
    }
}
