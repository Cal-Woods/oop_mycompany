package OrderManagementSystem.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class SupOrder {
    //Declare attributes
    private ArrayList<Item> itemRef;
    private LocalDate date;
    private int quantity;
    private int uniqueID;

    //Create no argument constructor
    public SupOrder() {
        
    }

    //A constructor that takes arguments
    public SupOrder(ArrayList<Item> items, LocalDate date) {

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
     * Overwrites SupOrder ArrayList<Item> itemRef
     * @param items An ArrayList<Item>
     */
    public void setItemRef(ArrayList<Item> items) {

    }
}
