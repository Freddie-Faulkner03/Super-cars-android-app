package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

// imports stuff from android library
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// imports stuff from google/youtube library
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class youtubeTutorial extends YouTubeBaseActivity {
    // creates a new youtube player view for my video
    YouTubePlayerView youTubePlayerView;
    // creates a listener which will be used to check for video
    YouTubePlayer.OnInitializedListener onInitializedListener;
    // button created to allow user to play video
    Button btnPlay;
    // this bool is used to allow me to mute/unmute the sound
    boolean soundOn;
    // media player used to allow video to play in backend
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // loads the screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_tutorial);

        // starts and sets up the youtube video
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.j);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        // sets up button, player and textbox so it can perform tasks
        btnPlay = findViewById(R.id.btnPlay);
        youTubePlayerView = findViewById(R.id.youtube_player);
        final TextView txtFail = findViewById(R.id.txtFail);

        // sets up video to either load is connected to internet
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                txtFail.setText(" ");
                youTubePlayer.loadVideo("6RNtB--oGiw");
            }

            // shows error if video fails to load
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                txtFail.setText("Video Failed To Load!");
            }
        };

        // plays the video
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(YoutubePlayerConfig.getApiKey(), onInitializedListener);
            }
        });

    }

    // function used to check if sound is on or off if mute is pressed
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

    // when navigating away form is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
        mediaPlayer.release();
    }

    // sets up form if navigated back onto the form
    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.j);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }
}
