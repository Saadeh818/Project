package org.example.AcceptanceTest;

import java.util.Scanner;

public class MainScreen {
    static String userInput;
    static String currentPage;
    Scanner scanner=new Scanner(System.in);

    public static void displayPage(String currentPage) {
        if (currentPage.equals("home-page"))
            System.out.print("Welcome To Car Accessories Company \n" +
                    "Choose To login by your type or signUp\n" +
                    "1. Admin Login\n" +
                    "2. Customer Login\n" +
                    "3. Installer Login\n" +
                    "4. SignUp\n" +
                    "5. press any key to continue\n"
            );
    }

    public static void setUserInput(String string) {
        userInput=string;
    }

}
