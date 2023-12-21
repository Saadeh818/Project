package org.example;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Admin extends Users{

    static public String username;
    static public String password;
    static public boolean loginFlag=false;
    static public boolean adminDashboardFlag=false;
    static public boolean manageProductFlag;
    static public boolean manageUsersFlag;


    private static final Map<String, String> users            = new HashMap<String, String>();
    static public        boolean             errorMessageFlag =false;

    static void getUsersFromFile(){
        try {
            users.clear ();
            File           file           = new File ( "src/Admins.txt" );
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                String nameAndPass;
                while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
                    String[] data = nameAndPass.split ( "," );
                    users.put ( data[ 0 ] , data[ 1 ] );
                }
            }
        }
        catch ( IOException e ) {
            throw new RuntimeException ( e );
        }
    }
    public static void clearCredentials() {
            // Reset the username and password to clear the credentials.
            username = null;
            password = null;
            loginFlag=false;
        }

    public static
    void setUsername ( String username ) {
            Admin.username =username;
    }

    public static
    void setPassword ( String password ) {
            Admin.password=password;
    }


        public static
        void login ( ) {
            getUsersFromFile();
            if (!users.containsKey(username)) {
                loginFlag = false;
                System.out.println ( "Wrong username" );
                return;
            }
            String adminPass = users.get(username);
            loginFlag = adminPass.equals(password);
            if(!loginFlag){
                System.out.println ( "Wrong password" );
                errorMessageFlag = false;
            }
            else{
                dashboardManager("Load Dashboard");
            }
        }

    private static void showAdminDashboard() {
        System.out.print("Welcome Admin " +username+"\n"+
                "What do you want to do?\n" +
                "1. Manage products\n" +
                "2. Manage users\n" +
                "3. Sign out\n"
        );
        adminDashboardFlag=true;
    }

    public Map<String, String> getUsers() {
        return users;
    }
    public static void dashboardManager(String userInput){
        switch (userInput) {
            case "1":

                manageProductFlag=true;
                break;
            case "2":
                manageUsersFlag=true;
                break;
            case "3":
                MainScreen.currentPage="home-page";
                MainScreen.displayPage(MainScreen.currentPage);
                clearCredentials();
                break;
            default:
                showAdminDashboard();
                loginFlag=true;
                break;
        }
    }
}
