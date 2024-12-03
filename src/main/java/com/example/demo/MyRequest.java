package com.example.demo;

public class MyRequest {
    private String message;
    private int intValue;
    private boolean booleanValue;

    public MyRequest() {
    }

    public MyRequest(String message, int intValue, boolean booleanValue) {
        this.message = message;
        this.intValue = intValue;
        this.booleanValue = booleanValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "message='" + message + '\'' +
                ", intValue=" + intValue +
                ", booleanValue=" + booleanValue +
                '}';
    }
}
