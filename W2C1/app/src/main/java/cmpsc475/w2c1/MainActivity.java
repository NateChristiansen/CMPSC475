package cmpsc475.w2c1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.Button);
        final TextView message = (TextView) findViewById(R.id.message);
        button.setOnClickListener(new View.OnClickListener() {
            boolean toggle = true;
            @Override
            public void onClick(View v) {
                if (toggle) message.setText(R.string.tag2);
                else message.setText(R.string.tag1);
                toggle = !toggle;
            }
        });
    }
}
