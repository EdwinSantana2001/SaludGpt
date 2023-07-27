package com.dds6.chatgpt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Cuestions extends AppCompatActivity {
    private TextView lbl_cuestion;
    private RadioButton rbt_cuestion1,rbt_cuestion2,rbt_cuestion3,rbt_cuestion4,rbt_cuestion5,rbt_cuestion6;
    private Button btn_next;
    SharedPreferences sharedPreferences;
    String age;
    Double ageSum ;
    int b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestions);

        //SharedPreferences
        sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        age =  sharedPreferences.getString("age","");
        ageSum = Double.parseDouble(age);
        //TextView
        lbl_cuestion = this.findViewById(R.id.lbl_cuestion);
        //RadioButton
        rbt_cuestion1 = this.findViewById(R.id.rbt_cuestion1);
        rbt_cuestion2 = this.findViewById(R.id.rbt_cuestion2);
        rbt_cuestion3 = this.findViewById(R.id.rbt_cuestion3);
        rbt_cuestion4 = this.findViewById(R.id.rbt_cuestion4);
        rbt_cuestion5 = this.findViewById(R.id.rbt_cuestion5);
        rbt_cuestion6 = this.findViewById(R.id.rbt_cuestion6);
        //Button
        btn_next = this.findViewById(R.id.btn_next);


        //llenado Automatico
        lbl_cuestion.setText(getString(R.string.lbl_cuestion1));
        rbt_cuestion1.setText(getString(R.string.lbl_cuestion1_response1));
        rbt_cuestion2.setText(getString(R.string.lbl_cuestion1_response2));
        rbt_cuestion3.setText(getString(R.string.lbl_cuestion1_response3));

        //PrimeraAccion/Recibe el dato de la edad

        if (!rbt_cuestion1.isChecked()&&!rbt_cuestion2.isChecked()&&!rbt_cuestion3.isChecked()&&!rbt_cuestion4.isChecked()&&!rbt_cuestion5.isChecked()&&!rbt_cuestion6.isChecked()){
            Toast.makeText(Cuestions.this, getString(R.string.message_empty), Toast.LENGTH_SHORT).show();
        }else {
            if (rbt_cuestion1.isChecked()) {
                ageSum = ageSum + 1;
            } else if (rbt_cuestion2.isChecked()) {
                ageSum = (double) (ageSum - 0.5);
            } else {
                ageSum = (double) (ageSum - 1);
            }
        }


        b=b+2;
        //Activa el cambio de Data
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                switch(b){
                    case 2 :
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion2));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion2_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion2_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion2_response3));
                        rbt_cuestion4.setEnabled(false);
                        rbt_cuestion5.setEnabled(false);
                        rbt_cuestion6.setEnabled(false);

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum + 1;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum - 0.5);
                        }else {
                            ageSum = (double) (ageSum - 1);
                        }
                        break;
                    case 3 :
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion3));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion3_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion3_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion3_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion3_response4));
                        rbt_cuestion5.setEnabled(true);
                        rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum + 3;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum + 2);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum = (double) (ageSum + 1);
                        }else if(rbt_cuestion4.isChecked()){
                            ageSum = (double) (ageSum -1.5);
                        }else{
                            ageSum = (double) (ageSum - 1);
                        }

                        break;
                    case 4:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion4));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion4_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion4_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion4_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion4_response4));
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        //rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum + 2;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum + 1.5);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum = (double) (ageSum + 0);
                        }else{
                            ageSum = (double) (ageSum - 0.5);
                        }
                        break;

                    case 5:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion5));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion5_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion5_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion5_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion5_response4));
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        //rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum + 2;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum + 1.5);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum = (double) (ageSum - 0.5);
                        }else{
                            ageSum = (double) (ageSum - 1);
                        }
                        break;
                    case 6:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion6));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion6_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion6_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion6_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion6_response4));
                        rbt_cuestion5.setEnabled(true);
                        rbt_cuestion5.setText(getString(R.string.lbl_cuestion6_response5));
                        rbt_cuestion6.setEnabled(true);
                        rbt_cuestion6.setText(getString(R.string.lbl_cuestion6_response6));

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum - 3;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum - 2);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum = (double) (ageSum - 1);
                        }else if(rbt_cuestion4.isChecked()){
                            ageSum = (double) (ageSum + 0);
                        }else if(rbt_cuestion5.isChecked()){
                            ageSum = (double) (ageSum + 1);
                        }else{
                            ageSum = (double) (ageSum + 3);
                        }
                        break;
                    case 7:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion7));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion7_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion7_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion7_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion7_response4));
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        //rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);rbt_cuestion6.setText("");

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum - 1;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum + 0.5);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum = (double) (ageSum + 1);
                        }else{
                            ageSum = (double) (ageSum + 2);
                        }
                        break;
                    case 8:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion8));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion8_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion8_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion8_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion8_response4));
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        //rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);rbt_cuestion6.setText("");

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum + 3;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum + 1);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum = (double) (ageSum - 1);
                        }else{
                            ageSum = (double ) (ageSum - 2);
                        }
                        break;
                    case 9:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion9));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion9_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion9_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion9_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion9_response4));
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        //rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);rbt_cuestion6.setText("");

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum + 3;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum + 2);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum = (double) (ageSum + 1);
                        }else{
                            ageSum = (double) (ageSum - 1.5);
                        }
                        break;
                    case 10:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion10));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion10_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion10_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion10_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion10_response4));
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        //rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);rbt_cuestion6.setText("");

                        if (!rbt_cuestion1.isChecked()&&!rbt_cuestion2.isChecked()&&!rbt_cuestion3.isChecked()&&!rbt_cuestion4.isChecked()&&!rbt_cuestion5.isChecked()&&!rbt_cuestion6.isChecked()){
                            Toast.makeText(Cuestions.this, getString(R.string.message_empty), Toast.LENGTH_SHORT).show();
                        }
                        if(rbt_cuestion1.isChecked()){
                            ageSum =  (ageSum + 1.5);
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum =  (ageSum + 2);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum =  (ageSum + 1);
                        }else{
                            ageSum =  (ageSum - 1.5);
                        }
                        break;
                    case 11:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion11));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion11_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion11_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion11_response3));
                        rbt_cuestion4.setEnabled(false);rbt_cuestion4.setText("");
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        rbt_cuestion6.setEnabled(false);rbt_cuestion6.setText("");

                        if(rbt_cuestion1.isChecked()){
                            ageSum = ageSum -2;
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum = (double) (ageSum +2);
                        }else {
                            ageSum = (double) (ageSum +5);
                        }
                        break;
                    case 12:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion12));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion12_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion12_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion12_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion12_response4));
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        //rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);rbt_cuestion6.setText("");

                        if(rbt_cuestion1.isChecked()){
                            ageSum =  (ageSum + 1);
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum =  (ageSum + 0);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum =  (ageSum -0.5);
                        }else{
                            ageSum =  (ageSum - 1.5);
                        }
                        break;
                    case 13:
                        lbl_cuestion.setText(getString(R.string.lbl_cuestion13));
                        rbt_cuestion1.setText(getString(R.string.lbl_cuestion13_response1));
                        rbt_cuestion2.setText(getString(R.string.lbl_cuestion13_response2));
                        rbt_cuestion3.setText(getString(R.string.lbl_cuestion13_response3));
                        rbt_cuestion4.setEnabled(true);
                        rbt_cuestion4.setText(getString(R.string.lbl_cuestion13_response4));
                        rbt_cuestion5.setEnabled(false);rbt_cuestion5.setText("");
                        //rbt_cuestion5.setText(getString(R.string.lbl_cuestion3_response5));
                        rbt_cuestion6.setEnabled(false);rbt_cuestion6.setText("");

                        if(rbt_cuestion1.isChecked()){
                            ageSum =  (ageSum + 1);
                        } else if (rbt_cuestion2.isChecked()) {
                            ageSum =  (ageSum + 0.5);
                        }else if(rbt_cuestion3.isChecked()){
                            ageSum =  (ageSum -1.5);
                        }else{
                            ageSum =  (ageSum - 0.5);
                        }
                        break;
                    default:
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("newAge",ageSum.toString());
                        editor.commit();
                        Toast.makeText(Cuestions.this, ageSum.toString(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(v.getContext(), Response.class);
                        startActivity(intent);
                }
            }
        });
    }
}