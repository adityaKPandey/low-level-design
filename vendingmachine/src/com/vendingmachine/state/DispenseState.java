package com.vendingmachine.state;

import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Inventory;
import com.vendingmachine.model.Item;
import com.vendingmachine.model.ItemShelf;
import com.vendingmachine.model.VendingMachine;
import com.vendingmachine.model.exception.VendingMachineException;
import java.util.Optional;

public class DispenseState implements State{

  public DispenseState(VendingMachine vendingMachine, Item item){
    dispense(vendingMachine, item);
  }

  @Override
  public void pressInsertCoinButton(VendingMachine vendingMachine) throws VendingMachineException {

  }

  @Override
  public void insertCoin(VendingMachine vendingMachine, Coin coin) throws VendingMachineException {

  }

  @Override
  public void pressSelectProductButton(VendingMachine vendingMachine)
      throws VendingMachineException {

  }

  @Override
  public void selectProduct(VendingMachine vendingMachine, Integer itemCode)
      throws VendingMachineException {

  }

  @Override
  public void refund(VendingMachine vendingMachine) throws VendingMachineException {

  }

  @Override
  public void dispense(VendingMachine vendingMachine, Item item)  {
    Inventory inventory = vendingMachine.getInventory();
    Optional<ItemShelf> foundShelf = inventory.findItem(item);
    if(foundShelf.isPresent()){
       ItemShelf itemShelf = foundShelf.get();
       itemShelf.setSoldOut(true);
       System.out.println("Dispensed item " + item );
    }else{
      System.out.println("ERROR - Could not find item to dispense : " + item);
    }
  }

}
