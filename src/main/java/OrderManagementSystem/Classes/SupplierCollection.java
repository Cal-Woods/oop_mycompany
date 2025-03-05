package OrderManagementSystem.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
        this.suppliers = new ArrayList<Supplier>();
        add(path);
    }

    /**
     * Adds a Supplier ArrayList to the SupplierCollection object instance using a file path to read data from a file.
     * @param path Given file path
     * @return An ArrayList<Supplier> to add to the instance ArrayList<Supplier>.
     */
    public void add(String path) {
        //Validation
        if(path == null || path.isBlank()) throw new IllegalArgumentException("Given path must NOT be null or a blank String!");
        
        //Create try-catch block to handle FileNotFoundException
        try {
            //Declare Scanner object to read from a file
            Scanner sc = new Scanner(new File(path));

            //Set sc delimiter to ','
            sc.useDelimiter(",");

            //Initialise while loop to read given file & create Supplier objects to add to list
            while(sc.hasNextLine()) {
                //Declare temp String array to hold each value of file line
                String name = sc.next(), address = sc.next();
                //Check file data before creating & adding Supplier object, return if there's a problem
                //String data check
                if(name.isBlank() || address.isBlank()) return;

                double owed = Double.parseDouble(sc.next()), limit = Double.parseDouble(sc.next());
                

                //Call sc.nextLine() to push sc forward
                sc.nextLine();

                //Create an instance Supplier object & add to list
                this.add(new Supplier(name, address, owed, limit));
            }

            return;
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());

            return;
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

    public void displayAll() {
        //Declare ArrayList temp
        ArrayList<Supplier> temp = new ArrayList<Supplier>(suppliers);

        //Sort temp alphabetically by supplier name
        temp.sort((a, b) -> {return 1 * a.getName().compareToIgnoreCase(b.getName());});
        
        //Initialise for each loop
        for(Supplier s : temp) {
            System.out.println(s);
        }

        return;
    }

    public void displayCreditors() {
        //Declare ArrayList temp
        ArrayList<Supplier> temp = new ArrayList<Supplier>(suppliers);

        //Sort temp in descending order by amount owed
        temp.sort((a, b) -> {return b.getAmountOwed() > a.getAmountOwed() ? 1: -1;});
        
        //Initialise for each loop
        for(Supplier s : temp) {
            System.out.println(s);
        }

        return;
    }

    public boolean cStoreSuppliers(String fileName) {
        //Validation
        if(fileName == null) throw new IllegalArgumentException("Given fileName must NOT be null!");
        if(fileName.isBlank()) return false;

        //If instance ArrayList is empty
        if(this.suppliers.isEmpty()) {
            System.out.println("Provided fileName is blank.");

            return false;
        }

        //Declare File object at fileName
        File file = new File(fileName);

        //Implement try-catch statement to catch FileNotFoundException
        try {
            //Declare Scanner object set to System.in
            PrintStream ps = new PrintStream(file);
            //Initialise for each loop to insert each element of SupplierCollection instance into file
            for(Supplier s : this.suppliers) {
                //Write data from Supplier properties to file
                ps.println(s.getName()+","+s.getAddress()+","+s.getAmountOwed()+","+s.getCreditLimit()+",");
            }

            //Close PrintStream
            ps.close();

            return true;
        }

        catch(FileNotFoundException e) {
            //Print message
            System.out.println("file "+fileName+" was not found, attempting to create new file with that name.");

            try {
                //Create file if not found
                file.createNewFile();

                PrintStream ps = new PrintStream(file);

                //Initialise for each loop to insert each element of SupplierCollection instance into file
                for(Supplier s : this.suppliers) {
                    //Write data from Supplier properties to file
                    ps.println(s.getName()+","+s.getAddress()+","+s.getAmountOwed()+","+s.getCreditLimit());
                }
                //Close PrintStream instance
                ps.close();

                return true;
            }

            catch(Exception ex) {
                System.out.println(ex.getMessage());

                return false;
            }
        }
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