package GroceryManager;

/**
 * Prajeet Pounraj
 * CSS 143, Tim Carlson
 * 3/9/2022
 * A subclass of GroceryItem. GroceryItems have more specific information
 * associated with them, depending upon their type (subclass).
 * Produce.java
 */
public class Produce extends GroceryItem {
    private boolean isOrganic;

    /**
     * Constructor that takes int quantity, String name, double price, and boolean
     * isOrganic and calls super to set the variables in the item class.
     * 
     * @param name
     * @param quantity
     * @param price
     * @param isOrganic
     */
    public Produce(String name, int quantity, double price, boolean isOrganic) {
        super(name, quantity, price);
        this.isOrganic = isOrganic;
    }

    /**
     * Constructor that takes in a string input and parses the String to get needed
     * information.
     * 
     * @param inputString
     */
    public Produce(String inputString) {
        String[] items = inputString.split(" ");
        setName(items[1]);
        setQuantity(Integer.parseInt(items[2]));
        setPrice(Double.parseDouble(items[3]));
        setIsOrganic(Boolean.parseBoolean(items[4]));
    }

    /**
     * Method that sets the private instance variable.
     * 
     * @param organic
     */
    public void setIsOrganic(Boolean organic) {
        this.isOrganic = organic;
    }

    /**
     * Method returns the instance variable.
     * 
     * @return
     */
    public boolean getIsOrangic() {
        return isOrganic;
    }

    /**
     * toString method that overrides the parent one and calls on super.
     */
    @Override
    public String toString() {
        return (super.toString() + String.format("%-25s\n",
                ("Organic: " + getIsOrangic())));
    }

}
