package GroceryManager;


import java.util.ArrayList;

public class GroceryOrder<T> extends ArrayList<T> {
    ArrayList<T> order;

    public GroceryOrder() {
        super();
        order = new ArrayList<T>();
    }
}
