package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    EditText txtFirstName, txtLastName, txtEmail, txtPassword, txtUsername, txtConfirmPassword;
    TextView txtError;
    Boolean empty, soundOn = true;
    RadioButton male, female, other;
    String firstName, lastName, email, username, password, gender;
    SQLiteDatabase users;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.c);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        txtFirstName = (EditText) findViewById(R.id.txtFirstName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtError = (TextView) findViewById(R.id.txtError);
        male = (RadioButton) findViewById(R.id.Male);
        female = (RadioButton) findViewById(R.id.Female);
        other = (RadioButton) findViewById(R.id.Other);

        // users = openOrCreateDatabase("users.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

    }


    public void cancel(View view) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle("Cancel").setMessage("Are you sure you want to cancel");
        myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        myAlert.show();
    }

    public void submit(View view) {
        if(!checkCredentials()){
            firstName = txtFirstName.getText().toString();
            lastName = txtLastName.getText().toString();
            email = txtEmail.getText().toString();
            username = txtUsername.getText().toString();
            password = txtPassword.getText().toString();

            if(male.isChecked()){
                gender = "Male";
            }
            else if (female.isChecked()){
                gender = "Female";
            }
            else{
                gender = "Other";
            }

            CustomerModel customerModel = new CustomerModel(firstName, lastName, email, username, password, gender, 0, 0);

            DatabaseHelper databaseHelper = new DatabaseHelper(Main3Activity.this);
            boolean success = databaseHelper.addOne(customerModel);
            if (success){
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            }

            mediaPlayer.pause();
            mediaPlayer.release();
            Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
            startActivity(intent);
        }
    }

    public Boolean checkCredentials(){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<String> usernames = new ArrayList<>();
        usernames = databaseHelper.getUsername();
        ArrayList<String> emails = new ArrayList<>();
        emails = databaseHelper.getEmail();

        if (checkEmpty()){
            txtError.setText("you have empty fields");
            return true;
        }
        else if (txtFirstName.getText().toString().contains(" ") | txtFirstName.getText().toString().trim().length() > 50){
            txtError.setText("First name is not correct");
            return true;
        }
        else if (txtLastName.getText().toString().contains(" ") | txtLastName.getText().toString().trim().length() > 50){
            txtError.setText("Last name is not correct");
            return true;
        }
        else if (txtEmail.getText().toString().contains(" ") | ! txtEmail.getText().toString().contains("@")){
            txtError.setText("email is not valid");
            return true;
        }
        else if (emails.contains(txtEmail.getText().toString())){
            txtError.setText("email address already registered");
            return true;
        }
        else if (txtUsername.getText().toString().trim().length() < 3 | txtUsername.getText().toString().contains(" ") | txtUsername.getText().toString().trim().length() > 50){
            txtError.setText("username is not elegible");
            return true;
        }
        else if (usernames.contains(txtUsername.getText().toString())){
            txtError.setText("username is already taken");
            return true;
        }
        else if (txtPassword.getText().toString().trim().length() < 6){
            txtError.setText("password is not long enough");
            return true;
        }
        else if (txtPassword.getText().toString().trim().length() > 25){
            txtError.setText("password is too long");
            return true;
        }
        else if (!txtConfirmPassword.getText().toString().equals(txtPassword.getText().toString())){
            txtError.setText("passwords do not match");
            return true;
        }
        else{
            return false;
        }

    }

    public Boolean checkEmpty(){
        if (txtFirstName.getText().toString().trim().length() < 1){
            return true;
        }
        else if (txtLastName.getText().toString().trim().length() < 1){
            return true;
        }
        else if (txtEmail.getText().toString().trim().length() < 1){
            return true;
        }
        else if (txtPassword.getText().toString().trim().length() < 1){
            return true;
        }
        else if (txtConfirmPassword.getText().toString().trim().length() < 1){
            return true;
        }
        else if (txtUsername.getText().toString().trim().length() < 1){
            return true;
        }
        else if (! male.isChecked() & ! female.isChecked() & ! other.isChecked()){
            return true;
        }
        else{
            return false;
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
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.c);
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
