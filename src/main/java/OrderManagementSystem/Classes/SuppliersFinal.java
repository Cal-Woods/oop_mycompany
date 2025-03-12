package OrderManagementSystem.Classes;

import java.util.TreeSet;

public class SuppliersFinal {
    private TreeSet<Supplier> sup;

    //Constructors
    /**
     * Initialises blank SuppliersFinal object.
     */
    public SuppliersFinal() {
        sup = new TreeSet<Supplier>();
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
}
