package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public
class ProductC {

    protected static  List < ProductC > productList= new ArrayList <> ( );
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

    public
    String getCategory ( ) {
        return category;
    }

    public
    String getName ( ) {
        return name;
    }

    public
    int getPrice ( ) {
        return this.price;
    }

    public static
    boolean isProductAddSuccessfully ( ) {
        return productAddSuccessfully;
    }

    private String  category;
    private String  name;
    private int     quantity;
    private int     price;
    private static boolean productAddSuccessfully;
    public         boolean updateProductSuccess;

    public
    ProductC ( ) {
        //To Hide The Private Constructor
    }

    public
    ProductC ( int id , String categoryIn , String nameIn , int quantityIn , int priceIn ) {
        this.productId = id;
        this.category  = categoryIn;
        this.name      = nameIn;
        this.quantity  = quantityIn;
        this.price     = priceIn;
    }

    public static
    void productManager ( String userInput ) {
        switch (userInput) {
            case "1":
                readyToAdd = true;
                readyToUpdate = false;
                readyToDelete = false;
                Admin.setAdminDashboardFlag ( false );
                wrongInputFlag = false;
                break;
            case "2":
                readyToAdd = false;
                readyToUpdate = false;
                readyToDelete = true;
                Admin.setAdminDashboardFlag ( false );
                wrongInputFlag = false;
                break;
            case "3":
                readyToAdd = false;
                readyToUpdate = true;
                readyToDelete = false;
                Admin.setAdminDashboardFlag ( false );
                wrongInputFlag = false;
                break;
            case "4":
                readyToAdd = false;
                readyToUpdate = false;
                readyToDelete = false;
                Admin.setAdminDashboardFlag ( true );
                wrongInputFlag = false;
                break;
            default:
                readyToAdd = false;
                readyToUpdate = false;
                readyToDelete = false;
                Admin.setAdminDashboardFlag ( false );
                wrongInputFlag = true;
        }
    }


    public static
    void displayProductsByCategory ( ) {
       LOGGER.info ( "********** Cat1 *********" );
        for ( ProductC product : productList ) {
            if ( product.category.equals ( "cat1" ) ) {
                productPrint ( product );
            }
        }
        LOGGER.info ( "********** Cat2 *********" );
        for ( ProductC product : productList ) {
            if ( product.category.equals ( "cat2" ) ) {
                productPrint ( product );
            }
        }
        LOGGER.info ( "********** Cat3 *********" );
        for ( ProductC product : productList ) {
            if ( product.category.equals ( "cat3" ) ) {
                productPrint ( product );
            }
        }
    }

    private static
    void productPrint ( ProductC product ) {
        String msg = ("Product ID: " + product.productId +
                "\nProduct Category: " + product.category +
                "\nProduct Name: " + product.name+
                "\nProduct Quantity: " + product.quantity +
                "\nProduct Price: " + product.price + "\n");
        LOGGER.info ( msg );
    }

    public static
    void addProduct ( String categoryI , String nameI , String quantityI , String priceI ) {
        try {

            if ( ! (categoryI.equals ( "cat1" ) || categoryI.equals ( "cat2" ) || categoryI.equals ( "cat3" )) || (nameI.length ( ) < 4) )
                productAddSuccessfully = false;
            else {
                ProductC product = new ProductC ( productList.size ( ) + 1 , categoryI , nameI , Integer.parseInt ( quantityI ) , Integer.parseInt ( priceI ) );
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

    public
    void setCategory ( String categoryI ) {
        if ( ! (categoryI.equals ( "cat1" ) || categoryI.equals ( "cat2" ) || categoryI.equals ( "cat3" )) ) {
            wrongInputFlag             = true;
            productDeletedSuccessfully = false;
        }
        else
            this.category = categoryI;
    }

    public static
    void selectIdToDelete ( String id , String categoryIn ) {
        try {
            int idInt = Integer.parseInt ( id );
            if ( checkIfProductExists ( idInt ) ) {
                productList.removeIf ( product -> product.category.equals ( categoryIn ) && product.productId == idInt );
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
                return true;
            }
        }
        return false;
    }


    public
    void updateValues ( int id , String category , String name , String quantity , String price ) {
        LOGGER.info ( "If You Dont Want To Change A Filed Just Insert A # On It." );
        for ( ProductC product : productList ) {
            if ( product.productId == id ) {
                productPrint ( product );
                if ( category.equals ( "#" ) ) category = product.category;
                if ( name.equals ( "#" ) ) name = product.name;
                if ( quantity.equals ( "#" ) ) quantity =String.valueOf ( product.quantity);
                if ( price.equals ( "#" ) ) price =String.valueOf ( product.price);
                selectIdToDelete ( String.valueOf ( id ) , product.getCategory ( ) );
                productList.add ( new ProductC ( id , category , name , Integer.parseInt ( quantity) , Integer.parseInt ( price) ) );
                updateProductSuccess = true;
                LOGGER.info ( "**********Product Updated Successfully**********" );
                productPrint ( product );
                return;
            }
            updateProductSuccess = false;
        }
    }


    }
