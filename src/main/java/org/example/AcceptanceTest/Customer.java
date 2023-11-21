package org.example.AcceptanceTest;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Customer {

    static public String username;
    static public String password;
    private static final Map<String, String> users = new HashMap<String, String>() {{
        put("saadeh@gmail.com", "12345678");
        put("deema@gmail.com", "00000000");
    }};
    static public boolean loginFlag=false;
    static public boolean errorMessageFlag=false;
    public static boolean addUserSuccess;

    public static void clearCredentials() {
        username = null;
        password = null;
        loginFlag=false;
    }

    public static void login(String username, String password) {
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
        return users;
    }

    public static void printUsers() {
        int x=0;
        for (Map.Entry<String, String> entry : users.entrySet()) {
            x++;
            System.out.println(x+ ". UserName: " + entry.getKey());
        }
    }

    public static void addCustomer(String userName, String password) {
        if(checkUserName(userName) && checkPassword(password)) {
            users.put(userName, password);
            addUserSuccess=true;
        }
        else addUserSuccess = false;
    }

    private static boolean checkPassword(String password) {
        return password.length()>=8;
    }

    private static boolean checkUserName(String userName) {
        return userName.contains("@")&&userName.contains(".");
    }
}
