package OrderManagementSystem.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Template for all Delivery objects.
 * @author Cal Woods
**/
public class Delivery {
    //Declare attributes
    private Item itemRef;
    private LocalDate date;
    private int quantity;



    //Constructors
    //No argument
    /**
     * A no argument constructor for the Delivery class.
     */
    public Delivery() {
        //Set attribute values
        setItemRef(new Item());
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
    public Delivery(Item item, LocalDate date) {
        setItemRef(item);
        setDate(date);
        setQuantity();
    }

    //Getter methods
    public Item getItemRef() {
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
     * Overwrites ItemRef Item with new Item
     * @param item An Item object
     * @return A boolean indicating operation success
     * @throws IllegalArgumentException If items array is null
     */
    public boolean setItemRef(Item item) {
        //Argument validation
        if(item == null)
            throw new IllegalArgumentException("Given Item object must NOT be null.");

        //Overwrite itemRef array
        this.itemRef = item;
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

        this.quantity = this.itemRef.getQuantityInStock();
        return true;
    }
    
    //Mutator methods
    //Calculate Delivery cost
    public double calculateDeliveryCost() {
    	return this.itemRef.getUnitCostPrice() * this.itemRef.getQuantityInStock();
    }
}
