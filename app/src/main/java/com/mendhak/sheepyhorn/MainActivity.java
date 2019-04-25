package com.mendhak.sheepyhorn;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener, MediaPlayer.OnCompletionListener {


    boolean alreadyPlaying;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.player = MediaPlayer.create(getApplicationContext(), R.raw.sheepyhorn);
        findViewById(R.id.sound_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(this.alreadyPlaying){ return; }

        this.alreadyPlaying = true;
        this.player.start();
        this.player.setOnCompletionListener(this);

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        this.alreadyPlaying=false;
    }
}
