package org.main;

import java.io.*;
import java.util.Map;
import java.util.logging.Logger;

import static org.main.Customer.fileRead;

public
class Users {

    public static final String CUSTOMER = "Customer";
    public static final String INSTALLER = "Installer";
    public static boolean selectUserToMenageFlag;
    public static        String  modifyAccountType;
    public static        boolean userDeleted;
    public static        boolean passwordUpdated;
    public static        boolean usernameChanged;
    public static        boolean failToAdd;
    public static        int     userToModifyID;
    public static boolean userIsFound       = false;
    public static boolean installerSelected = false;
    public static        boolean customerSelected = false;
    public static        boolean addUserSelected  = false;
    private static final Logger  LOGGER           = Logger.getLogger ( Users.class.getName ( ) );

    public
    Users ( ) {
        //To Hide The Private Constructor
    }


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

    public static
    void selectUserToMenage ( String userType ) {
        switch (userType) {
            case "1":
                Installer.printUsers ( );
                installerSelected = true;
                customerSelected = false;
                addUserSelected = false;
                break;
            case "2":
                Customer.printUsers ( );
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
            Installer.addInstaller ( userName , password );
            failToAdd = ! Installer.isAddUserSuccess ();
        }
        else if ( userType.equals ( "2" ) ) {
            Customer.addCustomer ( userName , password );
            failToAdd = ! Customer.isAddUserSuccess ();
        }
        else failToAdd = true;
    }


    public static
    void setUserToModifyID ( String id ) {
        try {
            userToModifyID = Integer.parseInt ( id );
            if ( customerSelected && (userToModifyID - 1 <= Customer.getUsers ( ).size ( )) ) userIsFound = true;
            else if ( installerSelected && (userToModifyID - 1 <= Installer.getUsers ( ).size ( )) ) userIsFound = true;
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
            if(filePath.contains ( CUSTOMER ))
            Customer.getUsersFromFile ( );
            else {
                Installer.getUsersFromFile ( );
            }
        }
        catch ( IOException e ) {
            printException ( e.getMessage () );
        }
    }

    protected static
    void deleteUser ( int userToModifyID , Map < String, String > users , String srcInstallersTxt ) {
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
                Installer.writeUsersToFile ( users , file.getPath ( ) );
                else {
                    Customer.writeUsersToFile ( users , file.getPath ( ) );
                }
            }
        }
        catch ( IOException e ) {
            Users.userDeleted = false;
            printException ( e.getMessage () );
        }
    }
    protected static
    void checkThenSetNewPassword ( int userToModifyID , String newPassword , Map < String, String > users , String srcInstallersTxt ) {
        if (srcInstallersTxt.contains ( INSTALLER ) && ! Installer.checkPassword ( newPassword ) ) {
            LOGGER.info ( "Password Format Wrong" );
            Users.passwordUpdated = false;
            return;
        }
        if (srcInstallersTxt.contains ( CUSTOMER ) && ! Customer.checkPassword ( newPassword ) ) {
            LOGGER.info ( "Password Format Wrong" );
            Users.passwordUpdated = false;
            return;
        }
        users.clear ( );
        File file = new File ( srcInstallersTxt );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                fileRead ( userToModifyID , newPassword , bufferedReader , LOGGER , users );
                Users.passwordUpdated = true;
                if(srcInstallersTxt.contains ( INSTALLER ))
                Installer.writeUsersToFile ( users , file.getPath ( ) );
                else {
                    Customer.writeUsersToFile ( users , file.getPath ( ) );
                }
            }
        }
        catch ( IOException e ) {
            Users.passwordUpdated = false;
            printException ( e.getMessage () );
        }
    }
}
