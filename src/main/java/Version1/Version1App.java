package Version1;

import java.time.LocalDate;

import Version1.Classes.Delivery;
import Version1.Classes.Item;
import Version1.Classes.Supplier;

public class Version1App {
    public static void main(String[] args) {
        //Print message
        System.out.println("This program represents an order management system. This is CA1 of the OOP Module.[]");


        Supplier s1 = new Supplier();
        Supplier s2 = new Supplier("Cal Woods", "666 Hells Lane Los Angeles", 243.31, 4000.00);
        Supplier s3 = new Supplier("Colm O'Donoghue", "21 Sunset Boulevard California Los Angeles USA", 350.00, 4000.00);
        
        //Create Item[] for Item objects
        Item i1 = new Item();
        Item i2 = new Item("Shampoo", 1, 6, 20, 30, 24.99, 1, true);
        Item i3 = new Item("Conditioner", 2, 24, 40, 30, 21.99, 2, true);
        Item i4 = new Item("Shower Gel", 3, 45, 50, 50, 44.99, 3, false);
        Item i5 = new Item("Aftershave", 4, 65, 80, 60, 34.99, 4, false);
        
        //Store Item objects in arrays
        Item[] items1 = {i1, i2};
        Item[] items2 = {i3, i4, i5};
        
        Delivery d1 = new Delivery(items1, LocalDate.now(), 2);
        Delivery d2 = new Delivery(items1, LocalDate.now(), 12);
		Delivery d3 = new Delivery(items2, LocalDate.now(), 30);
		
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