package cmpsc475.banjorental;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText numBanjo, numCases;
    final double BANJO_COST = 3, CASE_COST = 1, SALES_TAX = .05, INSURANCE = 0;
    TextView baseCost, salesTax, insurance, totalCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseCost = (TextView) findViewById(R.id.BaseCost);
        salesTax = (TextView) findViewById(R.id.SalesTax);
        insurance = (TextView) findViewById(R.id.Insurance);
        totalCost = (TextView) findViewById(R.id.TotalCost);

        numBanjo = (EditText) findViewById(R.id.NumBanjo);
        numCases = (EditText) findViewById(R.id.NumCases);
        numBanjo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void afterTextChanged(Editable s) {
                UpdateCost();
            }
        });
        numCases.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void afterTextChanged(Editable s) {
                UpdateCost();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void UpdateCost() {
        String temp;
        int banjos = 0, cases = 0;
        try{
            banjos = (temp = numBanjo.getText().toString()).isEmpty()  ? 0 : Integer.parseInt(temp);
        } catch (Exception ex) {
            banjos = 0;
        }
        try {
            cases = (temp = numCases.getText().toString()).isEmpty() ? 0 : Integer.parseInt(temp);
        } catch (Exception ex) {
            cases = 0;
        }
        double base = banjos * BANJO_COST + cases * CASE_COST;
        double tax = base * SALES_TAX;
        double ins = INSURANCE;
        double totcost = base + tax + ins;

        DecimalFormat df = new DecimalFormat("'$'0.00");

        baseCost.setText(df.format(base));
        salesTax.setText(df.format(tax));
        insurance.setText(df.format(ins));
        totalCost.setText(df.format(totcost));
    }

    public void clearText(View view) {
        TextView tv = (TextView) view;
        //tv.setText("");
    }
}
