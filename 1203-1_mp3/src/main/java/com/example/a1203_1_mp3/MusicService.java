package com.example.a1203_1_mp3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service{
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        Log.i("young","onCreate()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("young","onStartCommand()");
        mp = MediaPlayer.create(this,R.raw.koreansong);
        mp.setLooping(true);
        mp.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("young","onDestroy()");
        mp.stop();
        super.onDestroy();
    }
}
