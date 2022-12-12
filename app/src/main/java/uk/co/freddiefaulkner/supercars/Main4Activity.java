package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {
    String username;
    MediaPlayer mediaPlayer;
    boolean soundOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("A");

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.d);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    public void goToGame(View view) {
        Intent intent = new Intent(this, Main5Activity.class);
        Bundle b = new Bundle();
        b.putString("A", username);
        mediaPlayer.pause();
        mediaPlayer.release();
        intent.putExtras(b);
        startActivity(intent);
    }

    public void getStats(View view) {
        Intent intent = new Intent(this, Main6Activity.class);
        Bundle b = new Bundle();
        b.putString("A", username);
        mediaPlayer.pause();
        mediaPlayer.release();
        intent.putExtras(b);
        startActivity(intent);
    }

    public void viewCards(View view) {
        mediaPlayer.pause();
        mediaPlayer.release();
        Intent intent = new Intent(this, ViewCards.class);
        startActivity(intent);
    }

    public void sound(View view) {
        if(!soundOn){
            mediaPlayer.start();
            soundOn = true;
        }
        else{
            mediaPlayer.pause();
            soundOn = false;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.d);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
        mediaPlayer.release();
    }
}