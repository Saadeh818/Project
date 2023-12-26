package org.main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public
class ProductC {

    protected static final  List < ProductC > productList= new ArrayList <> ( );
    public static        boolean           readyToDelete;
    public static        boolean           readyToUpdate;
    public static        boolean           wrongInputFlag;
    public static        boolean           readyToAdd                 = false;
    public static        boolean           listProductFlag            = false;
    public static        boolean           productDeletedSuccessfully = true;
    private static final Logger            LOGGER                     = Logger.getLogger ( ProductC.class.getName ( ) );


    static {
        productList.add ( new ProductC ( 0 , "cat1" , "product1" , 18 , 100 ) );
        productList.add ( new ProductC ( 1 , "cat1" , "product2" , 85 , 150 ) );
        productList.add ( new ProductC ( 2 , "cat2" , "product3" , 44 , 480 ) );
        productList.add ( new ProductC ( 3 , "cat3" , "product4" , 48 , 940 ) );
        productList.add ( new ProductC ( 4 , "cat1" , "product5" , 10 , 613 ) );
        productList.add ( new ProductC ( 5 , "cat3" , "product6" , 88 , 984 ) );
        productList.add ( new ProductC ( 6 , "cat2" , "product7" , 91 , 513 ) );
        productList.add ( new ProductC ( 7 , "cat1" , "product8" , 77 , 560 ) );
        productList.add ( new ProductC ( 8 , "cat2" , "product9" , 24 , 613 ) );
    }

    public        int    productId;
    public static String category;
    public static String name;
    public static int     quantity;
    public static int     price;
    public static boolean productAddSuccessfully;
    public        boolean updateProductSuccess;

    public
    ProductC ( ) {
    }

    public
    ProductC ( int id , String categoryIn , String nameIn , int quantityIn , int priceIn ) {
        this.productId = id;
        category  = categoryIn;
        name      = nameIn;
        quantity  = quantityIn;
        price     = priceIn;
    }

    public static
    void productManager ( String userInput ) {
        switch (userInput) {
            case "1":
                readyToAdd = true;
                readyToUpdate = false;
                readyToDelete = false;
                Admin.adminDashboardFlag = false;
                wrongInputFlag = false;
                break;
            case "2":
                readyToAdd = false;
                readyToUpdate = false;
                readyToDelete = true;
                Admin.adminDashboardFlag = false;
                wrongInputFlag = false;
                break;
            case "3":
                readyToAdd = false;
                readyToUpdate = true;
                readyToDelete = false;
                Admin.adminDashboardFlag = false;
                wrongInputFlag = false;
                break;
            case "4":
                readyToAdd = false;
                readyToUpdate = false;
                readyToDelete = false;
                Admin.adminDashboardFlag = true;
                wrongInputFlag = false;
                break;
            default:
                readyToAdd = false;
                readyToUpdate = false;
                readyToDelete = false;
                Admin.adminDashboardFlag = false;
                wrongInputFlag = true;
        }
    }


    public static
    void displayProductsByCategory ( ) {
       LOGGER.info ( "********** Cat1 *********" );
        for ( ProductC product : productList ) {
            if ( category.equals ( "cat1" ) ) {
                productPrint ( product );
            }
        }
        LOGGER.info ( "********** Cat2 *********" );
        for ( ProductC product : productList ) {
            if ( category.equals ( "cat2" ) ) {
                productPrint ( product );
            }
        }
        LOGGER.info ( "********** Cat3 *********" );
        for ( ProductC product : productList ) {
            if ( category.equals ( "cat3" ) ) {
                productPrint ( product );
            }
        }
    }

    private static
    void productPrint ( ProductC product ) {
        String msg = ("Product ID: " + product.productId +
                "\nProduct Category: " + category +
                "\nProduct Name: " + name+
                "\nProduct Quantity: " + quantity +
                "\nProduct Price: " + price + "\n");
        LOGGER.info ( msg );
    }

    public static
    void addProduct ( String categoryI , String nameI , String quantityI , String priceI ) {
        try {

            if ( ! (categoryI.equals ( "cat1" ) || categoryI.equals ( "cat2" ) || categoryI.equals ( "cat3" )) || (nameI.length ( ) < 4) )
                productAddSuccessfully = false;
            else {
                category = categoryI;
                name     = nameI;
                quantity = Integer.parseInt ( quantityI );
                price    = Integer.parseInt ( priceI );
                ProductC product = new ProductC ( productList.size ( ) + 1 , category , name , quantity , price );
                productList.add ( product );
                productAddSuccessfully = true;
                LOGGER.info ( "Product Added Successfully..." );
            }
        }
        catch ( Exception ignored ) {
            productAddSuccessfully = false;
            LOGGER.info ( "\nProduct cannot be added" );
        }
    }

    public static
    void setCategory ( String categoryI ) {
        if ( ! (categoryI.equals ( "cat1" ) || categoryI.equals ( "cat2" ) || categoryI.equals ( "cat3" )) ) {
            wrongInputFlag             = true;
            productDeletedSuccessfully = false;
        }
        else
            category = categoryI;
    }

    public
    void setName ( String nameIn ) {
        name = nameIn;
    }

    public
    void setQuantity ( int quantityIn ) {
        quantity = quantityIn;
    }

    public
    void setPrice ( int priceIn ) {
        price = priceIn;
    }

    public static
    void selectIdToDelete ( String id , String categoryIn ) {
        try {
            int idInt = Integer.parseInt ( id );
            if ( checkIfProductExists ( idInt ) ) {
                productList.removeIf ( product -> category.equals ( categoryIn ) && product.productId == idInt );
                productDeletedSuccessfully = !checkIfProductExists ( idInt );
                LOGGER.info ( "The Product has been deleted successfully" );
            }
            else {
                LOGGER.info ( "The Product You Are Trying To Delete Is No Longer Available" );
                productDeletedSuccessfully = false;
            }
        }
        catch ( NumberFormatException e ) {
            Users.printException ( e.getMessage () );
        }
    }


    public static
    boolean checkIfProductExists ( int id ) {
        for ( ProductC product : productList ) {
            if ( product.productId == id ) {
                JOptionPane.showMessageDialog ( null , "checkIfProductExists" , "hello" , JOptionPane.ERROR_MESSAGE );
                return true;
            }
        }
        JOptionPane.showMessageDialog ( null , "checkIfProductExists2" , "hello" , JOptionPane.ERROR_MESSAGE );

        return false;
    }


    public
    void updateValues ( int id , String category , String name , String quantity , String price ) {
        LOGGER.info ( "If You Dont Want To Change A Filed Just Insert A # On It." );
        for ( ProductC product : productList ) {
            if ( product.productId == id ) {
                productPrint ( product );
                if ( ! category.equals ( "#" ) ) setCategory ( category );
                if ( ! name.equals ( "#" ) ) product.setName ( name );
                if ( ! quantity.equals ( "#" ) ) product.setQuantity ( Integer.parseInt ( quantity ) );
                if ( ! price.equals ( "#" ) ) product.setPrice ( Integer.parseInt ( price ) );
                updateProductSuccess = true;
                LOGGER.info ( "**********Product Updated Successfully**********" );
                productPrint ( product );
                return;
            }
                updateProductSuccess = false;
        }


    }
}
