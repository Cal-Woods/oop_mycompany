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

    /**
     * Gets the total cost of an order from a supplier.
     * 
     * @param id Given id to search in list.
     * 
     * @return total order cost, or -1.00 if id was not found
     * 
     * @throws IllegalArgumentException By internal method if id is < 1
     */
    public double calcOrderCost(int id) {
        //Declare SupOrder to store the matching return type of costLinearSearch() method, or stay null
        SupOrder match = costLinearSearch(id);

        //No match found case
        if(match == null) {
            //Print message
            System.out.println("There was no match found for given id "+id+".");

            return -1.00;
        }

        //Declare double total equals 0.00
        double total = 0.00;

        //Initialise for loop
        for (int i = 0; i < match.getItems().size(); i++) {
            //Add each Item unitCostPrice * quantity to total
            total += match.getItems().get(i).getUnitCostPrice() * match.getItems().get(i).getQuantity();
        }

        return total;
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