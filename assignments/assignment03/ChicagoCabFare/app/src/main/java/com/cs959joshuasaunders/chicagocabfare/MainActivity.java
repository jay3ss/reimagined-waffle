package com.cs959joshuasaunders.chicagocabfare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerMile = 3.0;
    double numberOfMiles;
    double totalCost;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miles = (EditText)findViewById(R.id.txtMiles);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button fare = (Button)findViewById(R.id.btnFare);
        fare.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView)findViewById(R.id.txtResult);
            @Override
            public void onClick(View v) {
                numberOfMiles = Double.parseDouble(miles.getText().toString());
                totalCost = costPerMile * numberOfMiles;

                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();

                result.setText("Fare for a " + groupChoice + " is " + currency.format(totalCost));
            }
        });
    }
}
