package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNum;

    public void generateRandomNumer() {
        Random rand = new Random();
        randomNum = rand.nextInt(20) + 1;

    }

    public void guess(View view) {

        EditText editText = (EditText) findViewById(R.id.et_number);
        int guessValue = Integer.parseInt(editText.getText().toString());
        String message = null;

        if(guessValue > randomNum) {
            message = "LOWER";
        }
        else if(guessValue < randomNum) {
            message = "GREATER";
        }
        else {
            Toast.makeText(this,"Yes right guess number is "+randomNum,Toast.LENGTH_SHORT).show();
            generateRandomNumer();
        }
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumer();
    }
}