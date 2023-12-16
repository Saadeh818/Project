package org.example.AcceptanceTest;
public class AccountDeletion {
    private boolean isAdmin;

    public AccountDeletion(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String deleteAccount(String password) {
        if (isAdmin) {
            // Simulate admin deletion logic
            if ("adminPass".equals(password)) {
                return "Account deleted successfully";
            } else {
                return "Wrong password. Account deletion failed.";
            }
        } else {
            // Simulate user deletion logic
            if ("correctPass".equals(password)) {
                return "Account deleted successfully";
            } else {
                return "Wrong password. Account deletion failed.";
            }
        }
    }
}
