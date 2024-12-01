package OrderManagementSystem.Version2;

import java.time.LocalDate;
import java.util.Scanner;

import OrderManagementSystem.Classes.*;

public class Version2App {
    public static void main(String[] args) {
    //Add Scanner object for getting user input. System.in = user input
    Scanner sc = new Scanner(System.in);

    //Print message
    System.out.println("This program represents an order management system. The first thing the program does is create a Stock class object. Then, the stock will have seven Item objects added to it.");
    //Declare Stock() object
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
    System.out.println("\nNow, The program creates three Delivery objects to place into a SupDeliveries ArrayList.");

    //Declare three Delivery objects
    Delivery delivery1 = new Delivery(stock.findItem("NVIDIA Gtx 1080TI"), 30, LocalDate.of(2025, 7, 6));
    Delivery delivery2 = new Delivery(stock.findItem(stock.findDearest()), 20, LocalDate.now());
    Delivery delivery3 = new Delivery(stock.findCheapest(), 26, LocalDate.MAX);

    //Create SupDeliveries object & add three Delivery objects
    SupDeliveries deliveries = new SupDeliveries();

    //Add delivery1, delivery2, delivery3 Delivery objects to deliveries using add() method
    deliveries.addDelivery(delivery1);
    deliveries.addDelivery(delivery2);
    deliveries.addDelivery(delivery3);

    //Test deliveries contains three Delivery objects
    deliveries.displayAllDeliveries();
    
    }
}
