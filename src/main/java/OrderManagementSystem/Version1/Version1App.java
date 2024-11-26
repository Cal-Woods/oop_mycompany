package OrderManagementSystem.Version1;

import java.time.LocalDate;
import java.util.ArrayList;

import OrderManagementSystem.Classes.Delivery;
import OrderManagementSystem.Classes.Item;
import OrderManagementSystem.Classes.Supplier;

public class Version1App {
    public static void main(String[] args) {
        //Print message
        System.out.println("This program represents an order management system. This is CA1 of the OOP Module.[]");


        Supplier s1 = new Supplier();
        Supplier s2 = new Supplier("Cal Woods", "666 Hells Lane Los Angeles", 243.31, 4000.00);
        Supplier s3 = new Supplier("Colm O'Donoghue", "21 Sunset Boulevard California Los Angeles USA", 350.00, 4000.00);
        
        //Create Item[] for Item objects
        Item i1 = new Item();
        Item i2 = new Item("Shampoo", 6, 20, 24.99, new Supplier("Cal Woods", "12 Nunya Beeswax Drive, Co Louth, Ireland", 3000.00, 6000.00), true);
        Item i3 = new Item("Conditioner", 2, 24, 21.99, new Supplier("Aaron Lee", "111 Gambler's Rest, New Vegas, Mojave Desert, Nevada, USA", 1243.76, 3499.99), true);
        Item i4 = new Item("Shower Gel", 3, 45, 44.99, new Supplier(), false);
        Item i5 = new Item("Aftershave", 4, 65, 34.99, new Supplier(), false);
        
        //Store Item objects in arrays
        ArrayList<Item> items1 = new ArrayList<Item>();
        //Add i1, i2 Item objects to items1 ArrayList
        items1.add(i1);
        items1.add(i2);

        //Repeat process with items2 ArrayList for i3, i4, i5
        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(i3);
        items2.add(i4);
        items2.add(i5);
        
        Delivery d1 = new Delivery(items1, LocalDate.now());
        Delivery d2 = new Delivery(items1, LocalDate.now());
		Delivery d3 = new Delivery(items2, LocalDate.now());
		
		//Print Supplier details using Supplier.toString() for each supplier
        System.out.println(s1.toString());
        System.out.println(s2.toString());
		System.out.println(s3.toString());

		//Print blank line
        System.out.println("");

        //Print d1 cost
        System.out.println("The total cost of the first delivery is "+d1.calculateDeliveryCost()+" euro\n");
        
        //Print s3.getAmountOwed
        System.out.println("The total amount owed to supplier 3 is: "+s3.getAmountOwed()+" euro. After delivery 2 is complete, the amount owed to supplier 3 goes up to "+(s3.getAmountOwed()+d2.calculateDeliveryCost())+" euro.");
        
        //End of program
    }
}