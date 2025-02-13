package OrderManagementSystem.Version3;

import OrderManagementSystem.Classes.Supplier;
import OrderManagementSystem.Classes.SupplierCollection;

public class Version3App {
    public static void main(String[] args) {
        //Print message
        System.out.println("Creating group1 SupplierCollection object with default constructor.\n\n");
        SupplierCollection group1 = new SupplierCollection();

        //Calling 'add()' from SupplierCollection 'group1'
        //group1.add("suppliers.txt");
        group1.add("suppliers.txt");
        //Print suppliers
        group1.displayAll();
    }
}