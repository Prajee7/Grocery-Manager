package GroceryManager;


/**
 * Prajeet Pounraj
 * CSS 143, Tim Carlson
 * 03/09/2022
 * Grocery Exception class that handles exceptions for the Grocery Order.
 */
public class GroceryException extends Exception {
    public GroceryException() {
        super("Error: Illegal method operation.");
    }

    public GroceryException(String str) {
        super(str);
    }
}
