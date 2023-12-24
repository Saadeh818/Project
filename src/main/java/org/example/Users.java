package org.example;

public class Users {

    public static boolean selectUserToMenageFlag;
    public static String modifyAccountType;
    protected static boolean userDeleted;
    static boolean installerSelected =false;
    static boolean customerSelected= false;
    static boolean addUserSelected= false;
    public static boolean  failToAdd;
    public static int userToModifyID;
    public static  boolean userIsFound= false;

    static void userManagementScreen(){
        System.out.print( """
                                  What do you want to do?\s
                                  1. Display All Installers To Modify One Of Them
                                  2. Display All Customers To Modify One Of Them
                                  3. Add New User
                                  4. Return To Dashboard
                                  5. LogOut
                                  """
        );
    }

    public static void selectUserToMenage(String userType) {
        switch (userType){
            case "1":
                Installer.printUsers();
                installerSelected=true;
                customerSelected=false;
                addUserSelected=false;
            break;
            case "2":
                Customer.printUsers();
                installerSelected=false;
                customerSelected=true;
                addUserSelected=false;
                break;
            case "3":
                installerSelected=false;
                customerSelected=false;
                addUserSelected=true;
                break;

            default:
                installerSelected=false;
                customerSelected=false;
                addUserSelected=false;
        }
    }

    public static void adduser(String userType, String userName, String password) {
        if(userType.isEmpty()){
            failToAdd =true;
            return;
        }
        if(userType.equals("1")){
            Installer.addInstaller(userName,password);
            failToAdd = !Installer.addUserSuccess;
        }
        else if(userType.equals("2")){
            Customer.addCustomer(userName,password);
            failToAdd = !Customer.addUserSuccess;
        }
        else failToAdd =true;
    }


    public static
    void userToModifyID ( String ID ) {
        try{
            userToModifyID = Integer.parseInt ( ID );
            if(customerSelected && (userToModifyID-1 <= Customer.getUsers ().size ()))userIsFound=true;
            else if ( installerSelected && (userToModifyID-1 <= Installer.getUsers ().size ()) ) userIsFound=true;
            else {
                userIsFound = false;
                System.out.println ( "Wrong User ID" );
            }
        }
        catch ( NumberFormatException e ) {
            userIsFound=false;
            System.out.println ( "Wrong Input Format For ID" );
        }
    }

    public static
    void setTypeToModify ( String string ) {
        installerSelected=false;
        customerSelected = false;
        if(string.equals ( "installer" )) {
            installerSelected = true;
            loadModifyAccountOptions ( );
        }
        else if ( string.equals ( "customer" ) ) {
            customerSelected=true;
            loadModifyAccountOptions ( );
        }
    }


    public static
    void loadModifyAccountOptions ( ) {
        System.out.println ( """
                                     1. Change Password.
                                     2. Change Username.
                                     3.Delete Account.
                                     4. Return Back
                                     5. Go To Dashboard.""" );
    }
}
