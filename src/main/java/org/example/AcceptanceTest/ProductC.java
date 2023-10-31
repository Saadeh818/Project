package org.example.AcceptanceTest;

public class ProductC {
    public static boolean readyToDelete;
    public static boolean readyToUpdate;
    public static boolean wrongInputFlag;
    public String category;
    public String name;
    public int quantity;
    public int price;
    public boolean productAddSuccessfully;
    public static boolean readyToAdd=false;

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
                productAddSuccessfully=true;
            }


        }
        catch (Exception ignored){
            productAddSuccessfully=false;
        }
    }
}
