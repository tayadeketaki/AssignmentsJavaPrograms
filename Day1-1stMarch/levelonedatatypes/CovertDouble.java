package levelonedatatypes;

public class CovertDouble {
    public static void main(String[] args) {
        //Write a program to assign a value of 100.235 to a double variable and then convert it to int.
        double number = 100.235;
        System.out.println("The int value for number is : "+ (int)number);
        int number2 = (int)Math.round(number);
        System.out.println("The converted value using Math.round is : " + number2);
    }
}
