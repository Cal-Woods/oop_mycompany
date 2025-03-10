package OrderManagementSystem.Version4;

//Import java Scanner class for getting user input
import java.util.Scanner;

//Required for Version4 as contains all classes
import OrderManagementSystem.Classes.*;

public class Version4App {
    public static void main(String[] args) {
        
    }

    /**
     * Takes a Scanner and uses it to get user input for a new Supplier object.
     * Supplier or DisSup class allowed.
     * 
     * @param keyboard A Scanner object: Must be set to System.in
     * 
     * @return The new Supplier object
     */
    private static Supplier getStoreSupplierType(Scanner keyboard) {
        //Prompt user
        System.out.println("Please enter a Supplier type: 'regular' or 'discount'");
        //Get user input from keyboard
        String supType = keyboard.next();

        //Check if supType is blank repeatedly
        while (supType.isBlank()) {
            //Print error & prompt
            System.out.print("That piece of text is blank! See above options.\nPlease re-enter supplier type: ");

            //Re-store keyboard input in supType
            supType = keyboard.next();
        }
        
        //Check if supType is incorrect repeatedly
        while (!supType.equalsIgnoreCase("regular") && !supType.equalsIgnoreCase("discount")) {
            System.out.println("\nThe value "+supType+" is not a valid option! See above options.\nPlease re-enter supplier type: ");


            //Re-store keyboard input in supType
            supType = keyboard.next();
        }

        //Declare Supplier supplier to store Supplier depending on previous keyboard input
        Supplier supplier = null;

        //Move keyboard token forward to remove '\n' character, needed for types other than String
        keyboard.nextLine();

        System.out.println("\nNow creating a "+supType+" supplier...");

        //Get Supplier details: prompt, then read from keyboard
        System.out.println("Please enter Supplier details.");

        System.out.print("\nSupplier name: ");
        String name = keyboard.nextLine();

        System.out.print("\n\nSupplier address: ");
        String address = keyboard.nextLine();

        //Remaining details
        System.out.print("\n\nAmount owed to Supplier: ");
        
        //Validate double inputs
        while (!keyboard.hasNextDouble()) {
            //Prompt/get input
            System.out.print("\n\nThe amount owed to Supplier was not in decimal format? Please re-enter value.\nAmount owed to Supplier: ");
            keyboard.next();
        }

        double amountOwed = keyboard.nextDouble();

        System.out.print("\n\nSupplier credit limit: ");

        //Validate double inputs
        while (!keyboard.hasNextDouble()) {
            //Prompt/get input
            System.out.print("\n\nThe Supplier credit limit was not in decimal format? Please re-enter value.\nSupplier credit limit: ");
            keyboard.next();
        }

        double creditLimit = keyboard.nextDouble();

        //Check if supType is regular or discount
        if(supType.equalsIgnoreCase("regular")) {
            //Set supplier to Supplier constructor with supplied details
            supplier = new Supplier(name, address, amountOwed, creditLimit);
        }

        else if(supType.equalsIgnoreCase("discount")) {
            //Get Supplier details
            System.out.println("\nPlease enter discount supplier specific details.");

            System.out.print("\nMinimum order value for discount: ");

            //Get extra details for DisSup, safely

            //Validate double inputs
            while (!keyboard.hasNextDouble()) {
                //Prompt/get input
                System.out.print("\n\nThe minimum order value for discount was not in decimal format? Please re-enter value.\n\nAmount owed to Supplier: ");
                keyboard.next();
            }

            double orderValueForDiscount = keyboard.nextDouble();

            //Prompt
            System.out.print("\n\nChoose what discount will be applied by this discount supplier: ");

            //Validate double inputs
            while (!keyboard.hasNextDouble()) {
                //Prompt/get input
                System.out.print("\n\nThe decimal discount applied was not in decimal format? Please re-enter value.\nAmount owed to Supplier: ");
                keyboard.next();
            }
            
            double discountApplied = keyboard.nextDouble();

            return new DisSup(name, address, amountOwed, creditLimit, orderValueForDiscount, discountApplied);

        }
        return supplier;
    }
}