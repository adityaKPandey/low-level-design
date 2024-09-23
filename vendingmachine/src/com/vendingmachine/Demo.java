package com.vendingmachine;

import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Inventory;
import com.vendingmachine.model.Item;
import com.vendingmachine.model.ItemShelf;
import com.vendingmachine.model.ItemType;
import com.vendingmachine.model.VendingMachine;
import com.vendingmachine.model.exception.VendingMachineException;
import com.vendingmachine.state.HasMoneyState;
import com.vendingmachine.state.IdleState;
import com.vendingmachine.state.ItemSelectionState;

public class Demo {

  public static void main(String [] args) throws VendingMachineException {

    //setup
    VendingMachine vendingMachine = new VendingMachine();

    Inventory inventory = new Inventory();
    inventory.addItem(new ItemShelf(new Item(ItemType.JUICE, 10), 1, false));
    inventory.addItem(new ItemShelf(new Item(ItemType.SODA, 15), 2, false));
    inventory.addItem(new ItemShelf(new Item(ItemType.PEPSI, 20), 3, false));
    inventory.addItem(new ItemShelf(new Item(ItemType.COKE, 30), 4, false));
    vendingMachine.setInventory(inventory);

    //insert coin
    vendingMachine.getState().pressInsertCoinButton(vendingMachine);
    vendingMachine.getState().insertCoin(vendingMachine, Coin.NICKEL);
    vendingMachine.getState().insertCoin(vendingMachine, Coin.PENNY);
    vendingMachine.getState().insertCoin(vendingMachine, Coin.DIME);

    //select product and dispense-> put it into dispense state and invokes dispense
    vendingMachine.getState().pressSelectProductButton(vendingMachine);
    vendingMachine.getState().selectProduct(vendingMachine, 2);


    vendingMachine.setState(new HasMoneyState());
    vendingMachine.getState().insertCoin(vendingMachine, Coin.DIME);
    vendingMachine.getState().pressSelectProductButton(vendingMachine);
    vendingMachine.getState().selectProduct(vendingMachine, 3);

    //cancel - refund

    //select product


  }
}
