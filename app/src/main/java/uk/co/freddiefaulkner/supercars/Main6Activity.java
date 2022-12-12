package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main6Activity extends AppCompatActivity {
    String username;
    TextView txtFirstName, txtLastName, txtEmail, txtUsername, txtHighScore;
    Button btnChangeUn, btnChangeEmail, btnChangePassword;
    MediaPlayer mediaPlayer;
    Boolean soundOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.f);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        Bundle b = getIntent().getExtras();
        username = b.getString("A");

        txtFirstName = (TextView) findViewById(R.id.txtFirstName);
        txtLastName = (TextView) findViewById(R.id.txtLastName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtHighScore = (TextView) findViewById(R.id.txtHighScore);

        btnChangeEmail = (Button) findViewById(R.id.btnChangeEmail);
        btnChangeUn = (Button) findViewById(R.id.btnChangeUn);
        btnChangePassword = (Button) findViewById(R.id.btnChangePassword);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        txtFirstName.setText("First Name: " + databaseHelper.getFirstName(username));
        txtLastName.setText("Last Name: " + databaseHelper.getLastName(username));
        txtEmail.setText("Email: " + databaseHelper.getEmail(username));
        txtUsername.setText("Username: " + databaseHelper.getUsername(username));
        txtHighScore.setText("Wins: " + databaseHelper.getHighScore(username));
    }

    public void changeText(View view) {
        String choice = "";
        switch(view.getId()){

            case R.id.btnChangeUn:
                choice = "username";
                mediaPlayer.pause();
                mediaPlayer.release();
                Intent intent1 = new Intent(this, Main7Activity.class);
                Bundle b1 = new Bundle();
                b1.putString("A", choice);
                b1.putString("B", username);
                intent1.putExtras(b1);
                startActivity(intent1);
                break;

            case R.id.btnChangeEmail:
                choice = "email";
                mediaPlayer.pause();
                mediaPlayer.release();
                Intent intent2 = new Intent(this, Main7Activity.class);
                Bundle b2 = new Bundle();
                b2.putString("A", choice);
                b2.putString("B", username);
                intent2.putExtras(b2);
                startActivity(intent2);
                break;

           case R.id.btnChangePassword:
                choice = "password";
                mediaPlayer.pause();
                mediaPlayer.release();
                Intent intent3 = new Intent(this, Main8Activity.class);
                Bundle b3 = new Bundle();
                b3.putString("A", choice);
                b3.putString("B", username);
                intent3.putExtras(b3);
                startActivity(intent3);
                break;
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
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.f);
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
