package org.lab137.techgadgets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] products = {
            "Toshiba - 50” Class – Fire TV Edition",
            "DJI - Mavic 2 Pro Quadcopter",
            "Apple - MacBook Air - 13.3\"",
            "Apple - 11-Inch iPad Pro (64GB)",
            "Beats Solo3 Wireless Headphones"
        };

        setListAdapter(
            new ArrayAdapter<String>(
                this,
                R.layout.activity_main,
                R.id.product,
                products)
        );
    }
}
