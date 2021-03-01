package levelonedatatypes;

import java.math.BigDecimal;

public class MultiplyDoubleInt {
    public static void main(String[] args) {
        //Write a program to print the product of the numbers 8.2 and 6.
        double num1 = 8.2;
        int num2 = 6;
        double multiplication = num1*num2;
        System.out.println("The multiplication product of 8.2 and 6 is : " + multiplication);
        System.out.println("The multiplication after rounding is : " + (float)multiplication);
    }
}
