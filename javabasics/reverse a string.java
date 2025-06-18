// Java Program to Reverse a String
// Using for loop
import java.io.*;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {      
        String s = "jahnavi"; 
        String r = "";
        char ch;
        for (int i = 0; i < s.length(); i++) {       	
          	// extracts each character
            ch = s.charAt(i);       
          	// adds each character in
            // front of the existing string
            r = ch + r; 
        }      
        System.out.println(r);
    }
}
