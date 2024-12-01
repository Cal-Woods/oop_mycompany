package OrderManagementSystem.Classes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

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
        setQuantity(0);
    }
    //Arguments for all attributes
    /**
     * Sets new Delivery object attributes.
     * @param items An ArrayList<Item>
     * @param date A LocalDate object
     * 
     * @see Quantity quantity of items is set automatically to items size
     */
    public Delivery(Item item, int quantity, LocalDate date) {
        setItemRef(item);
        setDate(date);
        setQuantity(quantity);
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

    public boolean setQuantity(int quantity) {
        //Validate attributes
        if(this.getItemRef() == null) {
            throw new IllegalArgumentException("There must be an Item object in itemRef to set quantity.");
        }

        this.quantity = quantity;
        return true;
    }
    
    //Mutator methods
    //Calculate Delivery cost
    public double calculateDeliveryCost() {
    	return this.itemRef.getUnitCostPrice() * this.itemRef.getQuantity();
    }

    @Override
    public String toString() {
        return "Item name: "+this.getItemRef().getName()+"\nItem quantity: "+this.getQuantity()+"\nDelivery date: "+this.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))+"\n";
    }
}
