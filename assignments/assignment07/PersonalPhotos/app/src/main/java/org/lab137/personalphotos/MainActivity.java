package org.lab137.personalphotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Family = {
            R.drawable.atthemuseum, R.drawable.bilsfamily,
            R.drawable.bilsfamilyportrait, R.drawable.brothernnephew,
            R.drawable.niece, R.drawable.sisnnephew,
            R.drawable.sisternfamily, R.drawable.wifenkids
    };
    Integer[] FamilyMembers = {
            R.string.atthemuseum, R.string.bilsfamily,
            R.string.bilsfamilyportrait, R.string.brothernnephew,
            R.string.niece, R.string.sisnnephew,
            R.string.sisternfamily, R.string.wifenkids
    };
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = findViewById(R.id.gridView);
        final ImageView pic = findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(
                    getBaseContext(),
                    FamilyMembers[position],
                    Toast.LENGTH_SHORT)
                    .show();
                pic.setImageResource(Family[position]);
            }
        });
    }

    private class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return Family.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Family[position]);
            pic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            pic.setLayoutParams(new GridView.LayoutParams(330, 300));
            return pic;
        }
    }
}
