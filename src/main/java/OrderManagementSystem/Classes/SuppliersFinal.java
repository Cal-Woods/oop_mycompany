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
}
