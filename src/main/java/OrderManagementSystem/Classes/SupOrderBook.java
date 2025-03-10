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


    public double calcOrderCost(int id) {
        //Declare SupOrder to store the matching return type of costBinSearch() method, or stay null
        SupOrder match = null;

        //Implement binary search for orders list SupOrder object with matching id
        int start = 0;
        int end = this.orders.size() - 1;

        // Declare SupOrder that gets SupOrder object from orders
        // SupOrder match = this.orders.get(id);

        if(match == null) {
            //Print message
            System.out.println("There was no match found for given id "+id+".");

            return -1.00;
        }

        return 0.00;
    }

    /**
     * Searches for given id in instance list.
     * 
     * @param id Given id to search for in list.
     * 
     * @return Found SupOrder or null if NOT found.
     * 
     * @throws IllegalArgumentException If given id is less than 1
     */
    private SupOrder costLinearSearch(int id) {
        //Initialise for loop
        for (int i = 0; i < this.orders.size(); i++) {
            //Check if i is id
            if(this.orders.get(i).getID() == id) {
                return this.orders.get(i);
            }
        }

        return null;
    }
}