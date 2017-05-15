package com.example.rdnasim.threadsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickHeroAlam(View view) {
        long futuretime = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < futuretime) {
            synchronized (this) {
                try {
                    wait(futuretime - System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        }
        TextView myText = (TextView) findViewById(R.id.myText);
        myText.setText("Please Search in\nwww.Google.com.bd");
    }
}