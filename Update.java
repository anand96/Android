package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Button update= (Button) findViewById(R.id.upd);
        Intent intent=getIntent();
        final EditText editText= (EditText) findViewById(R.id.n);
        final EditText editText1= (EditText)  findViewById(R.id.e);
        final EditText editText2= (EditText) findViewById(R.id.g);
        final EditText editText3= (EditText) findViewById(R.id.p);
        final EditText editText4= (EditText)  findViewById(R.id.c);
        final EditText editText5= (EditText)  findViewById(R.id.l);
        final EditText editText6= (EditText) findViewById(R.id.u);
        final EditText editText7= (EditText) findViewById(R.id.pw);
        final int id=intent.getIntExtra("id",0);

        editText.setText(intent.getStringExtra("name"));
        editText1.setText(intent.getStringExtra("email"));
        editText2.setText(intent.getStringExtra("gender"));
        editText3.setText(intent.getStringExtra("phone"));
        editText4.setText(intent.getStringExtra("country"));
        editText5.setText(intent.getStringExtra("lang"));
        editText6.setText(intent.getStringExtra("user"));
        editText7.setText(intent.getStringExtra("pass"));
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OuterDb outerDb=new OuterDb(getApplicationContext());
               long val= outerDb.update(id,editText.getText().toString(),editText1.getText().toString(),editText6.getText().toString(),editText7.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString(),editText5.getText().toString());
                if (val > 0)
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                    else
                    Toast.makeText(getApplicationContext(),"not updated",Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(getApplicationContext(),Login.class);
                startActivity(intent1);
            }
        });

    }
}
