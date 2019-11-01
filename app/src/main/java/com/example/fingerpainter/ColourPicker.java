package com.example.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


public class ColourPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_picker);
    }

    public void redbtn(View v) {
        Intent data = new Intent();
        data.putExtra("Colour", Color.RED);
        setResult(RESULT_OK, data);
        finish();
    }
    public void bluebtn(View v) {
        Intent data = new Intent();
        data.putExtra("Colour", Color.BLUE);
        setResult(RESULT_OK, data);
        finish();
    }
    public void blackbtn(View v) {
        Intent data = new Intent();
        data.putExtra("Colour", Color.BLACK);
        setResult(RESULT_OK, data);
        finish();
    }
    public void yellowbtn(View v) {
        Intent data = new Intent();
        data.putExtra("Colour", Color.YELLOW);
        setResult(RESULT_OK, data);
        finish();
    }
    public void greenbtn(View v) {
        Intent data = new Intent();
        data.putExtra("Colour", Color.GREEN);
        setResult(RESULT_OK, data);
        finish();
    }
}
