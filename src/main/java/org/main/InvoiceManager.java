package org.main;

import java.util.ArrayList;
import java.util.List;

public
class InvoiceManager {
    private final List < Invoice > invoiceList = new ArrayList <> ( );

    public
    void  createInvoice ( Invoice invoice ) {
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
