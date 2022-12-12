package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean soundOn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

    }
    public void goToLogin(View view){
        mediaPlayer.pause();
        mediaPlayer.release();
        Intent login = new Intent(this, Main2Activity.class);
        startActivity(login);
    }
    public void goToRegister(View view){
        mediaPlayer.pause();
        mediaPlayer.release();
        Intent register = new Intent(this, Main3Activity.class);
        startActivity(register);
    }

    public void goToTutorial(View view){
        mediaPlayer.pause();
        mediaPlayer.release();
        Intent tutorial = new Intent(this, youtubeTutorial.class);
        startActivity(tutorial);
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
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
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
