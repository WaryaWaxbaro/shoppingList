package com.company;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<Item> shoppingItems;

    public ShoppingList(){
        this.shoppingItems = new ArrayList<>();
    }

    public boolean addNewItem(Item item){
        if(findItem(item.getName()) >= 0){
            System.out.println("Item is already in the list");
            return false;
        }

        shoppingItems.add(item);
        return true;
    }

    private int findItem(Item item){
        return this.shoppingItems.indexOf(item);
    }

    public boolean updateItem(Item oldItem, Item newItem){
        int foundItem = findItem(oldItem);
        if(foundItem < 0){
            System.out.println(oldItem.getName() + ", was not found");
            return false;
        }

        this.shoppingItems.set(foundItem, newItem);
        System.out.println(oldItem.getName() + ", has been updated");
        return true;
    }

    public boolean removeItem(Item item){
        int foundItem = findItem(item);
        if(foundItem < 0){
            System.out.println(item.getName() + ", was not found");
            return false;
        }

        this.shoppingItems.remove(foundItem);
        System.out.println(item.getName() + ", has been removed");

        return true;
    }

    private int findItem(String itemName){
        for (int i = 0; i < this.shoppingItems.size(); i++) {
            Item item = this.shoppingItems.get(i);
            if(item.getName().equals(itemName)){
                return i;
            }
        }

        return -1;
    }

    public String checkItem(Item item){
        if(findItem(item) >= 0){
            return item.getName();
        }

        return null;
    }

    public Item checkItem(String name){
        int pos = findItem(name);
        if(pos >= 0){
            return this.shoppingItems.get(pos);
        }

        return null;
    }

    public void showItems(){
        System.out.println("Available items in the list");
        /*for (Item item :
                shoppingItems) {
            System.out.println(item.getId() + " " + item.getName());
        }*/
        if(shoppingItems.size() == 0){
            System.out.println("No items in the list. Add some");
        }

        for (int i = 0; i < shoppingItems.size(); i++) {
            System.out.println(i + 1 + ". " + shoppingItems.get(i).getName());
        }
    }
}
