package org.example.AcceptanceTest;

public class Users {
    public static boolean selectUserToMenageFlag;
    public static boolean installerSelected;
    public static boolean customerSelected;
    public static boolean addUserSelected;
    public static boolean failToAdd;

    static void userManagementScreen(){
        System.out.print("What do you want to do? \n" +
                "1. Display All Installers\n" +
                "2. Display All Installers Customers\n" +
                "3. Add New User\n"
        );
    }

    public static void selectUserToMenage(String userType) {
        switch (userType){
            case "1": Installer.printUsers();
            installerSelected=true;
            customerSelected=false;
            addUserSelected=false;
            break;
            case "2": Customer.printUsers();
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
}
