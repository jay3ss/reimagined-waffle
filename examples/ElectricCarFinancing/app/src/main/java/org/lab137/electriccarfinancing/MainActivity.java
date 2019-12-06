package org.lab137.electriccarfinancing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText years    = findViewById(R.id.txtYears);
        final EditText loan     = findViewById(R.id.txtLoan);
        final EditText interest = findViewById(R.id.txtInterest);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        Button button = findViewById(R.id.btnPayment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int intYears = Integer.parseInt(years.getText().toString());
                int intLoan = Integer.parseInt(loan.getText().toString());
                float decInterest = Float.parseFloat(interest.getText().toString());

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("years", intYears);
                editor.putInt("loan", intLoan);
                editor.putFloat("interest", decInterest);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
    }
}
