package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public
class Customer extends Users {

    private static final Map < String, String > users            = new HashMap <> ( );
    private static final Logger LOGGER = Logger.getLogger ( Customer.class.getName ( ) );
    static public        String                 username;
    static public        String                 password;
    static public        boolean                loginFlag        = false;
    static public        boolean                errorMessageFlag = false;
    public static    boolean addUserSuccess;
    protected static boolean installationRequestAdded = false;

    static
    void getUsersFromFile ( ) {
        try {
            users.clear ( );
            File file = new File ( "src/Customers.txt" );
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
        if ( ! Customer.users.containsKey ( username ) ) {
            loginFlag = false;
            return;
        }
        String adminPass = users.get ( username );
        loginFlag = adminPass.equals ( password );
        if ( ! loginFlag ) {
//            JOptionPane.showMessageDialog(null,"wrong Input","Error",JOptionPane.ERROR_MESSAGE);
            errorMessageFlag = false;
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
            LOGGER.info ( x + ". UserName: " + entry.getKey ( ) );
        }
    }

    public static
    void addCustomer ( String userName , String password ) {
        getUsersFromFile ( );
        if ( checkUserName ( userName ) && checkPassword ( password ) && ! users.containsKey ( userName ) ) {
            addToFile ( userName , password );
            addUserSuccess = true;
        }
        else addUserSuccess = false;
    }

    private static
    void addToFile ( String userName , String password ) {
        try {
            users.clear ( );
            File file = new File ( "src/Customers.txt" );
            try (BufferedWriter bufferedWriter = new BufferedWriter ( new FileWriter ( file , true ) )) {
                String nameAndPass = userName + "," + password;
                bufferedWriter.newLine ( );
                bufferedWriter.write ( nameAndPass );
            }
            getUsersFromFile ( );
        }
        catch ( IOException e ) {
            e.printStackTrace ( System.out );
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
        return userName.contains ( "@" ) && userName.contains ( "." );
    }

    public static
    void addAppointment ( String date , String requestID , String userRequested ) {
        Appointment appointment = new Appointment ( );
        if ( ! appointment.checkDate ( date ) ) {
            return;
        }
        appointment.addNewAppointment ( date , requestID , userRequested );
    }


    public static
    void deleteCustomerAccount ( int userToModifyID ) {
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
    void changePassword ( int userToModifyID , String newPassword ) {
        if ( ! checkPassword ( newPassword ) ) {
            LOGGER.info ( "Password Format Wrong" );
            Users.passwordUpdated = false;
            return;
        }
        users.clear ( );
        File file = new File ( "src/Customers.txt" );
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

    public static
    void writeUsersToFile ( Map < String, String > users , String filePath ) {
        bufferWriter ( users , filePath , LOGGER );
    }

    static
    void bufferWriter ( Map < String, String > users , String filePath , Logger logger ) {
        try (BufferedWriter writer = new BufferedWriter ( new FileWriter ( filePath , false ) )) {
            for ( Map.Entry < String, String > entry : users.entrySet ( ) ) {
                String line = entry.getKey ( ) + "," + entry.getValue ( );
                writer.write ( line );
                writer.newLine ( );
            }

            logger.info ( "Users written to file successfully." );
        }
        catch ( IOException e ) {
            e.printStackTrace ( System.out );
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

    public static void setUsername(String username) {
        Customer.username = username;
    }

    public static void setPassword(String password) {
        Customer.password = password;
    }

    public static
    void addInstallationRequest ( int productID , int quantity , String user ) {
//        InstallationID, ProductID,category, productName, quantity, price, user
        int installationID = Installer.getNumberOfInstallation ();
        String category="NO CATEGORY FOUND";
        String productName= "NO PRODUCT NAME FOUND";
        int price= 0;
        for ( ProductC product : ProductC.productList ) {
            if ( product.productId == productID ) {
                category =  product.category;
                productName= product.name;
                price = product.price;
            }else{
                LOGGER.info ( "Product is Not Found" );
                installationRequestAdded = false;
                return;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/InstallationRequests", true))) {
            writer.write(installationID + ". ," + productID + ", " + category + ", " + productName+ ", "+ quantity + ", " + price+ ", "+user);
            installationRequestAdded = true;
        } catch (IOException e) {
            installationRequestAdded = false;
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
    }
}
