package com.vendingmachine.state;

import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Item;
import com.vendingmachine.model.exception.InvalidStateException;
import com.vendingmachine.model.Inventory;
import com.vendingmachine.model.exception.ItemNotAvailableException;
import com.vendingmachine.model.ItemShelf;
import com.vendingmachine.model.VendingMachine;
import com.vendingmachine.model.exception.VendingMachineException;
import java.util.ArrayList;
import java.util.Objects;

public class ItemSelectionState implements State{

  @Override
  public void pressInsertCoinButton(VendingMachine vendingMachine) throws VendingMachineException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void insertCoin(VendingMachine vendingMachine, Coin coin) throws VendingMachineException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void pressSelectProductButton(VendingMachine vendingMachine)   throws VendingMachineException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void selectProduct(VendingMachine vendingMachine, Integer itemCode) throws VendingMachineException {
     vendingMachine.setState(new ItemSelectionState());
     checkInventory(vendingMachine, itemCode);
     ItemShelf itemShelf = vendingMachine.getInventory().getItem(itemCode);
     long balanceAmount = deductBalance(vendingMachine, itemShelf.getItem());
     if(balanceAmount < 0){
       System.out.println("Insufficient balance .. Please enter money or choose different product");
       return;
     }
     itemShelf.setSoldOut(true);
     vendingMachine.setState(new DispenseState(vendingMachine, itemShelf.getItem()));
  }

  private long deductBalance(VendingMachine vendingMachine, Item item) {
    long totalAmount = 0;
    for(Coin coin : vendingMachine.getCoins())
      totalAmount += coin.getValue();

    long refundAmount = totalAmount - item.getPrice();

    if (refundAmount > 0) {
      System.out.println("Refund amount " + refundAmount + " after dispensing");
      vendingMachine.setCoins(new ArrayList<>());
    }
    return refundAmount;
  }

  private void checkInventory(VendingMachine vendingMachine, Integer itemCode)
      throws ItemNotAvailableException {
     Inventory inventory = vendingMachine.getInventory();
     ItemShelf itemShelf = inventory.getItem(itemCode);
     if(Objects.nonNull(itemShelf) && !itemShelf.isSoldOut()){
        System.out.println("Item " + itemCode + " is available");
     }else {
       System.out.println("Item " + itemCode + " is not available");
       throw new ItemNotAvailableException(itemCode);
     }
  }

  @Override
  public void refund(VendingMachine vendingMachine) throws VendingMachineException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void dispense(VendingMachine vendingMachine, Item item) throws VendingMachineException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }
}
