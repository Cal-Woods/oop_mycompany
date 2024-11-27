package OrderManagementSystem.Version2;

import java.util.Scanner;

import OrderManagementSystem.Classes.*;

public class Version2App {
    public static void main(String[] args) {
    //Add Scanner object
    Scanner sc = new Scanner(System.in);

    //Declare Stock() object
    Stock stock = new Stock();

    //Add 7 Item objects to stock
    stock.add(new Item("", 34, 50, 80, 250.00, new Supplier("Roisin Mulligan", "13 Dundalk St, Dundalk, Co Louth, Ireland", 5000.00, 10000.00), true));
    
    }
}
