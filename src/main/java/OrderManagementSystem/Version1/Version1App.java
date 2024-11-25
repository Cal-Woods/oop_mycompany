package OrderManagementSystem.Version1;

import java.time.LocalDate;
import java.util.ArrayList;

import OrderManagementSystem.Classes.Delivery;
import OrderManagementSystem.Classes.Item;
import OrderManagementSystem.Classes.Supplier;

public class Version1App {
    public static void main(String[] args) {
        //Print message
        System.out.println("This program represents an order management system. This is CA1 of the OOP Module.");


        Supplier s1 = new Supplier("Roisin Mulligan", "122 Lecturers Lane, Dundalk, Co Louth, IE", 450.00, 2345.76);
        Supplier s2 = new Supplier("Cal Woods", "666 Hells Lane Los Angeles", 243.31, 4000.00);
        Supplier s3 = new Supplier("Colm O'Donoghue", "21 Sunset Boulevard California Los Angeles USA", 350.00, 4000.00);
        
        //Create Item[] for Item objects
        Item i1 = new Item();
        Item i2 = new Item("Shampoo", 6, 20, 30, 24.99, s1, true);
        Item i3 = new Item("Conditioner", 24, 40, 30, 21.99, s2, true);
        Item i4 = new Item("Shower Gel", 45, 50, 50, 44.99, s3, false);
        Item i5 = new Item("Aftershave", 65, 80, 60, 34.99, s1, false);
        
        //Store Item objects in arrays
        ArrayList<Item> items1 = new ArrayList<Item>(2);

        //Add to ArrayList items1
        items1.add(i1);
        items1.add(i2);

        //Repeat process for Delivery
        Item[] items2 = {i3, i4, i5};
        
        Delivery d1 = new Delivery(items1, LocalDate.now(), 2);
        Delivery d2 = new Delivery(items1, LocalDate.now(), 12);
		
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