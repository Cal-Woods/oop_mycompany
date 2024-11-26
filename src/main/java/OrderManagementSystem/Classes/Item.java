package OrderManagementSystem.Classes;
import java.util.InputMismatchException;

/** 
 * Defines an item & it's attributes + methods.
 * @author Cal Woods
**/
public class Item {
    //Attributes
    private String itemName;
    private int uniqueID;
    private int quantity;
    private int reOrderLevel;
    private int reOrderQuantity;
    private double unitCostPrice;
    private Supplier supplierRef;
    private boolean onOrderFlag;


    //Constructors
    //No arguments
    
    /**
     * An Item constructor with no arguments.
     * @see zero 0 is not a valid value, change all attributes after using this no argument constructor.
     */
    public Item() {
        //Set Item attributes
        this.itemName = "Change name";
        this.uniqueID = 0;
        this.quantity = 0;
        this.reOrderLevel = 0;
        this.reOrderQuantity = 0;
        this.unitCostPrice = 0.00;
        this.supplierRef = null;
        this.onOrderFlag = false;
    }

    //Create static int globalID to generate unique IDs
    private static int globalID;

    //Arguments for all attributes

    /**
     * @param name Given name String
     * @param quantity Given quantity int
     * @param reOrderLevel Given reOrderLevel int
     * @param reOrderAmount Given reOrderAmount int
     * @param cost given cost per unit
     * @param supplierRef Given supplier object
     * @param isOnOrder Given onOrder boolean
     * 
     * @throws IllegalArgumentExcepion if name is empty or null, any int is below zero, or the given supplier reference is null.
     */
    public Item(String name, int quantity, int reOrderLevel, int reOrderAmount, double cost, Supplier supplierRef, boolean isOnOrder) {
        //Set attributes to arguments
        setName(name);
        setUniqueID();
        setStockQuantity(quantity);
        setReOrderLevel(reOrderLevel);
        setReOrderQuantity(reOrderAmount);
        setUnitCostPrice(cost);
        setSupplierRef(supplierRef);
        setOnOrder(isOnOrder);
    }

    //Getters
    public String getName() {
        return this.itemName;
    }
    public int getUniqueID() {
        return this.uniqueID;
    }
    public int getQuantityInStock() {
        return this.quantity;
    }
    public int getReOrderLevel() {
        return this.reOrderLevel;
    }
    public int getReOrderQuantity() {
        return this.reOrderQuantity;
    }
    public double getUnitCostPrice() {
        return this.unitCostPrice;
    }
    public Supplier getSupplierRef() {
        return this.supplierRef;
    }
    public boolean isOnOrder() {
        return this.onOrderFlag;
    }


    //Setter methods
    public void setName(String name) {
        //Validate arguments
        if(name == null) {
            throw new IllegalArgumentException("Given item name must NOT be null.");
        }
        if(name.isBlank()) {
            throw new IllegalArgumentException("Given item name must NOT be blank.");
        }

        //Set value of itemName to name argument
        this.itemName = name;
    }

    /**
     * Sets a unique ID Automatically.
     * @return The new ID
     */
    private void setUniqueID() {
        this.uniqueID = globalID++;
    }
    public void setStockQuantity(int quantity) {
        //Validate arguments
        if(quantity < 0) {
            throw new IllegalArgumentException("Given quantity must be a positive integer.");
        }

        //Set quantityInStock to quantity
        this.quantity = quantity;
    }

    public void setReOrderLevel(int level) {
        //Validate arguments
        if(level < 0) {
            throw new IllegalArgumentException("Given level must be a positive integer.");
        }

        //Set reOrderLevel to level argument
        this.reOrderLevel = level;
    }
    public void setReOrderQuantity(int quantity) {
        //Validate arguments
        if(quantity < 0) {
            throw new IllegalArgumentException("Given quantity must be a positive integer.");
        }

        //Set reOrderQuantity to quantity
        this.reOrderQuantity = quantity;
    }
    public void setUnitCostPrice(double cost) {
        if(Double.isNaN(cost)) {
            throw new InputMismatchException("Given cost must be a valid decimal number.");
        }
        if(cost < 0.00) {
            throw new IllegalArgumentException("Given cost must be a positive value.");
        }

        //Set unitCostPrice to cost
        this.unitCostPrice = cost;
    }

    public void setSupplierRef(Supplier ref) {
        //Validate arguments
        if(ref == null) {
            throw new IllegalArgumentException("Given Supplier object must NOT be null.");
        }

        //Set supplierRef to ref
        this.supplierRef = ref;
    }
    public void setOnOrder(boolean onOrder) {
        //No validation required

        //Set onOrderFlag global to local onOrder argument
        this.onOrderFlag = onOrder;
    }


    //Mutator methods
    /**
     * Increases Item quantity in stock by given amount.
     * @param amount The amount to increase on quantity in stock
     * @return A boolean indicating whether or not the operation was successful
     */
    public boolean increaseQuantityInStock(int amount) {
        //Validate arguments
        if(amount < 0) {
            throw new IllegalArgumentException("Given amount must be a positive integer.");
        }

        //Increment quantityinStock by quantity
        this.quantity += amount;
        return true;
    }

    /**
     * Decreases Item quantity in stock by given amount.
     * @param amount The amount to decrease on quantity in stock
     * @return A boolean whether or not the operation was successful as a boolean value
     */
    public boolean decreaseQuantityInStock(int amount) {
        //Validate arguments
        if(amount < 0) {
            throw new IllegalArgumentException("Given amount must be a positive integer.");
        }

        //Increment quantityinStock by quantity
        this.quantity -= amount;
        return true;
    }
    
 
    //static methods for entire class


    //Override toString()
    @Override
    public String toString() {
        return "Item name: "+itemName+"\nUnique ID: "+uniqueID+"\nQuantity of item: "+quantity+"\nRe-Order level: "+reOrderLevel+"\nRe-Order quantity: "+reOrderQuantity+"\nUnit cost: "+unitCostPrice+" Euro\nSupplier ID Reference: "+supplierRef+"\nIs on order:"+onOrderFlag+"";
    }
}