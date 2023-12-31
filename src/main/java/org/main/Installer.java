package org.main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.main.Customer.*;

public
class Installer extends Users {
    public static final String SRC_INSTALLATION_REQUESTS = "src/InstallationRequests";
    public static final String SRC_INSTALLERS_TXT = "src/Installers.txt";
    private Map < String, String > users = new HashMap <> ( );

    public
    String getUsername ( ) {
        return this.username;
    }

    public
    String getPassword ( ) {
        return this.password;
    }

    public static
    boolean isLoginFlag ( ) {
        return loginFlag;
    }

    public static
    boolean isAddUserSuccess ( ) {
        return addUserSuccess;
    }

    public static
    boolean isListRequestsFlag ( ) {
        return listRequestsFlag;
    }

    public static
    boolean isRequestFound ( ) {
        return requestFound;
    }

    public static
    String getRequestID ( ) {
        return requestID;
    }

    public static
    String getUserRequested ( ) {
        return userRequested;
    }

    private String  username;
    private String  password;
    private static boolean loginFlag        = false;
    private static boolean errorMessageFlag = false;
    private static boolean addUserSuccess;

    public static
    void setAdminDashboardFlag ( boolean adminDashboardFlag ) {
        Installer.adminDashboardFlag = adminDashboardFlag;
    }

    private static boolean adminDashboardFlag;
    private static boolean installerDashboardFlag;

    public static
    void setListRequestsFlag ( boolean listRequestsFlag ) {
        Installer.listRequestsFlag = listRequestsFlag;
    }

    private static boolean listRequestsFlag = false;
    private static boolean requestFound;
    private static String  requestID;

    public
    void setUsername ( String username ) {
        this.username = username;
    }

    public
    void setPassword ( String password ) {
        this.password = password;
    }

    private static       String userRequested;
    private static final Logger LOGGER                 = Logger.getLogger ( Installer.class.getName ( ) );

    public static int getNumberOfInstallation(){
        try (BufferedReader reader = new BufferedReader(new FileReader( SRC_INSTALLATION_REQUESTS ))) {
            int lineCount = 0;
            while ( true ) {
                String readLine = reader.readLine ( );
                if ( readLine == null ) break;
                lineCount++;
            }
            return lineCount;
        } catch (IOException e) {
            printException ( e.getMessage () );
            return -1; // Return a special value indicating an error
        }
    }
    public void getUsersFromFile ( ) {
        try {
            putUsers ( users , SRC_INSTALLERS_TXT );
        }
        catch ( IOException e ) {
            printException ( e.getMessage () );
        }
    }

    void putUsers ( Map < String, String > users , String srcInstallersTxt ) throws IOException {
        users.clear ( );
        File file = new File ( srcInstallersTxt );
        try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
            String nameAndPass;
            while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
                String[] data = nameAndPass.split ( "," );
                users.put ( data[ 0 ] , data[ 1 ] );
            }
        }
    }

    public
    void clearCredentials ( ) {
        username  = null;
        password  = null;
        loginFlag = false;
    }

    public
    void login ( String username , String password ) {
        getUsersFromFile ( );
        if ( ! users.containsKey ( username ) ) {
            loginFlag = false;
            return;
        }
        String adminPass = users.get ( username );
        loginFlag = adminPass.equals ( password );
        if ( ! loginFlag ) {
            LOGGER.info ( "Can't Log In" );
            errorMessageFlag = true;
        }
        else {
            dashboardManager ( "Load Dashboard" );
        }
    }

    public
    void dashboardManager ( String userInput ) {
        switch (userInput) {
            case "1":
                listInstallationRequests ( );
                break;

            case "3":
                MainScreen.setCurrentPage ("home-page");
                MainScreen.displayPage ( MainScreen.getCurrentPage () );
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
        File file = new File ( SRC_INSTALLATION_REQUESTS );
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

    public
    Map < String, String > getUsers ( ) {
        getUsersFromFile ( );
        return users;
    }

    public
    void printUsers ( ) {
        getUsersFromFile ( );
        int x = 0;
        for ( Map.Entry < String, String > entry : users.entrySet ( ) ) {
            x++;
            String msg = x + ". UserName: " + entry.getKey ( );
            LOGGER.info ( msg );
        }

    }

    public
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

    private
    void addToFile ( String userName , String password ) {
        writeUsers ( userName , password , SRC_INSTALLERS_TXT, users);
    }

    boolean checkPassword ( String password ) {
        getUsersFromFile ( );
        return password.length ( ) >= 8;
    }

    private
    boolean checkUserName ( String userName ) {
        getUsersFromFile ( );
        return userName.contains ( "@" );
    }

    public static
    void setInstallationRequestId ( String string ) {
        File file = new File ( SRC_INSTALLATION_REQUESTS );
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

    public
    void deleteInstallerAccount ( int userToModifyID ) {
        deleteUser ( userToModifyID, users, SRC_INSTALLERS_TXT );
    }

    public
    void writeUsersToFile ( Map < String, String > users , String filePath ) {
        bufferWriter ( users , filePath , LOGGER );
    }

    public
    void changePassword ( int userToModifyID , String newPassword ) {
        checkThenSetNewPassword ( userToModifyID , newPassword, users, SRC_INSTALLERS_TXT);
    }

    public
    void changeUserName ( int userToModifyID , String newUserName ) {
        if ( ! checkUserName ( newUserName ) ) {
            LOGGER.info ( "Username Format Wrong Or Used" );
            Users.usernameChanged = false;
            return;
        }
        users.clear ( );
        File file = new File ( SRC_INSTALLERS_TXT );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                fileRead2 ( userToModifyID , newUserName , bufferedReader , LOGGER , users );
                Users.usernameChanged = true;
                writeUsersToFile ( users , file.getPath ( ) );
            }
        }
        catch ( IOException e ) {
            Users.usernameChanged = false;
            printException ( e.getMessage () );
        }
    }
}
