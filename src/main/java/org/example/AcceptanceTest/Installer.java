package org.example.AcceptanceTest;

import java.util.HashMap;
import java.util.Map;

public class Installer {
    static public String username;
    static public String password;
    private static final Map<String, String> users = new HashMap<String, String>() {{
        put("saadeh@installer.com", "12345678");
        put("deema@installer.com", "00000000");
    }};
    static public boolean loginFlag=false;
    static public boolean errorMessageFlag=false;

    public static void clearCredentials() {
        username = null;
        password = null;
        loginFlag=false;
    }

    public static void login(String username, String password) {
        if (!Installer.users.containsKey(username)) {
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

    public Map<String, String> getUsers() {
        return users;
    }
}
