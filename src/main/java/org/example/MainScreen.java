package org.example;

public class MainScreen {
    static String userInput;
    static String currentPage;

    public static void displayPage(String currentPage) {
        if (currentPage.equals("home-page"))
            System.out.print( """
                                      Welcome To Car Accessories Company\s
                                      Choose To login by your type or signUp
                                      1. Admin Login
                                      2. Customer Login
                                      3. Installer Login
                                      4. SignUp
                                      5. Exit Program
                                      6. Press Any key to reload this Page
                                      """
            );
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
                MainScreen.currentPage = "signUp-page";
                break;
            default:
                MainScreen.currentPage = "home-page";
        }
    }
}
