package cmpsc475.w2c1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class W2C2 extends AppCompatActivity {
    private TextView greetingTextView;
    private boolean isHello;
    private boolean isPsu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w2_c2);

        greetingTextView = (TextView) findViewById(R.id.textView);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(toggleGreeting);
        final Button psub = (Button) findViewById(R.id.button2);
        psub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPsu) {
                    greetingTextView.setText(R.string.psu2);
                }
                else {
                    greetingTextView.setText(R.string.psu1);
                }
                isPsu = !isPsu;
            }
        });
    }

    private final View.OnClickListener toggleGreeting = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isHello) {
                greetingTextView.setText(R.string.goodbye);
            }
            else {
                greetingTextView.setText(R.string.hello);
            }
            isHello = !isHello;
        }
    };
}
