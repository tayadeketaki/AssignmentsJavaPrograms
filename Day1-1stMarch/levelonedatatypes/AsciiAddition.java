package levelonedatatypes;

public class AsciiAddition {
    public static void main(String[] args) {
        //Write a program to add 3 to the ASCII value of the character 'd' and print the equivalent character.
        char ch = 'h';
        int ascii = ch;
        int newChar = ascii +3;
        System.out.println("After addition new character is : " + (char)newChar);
    }
}
