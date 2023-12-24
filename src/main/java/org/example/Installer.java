package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public
class Installer extends Users {
    private static final Map < String, String > users                  = new HashMap <> ( );
    static public        String                 username;
    static public        String                 password;
    static public        boolean                loginFlag              = false;
    static public        boolean                errorMessageFlag       = false;
    public static        boolean                addUserSuccess;
    public static        boolean                adminDashboardFlag;
    static public        boolean                installerDashboardFlag = false;
    static public        boolean                listRequestsFlag       = false;
    static public        boolean                requestFound;
    public static        String                 requestID;
    public static        String                 userRequested;
    private static final Logger                 LOGGER                 = Logger.getLogger ( Customer.class.getName ( ) );


    static
    void getUsersFromFile ( ) {
        try {
            users.clear ( );
            File file = new File ( "src/Installers.txt" );
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

    public static
    void clearCredentials ( ) {
        username  = null;
        password  = null;
        loginFlag = false;
    }

    public static
    void login ( String username , String password ) {
        getUsersFromFile ( );
        if ( ! Installer.users.containsKey ( username ) ) {
            loginFlag = false;
            return;
        }
        String adminPass = users.get ( username );
        loginFlag = adminPass.equals ( password );
        if ( ! loginFlag ) {
//            JOptionPane.showMessageDialog(null,"wrong Input","Error",JOptionPane.ERROR_MESSAGE);
            errorMessageFlag = false;
        }
        else {
            dashboardManager ( "Load Dashboard" );
        }
    }

    public static
    void dashboardManager ( String userInput ) {
        switch (userInput) {
            case "1":
                listInstallationRequests ( );
                break;
            case "2":
                MainScreen.currentPage = "home-page";
                MainScreen.displayPage ( MainScreen.currentPage );
                clearCredentials ( );
                break;
            default:
                showInstallerDashboard ( );
                loginFlag = true;
                break;
        }
    }

    private static
    void listInstallationRequests ( ) {
        listRequestsFlag = false;
        File file = new File ( "src/InstallationRequests" );
        try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
            String  installationRequest;
            boolean empty = true;
            while ( (installationRequest = bufferedReader.readLine ( )) != null ) {
                LOGGER.info ( installationRequest );
                empty = false;
            }
            if ( empty ) {
               LOGGER.info ( "There is no requests at the moment ;)" );
            }
            listRequestsFlag = true;
        }
        catch ( IOException e ) {
            LOGGER.info ( "Something wrong with your file" );
            listRequestsFlag = false;
        }

    }

    private static
    void showInstallerDashboard ( ) {
        LOGGER.info ( "Welcome Admin " + username + "\n" +
                                   "What do you want to do?\n" +
                                   "1. List Installation Requests\n" +
                                   "2. Sign out\n"
                         );
        installerDashboardFlag = true;
    }

    public static
    Map < String, String > getUsers ( ) {
        getUsersFromFile ( );
        return users;
    }

    public static
    void printUsers ( ) {
        getUsersFromFile ( );
        int x = 0;
        for ( Map.Entry < String, String > entry : users.entrySet ( ) ) {
            x++;
            LOGGER.info ( x + ". UserName: " + entry.getKey ( ) );
        }

    }

    public static
    void addInstaller ( String userName , String password ) {
        getUsersFromFile ( );
        if ( checkUserName ( userName ) && checkPassword ( password ) && ! users.containsKey ( userName ) ) {
            addToFile ( userName , password );
            addUserSuccess = true;
            LOGGER.info ( "Installer Added Successfully" );
        }
        else addUserSuccess = false;
        LOGGER.info ( "Fail To Add " );
    }

    private static
    void addToFile ( String userName , String password ) {
        try {
            users.clear ( );
            File           file           = new File ( "src/Installers.txt" );
            BufferedWriter bufferedWriter = new BufferedWriter ( new FileWriter ( file , true ) );
            String         nameAndPass    = userName + "," + password;
            bufferedWriter.newLine ( );
            bufferedWriter.write ( nameAndPass );
            bufferedWriter.close ( );
            getUsersFromFile ( );
        }
        catch ( IOException e ) {
            throw new RuntimeException ( e );
        }
    }

    private static
    boolean checkPassword ( String password ) {
        getUsersFromFile ( );
        return password.length ( ) >= 8;
    }

    private static
    boolean checkUserName ( String userName ) {
        getUsersFromFile ( );
        return userName.contains ( "@" );
    }

    public static
    void SetInstallationRequestId ( String string ) {
        File file = new File ( "src/InstallationRequests" );
        try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
            String installationRequest;
            requestFound = false;
            while ( (installationRequest = bufferedReader.readLine ( )) != null ) {
                String[] data = installationRequest.split ( "," );
                if ( data[ 0 ].contains ( string ) ) {
                    requestID     = data[ 0 ].replaceAll ( "\\." , "" );
                    userRequested = data[ 6 ];
                    requestFound  = true;
                    break;
                }
            }
            if ( ! requestFound ) {
                LOGGER.info ( "There is no requests with this ID ;)" );
            }
            listRequestsFlag = true;
        }
        catch ( IOException e ) {
            LOGGER.info ( "Something wrong with your file" );
            listRequestsFlag = false;
        }
    }

