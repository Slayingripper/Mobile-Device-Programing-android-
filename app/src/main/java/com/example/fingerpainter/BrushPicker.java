package com.example.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class BrushPicker extends AppCompatActivity {
    private Intent data = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_picker);
    }
/*FUNCTION FOR CHANGING  BRUSH SHAPE TO ROUND*/
    public void roundbtn (View v) {
        data.putExtra("Shape", "ROUND");
    }
    /*FUNCTION FOR CHANGING  BRUSH SHAPE TO SQUARE*/
    public void squarebtn(View v) {
        data.putExtra("Shape", "SQUARE");
    }
    /*FUNCTION FOR CHANGING  BRUSH SIZE TO 5PX*/
    public void fivebtn(View v) {
        data.putExtra("Width", 5);
    }
    /*FUNCTION FOR CHANGING  BRUSH SHAPE TO 10PX*/
    public void tenbtn(View v) {
        data.putExtra("Width", 10);
    }
    /*FUNCTION FOR CHANGING  BRUSH SHAPE TO 20PX*/
    public void twentybtn(View v) {
        data.putExtra("Width", 20);
    }
    /*FUNCTION FOR CHANGING  BRUSH SHAPE TO 30PX*/
    public void thirtybtn(View v) {
        data.putExtra("Width", 30);
    }
    /*FUNCTION FOR CHANGING  BRUSH SHAPE TO 64PX*/
    public void sixfourbtn(View v) {
        data.putExtra("Width", 64);
    }
    public void backbtn(View v) {
        setResult(RESULT_OK,data);
        finish();
    }
}
