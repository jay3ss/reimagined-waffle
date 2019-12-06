package org.lab137.electriccarfinancing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView monthlyPayment = findViewById(R.id.txtMonthlyPayment);
        ImageView image = findViewById(R.id.imgYears);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        int intYears = sharedPref.getInt("years", 0);
        int intLoan = sharedPref.getInt("loan", 0);
        float decInterest = sharedPref.getFloat("interest", 0);
        float decMonthlyPayment;

        decMonthlyPayment = (intLoan * (1 + (decInterest * intYears))) / (12 * intYears);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        monthlyPayment.setText("Monthly Payment " + currency.format(decMonthlyPayment));

        if (intYears == 3) {
            image.setImageResource(R.drawable.three);
        } else if (intYears == 4) {
            image.setImageResource(R.drawable.four);
        } else if (intYears == 5) {
            image.setImageResource(R.drawable.five);
        } else {
            monthlyPayment.setText("Enter 3, 4, or 5 years");
        }



    }
}
