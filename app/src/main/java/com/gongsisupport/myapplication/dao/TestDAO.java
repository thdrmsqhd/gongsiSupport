package com.gongsisupport.myapplication.dao;

import com.google.gson.annotations.SerializedName;

public class TestDAO {
    @SerializedName("body")
    private String text;
    private String testId;
    private String testPw;

    @Override
    public String toString() {
        return "TestDAO{" +
                "text='" + text + '\'' +
                ", testId='" + testId + '\'' +
                ", testPw='" + testPw + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestPw() {
        return testPw;
    }

    public void setTestPw(String testPw) {
        this.testPw = testPw;
    }
}
