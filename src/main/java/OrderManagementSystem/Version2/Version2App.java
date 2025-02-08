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
    System.out.println("\nNow, The program creates three Delivery objects to place into a SupDeliveries ArrayList. Here is our stock.\nCatalogue:");

    //Use stock.display() to print stock list
    stock.display();


    System.out.print("Enter the name of each Item you want to add to each delivery. If it is in stock, it will be added. Otherwise, Item cannot be added and user must enter again.\n");

    String name = "";
    int quantity = 0;
    
    System.out.print("Enter an Item name to search our stock: ");
    name = sc.nextLine();

    //Repeatedly check if Item with given name is NOT in stock
    while(stock.findItem(name) == null) {
        //Print prompt
        System.out.print("Given name could not be found in stock. Please re-enter name: ");
        //Set name to user input
        name = sc.nextLine();

        //Clear Scanner buffer
        sc.nextLine();

    }
    System.out.print("Enter quantity: ");
    quantity = sc.nextInt();

    //Create Delivery object delivery1
    Delivery delivery1 = new Delivery(stock.findItem(name), quantity, LocalDate.now());
    sc.nextLine();

    //Repeat process
    System.out.print("\nPlease enter name of Item to search for next delivery: ");
    name = sc.nextLine(); 
    while(stock.findItem(name) == null) {
        //Print prompt
        System.out.print("Given name could not be found in stock. Please re-enter name: ");
        //Set name to user input
        name = sc.nextLine();

        sc.nextLine();
    }
    System.out.print("Enter quantity: ");
    quantity = sc.nextInt();
    Delivery delivery2 = new Delivery(stock.findItem(name), quantity, LocalDate.now());
    sc.nextLine();

    System.out.print("\nEnter the name of an Item to find and a quantity on the next line: ");
    name = sc.nextLine();
    while(stock.findItem(name) == null) {
        //Print prompt
        System.out.print("Given name could not be found in stock. Please re-enter name: ");
        //Set name to user input
        name = sc.nextLine();

        //Clear Scanner buffer
        sc.nextLine();
    }
    System.out.print("Enter quantity: ");
    quantity = sc.nextInt();

    Delivery delivery3 = new Delivery(stock.findItem(name), quantity, LocalDate.now());
    sc.nextLine();

    //Print blank line
    System.out.println();

    //Print message
    System.out.println("The program is creating supplier deliveries and managing them.");
    //Create SupDeliveries object & add three Delivery objects
    SupDeliveries deliveries = new SupDeliveries();

    //Add delivery1, delivery2, delivery3 Delivery objects to deliveries using add() method
    deliveries.addDelivery(delivery1);
    deliveries.addDelivery(delivery2);
    deliveries.addDelivery(delivery3);

    //update amount owed to Suppliers after deliveries
    updateOwed(deliveries);

    //Decrease stock after deliveries
    updateStock(deliveries, stock);

    //Change onOrder flag for each Item in deliveries
    updateOnOrder(deliveries, stock, false);

    //Create an ArrayList<Item> items
    ArrayList<Item> items = new ArrayList<Item>();


    items.add(stock.getProducts().get(4));
    items.add(stock.getProducts().get(6));
    items.add(stock.getProducts().get(3));

    SupOrder order = new SupOrder(items, LocalDate.now());
    //3) Create an orderBook object & add objects to it.
    SupOrderBook orderBook = new SupOrderBook();

    //Add SupOrderto orderBook
    orderBook.add(order);

    //4) Delete all deliveries from Supplier Joe Smith
    System.out.println("Deleting deliveries from supplier, Joe Smith");
    deliveries.deleteDeliveries("Joe Smith");

    //The cheapest item
    System.out.println("The cheapest item in stock is: "+stock.findCheapest());
    System.out.println("\nThe dearest item in stock is: "+stock.findItem(stock.findDearest()));
    System.out.println("The details of the dearest Item are: "+stock.findItem(stock.findDearest()).toString());

    System.out.println("All deliveries on 1st December 2023 are none");

    System.out.println("");
    //Test deliveries contains three Delivery objects
    deliveries.displayAllDeliveries();

    //Close scanner
    sc.close();

    }
    
    //Create updateOwed() method to update amount owed to Suppliers
    /**
     * Updates amount owed to Suppliers after deliveries.
     * @param deliveries Given SupDeliveries object
     * @return o if successful, -1 otherwise
    **/
    public static int updateOwed(SupDeliveries deliveries) {
        //Validation
        if(deliveries == null)
            throw new IllegalArgumentException("Given SupDeliveries object must NOT be null");
        if(deliveries.getDeliveries().isEmpty() || deliveries.getDeliveries().size() == 0)
            return -1;

        //Initialise for loop to iterate over deliveries
        for (int i = 0; i < deliveries.getDeliveries().size(); i++) {
            //Update amount owed to each supplier by cost of delivery
            deliveries.getDeliveries().get(i).getItemRef().getSupplierRef().increaseAmountOwed(deliveries.getDeliveries().get(i).calculateDeliveryCost());
        }

        return 0;
    }

    //Create updateStock() method to decrease item stock by matching delivery item quantity
    /**
     * Decreases stock for delivered Item objects.
     * @param deliveries Given SupDeliveries object
     * @param stock Given Stock object
     * @return 0 if operation success, -1 otherwise.
     */
    public static int updateStock(SupDeliveries deliveries, Stock stock) {
        //Validation
        if(deliveries == null)
            throw new IllegalArgumentException("Given SupDeliveries object must NOT be null");
        if(stock == null)
            throw new IllegalArgumentException("Given Stock object must NOT be null");
        if(deliveries.getDeliveries().isEmpty() || deliveries.getDeliveries().size() == 0 || stock.getProducts().isEmpty() || stock.getProducts().size() == 0)
            return -1;

        //Initialise for loop to iterate over deliveries
        for (int i = 0; i < deliveries.getDeliveries().size(); i++) {
            //Decrease stock for each delivery
            stock.findItem(deliveries.getDeliveries().get(i).getItemRef().getName()).decreaseQuantity(deliveries.getDeliveries().get(i).getQuantity());
        }

        return 0;
    }

    public static int updateOnOrder(SupDeliveries deliveries, Stock stock, boolean onOrder) {
        //Validation
        if(deliveries == null)
            throw new IllegalArgumentException("Given SupDeliveries object must NOT be null");
        if(stock == null)
            throw new IllegalArgumentException("Given Stock object must NOT be null");
        if(deliveries.getDeliveries().isEmpty() || deliveries.getDeliveries().size() == 0 || stock.getProducts().isEmpty() || stock.getProducts().size() == 0)
            return -1;

        //Initialise for loop to iterate over deliveries
        for (int i = 0; i < deliveries.getDeliveries().size(); i++) {
            //Decrease stock for each delivery
            stock.findItem(deliveries.getDeliveries().get(i).getItemRef().getName()).setOnOrder(onOrder);
        }

        return 0;
    }
}