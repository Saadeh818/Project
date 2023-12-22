package org.example;
import java.util.ArrayList;
import java.util.List;

class Invoice {
    private String invoiceNumber;
    private String customerName;
    private String totalAmount;
    private String dueDate;

    // Getters and setters

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setCustomerEmail(String mail) {
    }
}

class InvoiceManager {
    private List<Invoice> invoiceList = new ArrayList<>();

    public void createInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }

    public void deleteInvoice(Invoice invoice) {
        invoiceList.remove(invoice);
    }

    public boolean invoiceExists(Invoice invoice) {
        return invoiceList.contains(invoice);
    }

    public void sendInvoice(Invoice currentInvoice) {
    }

    // Additional methods for managing invoices

    // ...
}

 class CustomerInvoice {
    public static void main(String[] args) {
        // You can now use the InvoiceManager and Invoice classes in your testing scenarios
    }

     public static void performInvoiceActions(String createNewInvoice) {
     }
 }