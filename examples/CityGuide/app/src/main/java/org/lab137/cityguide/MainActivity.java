package org.lab137.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    public enum Attraction {
        ART_INSTITUTE, MAGNIFICENT_MILE, WILLIS_TOWER,
        NAVY_PIER, WATER_TOWER
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String []attraction = {
            "Art Institute of Chicago",
            "Magnificent Mile",
            "Willis Tower",
            "Navy Pier",
            "Water Tower"
        };
        setListAdapter(new ArrayAdapter<String>(
            this,
            R.layout.activity_main,
            R.id.travel,
            attraction
        ));
    }

    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        Attraction attraction = Attraction.values()[position];

        switch (attraction) {
            case ART_INSTITUTE:
                startActivity(
                    new Intent(
                        Intent.ACTION_VIEW, Uri.parse(
                            "http://artic.edu"
                        )
                    )
                );
                break;
            case MAGNIFICENT_MILE:
                startActivity(
                    new Intent(
                        Intent.ACTION_VIEW, Uri.parse(
                            "http://themagnificentmile.com"
                        )
                    )
                );
                break;
            case WILLIS_TOWER:
                startActivity(new Intent(MainActivity.this, Willis.class));
                break;
            case NAVY_PIER:
                startActivity(new Intent(MainActivity.this, Pier.class));
                break;
            case WATER_TOWER:
                startActivity(new Intent(MainActivity.this, Water.class));
                break;
        }
    }
}
