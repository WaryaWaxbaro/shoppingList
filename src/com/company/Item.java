package com.company;

public class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Item createItem(String name){
        return new Item(name);
    }
}
