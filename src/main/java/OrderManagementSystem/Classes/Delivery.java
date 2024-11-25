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
    public Delivery() {
        //Set attribute values
        this.itemRef = new ArrayList<Item>();
        setDate(LocalDate.now());
        setQuantityInternal();
    }
    //Arguments for all attributes
    public Delivery(ArrayList<Item> items, LocalDate date, int quantity) {
        this.itemRef = items;
        this.date = date;
        this.quantity = quantity;
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
    public boolean setItemRef(ArrayList<Item> items) {
        //Overwrite itemRef array
        this.itemRef = items;
        setQuantityInternal();
        return true;
    }
    public boolean setDate(LocalDate date) {
        this.date = date;
        return true;
    }
    private boolean setQuantityInternal() {
        //Validate attributes
        if(this.itemRef == null) {
            return false;
        }
        this.quantity = this.itemRef.size();
        return true;
    }
    public boolean setQuantity(int quantity) {
        //Validate attributes
        if(this.itemRef == null) {
            throw new IllegalArgumentException("Given quantity must NOT be null.");
        }
        if(this.itemRef.size() == 0) {
            return false;
        }

        return true;
    }
    
    //Mutator methods
    public Item addItems(Item[] items) {
        //Argument validation
        if(items == null)
            throw new IllegalArgumentException();
    }


    //Calculate Delivery cost
    public double calculateDeliveryCost() {
    	//Create total double variable
    	double total = 0.00;
    	
    	//Set total to total + each Item unit cost price
    	for(int i = 0; i < itemRef.size(); i++) {
    	total += itemRef.get(i).getUnitCostPrice()*itemRef.get(i).getQuantityInStock();
    	}
    	
    	return total;
    }
}
