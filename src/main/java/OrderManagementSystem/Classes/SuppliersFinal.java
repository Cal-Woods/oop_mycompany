package OrderManagementSystem.Classes;

import java.util.ArrayList;
import java.util.TreeSet;

public class SuppliersFinal {
    private TreeSet<Supplier> sup;

    //Constructors
    /**
     * Initialises blank SuppliersFinal object.
     */
    public SuppliersFinal() {
        sup = new TreeSet<Supplier>((s1, s2) -> {return s1.hashCode() == s2.hashCode() ? 1 : -1;});
    }

    /**
     * Adds a Supplier object to instance.
     * 
     * @param supplier Given Suplier object
     * 
     * @return True if Supplier is added successfully, false otherwise.
     */
    public boolean add(Supplier supplier) {
        //Validation
        if(supplier == null) throw new IllegalArgumentException("Given supplier was null. This is NOT a valid argument.");

        return this.sup.add(supplier);
    }

    /**
     * Prints all Supplier objects in instance.
     * 
     * @return True if printing successful, false otherwise.
     */
    public boolean displayAllName() {
        //Validation
        if(this.sup.isEmpty()) return false;

        ArrayList<Supplier> temp = new ArrayList<Supplier>(this.sup);

        temp.sort((s1, s2) -> {return 1 * s1.getName().compareToIgnoreCase(s2.getName());});

        temp.forEach((supplier) -> {System.out.println(supplier+"\n");});

        return true;
    }

    /**
     * Removes a given Supplier object from SuppliersFinal if it exists in instance.
     * 
     * @param s Given Supplier object
     * 
     * @return Nothing
     */
    public void removeSupplier(String address) {
        //Validation
        if(address == null) throw new IllegalArgumentException("Given Supplier was null. Please enter a non-null Supplier");
        if(this.sup.isEmpty()) return;
        
        //For each Supplier in this.sup, check if given address matches Supplier address
        this.sup.forEach((supplier) -> {if(supplier.getAddress().equalsIgnoreCase(address)) {this.sup.remove(supplier); return;}});
    }



}
