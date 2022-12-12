package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Main7Activity extends AppCompatActivity {
    String choice, username, changedItem;
    EditText txtChange, txtChangeConfirm;
    ArrayList<String> emails = new ArrayList<>();
    ArrayList<String> userNames = new ArrayList<>();
    TextView txtError, txtTitle;
    MediaPlayer mediaPlayer;
    Boolean soundOn = true;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.g);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        txtChange = (EditText) findViewById(R.id.txtChange);
        txtChangeConfirm = (EditText) findViewById(R.id.txtChangeConfirm);
        txtTitle = (TextView) findViewById(R.id.image);
        txtError = (TextView) findViewById(R.id.txtError);

        Bundle b = getIntent().getExtras();
        choice = b.getString("A");
        username = b.getString("B");

        txtTitle.setText("Change " + choice);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        emails = databaseHelper.getEmail();
        userNames = databaseHelper.getUsername();



    }

    public void updateDb(View view) {
        if(isValid()){

            if(choice.equals("email")){
                DatabaseHelper databaseHelper = new DatabaseHelper(this);
                changedItem = txtChange.getText().toString();
                databaseHelper.updateEmail(changedItem, username);
            }

            else{
                DatabaseHelper databaseHelper = new DatabaseHelper(this);
                changedItem = txtChange.getText().toString();
                databaseHelper.updateUsername(username, changedItem);
            }

            mediaPlayer.pause();
            mediaPlayer.release();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

    public boolean isEmpty(){
        if (txtChange.getText().toString().trim().length() < 1) {
            return true;
        }

        if (txtChange.getText().toString().trim().length() < 1) {
            return true;
        }

        return false;
    }

    public boolean isValid(){
        if(isEmpty()){
            return false;
        }

        if(choice.equals("email")){
            if (txtChange.getText().toString().contains(" ") | ! txtChange.getText().toString().contains("@")){
                txtError.setText("email is not valid");
                return false;
            }
            else if (emails.contains(txtChange.getText().toString())){
                txtError.setText("email address already registered");
                return false;
            }
        }
        else{
             if (txtChange.getText().toString().trim().length() < 3 | txtChange.getText().toString().contains(" ") | txtChange.getText().toString().trim().length() > 50){
                txtError.setText("username is not elegible");
                return false;
            }
            else if (userNames.contains(txtChange.getText().toString())){
                txtError.setText("username is already taken");
                return false;
            }
        }

        if(txtChange.getText().toString().equals(txtChangeConfirm.getText().toString()))
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
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.g);
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
