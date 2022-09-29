package GroceryManager;

/**
 * Prajeet Pounraj
 * CSS 143, Tim Carlson
 * 3/9/2022
 * A subclass of GroceryItem. GroceryItems have more specific information
 * associated with them, depending upon their type (subclass).
 * Dairy.java
 */
public class Dairy extends GroceryItem {
    private int refrigerationTemperature;

    /**
     * Constructor that takes int quantity, String name, double price, and int
     * temp and calls super to set the variables in the item class.
     * 
     * @param name
     * @param quantity
     * @param price
     * @param refrigerationTemperature
     */
    Dairy(String name, int quantity, double price, int refrigerationTemperature) {
        super(name, quantity, price);
        setRefrigerationTemperature(refrigerationTemperature);
    }

    /**
     * Constructor that takes in a string input and parses the String to get needed
     * information.
     * 
     * @param inputString
     */
    public Dairy(String inputString) {
        String[] items = inputString.split(" ");
        setName(items[1]);
        setQuantity(Integer.parseInt(items[2]));
        setPrice(Double.parseDouble(items[3]));
        setRefrigerationTemperature(Integer.parseInt(items[4]));
    }

    /**
     * Method that sets the private instance variable.
     * 
     * @param refrigerationTemperature
     */
    public void setRefrigerationTemperature(int refrigerationTemperature) {
        this.refrigerationTemperature = refrigerationTemperature;
    }

    /**
     * Method returns the instance variable.
     * 
     * @return
     */
    public int getRefrigerationTemperature() {
        return refrigerationTemperature;
    }

    /**
     * toString method that overrides the parent one and calls on super.
     */
    @Override
    public String toString() {
        return (super.toString() + String.format("%-25s\n",
                ("Temperature: " + getRefrigerationTemperature())));
    }

}
