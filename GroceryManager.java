package GroceryManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.ArrayList;

public class GroceryManager {
    ArrayList<GroceryItem> inventory;
    HashSet<String> restockingList;

    /**
     * No - Arg Constructor.
     */
    public GroceryManager() {
        inventory = new ArrayList<>();
        restockingList = new HashSet<>();
    }

    /**
     * This method reads the file and takes in a parameter for the file name. reads
     * input and populates inventory Calls appropriate constructor with input
     * line.The input file starts with 3 integers, representing the number of Dairy,
     * Produce, and Meat items to follow.
     * 
     * @param string
     */
    public void loadInventory(String string) {
        Scanner scan = null;
        int dairyInt = 0, meatInt = 0, produceInt = 0;
        String line = "";

        try {
            scan = new Scanner(new FileInputStream(string));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        while (scan.hasNext()) {
            dairyInt = scan.nextInt();
            produceInt = scan.nextInt();
            meatInt = scan.nextInt();
            scan.nextLine();

            while (dairyInt != 0) {
                line = scan.nextLine();
                inventory.add(new Dairy(line));
                dairyInt--;
            }

            while (produceInt != 0) {
                line = scan.nextLine();
                inventory.add(new Produce(line));
                produceInt--;
            }

            while (meatInt != 0) {
                line = scan.nextLine();
                inventory.add(new Meat(line));
                meatInt--;
            }
        }

    }

    /**
     * Subtracts the items and quantities in the order from the inventory. If
     * the order has more than is in stock, fill it with whatever quantity is
     * available. Be careful not to go below 0. If inventory goes to 0, add to
     * restocking list. If the quantity ordered is greater than the quantity in
     * inventory, throw a GroceryException with message “out of xxxx”, but keep on
     * going. If an item in the order is not in inventory, also throw a
     * GroceryException but keep going.
     * 
     * @param order
     */
    public void processOrder(GroceryOrder<GroceryItem> order) throws GroceryException {
        ArrayList<String> tempList = new ArrayList<>();
        for (GroceryItem item : order) {
            for (GroceryItem item2 : inventory) {
                if (item.getName().compareTo(item2.getName()) == 1) {
                    int orderQuantity = item.getQuantity();
                    int invnQuantity = item2.getQuantity();
                    if (orderQuantity > invnQuantity) {
                        item.setQuantity(0);
                        restockingList.add(item.getName());
                        String str = item.getName();
                        if (!(tempList.contains(str))) {
                            tempList.add(str);
                            System.out.println("Out Of " + str);
                        }
                    } else {
                        item2.setQuantity(item2.getQuantity() - item.getQuantity());
                    }
                }
            }
        }
    }

    /**
     * Takes in string of item and searches the arraylist for the item and returns
     * null if not found.
     *
     * @param name
     * @return
     */
    public GroceryItem findItemByName(String name) {
        for (GroceryItem items : inventory) {
            if (items.getName().equals(name)) {
                return items;
            }
        }
        return null;
    }

    /**
     * Use BubbleSort, and use compareTo() to sort by name.
     */
    public void sortInventoryByName() {
        boolean order = true;
        GroceryItem item1;
        int index = 1;
        while (order) {
            order = false;
            for (int i = 0; i < inventory.size() - index; i++) {
                if (inventory.get(i).getName().compareTo(inventory.get(i + 1).getName()) > 0) {
                    item1 = inventory.get(i + 1);
                    inventory.set(i + 1, inventory.get(i));
                    inventory.set(i, item1);
                    order = true;
                }
            }
            index++;
        }
    }

    /**
     * insertionSort to sort the list without using .compareTo.
     */
    public void sortInventoryByPrice() {
        GroceryItem item1;
        int size = inventory.size();

        for (int i = 1; i < size; i++) {
            int index = i - 1;
            item1 = inventory.get(i);
            while (index >= 0 && inventory.get(index).getPrice() > item1.getPrice()) {
                inventory.set(index + 1, inventory.get(index));
                index--;
            }
            inventory.set(index + 1, item1);
        }
    }

    /**
     * List inventory with all their class-specific data. Line up columns for
     * readability. Use overloads of toString() from each class.
     */
    public void displayInventory() {
        for (GroceryItem item : inventory) {
            // System.out.print(item.toString());
            if (item instanceof Dairy) {
                System.out.print(((Dairy) item).toString());
            } else if (item instanceof Produce) {
                System.out.print(((Produce) item).toString());
            } else {
                System.out.print(((Meat) item).toString());
            }
        }
    }

    /**
     * Print the list of items that need to be restocked.
     */
    public void displayRestockingList() {
        for (String item : restockingList) {
            System.out.println(item);
        }
    }

}
