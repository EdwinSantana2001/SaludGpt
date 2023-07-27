package com.dds6.chatgpt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import org.json.JSONObject;

public class Response extends AppCompatActivity {
    private String prompt;
    PromptModel promptModel;
    private TextView lbl_ageResult, lbl_responseGPT,lbl_constant;
    private Button btn_back, btn_gpt;
    private ProgressBar pgb_wait;
    SharedPreferences sharedPreferences;
    GptConnection gptConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        gptConnection = new GptConnection(Response.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        lbl_ageResult = this.findViewById(R.id.lbl_ageResult);
        String newAge = sharedPreferences.getString("newAge","");
        double realAge = Double.parseDouble(newAge);
        lbl_ageResult.setText(newAge);
        String age = sharedPreferences.getString("age","");
        double baseAge = Double.parseDouble(age);
        lbl_responseGPT= this.findViewById(R.id.lbl_responseGPT);
        lbl_constant = this.findViewById(R.id.lbl_constant);
        lbl_constant.setText(sharedPreferences.getString("name","")+" "+getString(R.string.lbl_yourAge));
        btn_back= this.findViewById(R.id.btn_back);
        btn_gpt = this.findViewById(R.id.btn_gpt);
        pgb_wait = this.findViewById(R.id.pgb_wait);

        btn_gpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgb_wait.setVisibility(View.VISIBLE);
                if(realAge <= baseAge){
                prompt = getString(R.string.prompt_name)+ sharedPreferences.getString("name","") +
                        getString(R.string.prompt_teen1) + baseAge + getString(R.string.prompt_appearance) + realAge;
                gptConnection.generateText(prompt,
                        new com.android.volley.Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                pgb_wait.setVisibility(View.GONE);
                                lbl_responseGPT.setText(response);
                            }
                        },
                        new com.android.volley.Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                pgb_wait.setVisibility(View.GONE);
                                lbl_responseGPT.setText(getString(R.string.message_error));
                            }
                });
                }else {
                    prompt = getString(R.string.prompt_name)+ sharedPreferences.getString("name","") +
                            getString(R.string.prompt_old1) + baseAge + getString(R.string.prompt_appearance) + realAge;
                    gptConnection.generateText(prompt,
                            new com.android.volley.Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    pgb_wait.setVisibility(View.GONE);
                                    lbl_responseGPT.setText(response);
                                }
                            },
                            new com.android.volley.Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    pgb_wait.setVisibility(View.GONE);
                                    lbl_responseGPT.setText(getString(R.string.message_error));
                                }
                    });
                }

            }
        });
        //Button Back for go to first Layout(MainActivity)
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}