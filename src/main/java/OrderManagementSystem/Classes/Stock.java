package OrderManagementSystem.Classes;

import java.util.ArrayList;

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

    //Setters
    public boolean add(Item item) {
        //Validation
        if(item == null)
            throw new IllegalArgumentException("Given ArrayList<Item> must NOT be null.");

        //Use ArrayList<T> addAll method to add given items to instance ArrayList<Item> products
        products.add(item);
        return true;
    }

    //Mutator methods
    public Item findItem(String itemName) {
        //Validation
        if(itemName == null)
            throw new IllegalArgumentException("Given Item object must NOT be null.");
        if(itemName.isEmpty() || this.getProducts().isEmpty()) {
            return new Item();
        }

        //Initialise for loop to search ArrayList<Item> products instance variable for given itemName
        for (int i = 0; i < getProducts().size(); i++) {
            //Check if Item 
            if(getProducts().get(i).getName().equalsIgnoreCase(itemName)) {
                return getProducts().get(i);
            }
        }

        return new Item();
    }

    /**
     * Searches Stock.ArrayList<Item> products for the dearest Item.
     * @param item An Item object to check against the ArrayList<Item> products
     * 
     * @throws IllegalArgumentException If Item is null
     * @return 
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
        ArrayList<Item> ordersforSuppliers = new ArrayList<Item>(0);

        //Initialise for loop
        for (int i = 0; i < this.getProducts().size(); i++) {
            //Check for Item that has a quantity lower than reOrderLevel AND is not onOrder
            if(this.getProducts().get(i).getQuantityInStock() <= this.getProducts().get(i).getReOrderLevel() && this.getProducts().get(i).isOnOrder() == false) {
                ordersforSuppliers.add(this.getProducts().get(i));
            }
        }

        return ordersforSuppliers;
    }
}