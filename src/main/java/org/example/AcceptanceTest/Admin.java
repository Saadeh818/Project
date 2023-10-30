package org.example.AcceptanceTest;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Admin {
    static public String username;
    static public String password;
    static public boolean loginFlag=false;
    static public boolean adminDashboardFlag=false;
    private final Map<String, String> users = new HashMap<String, String>() {{
        put("Ahmad", "724");
        put("deema", "002");
    }};
    static public boolean errorMessageFlag=false;

    public void clearCredentials() {
            // Reset the username and password to clear the credentials.
            username = null;
            password = null;
        }

    public void setUsername(String username) {
            Admin.username =username;
    }

    public void setPassword(String password) {
            Admin.password=password;
    }


        public void login() {
            if (!users.containsKey(username)) {
                loginFlag = false;
                return;
            }
            String adminPass = users.get(username);
            loginFlag = adminPass.equals(password);
            if(!loginFlag){
                JOptionPane.showMessageDialog(null,"wrong Input","Error",JOptionPane.ERROR_MESSAGE);
                errorMessageFlag = false;
            }
            else{
                showAdminDashboard();
            }
        }

    private void showAdminDashboard() {
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
}
