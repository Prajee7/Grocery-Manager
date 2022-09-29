package GroceryManager;

/**
 * Prajeet Pounraj
 * CSS 143, Tim Carlson
 * 3/9/2022
 * an abstract class that implements Comparable. GroceryItems are things like
 * milk, lettuce, and bread. Each has a price. If they are stocked in the store,
 * they also have a quantity.
 */
public abstract class GroceryItem implements Comparable {
    private String name;
    private int quantity;
    private double price;

    /**
     * No-Arg Constructor that sets name to null, sets quantity to 0 and price to
     * 0.0.
     */
    public GroceryItem() {
        name = null;
        quantity = 0;
        price = 0.0;
    }

    /**
     * Constructor that takes in parameters that sets the instace variables.
     * 
     * @param name
     * @param quantity
     * @param price
     */
    public GroceryItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Setter that sets name. (Mutator)
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter that returns name. (Accessor)
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter that sets price. (Mutator)
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter that returns price. (Accessor)
     * 
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter that sets quantity. (Mutator)
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter that returns quantity. (Accessor)
     * 
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * toString method that returns the Name, Price and the Quantity of products
     */
    @Override
    public String toString() {
        return (String.format("%-25s%-25s%-25s", ("Name: " + getName()), ("Quantity: " + getQuantity()),
                ("Price: $" + getPrice())));

    }

    /**
     * CompareTo method that returns 1 if the name, price, and quantity are all the
     * same and returns 0 if its not and -1 if the object does not match.
     * 
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof GroceryItem) {
            GroceryItem other = (GroceryItem) o;
            if (other.getName().equalsIgnoreCase(this.getName())) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

}