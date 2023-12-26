package org.main;
public
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