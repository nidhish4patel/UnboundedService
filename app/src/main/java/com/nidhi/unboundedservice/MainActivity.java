package com.nidhi.unboundedservice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nidhi.unboundedservice.services.MediaplayerService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context = MainActivity.this;

    private Button btPlay, btStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btPlay = (Button)findViewById(R.id.button_play);
        btPlay.setOnClickListener(this);

        btStop = (Button)findViewById(R.id.button_stop);
        btStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, MediaplayerService.class);
        switch (v.getId()){

            case R.id.button_play:

                //Communication between Activity to service using Intent.

                startService(intent);

                break;

            case R.id.button_stop:

                stopService(intent);

                break;
        }
    }
}
