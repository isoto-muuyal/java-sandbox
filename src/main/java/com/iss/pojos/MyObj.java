package com.iss.pojos;

public class MyObj {

    private String status = "";

    public MyObj(){
        status = "created";
    }

    public void setStatus(String status) {
        this.status= " ------- " + status;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "MyObj: {" +
                    "status: " + this.getStatus() + "," +
                "}";
    }
}
