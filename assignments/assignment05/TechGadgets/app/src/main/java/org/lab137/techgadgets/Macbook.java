package org.lab137.techgadgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Macbook extends AppCompatActivity {
    String url = "https://www.bestbuy.com/site/apple-macbook-air-13-3-retina-display-intel-core-i5-8gb-memory-128gb-flash-storage-space-gray/5998704.p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macbook);

        Button gotoBtn = findViewById(R.id.btnGoto);

        gotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
    }
}
