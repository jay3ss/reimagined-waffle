package org.lab137.techgadgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Beats extends AppCompatActivity {
    String url = "https://www.amazon.com/Beats-Solo3-Wireless-Ear-Headphones/dp/B01LWWY3E2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beats);

        Button gotoBtn = findViewById(R.id.btnGoto);

        gotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
    }
}
