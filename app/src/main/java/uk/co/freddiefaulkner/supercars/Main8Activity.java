package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main8Activity extends AppCompatActivity {
    String username, choice;
    EditText txtOldPassword, txtChange, txtConfirmChange;
    TextView txtTitle, txtError;
    MediaPlayer mediaPlayer;
    Boolean soundOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.h);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        Bundle b = getIntent().getExtras();
        choice = b.getString("A");
        username = b.getString("B");

        txtOldPassword = (EditText) findViewById(R.id.txtOldPassword);
        txtConfirmChange = (EditText) findViewById(R.id.txtConfirmChange);
        txtChange = (EditText) findViewById(R.id.txtChange);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtError = (TextView) findViewById(R.id.txtError);

        txtTitle.setText("change " + choice);

    }

    public void updateDb(View view) {
        if(isValid()){
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            databaseHelper.updatePassword(username, txtChange.getText().toString());
            mediaPlayer.pause();
            mediaPlayer.release();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

    public boolean isValid(){
        if(isEmpty())
            return false;

        if (txtChange.getText().toString().trim().length() < 6){
            txtError.setText("password is not long enough");
            return false;
        }
        else if (txtChange.getText().toString().trim().length() > 25){
            txtError.setText("password is too long");
            return false;
        }
        else if (!txtConfirmChange.getText().toString().equals(txtChange.getText().toString())){
            txtError.setText("passwords do not match");
            return false;
        }

        return true;
    }

    public boolean isEmpty(){
        if(txtOldPassword.getText().toString().equals(""))
            return true;
        if(txtChange.getText().toString().equals(""))
            return true;
        if(txtConfirmChange.getText().toString().equals(""))
            return true;

        return false;
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
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.h);
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

