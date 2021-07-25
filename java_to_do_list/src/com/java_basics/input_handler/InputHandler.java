package com.java_basics.input_handler;

import com.java_basics.items_manager.ItemsManager;
import java.util.Scanner;

/**
 * Handle the input of the user in the command line.
 *
 * The user can choose between different operations to
 * perform on his/her To-Do List.
 */
public class InputHandler {
    /**
     * The scanner that reads the user input.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * The actual to do list.
     */
    private final ItemsManager items = new ItemsManager();

    /**
     * Let the user choose an operation to perform on the to do list.
     * The options are:
     *   List the items
     *   Add a new item
     *   Check off an item
     *   Update an item
     *   Quit the program
     */
    public void handleInput () {
        boolean quit = false;
        int choice = 0;

        while(!quit) {
            // Print the options available to the user.
            this.printInstructions();

            System.out.println("Please enter an option:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // Show all items in the list.
                case 1:
                    items.showItems();
                    break;
                // Add a new item to the list.
                case 2:
                    System.out.println("Please enter the name of the item you want to add:");
                    items.addItem(scanner.nextLine());
                    break;
                // Check off/remove an item.
                case 3:
                    System.out.println("Please enter the number of the item you want to check off:");
                    this.items.removeItem(scanner.nextInt());
                    break;
                // Update an item.
                case 4:
                    System.out.println("Please enter the number of the item you want to update:");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the new name for the item:");
                    String name = scanner.nextLine();
                    this.items.renameItem(index, name);
                    break;
                // Quit the program.
                case 5:
                    quit = true;
                    break;
            }
        }
    }

    /**
     * Print the available instructions the user can make.
     */
    private void printInstructions(){
        System.out.println("You have the following options available");
        System.out.println("\t 1 - List all items in your To-Do List.");
        System.out.println("\t 2 - Add a new item to your To-Do List.");
        System.out.println("\t 3 - Check off an item of to your To-Do List.");
        System.out.println("\t 4 - Update an item of to your To-Do List.");
        System.out.println("\t 5 - Quit the program.");
    }
}
