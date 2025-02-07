package OrderManagementSystem.Classes;

import java.time.LocalDate;

/**
 * Template for all Delivery objects.
 * @author Cal Woods
**/
public class Delivery {
    //Declare attributes
    private Item[] itemRef;
    private LocalDate date;
    private int quantity;



    //Constructors
    //No argument
    public Delivery() {
        //Set attribute values
        this.itemRef = new Item[0];
        setDate(LocalDate.now());
        setQuantityInternal();
    }
    //Arguments for all attributes
    public Delivery(Item[] items, LocalDate date, int quantity) {
        this.itemRef = items;
        this.date = date;
        this.quantity = quantity;
    }

    //Getter methods
    public Item[] getItemRef() {
        return this.itemRef;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public int getQuantity() {
        return this.quantity;
    }


    //Setter methods
    public boolean setItemRef(Item[] items) {
        //Overwrite itemRef array
        this.itemRef = items;
        setQuantityInternal();
        return true;
    }
    public boolean setDate(LocalDate date) {
        this.date = date;
        return true;
    }

    public boolean setQuantity(int quantity) {
        //Validate attributes
        if(this.itemRef == null) {
            throw new IllegalArgumentException("Given quantity must NOT be null.");
        }
        if(this.itemRef.length == 0) {
            return false;
        }

        this.quantity = quantity;
        return true;
    }
    
    //Mutator methods
    //Calculate Delivery cost
    public double calculateDeliveryCost() {
    	//Create total double variable
    	double total = 0.00;
    	
    	//Increase total by total + each Item unit cost price * each Item quantity
    	for(int i = 0; i < itemRef.length; i++) {
    	total += itemRef[i].getUnitCostPrice();
    	}
    	
    	return total * this.getQuantity();
    }
}
