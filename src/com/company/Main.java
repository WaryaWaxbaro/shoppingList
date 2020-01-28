package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ShoppingList shoppingList = new ShoppingList();
    public static void main(String[] args) {
	// write your code here
        boolean stop = false;
        prepareList();
        showMenu();
        while (!stop){
            System.out.println("\n Choose an action. Press 6 to see available actions\n");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\n Program is quiting...");
                    stop = true;
                    break;
                case 1:
                    showItems();
                    break;
                case 2:
                    addNewItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    checkItem();
                    break;
                case 6:
                    showMenu();
                    break;
            }
        }
    }

    private static void addNewItem(){
        System.out.println("Item name: ");
        String name = scanner.nextLine();
        Item newItem = Item.createItem(name);
        if(shoppingList.addNewItem(newItem)){
            System.out.println("Item added to the list");
        }else {
            System.out.println("Error, Item " + name + " is already in the list");
        }
    }

    private static void updateItem(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Item oldItem = shoppingList.checkItem(name);
        if(oldItem == null){
            System.out.println("Item not found");
            return;
        }

        System.out.println("Enter new Item: ");
        String newName = scanner.nextLine();
        Item newItem = Item.createItem(newName);
        if(shoppingList.updateItem(oldItem, newItem)){
            System.out.println("Item updated successfully");
        }else {
            System.out.println("Error updating item");
        }
    }

    private static void removeItem(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Item oldItem = shoppingList.checkItem(name);
        if(oldItem == null){
            System.out.println("Item not found");
            return;
        }

        if(shoppingList.removeItem(oldItem)){
            System.out.println("Item deleted!");
        }else {
            System.out.println("Error deleting item");
        }
    }

    private static void checkItem(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Item oldItem = shoppingList.checkItem(name);
        if(oldItem == null){
            System.out.println("Item not found");
            return;
        }

        System.out.println(oldItem.getName());
    }

    private static void showItems(){
        shoppingList.showItems();
    }

    private static void prepareList(){
        System.out.println("List is ready!");
    }

    private static void showMenu(){
        System.out.println("\nPlease, follow the instructions to use the shopping list program");
        System.out.println("0 - to close the program \n" +
                "1 - To see all items in the list\n" +
                "2 - To add new item to the shopping list\n" +
                "3 - To update an item in the shopping list\n" +
                "4 - To remove an item in the shopping list\n" +
                "5 - To check if an item is available in the shopping list\n" +
                "6 - Print instructions\n");
        System.out.println("What do you want to do?");
    }
}
