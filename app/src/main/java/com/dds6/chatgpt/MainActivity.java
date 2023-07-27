package com.dds6.chatgpt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText txt_name,txt_age;
    private Button btn_save;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText
        txt_name = this.findViewById(R.id.txt_name);
        txt_age = this.findViewById(R.id.txt_age);
        //Button
        btn_save = this.findViewById(R.id.btn_save);
        //SharedPreferences
        sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(txt_name.getText().toString().isEmpty()||txt_age.getText().toString().isEmpty()){
                    txt_name.setError(getString(R.string.message_empty));
                    txt_age.setError(getString(R.string.message_empty));
                }else{

                    String name = txt_name.getText().toString();
                    String age = txt_age.getText().toString();


                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name",name);
                    editor.putString("age",age);
                    editor.commit();


                    Intent intent = new Intent(v.getContext(), Cuestions.class);
                    startActivity(intent);
                }
            }
        });



    }
}