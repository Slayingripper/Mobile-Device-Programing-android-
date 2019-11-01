package com.example.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    static final int COLOUR_PICKER = 1;
    static final int BRUSH_PICKER = 2;
    FingerPainterView myFingerPainterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        myFingerPainterView = findViewById( R.id.view );

        myFingerPainterView.load( getIntent().getData() );


    }
    @Override
    protected void onSaveInstanceState (Bundle bundle) {
        super.onSaveInstanceState( bundle );
        //Saving brush colour
        bundle.putInt( "Colour", myFingerPainterView.getColour() );
        //Saving brush shape
        bundle.putString( "Shape", myFingerPainterView.getBrush().name() );
        //Saving brush width
        bundle.putInt( "Width", myFingerPainterView.getBrushWidth() );

    }
    public void onButton2Click(View v) {
        Intent intent = new Intent( MainActivity.this, ColourPicker.class );
        startActivityForResult( intent, COLOUR_PICKER );
    }

    public void onButtonClick(View v) {
        Intent intent = new Intent( MainActivity.this, BrushPicker.class );
        startActivity( intent );
    }
//restores the activity state
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState( savedInstanceState );

        //restore the brush shape

        String shape = savedInstanceState.getString("Shape");
        if(shape.equals("ROUND")){
            myFingerPainterView.setBrush(Paint.Cap.ROUND);
        }
        else {
            myFingerPainterView.setBrush( Paint.Cap.SQUARE);
        }
        myFingerPainterView.setBrushWidth(savedInstanceState.getInt("Width"));
        //restores the instance for colour
        myFingerPainterView.setColour( savedInstanceState.getInt( "Colour" ) );


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Changing the colour of the brush
        if ((requestCode == COLOUR_PICKER) && (resultCode == RESULT_OK)) {
            Bundle extras = data.getExtras();
            if (extras == null) return;
            int colour = extras.getInt( "Colour" );
            myFingerPainterView.setColour( colour );
        }
        //change the shape and size of brush by requesting the instance
        else if((requestCode== BRUSH_PICKER) && (resultCode==RESULT_OK)) {
            Bundle extras = data.getExtras();
            if(extras==null) return;
            String shape = extras.getString("Shape");
            if(shape!=null) {
                if (shape.equals("ROUND")) {
                    myFingerPainterView.setBrush(Paint.Cap.ROUND);
                } else if (shape.equals("SQUARE")) {
                    myFingerPainterView.setBrush(Paint.Cap.SQUARE);
                }
            }
            int width = extras.getInt("Width");
            if(width!=0) myFingerPainterView.setBrushWidth(width);
        }

    }
}

