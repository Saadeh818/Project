package org.example.AcceptanceTest;

import java.io.InputStream;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Car accessories company \n**************************");
            System.out.println("1. Login \n2. SignUp \nYour Input: ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if (num == 1) {
                break;
            } else if (num == 2) {
                break;
            } else continue;
        }
    }
}