package OrderManagementSystem.Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Stock {
    //Attribute: ArrayList<Item> products
    private ArrayList<Item> products = new ArrayList<Item>(0);

    //No argument constructor
    public Stock() {
        //Create blank ArrayList<Item>
        products = new ArrayList<Item>(0);
    }

    //Getters
    public ArrayList<Item> getProducts() {
        return products;
    }
    //create display() method
    public boolean display() {
        //Validation
        if(this.getProducts().isEmpty())
            return false;

        //Initialise for loop to iterate over ArrayList<Item> products
        for (int i = 0; i < getProducts().size(); i++) {
            System.out.println(getProducts().get(i).toString()+"\n");
        } 

        return true;
    }

    //Mutator methods
        public boolean add(Item item) {
        //Validation
        if(item == null)
            throw new IllegalArgumentException("Given ArrayList<Item> must NOT be null.");

        //Use ArrayList<T> addAll method to add given items to instance ArrayList<Item> products
        return products.add(item);
    }
    /**
     * Finds an Item in ArrayList<item> products.
     * @param itemName A String item name to search for in products
     * @return The found Item object
     **/
    public Item findItem(String itemName) {
        //Validation
        if(itemName == null)
            throw new IllegalArgumentException("Given Item object must NOT be null.");
        if(itemName.isEmpty() || this.getProducts().isEmpty()) {
            return null;
        }

        //Initialise for loop to search ArrayList<Item> products instance variable for given itemName
        for (int i = 0; i < getProducts().size(); i++) {
            //Check if Item 
            if(getProducts().get(i).getName().equalsIgnoreCase(itemName)) {
                return getProducts().get(i);
            }
        }

        return null;
    }

    /**
     * Searches Stock.ArrayList<Item> products for the dearest Item.
     * @param item An Item object to check against the ArrayList<Item> products
     * 
     * @throws IllegalArgumentException If Item is null
     * 
     * @return Name of dearest item in instance list
     */
    public String findDearest() {
        //Validate size() of products
        if(this.getProducts().size() == 0)
            return "";

        //Declare String dearestItem to track current object
        Item dearestItem = new Item();

        //Initialise for loop to find dearest Item object in this.products ArrayList<Item>
        for (int i = 0; i < this.getProducts().size(); i++) {
            //Check if current element is larger dearest
            if(getProducts().get(i).getUnitCostPrice() > dearestItem.getUnitCostPrice()) {
                dearestItem = getProducts().get(i);
            }
        }


        return dearestItem.getName();
    }

    /**
     * Finds the cheapest cost of an Item object in products
     * @return Item cheapestItem
     */
    public Item findCheapest() {
        //Validate size() of products
        if(this.getProducts().size() == 0)
            return null;
        //Declare Item cheapestItem to track current object
        Item cheapestItem = this.getProducts().get(0);

        //Initialise for loop to find dearest Item object in this.products ArrayList<Item>
        for (int i = 0; i < this.getProducts().size(); i++) {
            //Check if current element is larger dearest
            if(getProducts().get(i).getUnitCostPrice() < cheapestItem.getUnitCostPrice()) {
                cheapestItem = getProducts().get(i);
            }
        }
        return cheapestItem;
    }

    public ArrayList<Item> createOrders() {
        //Validation
        if(this.getProducts().size() == 0)
            return new ArrayList<Item>(0);

        //Declare ArrayList<Item> ordersForSuppliers to hold products that need to be ordered
        ArrayList<Item> ordersForSuppliers = new ArrayList<Item>(0);

        //Initialise for loop
        for (int i = 0; i < this.getProducts().size(); i++) {
            //Check for Item that has a quantity lower than reOrderLevel AND is not onOrder
            if(this.getProducts().get(i).getQuantity() <= this.getProducts().get(i).getReOrderLevel() && this.getProducts().get(i).isOnOrder() == false) {
                ordersForSuppliers.add(this.getProducts().get(i));
            }
        }

        return ordersForSuppliers;
    }
        
    /**
     * Displays all orders ordered alphabetically by name.
     * 
     * @return True if instance list is NOT empty, false otherwise
     */
    public boolean displayByName() {
        //Validation
        //Check if products is empty
        if(this.products.isEmpty()) return false;

        //Declare an ArrayList display to hold copy of all products
        ArrayList<Item> display = new ArrayList<Item>();

        //Copy products to display
        display.addAll(products);

        //Sort products by name ascending
        display.sort((a, b) -> {return 1 * a.getName().compareToIgnoreCase(b.getName());});

        //Print message
        System.out.println("The items in this list are:\n");

        //Display each Item in products
        for(Item item: display) {
            System.out.print("\n"+item);
        }

        return true;
    }

    /**
     * Displays instance Item objects in descending order of quantity.
     * 
     * @return True if instance list is NOT empty, false otherwise.
     */
    public boolean displayByQty() {
        //Validation
        //Check if products is empty
        if(this.products.isEmpty()) return false;

        //Declare an ArrayList display to hold copy of all products
        ArrayList<Item> display = new ArrayList<Item>();

        //Copy products to display
        display.addAll(products);

        //Sort products by quantity descending
        display.sort((a, b) -> {return b.getQuantity() > a.getQuantity() ? 1 : -1;});

        //Print message
        System.out.println("\n\nThe items in this list are:\n");

        //Display each Item in products
        for(Item item: display) {
            System.out.print("\n"+item);
        }

        return true;
    }

    /**
     * Creates a HashMap consisting of String keys set to Item name attribute & Item objects for values.
     */
    public HashMap<String, Item> createSupplierMap() {
        //Declare HashMap to store all Item objects from products
        HashMap<String, Item> stockMap = new HashMap<String, Item>();

        //Check if products isEmpty()
        if(products.isEmpty()) {
            return stockMap;
        }

        //Initialise for loop
        for (int i = 0; i < this.products.size(); i++) {
            //Insert each Item into map
            stockMap.put(this.products.get(i).getName(), this.products.get(i));
        }

        return stockMap;
    }
}