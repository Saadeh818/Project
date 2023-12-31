package org.main;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public
class Customer extends Users {

    public static final String SRC_CUSTOMERS_TXT = "src/Customers.txt";
    private Map < String, String > users = new HashMap <> ( );
    private static final Logger LOGGER = Logger.getLogger ( Customer.class.getName ( ) );

    public
    void setUsername ( String username ) {
        this.username = username;
    }

    public
    void setPassword ( String password ) {
        this.password = password;
    }

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

    private String  username;
    private String  password;
    private static boolean loginFlag        = false;
    private static boolean addUserSuccess;

    public static
    boolean isInstallationRequestAdded ( ) {
        return installationRequestAdded;
    }

    private static boolean installationRequestAdded;


    void getUsersFromFile ( ) {
        try {
            Installer installer = new Installer ();
            installer.putUsers ( users , SRC_CUSTOMERS_TXT );
        }
        catch ( IOException e ) {
            printException ( e.getMessage () );
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
            JOptionPane.showMessageDialog ( null, "wrong Input", "Error", JOptionPane.ERROR_MESSAGE );
        }
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

    private
    void addToFile ( String userName , String password ) {
        writeUsers ( userName , password , SRC_CUSTOMERS_TXT, users);
    }

    boolean checkPassword ( String password ) {
        getUsersFromFile ( );
        return password.length ( ) >= 8;
    }

    private
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


    public
    void deleteCustomerAccount ( int userToModifyID ) {
        deleteUser ( userToModifyID, users, SRC_CUSTOMERS_TXT );
    }

    public
    void changePassword ( int userToModifyID , String newPassword ) {
        checkThenSetNewPassword ( userToModifyID , newPassword, users, SRC_CUSTOMERS_TXT);
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

    public
    void writeUsersToFile ( Map < String, String > users , String filePath ) {
        bufferWriter ( users , filePath , LOGGER );
    }

    public
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
        category                 = productC.getCategory ();
        productName              = productC.getName ();
        price                    = productC.getPrice ();
        installationRequestAdded = true;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/InstallationRequests", true))) {
            writer.write ( "%n%d. ,%d, %s, %s, %d, %d, %s".formatted ( installationID , productID , category , productName , quantity , price , user ) );
        } catch (IOException e) {
            installationRequestAdded =false;
            printException ( e.getMessage () );
        }
    }
}
