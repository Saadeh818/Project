package org.example.AcceptanceTest;

import java.util.ArrayList;
import java.util.List;

public class ProductC {
    private static int nextProductId = 1;
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
    public List<ProductC> productList;

    public ProductC() {
        productList = new ArrayList<>();
        productList.add(new ProductC("cat1", "product1", 18, 100));
        productList.add(new ProductC("cat1", "product2", 85, 150));
        productList.add(new ProductC("cat2", "product3", 44, 480));
        productList.add(new ProductC("cat3", "product4", 48, 940));
        productList.add(new ProductC("cat1", "product5", 10, 613));
        productList.add(new ProductC("cat3", "product6", 88, 984));
        productList.add(new ProductC("cat2", "product7", 91, 513));
        productList.add(new ProductC("cat1", "product8", 77, 560));
        productList.add(new ProductC("cat2", "product9", 24, 613));
    }

    public ProductC(String category, String name, int quantity, int price) {
        this.productId = nextProductId++;
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
            if(product.category.equals("cat2")) {
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

    public void addProduct(String categoryI, String nameI, String quantityI, String priceI) {
        try {
            if (!(categoryI.equals("cat1") || categoryI.equals("cat2") || categoryI.equals("cat3")) || (nameI.length() < 4))
                productAddSuccessfully = false;
            else{
                category=categoryI;
                name=nameI;
                quantity = Integer.parseInt(quantityI);
                price=Integer.parseInt(priceI);
                ProductC product = new ProductC(category, name, quantity, price);
                productList.add(product);
                productAddSuccessfully=true;

            }
        }
        catch (Exception ignored){
            productAddSuccessfully=false;
        }
    }
}
