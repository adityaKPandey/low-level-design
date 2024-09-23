package com.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Inventory {

    Map<Integer, ItemShelf> itemshelfs = new HashMap<>();

    public void addItem(ItemShelf itemshelf){
        itemshelfs.put(itemshelf.getCode(), itemshelf);
    }

    public ItemShelf getItem(Integer itemCode){
        return itemshelfs.get(itemCode);
    }

    public Optional<ItemShelf> findItem(Item item){
       return  itemshelfs.entrySet().stream().filter(entry -> entry.getValue().getItem().equals(item)).map(
           Entry::getValue).findFirst();
    }

}
