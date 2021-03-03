package assignmentarray;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {

        //Write a program to find Day of the Week.
        String[] WeekDays = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter number for the day of week : ");
        while((!sc.hasNextInt()))
        {
            System.out.println("Please enter the valid number.");
            sc.next();
        }
        int DayEntered = sc.nextInt();
        if(DayEntered >7)
            System.out.println("Please enter valid Day.");
        else
            System.out.println("The day is : " + WeekDays[DayEntered-1]);
    }
}
