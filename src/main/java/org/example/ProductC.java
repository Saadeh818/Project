package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProductC {
    private static int nextProductId = 0;
    public int productId;
    public static boolean readyToDelete;
    public static boolean readyToUpdate;
    public static boolean wrongInputFlag;
    public String category;
    public String name;
    public int quantity;
    public int price;
    public boolean productAddSuccessfully;
    public static boolean readyToAdd=false;
    public static final List<ProductC> productList=new ArrayList<>();
    public static boolean listProductFlag=false;
    public static boolean productDeletedSuccessfully=true;

    static {
        productList.add(new ProductC(0, "cat1", "product1", 18, 100));
        productList.add(new ProductC(1, "cat1", "product2", 85, 150));
        productList.add(new ProductC(2, "cat2", "product3", 44, 480));
        productList.add(new ProductC(3, "cat3", "product4", 48, 940));
        productList.add(new ProductC(4, "cat1", "product5", 10, 613));
        productList.add(new ProductC(5, "cat3", "product6", 88, 984));
        productList.add(new ProductC(6, "cat2", "product7", 91, 513));
        productList.add(new ProductC(7, "cat1", "product8", 77, 560));
        productList.add(new ProductC(8, "cat2", "product9", 24, 613));
    }

    public boolean updateProductSuccess;

    public ProductC() {
    }

    public ProductC(int ID,String category, String name, int quantity, int price) {
        this.productId = ID;
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public static void productManager(String userInput) {
        switch (userInput){
            case "1":
                readyToAdd=true;
                readyToUpdate=false;
                readyToDelete=false;
                Admin.adminDashboardFlag=false;
                wrongInputFlag=false;
                break;
            case "2":
                readyToAdd=false;
                readyToUpdate=false;
                readyToDelete=true;
                Admin.adminDashboardFlag=false;
                wrongInputFlag=false;
                break;
            case "3":
                readyToAdd=false;
                readyToUpdate=true;
                readyToDelete=false;
                Admin.adminDashboardFlag=false;
                wrongInputFlag=false;
                break;
            case "4":
                readyToAdd=false;
                readyToUpdate=false;
                readyToDelete=false;
                Admin.adminDashboardFlag=true;
                wrongInputFlag=false;
                break;
            default:
                readyToAdd=false;
                readyToUpdate=false;
                readyToDelete=false;
                Admin.adminDashboardFlag=false;
                wrongInputFlag=true;
        }
    }



    public void productList() {
        System.out.println("********** Cat1 *********");
        for (ProductC product : productList) {
            if(product.category.equals("cat1")) {
                productPrint(product);
            }
        }
        System.out.println("********** Cat2 *********");
        for (ProductC product : productList) {
            if(product.category.equals("cat2")) {
                productPrint(product);
            }
        }
        System.out.println("********** Cat3 *********");
        for (ProductC product : productList) {
            if(product.category.equals("cat3")) {
                productPrint(product);
            }
        }
    }

    private void productPrint(ProductC product) {
        System.out.println("Product ID: " + product.productId);
        System.out.println("Product Category: " + product.category);
        System.out.println("Product Name: " + product.name);
        System.out.println("Product Quantity: " + product.quantity);
        System.out.println("Product Price: " + product.price);
        System.out.println();
    }

    public static
    void displatProduct ( ProductC product ){
        System.out.print(product.productId);
        System.out.print(", " + product.category);
        System.out.print(", " + product.name);
        System.out.print(", " + product.quantity);
        System.out.println(", " + product.price);
        System.out.println();
    }

    public void addProduct(String categoryI, String nameI, String quantityI, String priceI) {
        try {

            if (!(categoryI.equals("cat1") || categoryI.equals("cat2") || categoryI.equals("cat3")) || (nameI.length() < 4))
                productAddSuccessfully = false;
            else{
                category=categoryI;
                name=nameI;
                quantity = Integer.parseInt(quantityI);
                price=Integer.parseInt(priceI);
                ProductC product = new ProductC(productList.size()+1,category, name, quantity, price);
                productList.add(product);
                productAddSuccessfully=true;

            }
        }
        catch (Exception ignored){
            productAddSuccessfully=false;
        }
    }

    public void setCategory(String categoryI) {
        if (!(categoryI.equals("cat1") || categoryI.equals("cat2") || categoryI.equals("cat3"))) {
            wrongInputFlag = true;
            productDeletedSuccessfully = false;
        }
        else
            this.category=categoryI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void selectIdToDelete(String ID, String category) {
        if(checkIfProductExists(Integer.parseInt(ID))) {
            productList.removeIf(product -> product.category.equals(category) && product.productId == Integer.parseInt(ID));
            productDeletedSuccessfully = !checkIfProductExists(Integer.parseInt(ID));
            System.out.println("The Product has been deleted successfully");
        }
        else {
            productDeletedSuccessfully=false;
        }
    }


    private boolean checkIfProductExists(int ID) {
        for (ProductC product : productList){
            if (product.productId==ID){
                JOptionPane.showMessageDialog(null,"checkIfProductExists","hello",JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,"checkIfProductExists2","hello",JOptionPane.ERROR_MESSAGE);

        return false;
    }

    public void update() {

    }

    public void updateValues(int ID,String category, String name, String quantity, String price) {
        for (ProductC product : productList){
            if (product.productId == ID) {
                productPrint(product);
                product.setCategory(category);
                product.setName(name);
                product.setQuantity(Integer.parseInt(quantity));
                product.setPrice(Integer.parseInt(price));
                updateProductSuccess=true;
                System.out.println("**********Product Updated Success**********");
                productPrint(product);

                return;
            }
            else {
                updateProductSuccess=false;
            }
        }


    }
}
