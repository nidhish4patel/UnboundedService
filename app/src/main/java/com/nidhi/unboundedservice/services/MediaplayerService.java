package com.nidhi.unboundedservice.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.nidhi.unboundedservice.R;

/**
 * Created by nidhi on 5/31/2017.
 */

public class MediaplayerService extends Service {

    private Context context = MediaplayerService.this;

    private MediaPlayer mediaPlayer;


    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(context, R.raw.mysong);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //Start Service.
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
    }
}
