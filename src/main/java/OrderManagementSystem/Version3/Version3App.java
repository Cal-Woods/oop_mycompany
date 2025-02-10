package OrderManagementSystem.Version3;

import OrderManagementSystem.Classes.Supplier;
import OrderManagementSystem.Classes.SupplierCollection;

public class Version3App {
    public static void main(String[] args) {
        SupplierCollection collection = new SupplierCollection("Binary-File");

        collection.add(new Supplier("Kaitling Phillips", "666 Hells Highway", 564.38, 6000.87));

        System.out.println(collection);
    }
}
