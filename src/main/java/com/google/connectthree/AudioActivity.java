package com.google.connectthree;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPlay, btnPause;
    MediaPlayer mp;
    SeekBar vol;
    SeekBar timeBar;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        btnPause = (Button) findViewById(R.id.btnpause);
        btnPlay = (Button) findViewById(R.id.btnplay);
        vol = (SeekBar) findViewById(R.id.vol);
        timeBar = (SeekBar) findViewById(R.id.time);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mp = MediaPlayer.create(this, R.raw.macan);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        timeBar.setMax(mp.getDuration());
        timeBar.setProgress(0);

        vol.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        vol.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                timeBar.setProgress(mp.getCurrentPosition());
            }
        },0,100);
        vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        timeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
              if(fromUser)
                mp.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnplay:
                mp.start();
                break;
            case R.id.btnpause:
                mp.pause();
                break;
            default: break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mp.stop();
        finish();
        return super.onOptionsItemSelected(item);
    }
}
