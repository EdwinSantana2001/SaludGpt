package com.dds6.chatgpt;

import androidx.annotation.Nullable;

public class PromptModel {
    private int id;
    private String name;
    private int age;
    @Nullable
    private String prompt;
    @Nullable
    private int realAge;
    @Nullable
    private String response;

    public PromptModel() {
    }

    public PromptModel(int id, String name, int age,@Nullable String prompt,@Nullable int realAge ,@Nullable String response) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.prompt = prompt;
        this.realAge = realAge;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Nullable
    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(@Nullable String prompt) {
        this.prompt = prompt;
    }

    public int getRealAge() {
        return realAge;
    }

    public void setRealAge(int realAge) {
        this.realAge = realAge;
    }

    @Nullable
    public String getResponse() {
        return response;
    }

    public void setResponse(@Nullable String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "PromptModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", prompt='" + prompt + '\'' +
                ", realAge=" + realAge +
                ", response='" + response + '\'' +
                '}';
    }
}
