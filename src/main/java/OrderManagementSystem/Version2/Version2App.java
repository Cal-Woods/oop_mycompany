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
    stock.add(new Item("Microsoft 2-in-1 Keyboard", 34, 50, 80, 250.00, new Supplier("Roisin Mulligan", "13 Dundalk St, Dundalk, Co Louth, Ireland", 5000.00, 10000.00), true));
    stock.add(new Item("Microsoft Mouse", 60, 40, 145, 125.00, new Supplier("Stephen Larkin", "26 Doughiska Rd, Galway, Co. Galway, Ireland", 1280.50, 7500.00), false));
    stock.add(new Item("NVIDIA Gtx 1080TI", 55, 8, 35, 357.99, new Supplier("Nikolaos Pantelidis", "39 Rathmullen Rd, Drogheda, Co Louth, Ireland", 3500.00, 8000.00), false));
    stock.add(new Item("AMD Ryzen 3", 56, 60, 100, 200.00, new Supplier("Peter Gosling", "5 Williamsons Place, BlackRock, Dundalk, Co. Louth, Ireland", 2100.00, 3200.00), true));
    stock.add(new Item("Intel Core i9 13900X", 12, 40, 30, 10500.00, new Supplier("David O'Keefe", "7 Bellfield, Dundalk, Co Louth, Ireland", 12500.00, 30000.00), true));
    stock.add(new Item("CPU fan", 200, 90, 110, 59.99, new Supplier("Michelle Graham", "14 Cavanagarden Ballyshannon, Ballyshannon, Co. Donegal, Ireland", 6500.00, 32000.00), false));
    stock.add(new Item("12GB 2.0 USB-C", 31, 75, 75, 18.00, new Supplier("Amanda Clancy", "1 Georges Quay Dundalk, Dundalk, Co Louth, Ireland", 346.00, 2400.00), true));
    for (int i = 0; i < Supplier.getSuppliers().size(); i++) {
        System.out.println(Supplier.getSuppliers().get(i).getName());
    }
    }
}
