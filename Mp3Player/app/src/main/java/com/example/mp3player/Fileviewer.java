package com.example.mp3player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class Fileviewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fileviewer );

        final ListView lv = findViewById(R.id.ListView);
        File directory = new File( Environment.getExternalStorageDirectory().getPath()+ "/Music/");
        File list[] = directory.listFiles();

        //load the contents of the directory and send them back to the main activity when selected
        lv.setAdapter(new ArrayAdapter<File>(this,android.R.layout.simple_list_item_1, list));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                File selectedFromList = (File) (lv.getItemAtPosition( myItemInt ));
                String filePath = selectedFromList.getAbsolutePath();
                Log.d( "MusicPlayer", filePath );


                Intent data = new Intent();
                data.putExtra( "filePath", filePath );
                setResult( RESULT_OK, data );
                finish();


                //sends result back to main
            }
            }
        );}
}