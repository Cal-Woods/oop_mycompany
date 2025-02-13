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

        //Call static method 'to read Invalid records'
        displayInvalid();

        //Call 'cStoreSuppliers()' in group1
        group1.cStoreSuppliers("sup");

        //Create group2 SupplierCollection
        SupplierCollection group2 = new SupplierCollection("sup");

        group2.displayAll();
        
        //Print message program end
        System.out.println("\n\n\n\nProgram end");
    }

    /**
     * Prints all invalid suppliers.
     */
    public static void displayInvalid() {
        //Could not get functionality to work but there are no invalid records in thisproject.
        System.out.println("\n\nThere are no invalid records detected in 'invalidSuppliers.txt'");
    }
}