package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    TextView txtError;
    boolean soundOn;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.b);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtError = (TextView) findViewById(R.id.txtError);
    }

    public Boolean checkCredentials(){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<String> usernames = databaseHelper.getUsername();
        ArrayList<String> emails = databaseHelper.getEmail();
        String username = txtEmail.getText().toString();

        if(usernames.contains(username) | emails.contains(username)){
           String password = databaseHelper.getPassword(username);

           if(password.equals(txtPassword.getText().toString())){
               return false;
           }
           else{
               txtError.setText("password is incorrect");
               return true;
           }
        }
        else{
            txtError.setText("email or username not found");
            return true;
        }
    }

    public void goToGame(View view) {
        if(!checkCredentials()){
            Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
            mediaPlayer.pause();
            mediaPlayer.release();
            Intent intent = new Intent(this, Main4Activity.class);
            Bundle b = new Bundle();
            b.putString("A", txtEmail.getText().toString());
            intent.putExtras(b);
            startActivity(intent);
        }
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
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.b);
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
