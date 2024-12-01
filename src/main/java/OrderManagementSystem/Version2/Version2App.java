package OrderManagementSystem.Version2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import OrderManagementSystem.Classes.*;

public class Version2App {
    public static void main(String[] args) {
    //Add Scanner object for getting user input. System.in = user input
    Scanner sc = new Scanner(System.in);

    //Print message
    System.out.println("This program represents an order management system. The first thing the program does is create a Stock class object. Then, the stock will have seven Item objects added to it.");
    
    //Declare Stock object
    Stock stock = new Stock();

    //Add 7 Item objects to stock
    stock.add(new Item("Microsoft 2-in-1 Keyboard", 34, 50, 80, 250000.00, new Supplier("Roisin Mulligan", "13 Dundalk St, Dundalk, Co Louth, Ireland", 5000.00, 10000.00), true));
    stock.add(new Item("Microsoft Mouse", 60, 40, 145, 125.00, new Supplier("Stephen Larkin", "26 Doughiska Rd, Galway, Co. Galway, Ireland", 1280.50, 7500.00), false));
    stock.add(new Item("NVIDIA Gtx 1080TI", 55, 8, 35, 357.99, new Supplier("Nikolaos Pantelidis", "39 Rathmullen Rd, Drogheda, Co Louth, Ireland", 3500.00, 8000.00), false));
    stock.add(new Item("AMD Ryzen 3", 56, 60, 100, 200.00, new Supplier("Peter Gosling", "5 Williamsons Place, BlackRock, Dundalk, Co. Louth, Ireland", 2100.00, 3200.00), true));
    stock.add(new Item("Intel Core i9 13900X", 12, 40, 30, 10.00, new Supplier("David O'Keefe", "7 Bellfield, Dundalk, Co Louth, Ireland", 12500.00, 30000.00), true));
    stock.add(new Item("CPU fan", 200, 90, 110, 59.99, new Supplier("Michelle Graham", "14 Cavanagarden Ballyshannon, Ballyshannon, Co. Donegal, Ireland", 6500.00, 32000.00), false));
    stock.add(new Item("12GB 2.0 USB-C", 31, 75, 75, 18.00, new Supplier("Amanda Clancy", "1 Georges Quay Dundalk, Dundalk, Co Louth, Ireland", 346.00, 2400.00), true));

    //Print message
    System.out.println("\nNow, The program creates three Delivery objects to place into a SupDeliveries ArrayList.\n");
    System.out.print("Enter the name of each Item you want to add to each delivery. If it is in stock, it will be added. Otherwise, Item cannot be added. This wil occur three times.\n");

    //Declare three Delivery objects
    //Print prompt
    System.out.print("Enter the name of an Item to find and a quantity on the next line: ");

    //Get user inputs name, quantity and store
    String name = sc.nextLine();
    int quantity = sc.nextInt();
    
    //Create Delivery object delivery1
    Delivery delivery1 = new Delivery(stock.findItem(name), quantity, LocalDate.now());

    //Repeat process
    System.out.print("\nEnter the name of an Item to find and a quantity on the next line: ");
    name = sc.nextLine();

    //Clear Scanner buffer
    sc.nextLine();

    quantity = sc.nextInt();
    
    
    Delivery delivery2 = new Delivery(stock.findItem(name), quantity, LocalDate.now());
    
    System.out.print("Enter the name of an Item to find and a quantity on the next line: ");
    name = sc.nextLine();

    sc.nextLine();

    quantity = sc.nextInt();
    Delivery delivery3 = new Delivery(stock.findItem(sc.nextLine()), sc.nextInt(), LocalDate.now());

    //Print blank line
    System.out.println();

    //Create SupDeliveries object & add three Delivery objects
    SupDeliveries deliveries = new SupDeliveries();

    //Add delivery1, delivery2, delivery3 Delivery objects to deliveries using add() method
    deliveries.addDelivery(delivery1);
    deliveries.addDelivery(delivery2);
    deliveries.addDelivery(delivery3);

    //Check if deliveries object has invalid data with checkDeleteDeliveries() method and purge deliveries of invalid data
    if(checkDeleteDeliveries(deliveries)) {
    }


    //Check if any deliveries are invalid using checkDeliveries() app method
    //Test deliveries contains three Delivery objects
    deliveries.displayAllDeliveries();
    }

    
    //Create helper methods
    /**
     * Checks if any Supplier deliveries contain Item objects that have bad data and deletes those objects from given deliveries.
     * @param deliveries Given SupDeliveries object
     * @return A boolean, false if all Item objects within deliveries are valid, or if deliveries has 0 Item objects. True if any Item objects are not valid.
     * 
     * @throws IllegalArgumentException If given SupDeliveries object is null.
     */
    private static boolean checkDeleteDeliveries(SupDeliveries deliveries) {
        //Validation
        if(deliveries == null)
            throw new IllegalArgumentException("Given SupDeliveries object must NOT be null.");
        if(deliveries.getDeliveries().size() == 0)
            return true;

        //Declare boolean problem
        boolean problem = false;

        //Initialise for loop to iterate over given deliveries
        for (int i = 0; i < deliveries.getDeliveries().size(); i++) {
            //Check if current element of given deliveries object has a bad item name of 'change name'
            if(deliveries.getDeliveries().get(i).getItemRef().getName().equalsIgnoreCase("change name")) {
                //Remove current delivery from list
                deliveries.getDeliveries().remove(i);

                //Set problem to true
                problem = true;
            }
        }

        return problem;
    }
}