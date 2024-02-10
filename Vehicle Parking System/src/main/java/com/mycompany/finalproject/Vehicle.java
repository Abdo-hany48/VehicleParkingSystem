/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

/**
 *
 * @author AL-FAJR
 */
public abstract class Vehicle {
    protected int length;
    protected int spot;
    protected int id;
    protected String start_date;
    protected String End_date;
    protected int Start_time;
    protected int End_time;

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return End_date;
    }

    public void setEnd_date(String End_date) {
        this.End_date = End_date;
    }

    public int getStart_time() {
        return Start_time;
    }

    public void setStart_time(int Start_time) {
        this.Start_time = Start_time;
    }

    public int getEnd_time() {
        return End_time;
    }

    public void setEnd_time(int End_time) {
        this.End_time = End_time;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public void setdate(String S)
    {
        this.start_date=S;
    }
    public void settime(int N)
    {
        this.Start_time=N;
    }
    public int getSpot() {
        return spot;
    }
    public int getLength() {
        return length;
    }
    
    abstract boolean isAvailable(int parkSpot[]);
    abstract int calcmoney(String start_date,String End_date,int Start_time,int End_time);
    
    
}
