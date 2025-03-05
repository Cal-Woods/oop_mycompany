package OrderManagementSystem.Classes;

/**
 * Represents a discount supplier which is extended from Supplier class.
 */
public class DisSup extends Supplier {
    //Attributes
    double orderValueForDiscount;
    double discountPercentage;

    //Constructors
    /**
     * A no-argument constructor that sets attributes to default values.
     */
    public DisSup() {
        //Call Supplier super constructor
        super();

        //Initialise this object's attributes
        this.orderValueForDiscount = 0.00;
        this.discountPercentage = 0.00;
    }
}
