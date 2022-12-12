package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class youtubeTutorial extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    Button btnPlay;
    boolean soundOn;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_tutorial);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.j);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        btnPlay = findViewById(R.id.btnPlay);
        youTubePlayerView = findViewById(R.id.youtube_player);
        final TextView txtFail = findViewById(R.id.txtFail);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                txtFail.setText(" ");
                youTubePlayer.loadVideo("6RNtB--oGiw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                txtFail.setText("Video Failed To Load!");
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(YoutubePlayerConfig.getApiKey(), onInitializedListener);
            }
        });

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
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
        mediaPlayer.release();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.j);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }
}
