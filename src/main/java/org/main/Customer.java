package org.main;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public
class Customer extends Users {

    public static final String SRC_CUSTOMERS_TXT = "src/Customers.txt";
    private static final Map < String, String > users = new HashMap <> ( );
    private static final Logger LOGGER = Logger.getLogger ( Customer.class.getName ( ) );

    public static
    void setUsername ( String username ) {
        Customer.username = username;
    }

    public static
    void setPassword ( String password ) {
        Customer.password = password;
    }

    public static
    String getUsername ( ) {
        return username;
    }

    public static
    String getPassword ( ) {
        return password;
    }

    public static
    boolean isLoginFlag ( ) {
        return loginFlag;
    }

    public static
    boolean isAddUserSuccess ( ) {
        return addUserSuccess;
    }

    private static String  username;
    private static String  password;
    private static boolean loginFlag        = false;
    private static boolean addUserSuccess;

    public static
    boolean isInstallationRequestAdded ( ) {
        return installationRequestAdded;
    }

    private static boolean installationRequestAdded;


    static
    void getUsersFromFile ( ) {
        try {
            Installer.putUsers ( users , SRC_CUSTOMERS_TXT );
        }
        catch ( IOException e ) {
            printException ( e.getMessage () );
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
        if ( ! Customer.users.containsKey ( username ) ) {
            loginFlag = false;
            return;
        }
        String adminPass = users.get ( username );
        loginFlag = adminPass.equals ( password );
        if ( ! loginFlag ) {
            JOptionPane.showMessageDialog ( null, "wrong Input", "Error", JOptionPane.ERROR_MESSAGE );
        }
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
    void addCustomer ( String userName , String password ) {
        getUsersFromFile ( );
        if ( checkUserName ( userName ) && checkPassword ( password ) && ! users.containsKey ( userName ) ) {
            addToFile ( userName , password );
            addUserSuccess = true;
            LOGGER.info ( "Customer Added Successfully" );
        }
        else addUserSuccess = false;
        LOGGER.info ( "Fail To Add " );
    }

    private static
    void addToFile ( String userName , String password ) {
        writeUsers ( userName , password , SRC_CUSTOMERS_TXT, users);
    }


    static
    boolean checkPassword ( String password ) {
        getUsersFromFile ( );
        return password.length ( ) >= 8;
    }

    private static
    boolean checkUserName ( String userName ) {
        getUsersFromFile ( );
        return userName.contains ( "@" ) && userName.contains ( "." );
    }

    public static
    void addAppointment ( String date , String requestID , String userRequested ) {
        if ( ! Appointment.checkDate ( date ) ) {
            return;
        }
        Appointment.addNewAppointment ( date , requestID , userRequested );
    }


    public static
    void deleteCustomerAccount ( int userToModifyID ) {
        deleteUser ( userToModifyID, users, SRC_CUSTOMERS_TXT );
    }

    public static
    void changePassword ( int userToModifyID , String newPassword ) {
        checkThenSetNewPassword ( userToModifyID , newPassword, users, SRC_CUSTOMERS_TXT);
    }

    static
    void fileRead ( int userToModifyID , String newPassword , BufferedReader bufferedReader , Logger logger , Map < String, String > users ) throws IOException {
        String   nameAndPass;
        String[] data;
        int      index = 0;
        while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
            if ( (index != (userToModifyID - 1)) ) {
                data = nameAndPass.split ( "," );
                logger.info ( nameAndPass );
                users.put ( data[ 0 ] , data[ 1 ] );
                index++;
            }
            else if ( index == (userToModifyID - 1) ) {
                data = nameAndPass.split ( "," );
                users.put ( data[ 0 ] , newPassword );
            }
        }
    }

    static
    void fileRead2 ( int userToModifyID , String newUsername , BufferedReader bufferedReader , Logger logger , Map < String, String > users ) throws IOException {
        String   nameAndPass;
        String[] data;
        int      index = 0;
        while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
            if ( (index != (userToModifyID - 1)) ) {
                data = nameAndPass.split ( "," );
                logger.info ( nameAndPass );
                users.put ( data[ 0 ] , data[ 1 ] );
                index++;
            }
            else if ( index == (userToModifyID - 1) ) {
                data = nameAndPass.split ( "," );
                users.put ( newUsername , data[ 1 ] );
            }
        }
    }

    public static
    void writeUsersToFile ( Map < String, String > users , String filePath ) {
        bufferWriter ( users , filePath , LOGGER );
    }

    static
    void bufferWriter ( Map < String, String > users , String filePath , Logger logger ) {
        try (BufferedWriter writer = new BufferedWriter ( new FileWriter ( filePath , false ) )) {
            for ( Map.Entry < String, String > entry : users.entrySet ( ) ) {
                String line = entry.getKey ( ) + "," + entry.getValue ( )+"\n";
                writer.write ( line );
            }

            logger.info ( "Users written to file successfully." );
        }
        catch ( IOException e ) {
            printException ( e.getMessage () );
        }
    }

    public static
    void changeUserName ( int userToModifyID , String newUserName ) {
        if ( ! checkUserName ( newUserName ) ) {
            LOGGER.info ( "Password Format Wrong" );
            Users.usernameChanged = false;
            return;
        }
        users.clear ( );
        File file = new File ( SRC_CUSTOMERS_TXT );
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

    public static
    void addInstallationRequest ( int productID , int quantity , String user ) {
//        InstallationID, ProductID,category, productName, quantity, price, user
        int      installationID = Installer.getNumberOfInstallation ( ) + 1;
        String category;
        String productName;
        int price;

        @SuppressWarnings ( "unused") ProductC productC;
        try {
            //noinspection UnusedAssignment
            productC = ProductC.productList.get ( productID );
        }
        catch ( Exception e ) {
            LOGGER.info ( "Not Found" );
            installationRequestAdded =false;
            return;
        }
        category                 = ProductC.getCategory ();
        productName              = ProductC.getName ();
        price                    = ProductC.getPrice ();
        installationRequestAdded = true;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/InstallationRequests", true))) {
            writer.write ( "%n%d. ,%d, %s, %s, %d, %d, %s".formatted ( installationID , productID , category , productName , quantity , price , user ) );
        } catch (IOException e) {
            installationRequestAdded =false;
            printException ( e.getMessage () );
        }
    }
}
