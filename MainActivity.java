package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button regButton= (Button) findViewById(R.id.reg);
        final RadioGroup radioGroup= (RadioGroup) findViewById(R.id.rgup);
        final CheckBox checkBox1= (CheckBox) findViewById(R.id.chk1);
        final CheckBox checkBox2= (CheckBox)findViewById(R.id.chk2);
        final CheckBox checkBox3=(CheckBox)findViewById(R.id.chk3);
        final Spinner spinner= (Spinner) findViewById(R.id.spin);
        final EditText editText= (EditText) findViewById(R.id.name);
        final EditText editText1= (EditText) findViewById(R.id.email);
        final EditText editText2= (EditText) findViewById(R.id.uname);
        final EditText editText3= (EditText) findViewById(R.id.pass);
        final EditText editText4= (EditText) findViewById(R.id.cpass);
        final EditText editText5= (EditText) findViewById(R.id.pno);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OuterDb outerDb=new OuterDb(getApplicationContext());
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(id);
                String gender = radioButton.getText().toString();
                String  country=spinner.getSelectedItem().toString();
                String password=editText3.getText().toString();
                String confirm=editText4.getText().toString();
                if(password.equals(confirm)==false)
                    Toast.makeText(getApplicationContext(),"Reenter password correctly",Toast.LENGTH_LONG).show();
                else
                {
                    String lang = "";
                    if (checkBox1.isChecked()) {
                        lang = lang + checkBox1.getText().toString() + " ";
                    }
                    if (checkBox2.isChecked()) {
                        lang = lang + checkBox2.getText().toString() + " ";
                    }
                    if (checkBox3.isChecked()) {
                        lang = lang + checkBox3.getText().toString() + " ";
                    }
                    Toast.makeText(getApplicationContext(), lang, Toast.LENGTH_LONG).show();
                    long ress = outerDb.insetdata(editText.getText().toString(), editText1.getText().toString(), editText2.getText().toString(), password, confirm, editText5.getText().toString(), gender, country, lang);
                    if (ress > 0) {
                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(), "not registered", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
