package org.lab137.techgadgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Toshiba extends AppCompatActivity {
    String url = "https://www.bestbuy.com/site/toshiba-50-class-led-2160p-smart-4k-uhd-tv-with-hdr-fire-tv-edition/6194909.p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toshiba);

        Button gotoBtn = findViewById(R.id.btnGoto);

        gotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
    }
}
