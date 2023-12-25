package org.example;

import java.awt.image.LookupOp;
import java.util.Scanner;
import java.util.logging.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public
class Main {
    static                   Scanner        scanner        = new Scanner ( System.in );
    static                   InvoiceManager invoiceManager = new InvoiceManager ( );  // Assuming you have an InvoiceManager instance
    static                   Invoice        currentInvoice;
    private static final Logger         LOGGER         = Logger.getLogger ( Customer.class.getName ( ) );


    public static
    void main ( String[] args ) {
        while ( true ) {
            MainScreen.displayPage ( "home-page" );
            MainScreen.userInput = scanner.nextLine ( );
            if ( MainScreen.userInput.equals ( "5" ) ) break;
            MainScreen.nextScreen ( MainScreen.userInput );
            switch (MainScreen.currentPage) {
                case "admin-login":
                    adminActions ( );
                    break;
                case "customer-login":
                    customerAction();
                    break;

                case "installer-login":
                    installerActions ( );
                    break;
                case "signUp-page":
                    LOGGER.info ( "Choose type 1 for installer 2 for customer" );
                    String type = scanner.nextLine ( );
                    LOGGER.info ( "Enter Your Email: " );
                    String email = scanner.nextLine ( );
                    LOGGER.info ( "Enter Your Password: " );
                    Users.adduser ( type , email , scanner.nextLine ( ) );
                    break;
                default:
                    break;
            }
        }
    }

    private static
    void installerActions ( ) {
       LOGGER.info ( "Welcome Installer Please fill your data to login\n"
                                   + "Enter your name please: " );
        Installer.clearCredentials ( );
        String username = scanner.nextLine ( );
        LOGGER.info ( "\nEnter Password please: " );
        String password = scanner.nextLine ( );

        Installer.login ( username , password );
        installerDashboard ( username , password );

    }

    private static
    void installerDashboard ( String username , String password ) {
        String userInput = scanner.nextLine ( );
        Installer.dashboardManager ( userInput );
        if ( userInput.equals ( "1" ) ) {
            LOGGER.info ( "Choose ID To Schedule An Appointment Or Enter # To return To dashboard " );
            userInput = scanner.nextLine ( );
            if ( userInput.equals ( "#" ) )
                installerDashboard ( username , password );
            else

                Installer.setInstallationRequestId ( userInput );
            if ( Installer.requestFound ) {
                LOGGER.info ( "Enter The Date to Schedule An Appointment : \" Date Format is day/month/year\" " );
                Customer.addAppointment ( scanner.nextLine ( ) , Installer.requestID , Installer.userRequested );
                installerDashboard ( username , password );
            }

        }
    }


    private static
    void adminActions ( ) {
       LOGGER.info ( "Welcome Admin Please fill your data to login\n"
                                   + "Enter your name please: " );
        Admin.clearCredentials ( );
        String username = scanner.nextLine ( );
        LOGGER.info ( "\nEnter Password please: " );
        String password = scanner.nextLine ( );

        Admin.setUsername ( username );
        Admin.setPassword ( password );

        Admin.login ( );
        adminDashboard ( username , password );
    }
    private static
    void customerAction ( ) {
        LOGGER.info ( "Welcome Admin Please fill your data to login\n"
                + "Enter your name please: " );
        Customer.clearCredentials ( );
        String username = scanner.nextLine ( );
        LOGGER.info ( "\nEnter Password please: " );
        String password = scanner.nextLine ( );

        Customer.setUsername ( username );
        Customer.setPassword ( password );

        Customer.login ( username, password);
        if(!Customer.loginFlag)
        {
         LOGGER.info("USERNAME OR PASSWORD IS WRONG");
         customerAction();
        }
        else
        {
            customerDachdoard();
        }
    }
    private static
    void adminDashboard ( String username , String password ) {
        switch (scanner.nextLine ( )) {
            case "1":
                productManager ( username , password );
                return;
            case "2":
                userManager ( username , password );
                return;
            case "3":
                return;
            default:
                LOGGER.info ( "Wrong Input Please Try To Choose Write" );
                adminActions ( );
        }
    }

