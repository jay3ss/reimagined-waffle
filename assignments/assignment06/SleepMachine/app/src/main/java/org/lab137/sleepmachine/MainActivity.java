package org.lab137.sleepmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnWaves, btnFan;
    MediaPlayer mpWaves, mpFan;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create play buttons for the MP3s
        btnWaves = findViewById(R.id.btnWaves);
        btnWaves.setOnClickListener(bWaves);

        btnFan = findViewById(R.id.btnFan);
        btnFan.setOnClickListener(bFan);

        // Create the media player instances
        mpWaves = new MediaPlayer();
        mpWaves = MediaPlayer.create(this, R.raw.waves);

        mpFan = new MediaPlayer();
        mpFan = MediaPlayer.create(this, R.raw.fan);

        // The song is not playing
        playing = 0;
    }

    Button.OnClickListener bWaves = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                // The waves MP3 is NOT playing
                case 0:
                    mpWaves.start();
                    playing = 1;
                    btnWaves.setText("Pause Waves Track");
                    btnFan.setVisibility(View.INVISIBLE);
                    break;
                // The waves MP3 is playing
                case 1:
                    mpWaves.pause();
                    playing = 0;
                    btnWaves.setText("Play Waves Track");
                    btnFan.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener bFan = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                // The waves MP3 is NOT playing
                case 0:
                    mpFan.start();
                    playing = 1;
                    btnFan.setText("Pause Fan Track");
                    btnWaves.setVisibility(View.INVISIBLE);
                    break;
                // The waves MP3 is playing
                case 1:
                    mpFan.pause();
                    playing = 0;
                    btnFan.setText("Play Fan Track");
                    btnWaves.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}