    public static
    void deleteInstallerAccount ( int userToModifyID ) {
        users.clear ( );
        File file = new File ( "src/Installers.txt" );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                String   nameAndPass;
                String[] data;
                int      index = 0;
                while ( true ) {
                    if ( (nameAndPass = bufferedReader.readLine ( )) != null && index != (userToModifyID - 1) ) {
                        data = nameAndPass.split ( "," );
                        LOGGER.info ( nameAndPass );
                        users.put ( data[ 0 ] , data[ 1 ] );
                        index++;
                    }
                    else break;
                }
                Users.userDeleted = true;
                writeUsersToFile ( users , file.getPath ( ) );
            }
        }
        catch ( IOException e ) {
            Users.userDeleted = false;
            throw new RuntimeException ( e );
        }
    }

    public static
    void writeUsersToFile ( Map < String, String > users , String filePath ) {
        Customer.bufferWriter ( users , filePath , LOGGER );
    }

    public static
    void changePassword ( int userToModifyID , String newPassword ) {
        if ( ! checkPassword ( newPassword ) ) {
            LOGGER.info ( "Password Format Wrong" );
            Users.userDeleted = false;
            return;
        }
        users.clear ( );
        File file = new File ( "src/Customers.txt" );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                Customer.fileRead ( userToModifyID , newPassword , bufferedReader , LOGGER , users );
                Users.userDeleted = true;
                writeUsersToFile ( users , file.getPath ( ) );
            }
        }
        catch ( IOException e ) {
            Users.userDeleted = false;
            throw new RuntimeException ( e );
        }
    }

    public static
    void changeUserName ( int userToModifyID , String newUserName ) {
        if ( ! checkUserName ( newUserName ) ) {
            LOGGER.info ( "UserName Format Wrong or Used" );
            Users.usernameChanged = false;
            return;
        }
        users.clear ( );
        File file = new File ( "src/Customers.txt" );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                String   nameAndPass;
                String[] data;
                int      index = 0;
                while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
                    if ( (index != (userToModifyID - 1)) ) {
                        data = nameAndPass.split ( "," );
                        LOGGER.info ( nameAndPass );
                        users.put ( data[ 0 ] , data[ 1 ] );
                        index++;
                    }
                    else if ( index == (userToModifyID - 1) ) {
                        data = nameAndPass.split ( "," );
                        users.put ( newUserName , data[ 1 ] );
                    }
                }
                Users.usernameChanged = true;
                writeUsersToFile ( users , file.getPath ( ) );
            }
        }
        catch ( IOException e ) {
            Users.usernameChanged = false;
            throw new RuntimeException ( e );
        }
    }
}
