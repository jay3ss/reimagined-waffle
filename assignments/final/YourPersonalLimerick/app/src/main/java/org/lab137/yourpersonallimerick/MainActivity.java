package org.lab137.yourpersonallimerick;

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

        final EditText city       = findViewById(R.id.txtCity);
        final EditText occupation = findViewById(R.id.txtOccupation);
        final EditText number     = findViewById(R.id.txtNumber);
        final EditText verb       = findViewById(R.id.txtVerb);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Button button = findViewById(R.id.btnGenerate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strCity       = city.getText().toString();
                String strOccupation = occupation.getText().toString();
                float fltNumber      = Float.parseFloat(number.getText().toString());
                String strVerb       = verb.getText().toString();

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("city", strCity);
                editor.putString("occupation", strOccupation);
                editor.putFloat("number", fltNumber);
                editor.putString("verb", strVerb);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Limerick.class));
            }
        });
    }
}
