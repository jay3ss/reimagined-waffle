package org.lab137.yourpersonallimerick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Limerick extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limerick);

        TextView title = findViewById(R.id.txtTitleLimerickAct);
        TextView limerick = findViewById(R.id.txtLimerick);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String city       = prefs.getString("city", "Los Angeles");
        String occupation = prefs.getString("occupation", "engineer");
        float number      = prefs.getFloat("number", 2);
        String verb       = prefs.getString("verb", "built");

        title.setText("The " + occupation + " from " + city);

        DecimalFormat format = new DecimalFormat("###,###.##");

        String txtLimerick = "There was ";

        if (isVowel(occupation.substring(0, 1))) {
            txtLimerick += "an ";
        } else {
            txtLimerick += "a ";
        }

        txtLimerick += occupation + " from " + city + " with a beard\n";
        txtLimerick += "Who said, 'It is just as I feared!'\n";
        txtLimerick += "\t\t" + format.format(number) + " Owls and a Hen,\n";
        txtLimerick += "\t\t" + format.format(2 * number) + " Larks and a Wren,\n";
        txtLimerick += "Have all " + verb + " their nests in my beard!";

        limerick.setText(txtLimerick);
    }

    public boolean isVowel(String letter) {
        String[] vowels = {"a", "e", "i", "o", "u"};

        for (String v: vowels) {
            if (v.equals(letter.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
