package assignmentarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NoOfGrades {
    public static void main(String[] args) {

        //Write a program that allows user to enter number of grades(out off 100)
        // and provide them with their average,highest & lowest score
        double SumMarks = 0;
        System.out.print("Please enter number no of Grades : ");
        Scanner sc =  new Scanner(System.in);
        while((!sc.hasNextInt()))
        {
            System.out.println("Please enter the valid number.");
            sc.next();
        }
        int CountOfMarks = sc.nextInt();
        System.out.print("Please enter" + CountOfMarks + " Marks to be Grade  : ");
        double[] Marks = new double [CountOfMarks];
        for(int i =0; i<CountOfMarks;i++)
        {
            Marks[i] = sc.nextDouble();
        }

        for(double a : Marks)
        {
            SumMarks = SumMarks + a;
        }
        System.out.println("The Average of these marks is :" + String.format("%.2f",SumMarks/CountOfMarks));

        Arrays.sort(Marks);
        System.out.println("The Highest Marks is : " +Marks[CountOfMarks -1]);
        System.out.println("The Lowest Marks is : " +Marks[0]);





    }

}
