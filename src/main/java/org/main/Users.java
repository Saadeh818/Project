package org.main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public
class Users {

    public static final String CUSTOMER = "Customer";
    public static final String INSTALLER = "Installer";
    public static boolean selectUserToMenageFlag;

    public static
    void setModifyAccountType ( String modifyAccountType ) {
        Users.modifyAccountType = modifyAccountType;
    }

    public static
    boolean isUserDeleted ( ) {
        return userDeleted;
    }

    public static
    boolean isPasswordUpdated ( ) {
        return passwordUpdated;
    }

    public static
    boolean isInstallerSelected ( ) {
        return installerSelected;
    }

    public static
    boolean isCustomerSelected ( ) {
        return customerSelected;
    }

    public static
    boolean isAddUserSelected ( ) {
        return addUserSelected;
    }

    private static       String  modifyAccountType;
    private static       boolean userDeleted;
    private static       boolean passwordUpdated;
    public static        boolean usernameChanged;
    public static        boolean failToAdd;
    public static        int     userToModifyID;
    public static        boolean userIsFound       = false;
    private static       boolean installerSelected = false;
    private static       boolean customerSelected = false;
    private static       boolean addUserSelected  = false;
    private static final Logger  LOGGER           = Logger.getLogger ( Users.class.getName ( ) );

    public static
    void userManagementScreen ( ) {
        LOGGER.info ( """
                                   What do you want to do?\s
                                   1. Display All Installers To Modify One Of Them
                                   2. Display All Customers To Modify One Of Them
                                   3. Add New User
                                   4. Return To Dashboard
                                   5. LogOut
                                   """
                         );
    }

    public
    void selectUserToMenage ( String userType ) {
        switch (userType) {
            case "1":
                Installer installer = new Installer ();
                installer.printUsers ( );
                installerSelected = true;
                customerSelected = false;
                addUserSelected = false;
                break;
            case "2":
                Customer customer = new Customer ();
                customer.printUsers ( );
                installerSelected = false;
                customerSelected = true;
                addUserSelected = false;
                break;
            case "3":
                installerSelected = false;
                customerSelected = false;
                addUserSelected = true;
                break;

            default:
                installerSelected = false;
                customerSelected = false;
                addUserSelected = false;
        }
    }

    public static
    void adduser ( String userType , String userName , String password ) {
        if ( userType.isEmpty ( ) ) {
            failToAdd = true;
            return;
        }
        if ( userType.equals ( "1" ) ) {
            Installer installer= new Installer ();
            installer.addInstaller ( userName , password );
            failToAdd = ! Installer.isAddUserSuccess ();
        }
        else if ( userType.equals ( "2" ) ) {
            Customer customer=new Customer ();
            customer.addCustomer ( userName , password );
            failToAdd = ! Customer.isAddUserSuccess ();
        }
        else failToAdd = true;
    }


    public static
    void setUserToModifyID ( String id ) {
        try {
            userToModifyID = Integer.parseInt ( id );
            Installer installer= new Installer ();
            Customer customer = new Customer ();
            if ( customerSelected && (userToModifyID - 1 <= customer.getUsers ( ).size ( )) ) userIsFound = true;
            else if ( installerSelected && (userToModifyID - 1 <= installer.getUsers ( ).size ( )) ) userIsFound = true;
            else {
                userIsFound = false;
                LOGGER.info ( "Wrong User ID" );
            }
        }
        catch ( NumberFormatException e ) {
            userIsFound = false;
            LOGGER.info ( "Wrong Input Format For ID" );
            printException ( e.getMessage ( ) );
        }
    }

    public static
    void printException ( String s ) {
        LOGGER.info ( s );
    }

    public static
    void setTypeToModify ( String string ) {
        installerSelected = false;
        customerSelected  = false;
        if ( string.equals ( "installer" ) ) {
            installerSelected = true;
            loadModifyAccountOptions ( );
        }
        else if ( string.equals ( "customer" ) ) {
            customerSelected = true;
            loadModifyAccountOptions ( );
        }
    }


    public static
    void loadModifyAccountOptions ( ) {
        LOGGER.info ( """
                                     1. Change Password.
                                     2. Change Username.
                                     3.Delete Account.
                                     4. Return Back
                                     5. Go To Dashboard.""" );
    }

    static
    void writeUsers ( String userName , String password , String filePath , Map < String, String > users ) {
        try {
            users.clear ( );
            File file = new File ( filePath );
            try (BufferedWriter bufferedWriter = new BufferedWriter ( new FileWriter ( file , true ) )) {
                String nameAndPass = userName + "," + password;
                bufferedWriter.write ( nameAndPass+ "\n" );
            }
            if(filePath.contains ( CUSTOMER )){
                Customer customer = new Customer ();
                customer.getUsersFromFile ( );
            }
            else {
                Installer installer = new Installer ();
                installer.getUsersFromFile ( );
            }
        }
        catch ( IOException e ) {
            printException ( e.getMessage () );
        }
    }

    protected static
    void deleteUser ( int userToModifyID , Map < String, String > users , String srcInstallersTxt ) {
        Installer installer = new Installer ();
        Customer customer = new Customer ();
        users.clear ( );
        File file = new File ( srcInstallersTxt );
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
                if(srcInstallersTxt.contains ( INSTALLER ))
                installer.writeUsersToFile ( users , file.getPath ( ) );
                else {
                    customer.writeUsersToFile ( users , file.getPath ( ) );
                }
            }
        }
        catch ( IOException e ) {
            Users.userDeleted = false;
            printException ( e.getMessage () );
        }
    }
    protected
    void checkThenSetNewPassword ( int userToModifyID , String newPassword , Map < String, String > users , String srcInstallersTxt ) {
        Installer installer = new Installer ();
        Customer customer= new Customer ();
        if (srcInstallersTxt.contains ( INSTALLER ) && ! installer.checkPassword ( newPassword ) ) {
            LOGGER.info ( "Password Format Wrong" );
            Users.passwordUpdated = false;
            return;
        }
        if (srcInstallersTxt.contains ( CUSTOMER ) && ! customer.checkPassword ( newPassword ) ) {
            LOGGER.info ( "Password Format Wrong" );
            Users.passwordUpdated = false;
            return;
        }
//        users.clear ( );
        File file = new File ( srcInstallersTxt );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                users= fileRead ( userToModifyID , newPassword , bufferedReader , LOGGER , srcInstallersTxt);
                Users.passwordUpdated = true;
                if(srcInstallersTxt.contains ( INSTALLER ))
                installer.writeUsersToFile ( users , file.getPath ( ) );
                else {
                    customer.writeUsersToFile ( users , file.getPath ( ) );
                }
            }
        }
        catch ( IOException e ) {
            Users.passwordUpdated = false;
            printException ( e.getMessage () );
        }
    }

    Map < String, String > fileRead ( int userToModifyID , String newPassword , BufferedReader bufferedReader , Logger logger , String srcInstallersTxt ) throws IOException {
        String   nameAndPass;
        String[] data;
        Map < String, String > users = new HashMap <> (  );
        int      index               = 0;
        while ( (nameAndPass = bufferedReader.readLine ( )) != null ) {
            data = nameAndPass.split ( "," );
            if ( (index != (userToModifyID - 1)) ) {
                logger.info ( nameAndPass );
                users.put ( data[ 0 ] , data[ 1 ] );
                index++;
            }
            else if ( index == (userToModifyID - 1) ) {
                users.put ( data[ 0 ] , newPassword );
            }
        }
        return users;
    }

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
}
