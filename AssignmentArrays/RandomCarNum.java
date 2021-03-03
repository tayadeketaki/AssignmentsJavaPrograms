package assignmentarray;

import java.util.Random;
import java.util.Scanner;

public class RandomCarNum {
    public static void main(String[] args) {

        //Write a program to print random & unique car digit number
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of Car numbers : ");
        while(!sc.hasNextInt())
        {
            System.out.println("Please enter the valid number.");
            sc.next();
        }
        int CountOfNumber = sc.nextInt();
        String[] NumbersOfCars = new String[CountOfNumber];
        Random Rd = new Random();
        for(int i = 0;i < CountOfNumber;i++)
        {
            NumbersOfCars[i] = "MH"+String.format("%4d",Rd.nextInt(10000));

        }
        for(String s : NumbersOfCars)

        {
            System.out.println("The Number of car is : "+s);
        }




    }
}
