package OrderManagementSystem.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SupplierCollection {
    //Attributes
    private ArrayList<Supplier> suppliers;

    //Constructors
    //no argument
    /** 
     * A no-argument constructor that sets SupplierCollection initial capacity to 10.
     **/
    public SupplierCollection() {
        this.suppliers = new ArrayList<Supplier>(10);
    }

    /**
     * A constructor that accepts a File object containing information for Supplier objects
     * as an argument and initialises an instance ArrayList with the file values.
     * @param path Given String containing file path
     **/
    public SupplierCollection(String path) {
        this.suppliers = add(path);
    }

    /**
     * Adds a Supplier ArrayList to the SupplierCollection object instance using a file path to read data from a file.
     * @param path Given file path
     * @return An ArrayList<Supplier> to add to the instance ArrayList<Supplier>.
     */
    public ArrayList<Supplier> add(String path) {
        //Validation
        if(path == null || path.isBlank()) throw new IllegalArgumentException("Given path must NOT be null or a blank String!");
        
        //Create try-catch block to handle FileNotFoundException
        try {
            //Declare Scanner object to read from a file
            Scanner sc = new Scanner(new File(path));

            //Set sc delimiter to ','
            sc.useDelimiter(",");

            //Declare ArrayList<Supplier> list, initial capacity to return to instance ArrayList<Supplier>
            ArrayList<Supplier> list = new ArrayList<Supplier>();

            //Initialise while loop to read given file & create Supplier objects to add to list
            while(sc.hasNextLine()) {
                //Declare temp String array to hold each value of file line
                String name = sc.next(), address = sc.next();
                //Check file data before creating & adding Supplier object, return if there's a problem
                //String data check
                if(name.isBlank() || address.isBlank()) return null;

                double owed = Double.parseDouble(sc.next()), limit = Double.parseDouble(sc.next());
                //Double data check using try-catch
                

                //Call sc.nextLine() to push sc forward
                sc.nextLine();

                //Create an instance Supplier object & add to list
                list.add(new Supplier(name, address, owed, limit));
            }

            return list;
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            return new ArrayList<Supplier>();
        }
    }

    /**
     * Adds a Supplier object to instance SupplierCollection.
     * @param supplier Given Supplier object
     * 
     * @return Boolean true if successful
     */
    public boolean add(Supplier supplier) {
        //Validation
        if(supplier == null) throw new IllegalArgumentException("Given Supplier object must NOT be null!");

        //Call suppliers instance 'add()' method to add given Supplier object to suppliers
        this.suppliers.add(supplier);

        return true;
    }

    @Override
    public String toString() {
        String list = "";

        for (int i = 0; i < this.suppliers.size(); i++) {
            list += this.suppliers.get(i).toString()+"\n";
        }

        return list;
    }
}