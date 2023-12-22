package org.example;

public class Users {

    public static boolean selectUserToMenageFlag;
    public static String modifyAccountType;
    static boolean installerSelected =false;
    static boolean customerSelected= false;
    static boolean addUserSelected= false;
    public static boolean  failToAdd;
    public static int userToModifyID;
    private static boolean userDisplayed;
    public static  boolean userIsFound= false;

    static void userManagementScreen(){
        System.out.print("What do you want to do? \n" +
                "1. Display All Installers To Modify One Of Them\n" +
                "2. Display All Customers To Modify One Of Them\n" +
                "3. Add New User\n" +
                 "4. Return To Dashboard\n" +
                 "5. LogOut\n"
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
            userIsFound=false;;
            System.out.println ( "Wrong Input Format For ID" );
        }
    }

    public static
    void setTypeToModify ( String string ) {
        installerSelected=false;
        customerSelected = false;
        if(string.equals ( "installer" )) {
            installerSelected = true;
            printModifyOptions();
        }
        else if ( string.equals ( "customer" ) ) {
            customerSelected=true;
            printModifyOptions();
        }
    }

    private static
    void printModifyOptions ( ) {
        System.out.print ( "\n What Do You Want To Update ?  \n" +
                                   "1. Change Password \n" +
                                   "2. Change UserName \n" +
                                   "3. Delete Account \n " );
    }

    public static
    void loadModifyAccountOptions ( ) {
        System.out.println ( "1. Change Password.\n" +
                                     "2. Change Username.\n" +
                                     "3.Delete Account.\n" +
                                     "4. Return Back\n" +
                                     "5. Go To Dashboard." );
    }

    public static
    void modifyAccount ( String modifyAccountType , int userToModifyID , String modifyOption ) {
        if (modifyAccountType.equalsIgnoreCase ( "installer" )){
            switch (modifyOption){
                case "1":

            }
        }
        if (modifyAccountType.equalsIgnoreCase ( "customer" )){

        }
    }
}
