package org.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public
class Admin extends Users {
    private static final Logger LOGGER = Logger.getLogger ( Admin.class.getName ( ) );
    private static final Map < String, String > users            = new HashMap <> ( );
    protected static String  username;
    protected static String  password;

    public static
    boolean isLoginFlag ( ) {
        return loginFlag;
    }

    public static
    boolean isAdminDashboardFlag ( ) {
        return adminDashboardFlag;
    }

    public static
    void setAdminDashboardFlag ( boolean adminDashboardFlag ) {
        Admin.adminDashboardFlag = adminDashboardFlag;
    }

    public static
    boolean isManageUsersFlag ( ) {
        return manageUsersFlag;
    }

    public static
    boolean isErrorMessageFlag ( ) {
        return errorMessageFlag;
    }

    private static boolean loginFlag;
    private static boolean adminDashboardFlag;
    private static boolean manageUsersFlag;
    private static boolean errorMessageFlag;

    static
    void getUsersFromFile ( ) {
        try {
            users.clear ( );
            File file = new File ( "src/Admins.txt" );
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                String nameAndPass;
                while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
                    String[] data = nameAndPass.split ( "," );
                    users.put ( data[ 0 ] , data[ 1 ] );
                }
            }
        }
        catch ( IOException e ) {
            printException ( e.getMessage () );
        }
    }

    public static
    void clearCredentials ( ) {
        // Reset the username and password to clear the credentials.
        username  = null;
        password  = null;
        loginFlag = false;
    }

    public static
    void setUsername ( String username ) {
        Admin.username = username;
    }

    public static
    void setPassword ( String password ) {
        Admin.password = password;
    }


    public static
    void login ( ) {
        getUsersFromFile ( );
        if ( ! users.containsKey ( username ) ) {
            loginFlag = false;
            LOGGER.info ( "Wrong username" );
            return;
        }
        String adminPass = users.get ( username );
        loginFlag = adminPass.equals ( password );
        if ( ! isLoginFlag () ) {
            LOGGER.info ( "Wrong password" );
            errorMessageFlag = false;
        }
        else {
            dashboardManager ( "Load Dashboard" );
        }
    }

    private static
    void showAdminDashboard ( ) {
        String welcomeMessage = "Welcome Admin " + username;
        LOGGER.info ( welcomeMessage);
        LOGGER.info ( """
                              What do you want to do?
                              1. Manage products
                              2. Manage users
                              3. Sign out""" );
        adminDashboardFlag = true;
    }

    public static
    void dashboardManager ( String userInput ) {
        switch (userInput) {
            case "1":

                break;
            case "2":
                manageUsersFlag = true;
                break;
            case "3":
                MainScreen.setCurrentPage ("home-page");
                MainScreen.displayPage ( MainScreen.getCurrentPage () );
                clearCredentials ( );
                break;
            default:
                showAdminDashboard ( );
                loginFlag = true;
                break;
        }
    }
}
