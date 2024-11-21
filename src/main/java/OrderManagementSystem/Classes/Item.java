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
    private int quantityInStock;
    private int reOrderLevel;
    private int reOrderQuantity;
    private double unitCostPrice;
    private int supplierRef;
    private boolean onOrderFlag;


    //Constructors
    //No arguments
    /**
     * An Item constructor with no arguments.
     */
    public Item() {
        //Set Item attributes
        this.itemName = "An item";
        this.uniqueID = 0;
        this.quantityInStock = 0;
        this.reOrderLevel = 0;
        this.reOrderQuantity = 0;
        this.unitCostPrice = 0.00;
        this.supplierRef = 0;
        this.onOrderFlag = false;
    }

    //Arguments for all attributes

    /**
     * @param name Given name String
     * @param ID Given ID number int
     * @param quantity Given quantity int
     * @param reOrderLevel Given reOrderLevel int
     * @param reOrderAmount Given reOrderAmount int
     * @param cost given cost per unit
     * @param supplierID Given supplier ID(Must already exist in Supplier)
     * @param isOnOrder Given onOrder boolean
     */
    public Item(String name, int ID, int quantity, int reOrderLevel, int reOrderAmount, double cost, int supplierID, boolean isOnOrder) {
        this.itemName = name;
        this.uniqueID = ID;
        this.quantityInStock = quantity;
        this.reOrderLevel = reOrderLevel;
        this.reOrderQuantity = reOrderAmount;
        this.unitCostPrice = cost;
        this.supplierRef = supplierID;
        this.onOrderFlag = false;
    }

    //Getters
    public String getName() {
        return this.itemName;
    }
    public int getUniqueID() {
        return this.uniqueID;
    }
    public int getQuantityInStock() {
        return this.quantityInStock;
    }
    public int getReOrderLevel() {
        return this.reOrderLevel;
    }
    public int getReOrderQuantity() {
        return this.reOrderQuantity;
    }
    public double getUnitCostPrice() {
        return unitCostPrice;
    }
    public int getSupplierRef() {
        return this.supplierRef;
    }
    public boolean isOnOrder() {
        return this.onOrderFlag;
    }


    //Setter methods
    public boolean setName(String name) {
        //Validate arguments
        if(name == null) {
            throw new IllegalArgumentException("Given name must NOT be null.");
        }
        if(name.isBlank()) {
            return false;
        }

        //Set value of itemName to name argument
        this.itemName = name;
        return true;
    }

    public boolean setUniqueID(int ID) {
        //Validate Arguments
        if(ID < 0) {
            throw new IllegalArgumentException("Given ID must be a positive integer.");
        }

        //Set uniqueID to ID argument
        this.uniqueID = ID;
        return true;
    }
    public boolean setStockQuantity(int quantity) {
        //Validate arguments
        if(quantity < 0) {
            throw new IllegalArgumentException("Given quantity must be a positive integer.");
        }

        //Set quantityInStock to quantity
        this.quantityInStock = quantity;
        return true;
    }
    public boolean setReOrderLevel(int level) {
        //Validate arguments
        if(level < 0) {
            throw new IllegalArgumentException("Given level must be a positive integer.");
        }

        //Set reOrderLevel to level argument
        this.reOrderLevel = level;
        return true;
    }
    public boolean setReOrderQuantity(int quantity) {
        //Validate arguments
        if(quantity < 0) {
            throw new IllegalArgumentException("Given quantity must be a positive integer.");
        }

        //Set reOrderQuantity to quantity
        this.reOrderQuantity = quantity;
        return true;
    }
    public boolean setUnitCostPrice(double cost) {
        if(Double.isNaN(cost)) {
            throw new InputMismatchException("Given cost must be a valid decimal number.");
        }
        if(cost < 0.00) {
            throw new IllegalArgumentException("Given cost must be a positive value.");
        }

        //Set unitCostPrice to cost
        this.unitCostPrice = cost;
        return true;
    }
    public boolean setSupplierRef(int ref) {
        //Validate arguments
        if(ref <= 0) {
            throw new IllegalArgumentException("Given ref value must be a positive integer & greater than 0.");
        }

        //Set supplierRef to ref
        this.supplierRef = ref;
        return true;
    }
    public boolean setOnOrder(boolean onOrder) {
        //No validation required

        //Set onOrderFlag global to local onOrder argument
        this.onOrderFlag = onOrder;
        return true;
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
        this.quantityInStock += amount;
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
        this.quantityInStock -= amount;
        return true;
    }
    
 
    //static methods
    public static boolean validateSupplierID(Item item, Item[] items) {
        //Validate arguments
        if(item == null) {
            throw new IllegalArgumentException("Given item must NOT be null.");
        }
        if(item.supplierRef == 0) {
            return false;
        }
        if(items == null) {
            throw new IllegalArgumentException("Given Item array must NOT be null.");
        }

        //Initialise for loop
        for (int i = 0; i < items.length; i++) {
            if(item.getSupplierRef() == items[i].getSupplierRef()) {
                return false;
            }
        }
        return true;
    }

    //Override toString()
    @Override
    public String toString() {
        return "Item name: "+itemName+"\nUnique ID: "+uniqueID+"\nQuantity in stock: "+quantityInStock+"\nRe-Order level: "+reOrderLevel+"\nRe-Order quantity: "+reOrderQuantity+"\nUnit cost: "+unitCostPrice+" Euro\nSupplier ID Reference: "+supplierRef+"\nIs on order:"+onOrderFlag+"";
    }
}