package com.andriod.androidclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class PicActivity extends AppCompatActivity {

    public static final String KEY_PIC_URL = "picUrl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(this);
        setContentView(imageView);

        final Intent intent = getIntent();
        if(intent == null) {
            Toast.makeText(this, "Intent mustn't be null", Toast.LENGTH_LONG).show();
            finish();
        }

        Bundle bundle = intent.getExtras();
        if(bundle == null) {
            Toast.makeText(this, "Bundle mustn't be null", Toast.LENGTH_SHORT).show();
            finish();
        }

        String picUrl = bundle.getString(KEY_PIC_URL);
        if(picUrl == null) {
            Toast.makeText(this, "picUrl mustn't be null", Toast.LENGTH_LONG).show();
            finish();
        }

        final boolean[] isClicked = {false};

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked[0] = true;
            }
        });

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if(isClicked[0])
                    setResult(RESULT_OK,intent);
                else
                    setResult(RESULT_CANCELED,intent);

                finish();
            }
        },2000);

    }

}
