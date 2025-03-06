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
        //Sort orders by uniqueID in ascending order for binary search
        this.orders.sort((a, b) -> {return a.getID() < b.getID() ? a.getID() : b.getID();});

        //Declare SupOrder to store the matching object, or stay null
        SupOrder match = null;

        //Implement binary search for orders list SupOrder object with matching id
        int start = 0;
        int end = this.orders.size() - 1;

        //Initialise while loop
        while(start <= end) {
            //Declare int mid for holding middle of end - start
            int mid = start+(end-start)/2;

            //Check binary search cases
            if(this.orders.get(mid).getID() == id) {
                //Store match
                match = this.orders.get(mid);

                break;
            }
            else if(this.orders.get(mid).getID() < id) {
                start = mid;
            }
            else if(this.orders.get(mid).getID() > id) {
                end = mid;
            }
        }

        //TODO: Finish calculating order

        // Declare SupOrder that gets SupOrder object from orders
        // SupOrder match = this.orders.get(id);

        // if(match == null) {
        //     //Print error message
        //     System.out.println("");


        // }

        return 0.00;
    }
}