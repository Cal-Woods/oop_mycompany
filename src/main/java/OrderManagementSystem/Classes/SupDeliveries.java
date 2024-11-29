package OrderManagementSystem.Classes;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class SupDeliveries {
    //Declare ArrayList<Delivery> inComing
    ArrayList<Delivery> inComing = new ArrayList<Delivery>(0);

    //Gettees
    public ArrayList<Delivery> getDeliveries() {
        return inComing;
    }

    //Mutator methods
    /**
     * Adds a Delivery object to SupDeliveries inComing ArrayList<Delivery>.
     * @param delivery An object of Delivery class
     * @return A boolean indicating operation success
     */
    public boolean addDelivery(Delivery delivery) {
        //Validation
        if(delivery == null)
            throw new IllegalArgumentException("Given delivery object must NOT be null.");

        this.getDeliveries().add(delivery);
        return true;
    }

    /**
     * Searches ArrayList<Delivery> for Delivery objects on particular days
     * @param day A three character String, containing a case-insensitive abbreviated day. E.g. "mon" or "THU" or "SaT"
     * @return 
     */
    public ArrayList<Delivery> findAllDeliveries(LocalDate day) {
        //Validation
        if(getDeliveries().size() == 0)
            return new ArrayList<Delivery>();

        //Declare ArrayList<Delivery> deliveries
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();


        //Initialise for loop to iterate through ArrayList<Delivery>
        for (int i = 0; i < getDeliveries().size(); i++) {
            //Compare Delivery object date day of week as String, to 
            if(getDeliveries().get(i).getDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).equalsIgnoreCase(day.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH))) {
                //Store current Delivery object in deliveries
                deliveries.add(getDeliveries().get(i));
            }
        }
        
        return deliveries;
    }

    public ArrayList<Delivery> findAllDeliveries(String itemName) {
        //Validation
        if(itemName == null)
            throw new IllegalArgumentException("Given Item object must NOT be null.");

        if(itemName.isBlank())
            return new ArrayList<Delivery>();

        if(getDeliveries().size() == 0)
            return new ArrayList<Delivery>();


        //Declare ArrayList<Delivery> deliveries
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();

        //Initialise for loop to iterate through ArrayList<Delivery>
        for (int i = 0; i < getDeliveries().size(); i++) {
            //Check if current Delivery Item matches given Item object
            if(getDeliveries().get(i).getItemRef().getName().equalsIgnoreCase(itemName)) {
                
                //Add matching item to deliveries method ArrayList<Delivery>
                deliveries.add(getDeliveries().get(i));
            }
        }
        return deliveries;
    }
}