    private static
    void userManager ( String username , String password ) {
        Users.userManagementScreen ( );
        String userInput = scanner.nextLine ( );
        Users.selectUserToMenage ( userInput );
        switch (userInput) {
            case "1":
            case "2":
                LOGGER.info ( "Enter Installer ID To Modify: " );
                Users.userToModifyID ( scanner.nextLine ( ) );
                Users.loadModifyAccountOptions ( );
                switch (scanner.nextLine ( )) {
                    case "1":
                        LOGGER.info ( "Enter new password: " );
                        if ( Users.installerSelected ) Installer.changePassword ( Users.userToModifyID , scanner.nextLine ( ) );
                        else if ( Users.customerSelected ) Customer.changePassword ( Users.userToModifyID , scanner.nextLine ( ) );
                        break;
                    case "2":
                        LOGGER.info ( "Enter new UserName: " );
                        if ( Users.installerSelected ) Installer.changeUserName ( Users.userToModifyID , scanner.nextLine ( ) );
                        else if ( Users.customerSelected ) Customer.changeUserName ( Users.userToModifyID , scanner.nextLine ( ) );
                        break;
                    case "3":
                        if ( Users.installerSelected ) Installer.deleteInstallerAccount ( Users.userToModifyID );
                        else if ( Users.customerSelected ) Customer.deleteCustomerAccount ( Users.userToModifyID );
                        break;
                    case "5":
                        return;
                    default:
                        userManager ( username , password );
                        break;
                }
                break;
            case "3":
                 LOGGER.info ( """
                                       Choose User Type To Add:
                                       1. Installer
                                       2. Customer\s""");
                String NewUserType = scanner.nextLine ( );
                LOGGER.info ( "Enter User Name: " );
                String NewUserName = scanner.nextLine ( );
               LOGGER.info ( "Enter Password: " );
                String newUserPassword = scanner.nextLine ( );
                Users.adduser ( NewUserType , NewUserName , newUserPassword );
                userManager ( username , password );
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
    void productManager ( String username , String password ) {
        ProductC productC = new ProductC ( );
        LOGGER.info ( """
                              *********************************************
                              Here You Can Manage All Products
                              1. Add a Product.
                              2. Delete a Product.
                              3.Update a Product.
                              4.Return to dashboard.
                              5.Sign Out.
                              """ );
        switch (scanner.nextLine ( )) {
            case "1":
                ProductC.productList ( );
                LOGGER.info ( "Enter The Category: " );
                String categoryI = scanner.nextLine ( );
                LOGGER.info ( "Enter The Product Name: " );
                String nameI = scanner.nextLine ( );
                LOGGER.info ( "Enter The Product Quantity: " );
                String quantityI = scanner.nextLine ( );
                LOGGER.info ( "Enter The Product Price: " );
                String priceI = scanner.nextLine ( );
                productC.addProduct ( categoryI , nameI , quantityI , priceI );
                productManager ( username , password );
                break;
            case "2":
                ProductC.productList ( );
                LOGGER.info ( """
                                      1. Cat1.
                                      2. Cat2.
                                      3. Cat3.
                                      Press Any Key To Return.""" );
                switchStatement ( username , password , productC );
                LOGGER.info ( "Enter The ID Of The Product" );
                productC.selectIdToDelete ( scanner.nextLine ( ) , productC.category );
                LOGGER.info ( "Product Deleted Successfully.................. " );
                productManager ( username , password );
                break;
            case "3":
                ProductC.productList ( );
                LOGGER.info ( """
                                      1. Cat1.
                                      2. Cat2.
                                      3. Cat3.
                                      Press Any Key To Return.""" );
                switchStatement ( username , password , productC );
                LOGGER.info ( "Any Field that you dont want to change just insert #..." );
                LOGGER.info ( "Enter The ID Of The Product" );
                productC.productId = Integer.parseInt ( scanner.nextLine ( ) );
                LOGGER.info ( "Enter new Category (cat1,cat2,cat3): " );
                String category = scanner.nextLine ( );
                LOGGER.info ( "Enter new Name : " );
                String name = scanner.nextLine ( );
                LOGGER.info ( "Enter new Quantity : " );
                String quantity = scanner.nextLine ( );
                LOGGER.info ( "Enter new Price : " );
                String price = scanner.nextLine ( );
                productC.updateValues ( productC.productId , category , name , quantity , price );
                break;
            case "4":
                productManager ( username , password );
                break;
            case "5":
                break;
        }
    }

    private static
    void switchStatement ( String username , String password , ProductC productC ) {
        switch (scanner.nextLine ( )) {
            case "1":
                productC.setCategory ( "cat1" );
                break;
            case "2":
                productC.setCategory ( "cat2" );
                break;
            case "3":
                productC.setCategory ( "cat3" );
                break;
            default:
                productManager ( username , password );
                break;
        }
    }

    private static
    void customerDachdoard ( ) {
        LOGGER.info ( "Welcome Customer! Please choose an option:" );
        LOGGER.info ( "1. View Products" );
        LOGGER.info ( "2. Write a Product Review" );
        LOGGER.info ( "3. Return to Dashboard" );

        String userInput = scanner.nextLine ( );

        switch (userInput) {
            case "1":
                ProductC.productList ( );
                break;
            case "2":
                writeProductReview ( );
                break;
            case "3":
                return;
            default:
                LOGGER.info ( "Invalid input. Please try again." );
                customerDachdoard ( );
        }
    }

    private static
    void viewProducts ( ) {
        // TODO: Implement logic to display products to the customer
        LOGGER.info ( "Displaying products..." );
    }

    private static
    void writeProductReview ( ) {
        LOGGER.info ( "Enter the product name you want to review:" );
        String productName = scanner.nextLine ( );

        LOGGER.info ( "Write your review:" );
        String review = scanner.nextLine ( );

        // TODO: Implement logic to submit the review
        LOGGER.info ( "Thank you for your review!" );
    }

    private static
    void sendInvoice ( ) {
        enterCustomerEmailAddress ( );
        invoiceManager.sendInvoice ( currentInvoice );
    }

    private static
    void enterCustomerEmailAddress ( ) {
        currentInvoice.setCustomerEmail ( "dena123@email.com" );
    }

    public
    void performInvoiceActions ( String action ) {
        switch (action) {
            case "Create New Invoice":
                createNewInvoice ( );
                break;
            case "Delete Invoice":
                deleteInvoice ( );
                break;
            case "Edit Invoice":
                editInvoice ( );
                break;
            case "View Invoice":
                viewInvoice ( );
                break;
            case "Send Invoice":
                sendInvoice ( );
                break;
            default:
                LOGGER.info ( "Invalid action: " + action );
        }
    }

    private
    void viewInvoice ( ) {
    }

    private
    void editInvoice ( ) {
    }

    private
    void createNewInvoice ( ) {
        currentInvoice = new Invoice ( );
        enterNecessaryDetailsForNewInvoice ( );
        invoiceManager.createInvoice ( currentInvoice );
        verifyNewInvoiceIsAddedToList ( );
    }

    private
    void verifyNewInvoiceIsAddedToList ( ) {
    }

    private
    void enterNecessaryDetailsForNewInvoice ( ) {
        currentInvoice.setInvoiceNumber ( "001" );
        currentInvoice.setCustomerName ( "dena" );
        currentInvoice.setTotalAmount ( "$500" );
        currentInvoice.setDueDate ( "2023-02-15" );
    }


    // Other methods...

    private
    void deleteInvoice ( ) {
        enterNecessaryDetailsForNewInvoice ( ); // Assuming you need details for deletion
        invoiceManager.deleteInvoice ( currentInvoice );
        verifySelectedInvoiceIsDeleted ( );
    }

    private
    void verifySelectedInvoiceIsDeleted ( ) {
    }

    private
    void logoutUser ( ) {
        currentInvoice = null;
        LOGGER.info ( "Logged out..." );
        LOGGER.info ( "Thanks for using iCar." );
    }


}