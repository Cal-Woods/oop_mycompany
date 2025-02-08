package OrderManagementSystem.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class SupOrder {
    //Declare attributes
    private ArrayList<Item> itemRef;
    private LocalDate date;
    private int quantity;
    private int uniqueID;

    //Declare static IDSeed for Incremental id assignment
    private static int idSeed = 0;

    //Create no argument constructor
    /**
     * Constructor with no arguments, generates default values for attributes, change IMMEDIATELY!
     */
    public SupOrder() {
        this.itemRef = new ArrayList<Item>(0);
        this.date = LocalDate.EPOCH;
        this.quantity = getItems().size();
        this.uniqueID = 0;
    }

    //A constructor that takes arguments
    /**
     * An arguments constructor.
     * @param items An ArrayList of Item objects
     * @param date A LocalDate object
     * 
     * @see This This constructor uses various methods to validate incoming data before setting attributes.
     * @see Various Various validation methods throw IllegalArgumentException.
     */
    public SupOrder(ArrayList<Item> items, LocalDate date) {
       //Instance methods to validate data before setting attributes
        setItemRef(items);
        setDate(date);
        setQuantity();
        setUniqueID();
    }

    //Getter methods
    public ArrayList<Item> getItems(){
        return this.itemRef;
    }
    public LocalDate getDate() {
        //Validate date attribute
        return this.date;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public int getID() {
        return this.uniqueID;
    }

    //Setter methods
    /**
     * Overwrites SupOrder ArrayList<Item> itemRef with new ArrayList<Item>
     * @param items An ArrayList<Item> 
     */
    public void setItemRef(ArrayList<Item> items) {
        //Validation
        if(items == null)
            throw new IllegalArgumentException("Given ArrayList<Item> must NOT be null.");

        this.itemRef = items;
    }
    public void setDate(LocalDate date) {
        //Validation
        if(date == null)
            throw new IllegalArgumentException("Given date must NOT be null.");
        if(date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Given date must be the current local date or after, cannot be before current local date.");
        }

        this.date = date;
    }
    public void setQuantity() {
        this.quantity = getItems().size();
    }
    public void setUniqueID() {
        this.uniqueID = idSeed++;
    }
}