package org.example;

import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner scanner = new Scanner ( System.in );

    public static
    void main ( String[] args ) {
        while ( true ) {
            MainScreen.displayPage ( "home-page" );
            MainScreen.userInput = scanner.nextLine ( );
            MainScreen.nextScreen ( MainScreen.userInput );
            switch (MainScreen.currentPage){
                case "admin-login":
                    adminActions();
                    break;
                case "customer-login":
                    break;

                case "installer-login":
                    installerActions();
                    break;
                case "signUp-page":
                    System.out.println("Choose type 1 for installer 2 for customer");
                    String type= scanner.nextLine();
                    System.out.print("Enter Your Email: ");
                    String email= scanner.nextLine();
                    System.out.print("Enter Your Password: ");
                    Users.adduser ( type,email,scanner.nextLine ());
                    break;
                default:
                    break;
            }
        }
    }

    private static
    void installerActions ( ) {
        System.out.print ( "Welcome Installer Please fill your data to login\n"
                                   + "Enter your name please: " );
        Installer.clearCredentials ();
        String username = scanner.nextLine ();
        System.out.println ( );
        System.out.println ( "Enter Password please: "  );
        String password = scanner.nextLine ();

        Installer.login (username,password);
        installerDashboard ( username , password );

    }

    private static
    void installerDashboard ( String username , String password ) {
        String userInput = scanner.nextLine ();
        Installer.dashboardManager ( userInput );
        if (userInput.equals ( "1" )){
            System.out.println ( "Choose ID To Schedule An Appointment Or Enter # To return To dashboard " );
            userInput = scanner.nextLine ();
            if (userInput.equals ( "#" ))
                installerDashboard ( username , password );
            else

                Installer.SetInstallationRequestId ( userInput );
            if ( Installer.requestFound ){
//                    System.out.println ( Installer.requestID +" "+Installer.userRequested );
                System.out.println ( "Enter The Date to Schedule An Appointment : \" Date Format is day/month/year\" " );
                Customer.addAppointment(scanner.nextLine (), Installer.requestID, Installer.userRequested);
                installerDashboard ( username , password );
            }

        }
    }


    private static
    void adminActions ( ) {
        System.out.print ( "Welcome Admin Please fill your data to login\n"
                                   + "Enter your name please: " );
        Admin.clearCredentials ();
        String username = scanner.nextLine ();
        System.out.println ( );
        System.out.println ( "Enter Password please: "  );
        String password = scanner.nextLine ();

        Admin.setUsername ( username );
        Admin.setPassword ( password );

        Admin.login ();
        adminDashboard ( username , password );
    }

    private static
    void adminDashboard ( String username , String password ) {
        switch (scanner.nextLine ()){
            case "1":
                productManager ( username , password );
                return;
            case "2":
                userManager ( username , password );
                return;
            case "3":
                return;
            default:
                System.out.println ( "Wrong Input Please Try To Choose Write" );
                adminActions ( );
        }
    }

    private static
    void userManager ( String username , String password ) {
        Users.userManagementScreen ();
        String userInput = scanner.nextLine ();
        Users.selectUserToMenage(userInput);
        switch (userInput){
            case "1":
            case "2":
                System.out.print ( "Enter Installer ID To Modify: " );
                Users.userToModifyID ( scanner.nextLine () );
                Users.loadModifyAccountOptions();
                switch (scanner.nextLine ()){
                    case "1":
                        //TODO: Change Password
                        break;
                    case "2":
                        //TODO: Change Username
                        break;
                    case "3":
                        //TODO: Delete Account
                        break;
                    case "5":
                        return;
                    default:
                        userManager ( username , password );
                        break;
                }
                break;
            case "3":
                System.out.println ( "Choose User Type To Add:\n" +
                                             "1. Installer\n" +
                                             "2. Customer " );
                String NewUserType = scanner.nextLine ();
                System.out.print ( "Enter User Name: " );
                String NewUserName = scanner.nextLine ();
                System.out.print ( "Enter Password: " );
                String newUserPassword= scanner.nextLine ();
                Users.adduser(NewUserType,NewUserName,newUserPassword);
                userManager(username,password);
                break;
            case "4":
                adminDashboard ( username , password );
            case "5":
                return;
            default:
                userManager ( username , password );
        }
    }

    private static
    void productManager ( String username, String password ) {
        ProductC productC = new ProductC (  );
        System.out.print ( "*********************************************\n" +
                                   "Here You Can Manage All Products\n" +
                                   "1. Add a Product.\n" +
                                   "2. Delete a Product.\n" +
                                   "3.Update a Product.\n" +
                                   "4.Return to dashboard.\n" +
                                   "5.Sign Out.\n" );
        switch (scanner.nextLine ()){
            case "1":
                ProductC.productList();
                System.out.print ("Enter The Category: ");
                String categoryI = scanner.nextLine ();
                System.out.print ("Enter The Product Name: ");
                String nameI =scanner.nextLine ();
                System.out.print ("Enter The Product Quantity: ");
                String quantityI=scanner.nextLine ();
                System.out.print ("Enter The Product Price: ");
                String priceI=scanner.nextLine ();
                productC.addProduct ( categoryI,nameI,quantityI,priceI );
                productManager ( username, password );
                break;
            case "2":
                ProductC.productList();
                System.out.println ( "1. Cat1.\n" +
                                             "2. Cat2.\n" +
                                             "3. Cat3.\n" +
                                             "Press Any Key To Return." );
                switch (scanner.nextLine ()){
                    case "1":
                        productC.setCategory ("cat1");
                        break;
                    case "2":
                        productC.setCategory ("cat2");
                        break;
                    case "3":
                        productC.setCategory ("cat3");
                        break;
                    default:
                        productManager ( username, password );
                        break;
                }
                System.out.print ( "Enter The ID Of The Product" );
                productC.selectIdToDelete(scanner.nextLine (),productC.category);
                break;
            case "3":
                ProductC.productList();
                System.out.println ( "1. Cat1.\n" +
                                             "2. Cat2.\n" +
                                             "3. Cat3.\n" +
                                             "Press Any Key To Return." );
                switch (scanner.nextLine ()){
                    case "1":
                        productC.setCategory ("cat1");
                        break;
                    case "2":
                        productC.setCategory ("cat2");
                        break;
                    case "3":
                        productC.setCategory ("cat3");
                        break;
                    default:
                        productManager ( username, password );
                        break;
                }
                System.out.println ( "Any Field that you dont want to change just insert #..." );
                System.out.print ( "Enter The ID Of The Product" );
                productC.productId= Integer.parseInt(scanner.nextLine ());
                System.out.print ( "Enter new Category (cat1,cat2,cat3): " );
                String category = scanner.nextLine ();
                System.out.print ( "Enter new Name : " );
                String name = scanner.nextLine ();
                System.out.print ( "Enter new Quantity : " );
                String quantity = scanner.nextLine ();
                System.out.print ( "Enter new Price : " );
                String price = scanner.nextLine ();
                productC.updateValues(productC.productId, category,name,quantity,price);
                break;
            case "4":
                productManager ( username, password );
                break;
            case "5":
                break;
        }
    }


    private static
    void Customer() {
        System.out.println("Welcome Customer! Please choose an option:");
        System.out.println("1. View Products");
        System.out.println("2. Write a Product Review");
        System.out.println("3. Return to Dashboard");

        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                viewProducts();
                break;
            case "2":
                writeProductReview();
                break;
            case "3":
                return;
            default:
                System.out.println("Invalid input. Please try again.");
                Customer();
        }
    }

    private static void viewProducts() {
        // TODO: Implement logic to display products to the customer
        System.out.println("Displaying products...");
    }

    private static void writeProductReview() {
        System.out.println("Enter the product name you want to review:");
        String productName = scanner.nextLine();

        System.out.println("Write your review:");
        String review = scanner.nextLine();

        // TODO: Implement logic to submit the review
        System.out.println("Thank you for your review!");
    }
}