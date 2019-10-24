package org.lab137.averageincometaxbycountryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the taxable income
        final EditText taxableIncome = findViewById(R.id.txtTaxableIncome);

        // Get the resident country
        final RadioButton china = findViewById(R.id.radChina);
        final RadioButton germany = findViewById(R.id.radGermany);
        final RadioButton sweden = findViewById(R.id.radSweden);
        final RadioButton usa = findViewById(R.id.radUsa);

        // Get the results TextView
        final TextView result = findViewById(R.id.txtResult);

        // Get the calculate button
        Button calculate = findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double taxableIncomeEntered = Double.parseDouble(taxableIncome.getText().toString());
                double taxesOwed = 0;
                String resultMessage = "Taxes owed are ";

                DecimalFormat yuan = new DecimalFormat("¥###,###,###.##");  // China
                DecimalFormat euro = new DecimalFormat("€###,###,###.##");  // Germany
                DecimalFormat krona = new DecimalFormat("kr###,###,###.##");// Sweden
                DecimalFormat dollar = new DecimalFormat("$###,###,###.##");// USA

                if (china.isChecked()){
                    taxesOwed = taxableIncomeEntered * 0.25;
                    resultMessage += yuan.format(taxesOwed);
                }
                if (germany.isChecked()) {
                    taxesOwed = taxableIncomeEntered * 0.32;
                    resultMessage += euro.format(taxesOwed);
                }
                if (sweden.isChecked()) {
                    taxesOwed = taxableIncomeEntered * 0.34;
                    resultMessage += krona.format(taxesOwed);
                }

                if (usa.isChecked()){
                    taxesOwed = taxableIncomeEntered * 0.18;
                    resultMessage += dollar.format(taxesOwed);
                }

                result.setText(resultMessage);
            }
        });
    }
}
