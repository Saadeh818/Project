package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.example.Customer.fileRead;
import static org.example.Customer.fileRead2;

public
class Installer extends Users {
    private static Map < String, String > users = new HashMap <> ( );
    public static final String INSTALLERS_FILE_PATH = "src/Installers.txt";
    protected static        String                 username;
    protected static String  password;
    protected static    boolean loginFlag        = false;
    protected static    boolean errorMessageFlag = false;
    protected static    boolean addUserSuccess;
    protected static boolean adminDashboardFlag;
    protected static boolean installerDashboardFlag = false;
    protected static boolean listRequestsFlag       = false;
    protected static        boolean                requestFound;
    protected static        String                 requestID;
    protected static        String                 userRequested;
    private static final Logger                 LOGGER                 = Logger.getLogger ( Installer.class.getName ( ) );

    public static int getNumberOfInstallation(){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/InstallationRequests"))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            return lineCount;
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
            return -1; // Return a special value indicating an error
        }
    }
    static
    void getUsersFromFile ( ) {
        try {
            users.clear ( );
            File file = new File ( INSTALLERS_FILE_PATH );
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                String nameAndPass;
                while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
                    String[] data = nameAndPass.split ( "," );
                    users.put ( data[ 0 ] , data[ 1 ] );
                }
            }
        }
        catch ( IOException e ) {
            String s = e.getMessage ();
            LOGGER.info ( s );
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

            case "3":
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
        }

    }

    protected static
    void showInstallerDashboard ( ) {
        String s = "Welcome Installer ";
        LOGGER.info ( s );
        LOGGER.info ( """
                              What do you want to do?
                              1. List Installation Requests
                              2. List All Appointments
                              3. Sign out
                              """
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
            String msg = x + ". UserName: " + entry.getKey ( );
            LOGGER.info ( msg );
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
            try (BufferedWriter bufferedWriter = new BufferedWriter ( new FileWriter ( file , true ) )) {
                String nameAndPass = userName + "," + password;
                bufferedWriter.write ( nameAndPass+ "\n" );
            }
            getUsersFromFile ( );
        }
        catch ( IOException e ) {
            String s = e.getMessage ();
            LOGGER.info ( s );
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
    void setInstallationRequestId ( String string ) {
        File file = new File ( "src/InstallationRequests" );
        try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
            String installationRequest;
            requestFound = false;
            while ( (installationRequest = bufferedReader.readLine ( )) != null ) {
                String[] data = installationRequest.split ( "," );
                if ( data[ 0 ].contains ( string ) ) {
                    requestID     = data[ 0 ].replace ( "\\." , "" );
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
                while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
                    if ( (index != (userToModifyID - 1)) ) {
                        data = nameAndPass.split ( "," );
                        LOGGER.info ( nameAndPass );
                        users.put ( data[ 0 ] , data[ 1 ] );
                        index++;
                    }
                }
                Users.userDeleted = true;
                writeUsersToFile ( users , file.getPath ( ) );
            }
        }
        catch ( IOException e ) {
            Users.userDeleted = false;
            e.printStackTrace ( System.out );
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
            Users.passwordUpdated = false;
            return;
        }
        users.clear ( );
        File file = new File ( "src/Installers.txt" );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                fileRead ( userToModifyID , newPassword , bufferedReader , LOGGER , users );
                Users.passwordUpdated = true;
                writeUsersToFile ( users , file.getPath ( ) );
            }
        }
        catch ( IOException e ) {
            Users.passwordUpdated = false;
            throw new RuntimeException ( e );
        }
    }

    public static
    void changeUserName ( int userToModifyID , String newUserName ) {
        if ( ! checkUserName ( newUserName ) ) {
            LOGGER.info ( "Username Format Wrong Or Used" );
            Users.usernameChanged = false;
            return;
        }
        users.clear ( );
        File file = new File ( "src/Installers.txt" );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                fileRead2 ( userToModifyID , newUserName , bufferedReader , LOGGER , users );
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
