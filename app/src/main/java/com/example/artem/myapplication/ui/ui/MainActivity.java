package com.example.artem.myapplication.ui.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.artem.myapplication.R;
import com.example.artem.myapplication.ui.Config;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFY_ID = 101;
    Button btn;
    Button btn1;
    Button btn2;
    TextView viewText;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent();
        intent.putExtra("name", Config.txt);
        setResult(RESULT_OK, intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewText = (TextView) findViewById(R.id.txt1);
        btn1 = (Button) findViewById(R.id.sendnotification);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String notiftitle, notiftext;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Context context = getApplicationContext();

                PendingIntent contentIntent = PendingIntent.getActivity(context,
                        0, intent,
                        PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationManager nm = (NotificationManager) context
                        .getSystemService(Context.NOTIFICATION_SERVICE);

                Notification.Builder builder = new Notification.Builder(context);

                builder.setContentIntent(contentIntent)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setWhen(System.currentTimeMillis())
                        .setContentTitle(String.valueOf(R.string.notiftitle))
                        .setContentText(String.valueOf(R.string.notiftext))
                        .setAutoCancel(true);

                Notification notification = builder.getNotification();
                nm.notify(NOTIFY_ID, notification);
            }
        });

        btn = (Button) findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(result, 0);
            }
        });

        btn2 = (Button) findViewById(R.id.send_data);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewText.setText(Config.txt);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
