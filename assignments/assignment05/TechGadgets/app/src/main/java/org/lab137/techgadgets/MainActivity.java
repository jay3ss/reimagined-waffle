package org.lab137.techgadgets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private enum Product {
        TOSHIBA, DRONE, MACBOOK, IPAD, BEATS
    }

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

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Product product = Product.values()[position];

        switch (product) {
            case TOSHIBA:
                startActivity(new Intent(MainActivity.this, Toshiba.class));
                break;
            case DRONE:
                startActivity(new Intent(MainActivity.this, Drone.class));
                break;
            case MACBOOK:
                startActivity(new Intent(MainActivity.this, Macbook.class));
                break;
            case IPAD:
                startActivity(new Intent(MainActivity.this, Ipad.class));
                break;
            case BEATS:
                startActivity(new Intent(MainActivity.this, Beats.class));
                break;
        }
    }
}
