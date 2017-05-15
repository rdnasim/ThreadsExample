package com.example.rdnasim.threadsexample;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            TextView myText = (TextView) findViewById(R.id.myText);
            myText.setText("Please Search in\nwww.Google.com.bd");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickHeroAlam(View view) {

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                long futuretime = System.currentTimeMillis() + 10000;

                while (System.currentTimeMillis() < futuretime) {
                    synchronized (this) {
                        try {
                            wait(futuretime - System.currentTimeMillis());
                        } catch (Exception e) {
                        }
                    }
                }

                handler.sendEmptyMessage(1);

            }
        };

        Thread myThread = new Thread(runnable);
        myThread.start();

        TextView myText = (TextView) findViewById(R.id.myText);
        myText.setText("Please Search in\nwww.Google.com.bd");
    }
}