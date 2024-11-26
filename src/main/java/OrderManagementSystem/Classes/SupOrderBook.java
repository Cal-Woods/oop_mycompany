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
    public void add(SupOrder order) {
        //Validation
        if(order == null)
            throw new IllegalArgumentException("Given SupOrder array must NOT be null.");

        //Use ArrayList add() method to add order to orders
        this.orders.add(order);
    }
    public void add(ArrayList<SupOrder> orders) {
        //Validation
        if(orders == null)
            throw new IllegalArgumentException("Given ArrayList must NOT be null.");
        
        this.orders.addAll(orders);
    }
}
