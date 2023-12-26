package org.main;

import java.util.logging.Logger;

public
class MainScreen {
    static               String userInput;
    public static        String currentPage;
    private static final Logger LOGGER = Logger.getLogger ( MainScreen.class.getName ( ) );

    public
    MainScreen ( ) {
        userInput = "";
        currentPage="";
    }


    public static
    void displayPage ( String currentPage ) {
        if ( currentPage.equals ( "home-page" ) )
            LOGGER.info ( """
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

    public static
    void setUserInput ( String string ) {
        userInput = string;
    }

    public static
    void nextScreen ( ) {
        switch (MainScreen.userInput) {
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
