package org.example.AcceptanceTest;

public class Admin extends MainScreen{
    public static void displayPage(String currentPage){
        if (currentPage.equals("home-page"))
            System.out.print("Welcome To Car Accessories Company \n" +
                    "Choose To login by your type or signUp\n" +
                    "1. Admin Login\n" +
                    "2. Customer Login\n" +
                    "3. Installer Login\n" +
                    "4. SignUp\n" +
                    "5. press any key to continue\n"
            );
    }
}
