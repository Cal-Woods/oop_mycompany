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

    /**
     * Initialises DisSup instance with arguments for costBeforeDiscount & discountPercentage, as well as arguments
     * for initialising all parent Supplier attributes.
     * 
     * @param name Given Supplier name
     * @param address Given Supplier address
     * @param amountOwed Given amount owed to Supplier
     * @param creditLimit Given credit limit
     * @param orderValueForDiscount Given cost of order before discount is applied, for discount supplier
     * @param discountPercentage Given discount percentage
     */
    public DisSup(String name, String address, double amountOwed, double creditLimit, double orderValueForDiscount, double discountPercentage) {
        //Call super() with given Supplier parameters
        super(name, address, amountOwed, creditLimit);

        //Initialise DisSup attributes
        this.orderValueForDiscount = orderValueForDiscount;
        this.discountPercentage = discountPercentage;
    }

    //Getters
    /**
     * Gets the order value required for this discount supplier to give a discount.
     * 
     * @return The order value this discount supplier requires before giving a discount
     */
    public double getOrderValueForDiscount() {
        return this.orderValueForDiscount;
    }

    /**
     * Gets the discount percentage that is applied by this discount supplier.
     * 
     * @return The discount percentage to apply to orders
     */
    public double getDiscountPercentage() {
        return this.discountPercentage;
    }

    //Setters
    /**
     * Sets the order value required for a discount.
     * 
     * @param orderValueForDiscount Given order value for discount
     */
    public void setOrderValueForDiscount(double orderValueForDiscount) {
        //Set this.orderValueForDiscount to given orderValueForDiscount
        this.orderValueForDiscount = orderValueForDiscount;
    }

    /**
     * Sets instance discountPercentage to given discountPercentage.
     * 
     * @param discountPercentage Given discount percentage
     */
    public void setDiscountPercentage(double discountPercentage) {
        //Set this.discountPercentage to given discountPercentage
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return super.toString()+"Order value for discount: "+this.getOrderValueForDiscount()+"\nDiscount percentage: "+this.discountPercentage+"\n";
    }
}
