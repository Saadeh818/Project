package org.example;

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
//        else if (currentPage.equals("admin-login") || currentPage.equals("customer-login") || currentPage.equals("installer-login")){
//            System.out.println ( "Enter Admin User Name And Password: " );
//        }
//        else if (currentPage.equals ( "signUp-page" )){
//
//        }
    }

    public static void setUserInput(String string) {
        userInput=string;
    }

    public static void nextScreen(String userInput) {
        if (userInput.equals(" '")){ MainScreen.currentPage = "home-page";
            return;}
        switch (MainScreen.userInput){
            case "1":
                MainScreen.currentPage = "admin-login";
                break;
            case "2":
                MainScreen.currentPage = "customer-login";
                break;
            case "3":
                MainScreen.currentPage = "installer-login";
                break;
            case "4":
            case " '":
                MainScreen.currentPage = "signUp-page";
                break;
            default:
                MainScreen.currentPage = "home-page";
        }
    }
}
