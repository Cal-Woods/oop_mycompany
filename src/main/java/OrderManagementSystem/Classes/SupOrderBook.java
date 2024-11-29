package OrderManagementSystem.Classes;

import java.util.ArrayList;

public class SupOrderBook {
    //Declare attributes
    private ArrayList<SupOrder> orders = new ArrayList<SupOrder>(0);

    //Getter methods
    public ArrayList<SupOrder> getOrders() {
        return orders;
    }

    //Mutator methods
    /**
     * Adds a SupOrder object to instance ArrayList<Item> object
     * @param order A SupOrder object
     * 
     * @throws IllegalArgumentException If given SupOrder object is null.
     * @return int 0 if method is successful, otherwise, throws IllegalArgumentException
     */
    public int add(SupOrder order) {
        //Validation
        if(order == null)
            throw new IllegalArgumentException("Given SupOrder array must NOT be null.");

        //Use ArrayList add() method to add order to orders
        this.orders.add(order);
        return 0;
    }

    /**
     * Adds all items from a given ArrayList<SupOrder>
     * @param orders An ArrayList<SupOrder>
     * 
     * @throws IllegalArgumentException If ArrayList<SupOrder> is null
     * 
     * @return Int 0 if method successful, otherwise, -1
     */
    public int add(ArrayList<SupOrder> orders) {
        //Validation
        if(orders == null)
            throw new IllegalArgumentException("Given ArrayList must NOT be null.");
        if(orders.isEmpty())
            return -1;
            
        this.orders.addAll(orders);
        return 0;
    }
}