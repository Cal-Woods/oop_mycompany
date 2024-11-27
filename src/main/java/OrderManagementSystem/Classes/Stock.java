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
            if(getProducts().get(i).getName().equals(itemName)) {
                return getProducts().get(i);
            }
        }

        return new Item();
    }

    public String findDearest(Item item) {
        //Declare Item itemObj to track current object
        Item itemObj = new Item();

        //Initialise for loop to find dearest Item object in this.products ArrayList<Item>
        for (int i = 0; i < this.getProducts().size()-1; i++) {
            //Check if current element is larger dearest
            if(getProducts().get(i).getUnitCostPrice() > itemObj.getUnitCostPrice()) {
                itemObj = getProducts().get(i);
            }
        }

        //Check if itemObj is valid
        if(itemObj.getUnitCostPrice() == 0.00)
            return "";

            return itemObj.getName();
    }
}
