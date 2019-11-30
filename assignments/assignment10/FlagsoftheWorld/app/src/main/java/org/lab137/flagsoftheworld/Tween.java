package org.lab137.flagsoftheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Tween extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        ImageView imgFadeaway = findViewById(R.id.imgTween);
        imgFadeaway.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fadeaway));
    }
}
