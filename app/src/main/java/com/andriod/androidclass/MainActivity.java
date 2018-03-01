package com.andriod.androidclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_PIC_CLICKED = 322;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,PicActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(PicActivity.KEY_PIC_URL,"");

                intent.putExtras(bundle);

                startActivityForResult(intent,REQ_CODE_PIC_CLICKED);
            }
        },2000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_CANCELED)
            Toast.makeText(this,"canceled",Toast.LENGTH_LONG).show();

        if(resultCode != RESULT_OK){
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        Toast.makeText(this,
                "Image : "
                        + data.getExtras().getString(PicActivity.KEY_PIC_URL),
                Toast.LENGTH_LONG).show();

    }
}
