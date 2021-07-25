package com.java_basics.items_manager;

import java.util.ArrayList;

public class ItemsManager {

    ArrayList<String> items = new ArrayList<String>();

    /**
     * Print all items in the list to the console.
     */
    public void showItems(){
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println(i+1 + ". " + items.get(i));
        }
    }

    /**
     * Add a new item to the list.
     *
     * @param item
     *   The item that will be added.
     */
    public void addItem(String item) {
        this.items.add(item);
        System.out.println(item + " was added to the list.");
    }

    /**
     * Remove an item from the list.
     *
     * @param index
     *   The index+0 of the item in
     */
    public void removeItem(int index) {
        // The given number may not be 0.
        if(index == 0) {
            System.out.println("You must give a number greater than 0.");
            return;
        }

        // The given number may not be greater than the actual length of the list.
        if(index > this.items.size()){
            System.out.println("This item does not appear in your list");
            return;
        }
        this.items.remove(index-1);
        System.out.println("Item " + (index - 1) + " was checked off successfully.");
    }

    /**
     * Rename an entry in the list.
     *
     * @param index
     *   index+1 in the list.
     * @param newName
     *   The new name of the item.
     */
    public void renameItem(int index, String newName) {
        // The given number may not be 0.
        if(index == 0) {
            System.out.println("You must give a number greater than 0.");
            return;
        }

        // The given number may not be greater than the actual length of the list.
        if(index > this.items.size()){
            System.out.println("This item does not appear in your list");
            return;
        }

        this.items.set(index - 1, newName);
    }
}
