package com.dds6.chatgpt;

import android.content.Context;
import android.util.Log;
import com.android.volley.*;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GptConnection {
    private static final String BASE_URL = "https://api.openai.com/v1/chat/completions";
    private RequestQueue queue;

    public GptConnection (Context context){
        queue = Volley.newRequestQueue(context);
    }

    public void generateText(String prompt, Response.Listener<String> listener,Response.ErrorListener errorListener) {
        JSONObject jsonBody = new JSONObject();
        try {
            JSONArray messagesArray = new JSONArray();

            JSONObject systemMessage = new JSONObject();
            systemMessage.put("role", "system");
            systemMessage.put("content", prompt);
            messagesArray.put(systemMessage);

            jsonBody.put("messages", messagesArray);
            jsonBody.put("max_tokens", 3000);
            jsonBody.put("model", "gpt-3.5-turbo");
            jsonBody.put("temperature", 0.7);
            jsonBody.put("top_p", 1);
            jsonBody.put("frequency_penalty", 0);
            jsonBody.put("presence_penalty", 0);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, BASE_URL, jsonBody,
                response -> {
                    // Maneja la respuesta de la API de ChatGPT
                    try {
                        JSONObject message = (JSONObject) response.getJSONArray("choices")
                                .getJSONObject(0)
                                .get("message");
                        String text = message.getString("content");
                        listener.onResponse(text);
                    } catch (JSONException e) {
                        Log.e("Gpt3Api", "Error parseando respuesta", e);
                        errorListener.onErrorResponse(new VolleyError("Error parseando respuesta"));
                    }
                },
                errorListener) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer key of your Account in ChatOpenAi(ChatGPT)");
                return headers;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
}


