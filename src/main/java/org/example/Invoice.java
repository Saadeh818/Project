package org.example;

import java.util.ArrayList;
import java.util.List;
class Invoice {
    private              String invoiceNumber;
    private              String customerName;
    private              String totalAmount;
    private              String dueDate;


    // Getters and setters


    public
    void setInvoiceNumber ( String invoiceNumber ) {
        this.invoiceNumber = invoiceNumber;
    }


    public
    void setCustomerName ( String customerName ) {
        this.customerName = customerName;
    }
    public
    void setTotalAmount ( String totalAmount ) {
        this.totalAmount = totalAmount;
    }

    public
    void setDueDate ( String dueDate ) {
        this.dueDate = dueDate;
    }

    public
    void setCustomerEmail ( String mail ) {
    }
}

class InvoiceManager {
    private final List < Invoice > invoiceList = new ArrayList <> ( );

    public
    void createInvoice ( Invoice invoice ) {
        invoiceList.add ( invoice );
    }

    public
    void deleteInvoice ( Invoice invoice ) {
        invoiceList.remove ( invoice );
    }

    public
    boolean invoiceExists ( Invoice invoice ) {
        return invoiceList.contains ( invoice );
    }

    public
    void sendInvoice ( Invoice currentInvoice ) {
    }

    // Additional methods for managing invoices

    // ...
}

class CustomerInvoice {
    public static
    void main ( String[] args ) {
        CustomerInvoice customerInvoice = new CustomerInvoice ( );
        performInvoiceActions ( "Create New Invoice" );
        performInvoiceActions ( "Delete Invoice" );
        // Perform other actions as needed
    }

    public static
    void performInvoiceActions ( String createNewInvoice ) {
    }
}