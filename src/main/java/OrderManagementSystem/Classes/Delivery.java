package OrderManagementSystem.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Template for all Delivery objects.
 * @author Cal Woods
**/
public class Delivery {
    //Declare attributes
    private ArrayList<Item> itemRef;
    private LocalDate date;
    private int quantity;



    //Constructors
    //No argument
    /**
     * A no argument constructor for the Delivery class.
     */
    public Delivery() {
        //Set attribute values
        this.itemRef = new ArrayList<Item>(0);
        setDate(LocalDate.now());
        setQuantity();
    }
    //Arguments for all attributes
    /**
     * Sets new Delivery object attributes.
     * @param items An ArrayList<Item>
     * @param date A LocalDate object
     * 
     * @see Quantity quantity of items is set automatically to items size
     */
    public Delivery(ArrayList<Item> items, LocalDate date) {
        setItemRef(items);
        setDate(date);
        setQuantity();
    }

    //Getter methods
    public ArrayList<Item> getItemRef() {
        return this.itemRef;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public int getQuantity() {
        return this.quantity;
    }


    //Setter methods
    /**
     * Overwrites ItemRef arraylist<Item> with new arraylist<Item>.
     * @param items An ArrayList<Item>
     * @return 
     * @throws IllegalArgumentException If items array is null
     */
    public boolean setItemRef(ArrayList<Item> items) {
        //Argument validation
        if(items == null)
            throw new IllegalArgumentException("Given ArrayList<Item> must NOT be null.");

        //Overwrite itemRef array
        this.itemRef = items;
        setQuantity();
        return true;
    }
    public boolean setDate(LocalDate date) {
        //Argument validation
        if(date == null)
            throw new IllegalArgumentException("");

        if(date.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Given date must NOT be before today.");

        this.date = date;
        return true;
    }

    public boolean setQuantity() {
        //Validate attributes
        if(this.itemRef == null) {
            throw new IllegalArgumentException("There must be items in itemRef to set quantity.");
        }
        if(this.itemRef.size() == 0) {
            return false;
        }
        
        this.quantity = this.itemRef.size();
        return true;
    }
    
    //Mutator methods
    //Calculate Delivery cost
    public double calculateDeliveryCost() {
    	//Create total double variable
    	double total = 0.00;
    	
    	//Set total to total + each Item unit cost price
    	for(int i = 0; i < getQuantity(); i++) {
    	    total += this.getItemRef().get(i).getUnitCostPrice() * this.getItemRef().get(i).getQuantityInStock();
    	}

    	return total;
    }
}
