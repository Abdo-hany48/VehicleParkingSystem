/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author AL-FAJR
 */
public class Bus extends Vehicle {

    public Bus() {
        length=10;
    }
    
    @Override
    boolean isAvailable(int parkSpot[]) {
        boolean available=false;
        ArrayList <Integer> space=new ArrayList();
        ArrayList <Integer> index=new ArrayList();
        int counter=1;
        for(int i=1;i<100;i++)  // all free spaces with there index
        {
            if(parkSpot[i]==0)
            {
                if(parkSpot[i+1]==0)
                    counter ++;
                else 
                {
                    index.add(i-counter+1);
                    space.add(counter);
                    counter =1;
                }
            }
        }
        int size=space.size();
        for(int i=0; i < (size-1); i++) //sort spaces whith indexes
        {
            for(int j=0; j < (size-i-1); j++)
            {
                if(space.get(j) > space.get(j+1))
                {
                    Collections.swap(space, j, j+1);
                    Collections.swap(index, j, j+1);
                }
            }
        }
        for (int i=0 ;i<size ;i++) //the minimum space that match the length
        {
            if(space.get(i)>=length)
            {
                available=true;
                this.spot=index.get(i);
            }
        }
        return available;
    }
    
    @Override
   int calcmoney(String start_date,String end_date,int start_time,int End_time)
   {
       int startdays,startmonths,startyears,enddays,endmonths,endyears;
       int result;
       startdays=Integer.parseInt(""+start_date.charAt(0)+start_date.charAt(1));
       startmonths=Integer.parseInt(""+start_date.charAt(3)+start_date.charAt(4));
       startyears=Integer.parseInt(""+start_date.charAt(6)+start_date.charAt(7)+start_date.charAt(8)+start_date.charAt(9));
       enddays=Integer.parseInt(""+end_date.charAt(0)+end_date.charAt(1));
       endmonths=Integer.parseInt(""+end_date.charAt(3)+end_date.charAt(4));
       endyears=Integer.parseInt(""+end_date.charAt(6)+end_date.charAt(7)+end_date.charAt(8)+end_date.charAt(9));
       result=(End_time-start_time)+(24*(enddays-startdays))+(24*30*(endmonths-startmonths))+(360*24*(endyears-startyears));
       result*=15;
       return result;
   }
}
