package com.example.user.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dispaly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispaly);
        Button upgrade= (Button) findViewById(R.id.upd);
        Button delete= (Button) findViewById(R.id.del);
        TextView textView= (TextView) findViewById(R.id.n);
        TextView textView1= (TextView) findViewById(R.id.e);
        TextView textView2= (TextView) findViewById(R.id.g);
        TextView textView3= (TextView) findViewById(R.id.p);
        TextView textView4= (TextView) findViewById(R.id.c);
        TextView textView5= (TextView) findViewById(R.id.l);
        TextView textView6= (TextView) findViewById(R.id.pw);
        TextView textView7= (TextView) findViewById(R.id.cpw);
        final Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        String  password=intent.getStringExtra("password");
        final OuterDb outerDb=new OuterDb(getApplicationContext());
        Cursor value=outerDb.login(username,password);


        if(value.getCount()>0) {

            while (value.moveToNext()) {

                final int id = value.getInt(value.getColumnIndex(OuterDb.Squliteclssext.id));
                final String name = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.name));
                final String email = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.email));
                final String user = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.username));
                final String pass = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.password));
                final String confirm = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.confirm));
                final String phone = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.phone));
                final String gender = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.gender));
                final String country = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.country));
                final String lang = value.getString(value.getColumnIndex(OuterDb.Squliteclssext.lang));
                textView.setText(name);
                textView1.setText(email);
                textView2.setText(gender);
                textView3.setText(phone);
                textView4.setText(country);
                textView5.setText(lang);
                textView6.setText(password);
                textView7.setText(confirm);
                upgrade.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1=new Intent(getApplicationContext(),Update.class);
                        intent1.putExtra("name",name);
                        intent1.putExtra("email",email);
                        intent1.putExtra("user",user);
                        intent1.putExtra("pass",pass);
                        intent1.putExtra("confirm",confirm);
                        intent1.putExtra("phone",phone);
                        intent1.putExtra("gender",gender);
                        intent1.putExtra("country",country);
                        intent1.putExtra("lang",lang);
                        intent1.putExtra("id",id);
                        startActivity(intent1);
                    }
                });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OuterDb outerDb1=new OuterDb(getApplicationContext());
                        long val=outerDb1.delete(user,pass);
                        if(val>0) {
                            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"not deleted",Toast.LENGTH_LONG).show();
                        Intent intent1=new Intent(getApplicationContext(),Login.class);
                        startActivity(intent1);
                        finishAffinity();

                    }
                });


            }
        }
        else {

            Toast.makeText(getApplicationContext(),"Wrong id or password",Toast.LENGTH_LONG).show();
            Intent intent1=new Intent(getApplicationContext(),Login.class);
            startActivity(intent1);
            finishAffinity();
        }

    }


}

