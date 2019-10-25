package org.lab137.techgadgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ipad extends AppCompatActivity {
    String url = "https://www.bestbuy.com/site/apple-11-inch-ipad-pro-latest-model-with-wi-fi-64gb-space-gray/5985628.p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipad);

        Button gotoBtn = findViewById(R.id.btnGoto);

        gotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
    }
}
