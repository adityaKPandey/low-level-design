package com.vendingmachine.state;

import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Item;
import com.vendingmachine.model.exception.InvalidStateException;
import com.vendingmachine.model.VendingMachine;
import com.vendingmachine.model.exception.VendingMachineException;

public class HasMoneyState implements State{

  @Override
  public void pressInsertCoinButton(VendingMachine vendingMachine) throws VendingMachineException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void insertCoin(VendingMachine vendingMachine, Coin coin) throws VendingMachineException  {
    vendingMachine.setState(new HasMoneyState());
    vendingMachine.getCoins().add(coin);
  }

  @Override
  public void pressSelectProductButton(VendingMachine vendingMachine) throws VendingMachineException  {
     vendingMachine.setState(new ItemSelectionState());
  }

  @Override
  public void selectProduct(VendingMachine vendingMachine, Integer itemCode) throws VendingMachineException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void refund(VendingMachine vendingMachine) throws VendingMachineException{
    vendingMachine.setState(new IdleState());
  }

  @Override
  public void dispense(VendingMachine vendingMachine, Item item) throws VendingMachineException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }
}
