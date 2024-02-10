/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.finalproject;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author AL-FAJR
 */
public class FinalProject {
    
    public static void displayMenu()
    {
        
        System.out.println("Please Enter number from the list");
        System.out.println("1 - Adding a Vehicle\n"
                + "2 - Leaving a Vehicle\n"
                + "3 - Show parking status\n"
                + "4 - Exit program");
        System.out.println();
    }
    public static void vehicleaddMenu()
    {
        System.out.println("Please choose the type of the Vehicle from the List");
        System.out.println("1 - Car\n"
                + "2 - Bus\n"
                + "3 - Truck\n"
                + "4 - Motorcycle\n");
    }
    public static void removeErrorMenu()
    {
        System.out.println("Sorry This ID is not in the parking ");
        System.out.println("!!!");
        System.out.println("********please enter the Valid ID of your Vehicle******** ");

    }
    public static String type(int n)
    {
        String s="";
        switch (n)
        {
            case 1: 
                s= "Car";
                break;
            case 2: s= "Bus";
                break;
            case 3: s= "Truck";
                break;
            case 4 : s= "Motorcycle";
                break;
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Park parking = new Park();
        System.out.println("Welcome to Vehicle parking APP");
        
        while(true)
        {
            displayMenu();
            int choic=in.nextInt();
            int num,ID,start_time;
            String start_date;
            while(choic>4||choic<1)
            {
                System.out.println("the number you Entered not from the list");
                displayMenu();
                choic=in.nextInt();
            }
            
            backspace:{
            switch (choic){
                case 1: 
                    vehicleaddMenu();
                    num=in.nextInt();
                    while(num>4||num<1)
                    {
                        System.out.println("the number you choosed not from the list !!!!!");
                        System.out.println("####please Enter a valid input####");
                        System.out.println("OR !! press 0 to return to main menu");
                        vehicleaddMenu();
                        num=in.nextInt();
                        if (num==0)
                        {
                            break backspace;
                        }
                    }
                    String Type=type(num);
                    if(parking.isAvailable(num))
                    {
                        System.out.println("Please Enter "+Type+" ID");
                        ID=in.nextInt();
                        System.out.println("Please Enter the time in 24-Hour clock in hours and the date in this format DD/MM/YYYY");
                        start_time=in.nextInt();
                        start_date=in.next();
                        parking.park(num, ID,start_date,start_time);
                    }
                    else
                    {
                        System.out.println("There is not enough space for the "+Type);
                    }
                    break;
                case 2:
                    System.out.println("********please enter the Valid ID of your Vehicle********");
                    System.out.println("OR !!! press 0 to return to the main menu");
                    ID=in.nextInt();
                    if (ID==0)
                    {
                        break backspace;
                    }
                    int IDsize=parking.isExist(ID);
                    while(IDsize==0)
                    {
                        removeErrorMenu();
                        System.out.println("OR !!! press 0 to return to the main menu");
                        ID=in.nextInt();
                        if (ID==0)
                        {
                            break backspace;
                        }
                        IDsize=parking.isExist(ID);
                    }
                    System.out.println("Please Enter the time in 24-Hour clock in hours and the date in this format DD/MM/YYYY");
                    String end_date;
                    int end_time;
                    end_time=in.nextInt();
                    end_date=in.next();
                    parking.leave(ID, IDsize,end_date,end_time);
                    break;
                case 3:
                    parking.showParkStatus();
                    break;
                case 4:
                    return;
            }
            }
        }
    }
}
