package engl202c.calculatortutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private Expression expression;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.textView);
        expression = new Expression();
    }

    public void numberClicked(View view) {
        String num = ((Button) view).getText().toString();
        String curVal = display.getText().toString();
        if (curVal.equals("0"))
            display.setText(num);
        else
            display.setText(curVal + num);
    }

    public void opClicked(View view) {
        String op = ((Button) view).getText().toString();
        String curVal = display.getText().toString();
        expression.operand1 = Integer.parseInt(curVal);
        expression.operator = op;
        display.setText("0");
    }

    public void clearClicked(View view) {
        expression = new Expression();
        display.setText("0");
    }

    public void equalClicked(View view) {
        String curVal = display.getText().toString();
        expression.operand2 = Integer.parseInt(curVal);
        display.setText(String.valueOf(expression.getValue()));
    }
}
