package org.lab137.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnUkulele, btnDrums;
    MediaPlayer mpUkulele, mpDrums;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create play buttons for the MP3s
        btnUkulele = findViewById(R.id.btnUkulele);
        btnUkulele.setOnClickListener(bUkulele);

        btnDrums = findViewById(R.id.btnDrums);
        btnDrums.setOnClickListener(bDrums);

        // Create the media player instances
        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);

        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);

        // The song is not playing
        playing = 0;
    }

    Button.OnClickListener bUkulele = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                // The ukulele MP3 is NOT playing
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    btnUkulele.setText("Pause Ukulele Song");
                    btnDrums.setVisibility(View.INVISIBLE);
                    break;
                // The ukulele MP3 is playing
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    btnUkulele.setText("Play Ukulele Song");
                    btnDrums.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener bDrums = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                // The ukulele MP3 is NOT playing
                case 0:
                    mpDrums.start();
                    playing = 1;
                    btnDrums.setText("Pause Drums Song");
                    btnUkulele.setVisibility(View.INVISIBLE);
                    break;
                // The ukulele MP3 is playing
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    btnDrums.setText("Play Drums Song");
                    btnUkulele.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}
