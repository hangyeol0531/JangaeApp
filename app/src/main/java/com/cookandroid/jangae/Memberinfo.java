package com.cookandroid.jangae;

public class Memberinfo {
    private String name;
    private String phone;
    private String birth;
    private String position;
    private String address;

    public Memberinfo(String name, String phone, String birth, String address, String position){
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.address = address;
        this.position = position;
    }
    ////////////////////////
    public String getName(){
        return this.name;
    }
    public void setNmae(String name){
        this.name = name;
    }
    ////////////////////////
    public String getphone(){
        return this.phone;
    }
    public void setphone(String phone){
        this.phone = phone;
    }
    ////////////////////////
    public String getbirth(){
        return this.birth;
    }
    public void setbirth(String birth){
        this.birth = birth;
    }
    ////////////////////////
    public String getaddress(){
        return this.address;
    }

    public void setposition(String position){
        this.position = position;
    }
    public String getposition(){
        return this.position;
    }
}
