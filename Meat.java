package GroceryManager;

/**
 * Prajeet Pounraj
 * CSS 143, Tim Carlson
 * 3/9/2022
 * A subclass of GroceryIt/em. GroceryItems have more specific information
 * associated with them, depending upon their type (subclass).
 * Meat.java
 */
public class Meat extends GroceryItem {
    private boolean isGround;

    /**
     * Constructor that takes int quantity, String name, double price, and boolean
     * isGround and calls super to set the variables in the item class.
     * 
     * @param name
     * @param quantity
     * @param price
     * @param isGround
     */
    public Meat(String name, int quantity, double price, boolean isGround) {
        super(name, quantity, price);
        this.isGround = isGround;
    }

    /**
     * Constructor that takes in a string input and parses the String to get needed
     * information.
     * 
     * @param inputString
     */
    public Meat(String inputString) {
        String[] items = inputString.split(" ");
        setName(items[1]);
        setQuantity(Integer.parseInt(items[2]));
        setPrice(Double.parseDouble(items[3]));
        setisGround(Boolean.parseBoolean(items[4]));
    }

    /**
     * Method that sets the private instance variable.
     * 
     * @param isGround
     */
    public void setisGround(Boolean isGround) {
        this.isGround = isGround;
    }

    /**
     * Method returns the instance variable.
     * 
     * @return
     */
    public boolean getIsGround() {
        return this.isGround;
    }

    /**
     * toString method to print.
     */
    @Override
    public String toString() {
        return (super.toString() + String.format("%-25s\n", ("isGround: " + getIsGround())));
    }

}