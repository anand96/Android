package com.example.user.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button regButton = (Button) findViewById(R.id.button2);
        final Button regButton1 = (Button) findViewById(R.id.button1);
        final Button regButton2 = (Button) findViewById(R.id.button3);
        final EditText et = (EditText) findViewById(R.id.username);
        final EditText et1 = (EditText) findViewById(R.id.password);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String username = et.getText().toString();
                Toast.makeText(getApplicationContext(), username, Toast.LENGTH_LONG).show();
                startActivity(intent);


            }
        });
        regButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et.getText().toString();
                String password = et1.getText().toString();
                Intent intent1 = new Intent(getApplicationContext(), Dispaly.class);
                intent1.putExtra("username", username);
                intent1.putExtra("password", password);
                startActivity(intent1);

            }
        });
        regButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Forgotp.class);
                startActivity(intent2);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext());
                Notification notification= builder.setSmallIcon(R.drawable.mesg)
                        .setContentTitle("My Notification")
                        .setContentText("Change password")
                        .build();
                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1,notification);


            }
        });

    }

}
