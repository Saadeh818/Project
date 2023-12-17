package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Customer extends Users{

    static public String username;
    static public String password;
    private static final Map<String, String> users = new HashMap<String, String>();
    static public boolean loginFlag=false;
    static public boolean errorMessageFlag=false;
    public static boolean addUserSuccess;

    static
    void getUsersFromFile ( ){
        try {
            users.clear ();
            File           file           = new File ( "src/Customers.txt" );
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
        username = null;
        password = null;
        loginFlag=false;
    }

    public static void login(String username, String password) {
        getUsersFromFile();
        if (!Customer.users.containsKey(username)) {
            loginFlag = false;
            return;
        }
        String adminPass = users.get(username);
        loginFlag = adminPass.equals(password);
        if(!loginFlag){
//            JOptionPane.showMessageDialog(null,"wrong Input","Error",JOptionPane.ERROR_MESSAGE);
            errorMessageFlag = false;
        }
        else{
            dashboardManager("Load Dashboard");
        }
    }

    private static void dashboardManager(String loadDashboard) {
    }

    public static Map<String, String> getUsers() {
        getUsersFromFile();
        return users;
    }

    public static void printUsers() {
        getUsersFromFile();
        int x=0;
        for (Map.Entry<String, String> entry : users.entrySet()) {
            x++;
            System.out.println(x+ ". UserName: " + entry.getKey());
        }
    }

    public static void addCustomer(String userName, String password) {
        getUsersFromFile();
        if(checkUserName(userName) && checkPassword(password) && !users.containsKey ( userName )) {
            addToFile(userName, password);
            addUserSuccess=true;
        }
        else addUserSuccess = false;
    }

    private static
    void addToFile ( String userName , String password ) {
        try {
            users.clear ();
            File           file           = new File ( "src/Customers.txt" );
            BufferedWriter bufferedWriter = new BufferedWriter ( new FileWriter ( file,true ) );
            String nameAndPass = userName +","+password;
            bufferedWriter.newLine ();
            bufferedWriter.write ( nameAndPass );
            bufferedWriter.close ();
            getUsersFromFile ();
        }
        catch ( IOException e ) {
            throw new RuntimeException ( e );
        }
    }

    private static boolean checkPassword(String password) {
        getUsersFromFile ();
        return password.length()>=8;
    }

    private static boolean checkUserName(String userName) {
        getUsersFromFile ();
        return userName.contains("@")&&userName.contains(".");
    }

    public static
    void addAppointment ( String date , String requestID , String userRequested ) {
        Appointment appointment = new Appointment();
       if  (!appointment.checkDate(date)){
           //TODO: reload the screen that sets the appointment
           return;
       }
       appointment.addNewAppointment(date, requestID, userRequested);
    }
}
