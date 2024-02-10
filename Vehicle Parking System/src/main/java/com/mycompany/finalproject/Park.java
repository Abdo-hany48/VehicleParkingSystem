/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author AL-FAJR
 */
public class Park {
    
    protected int[] parkspot = new int[101];
    ArrayList <Car> car=new ArrayList(25);
    ArrayList <Bus> bus=new ArrayList(10);
    ArrayList <Truck> truck=new ArrayList(20);
    ArrayList <Motorcycle> motorcycle=new ArrayList(50);
    public Park(){
        Arrays.fill(parkspot, 0);
        parkspot[100]=1;
    }
    public boolean isAvailable(int type)
    {
        boolean available=false;
        int indx=0;
        switch (type){
            case 1:
                    car.add(new Car());  //create object car 
                    indx=car.size()-1;
                    if(car.get(indx).isAvailable(parkspot)) // cheak available for the last car have been add 
                       available=true;
                    else {
                        car.remove(indx);
                        available=false;
                    }
                    break;
            case 2:
                    bus.add(new Bus());  //create object car 
                    indx=bus.size()-1;
                    if(bus.get(indx).isAvailable(parkspot)) // cheak available for the last car have been add 
                       available=true;
                    else {
                        bus.remove(indx);
                        available=false;
                    }
                    break;
            case 3:
                    truck.add(new Truck());  //create object car 
                    indx=truck.size()-1;
                    if(truck.get(indx).isAvailable(parkspot)) // cheak available for the last car have been add 
                       available=true;
                    else {
                        truck.remove(indx);
                        available=false;
                    }
                    break;
            case 4:
                    motorcycle.add(new Motorcycle());  //create object car 
                    indx=motorcycle.size()-1;
                    if(motorcycle.get(indx).isAvailable(parkspot)) // cheak available for the last car have been add 
                       available=true;
                    else {
                        motorcycle.remove(indx);
                        available=false;
                    }
                    break;
        }
        return available;
    }
    public void park(int type ,int id,String start_date,int start_time)
    {
        int indx=0;
        switch (type){
            case 1:
                indx=car.size()-1;
                car.get(indx).setId(id);
                car.get(indx).setdate(start_date);
                car.get(indx).settime(start_time);
                Arrays.fill(parkspot, car.get(indx).getSpot(),
                        car.get(indx).getSpot()+car.get(indx).getLength(), id);
                System.out.println("Successful addition");
                break;
            case 2:
                indx=bus.size()-1;
                bus.get(indx).setId(id);
                bus.get(indx).setdate(start_date);
                bus.get(indx).settime(start_time);
                Arrays.fill(parkspot, bus.get(indx).getSpot(),
                        bus.get(indx).getSpot()+bus.get(indx).getLength(), id);
                System.out.println("Successful addition");
                break;
            case 3:
                indx=truck.size()-1;
                truck.get(indx).setId(id);
                truck.get(indx).setdate(start_date);
                truck.get(indx).settime(start_time);
                Arrays.fill(parkspot, truck.get(indx).getSpot(),
                        truck.get(indx).getSpot()+truck.get(indx).getLength(), id);
                System.out.println("Successful addition");
                break;
            case 4:
                indx=motorcycle.size()-1;
                motorcycle.get(indx).setId(id);
                motorcycle.get(indx).setdate(start_date);
                motorcycle.get(indx).settime(start_time);
                Arrays.fill(parkspot, motorcycle.get(indx).getSpot(),
                        motorcycle.get(indx).getSpot()+motorcycle.get(indx).getLength(), id);
                System.out.println("Successful addition");
                break;                
        }
    }
    public int isExist(int ID)
    {
        int counter=0;
        for (int I=0;I<100;I++)
        {
            if (parkspot[I]==ID)
            {
                parkspot[I]=0;
                counter++;
            }
        }
        return counter;
    }
    public void leave(int id,int size,String end_date,int end_time)
    {
        int receipt;
        String type;
        if (size==2) // motorcycle
        {
            for (int I=0;I<motorcycle.size();I++) //get the indx of the motocycle
            {
                if (id==motorcycle.get(I).id)
                {
                    id=I;
                    motorcycle.get(id).End_date=end_date;
                    motorcycle.get(id).End_time=end_time;
                    break;
                }
            }
            type="motorcycle";
            receipt=motorcycle.get(id).calcmoney(motorcycle.get(id).start_date,motorcycle.get(id).End_date,motorcycle.get(id).Start_time,motorcycle.get(id).End_time);
            motorcycle.remove(id);
        }
        else if (size==5) // car
        {
            for (int I=0;I<car.size();I++)     //get the indx of the car
            {
                if (id==car.get(I).id)
                {
                    id=I;
                    car.get(id).End_date=end_date;
                    car.get(id).End_time=end_time;
                    break;
                }
            }
            type="car";
            receipt=car.get(id).calcmoney(car.get(id).start_date,car.get(id).End_date,car.get(id).Start_time,car.get(id).End_time);
            car.remove(id);
        }
        else if (size==7) // truck
        {
            for (int I=0;I<truck.size();I++)       //get the indx of the truck
            {
                if (id==truck.get(I).id)
                {
                    id=I;
                    truck.get(id).End_date=end_date;
                    truck.get(id).End_time=end_time;
                    break;
                }
            }
            type="truck";
            receipt=truck.get(id).calcmoney(truck.get(id).start_date,truck.get(id).End_date,truck.get(id).Start_time,truck.get(id).End_time);
            truck.remove(id);
        }
        else // bus
        {
            for (int I=0;I<bus.size();I++)    //get the indx of the bus
            {
                if (id==bus.get(I).id)
                {
                    id=I;
                    bus.get(id).End_date=end_date;
                    bus.get(id).End_time=end_time;
                    break;
                }
            }
            type="bus";
            receipt=bus.get(id).calcmoney(bus.get(id).start_date,bus.get(id).End_date,bus.get(id).Start_time,bus.get(id).End_time);
            bus.remove(id);
        }
        System.out.println("Your "+type+" leaved successfully");
        System.out.println("your receipt %#########%");
        System.out.println("             %         %");
        System.out.println("             %   "+receipt+"   %");
        System.out.println("             %         %");
        System.out.println("             %#########%");
    }
    public void showParkStatus()
    {
        String s1=new String(),s2=new String(),s3=new String();
        int space=0;
       for(int i=0;i<100;i++)
        {
 
 
          if(parkspot[i]==0)
          {
 
              s2+="  ";
              s3+="__";
              space++;
              if(space%2==0)
              {
                  if(space<=9)s1+=" "+space;
                  else s1+=space;
              }
              else s1+="  ";
          }
          else
          {
              space=0;
              int cnt=1;
              i++;
              while(i<100&&parkspot[i]==parkspot[i-1])
              {
                  cnt++;
                  i++;
              }
              i--;
              if(cnt==5)
              {
                  s1+="  _____   ";
                  s2+=" | Car  \\ ";
                  s3+=" -o----o  ";
 
              }
              else if(cnt==7)
              {
                  s1+="          _   ";
                  s2+=" | Truck |  \\ ";
                  s3+=" --oo-----o-  ";
 
              }
              else if(cnt==10)
              {
                  s1+="  ________________  ";
                  s2+=" |      Bus       \\ ";
                  s3+=" --oo----------oo-- ";
 
              }     
              else 
              {
                  s1+="      ";
                  s2+="  Mo  ";
                  s3+=" o^^o ";
 
              }
 
 
          }
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
