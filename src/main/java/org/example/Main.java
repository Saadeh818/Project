package org.example;

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
                    break;
                case "signUp-page":
                    break;
                default:
                    break;
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
        while ( true ){
            switch (scanner.nextLine ()){
                case "1":
                    adminProductManager ( username, password );
                    break;
                case "2":
                    userManager(username,password);
                    break;
                case "3":
                    return;
                default:
                    System.out.println ( "Wrong Input Please Try To Choose Write" );
            }
        }
    }

    private static
    void userManager ( String username , String password ) {
    }

    private static
    void adminProductManager ( String username, String password ) {


        ProductC.productList();
        System.out.print ( "*********************************************\n" +
                                   "Here You Can Manage All Products\n" +
                                   "1. Add a Product.\n" +
                                   "2. Delete a Product.\n" +
                                   "3.Update a Product.\n" +
                                   "4.Return to dashboard.\n" +
                                   "5.Sign Out.\n" );
        switch (scanner.nextLine ()){
            case "1":
                System.out.print ("Enter The Category: ");
                String categoryI = scanner.nextLine ();
                System.out.print ("Enter The Product Name: ");
                String nameI =scanner.nextLine ();
                System.out.print ("Enter The Product Quantity: ");
                String quantityI=scanner.nextLine ();
                System.out.print ("Enter The Product Price: ");
                String priceI=scanner.nextLine ();
                ProductC productC = new ProductC (  );
                productC.addProduct ( categoryI,nameI,quantityI,priceI );
                adminProductManager ( username, password );
                break;
            case "2":
                //TODO: Delete Product

                break;
            case "3":
                //TODO: Update Product
                break;
            case "4":
                //TODO: Return to dashboard
                break;
            case "5":
                //TODO: Sign Out
                break;
        }
    }

}
