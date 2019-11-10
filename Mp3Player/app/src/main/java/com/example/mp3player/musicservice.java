package com.example.mp3player;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class musicservice extends Service {

    MP3Player mp3Player;
    Intent notifyIntent;
    NotificationManager notifyManager;
    NotificationCompat.Builder notifyBuilder;

    private final String tag = "music service";
    private musichandler binder = new musichandler();

    public class musichandler extends Binder

    {

        public void play() {
            mp3Player.play();
            Log.i(tag, "Play that funky music");
        }

        public void pause() {
            mp3Player.pause();
            Log.i(tag, "Music Paused");
        }

        public void stop() {
            mp3Player.stop();
            Log.i(tag, "Music Stopped");
        }
        public int getDuration() {
            return mp3Player.getDuration();
        }

        public int getProgress() {
            return mp3Player.getProgress();
        }

        public String getFilePath() {
            return mp3Player.getFilePath();
        }

        public MP3Player.MP3PlayerState getState() {
            return mp3Player.getState();
        }

        public void seekTo(int msec) {

            mp3Player.seekTo(msec);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.i(tag, "onBind");
        return binder;
    }
    @Override
    public void onCreate() {

        super.onCreate();
        mp3Player = new MP3Player();

        notifyIntent = new Intent(this, MainActivity.class);
        notifyManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notifyBuilder = new NotificationCompat.Builder(this)
                .setContentIntent(PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT))
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("MP3PLAYER")
                .setContentText("Application started running...");

        notifyManager.notify(1, notifyBuilder.build());
        Log.i(tag, "service onCreate");
        Log.i(tag, "notification created");
    }
    @Override
    public boolean onUnbind(Intent intent) {
        notifyManager.cancel(1);
        mp3Player.stop();
        Log.i(tag, "onUnbind");
        Log.i(tag, "notification cancelled");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(tag, "onDestroy");
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(tag, "onRebind");
        super.onRebind(intent);
    }



}
