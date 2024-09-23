package com.vendingmachine.state;

import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Item;
import com.vendingmachine.model.exception.InvalidStateException;
import com.vendingmachine.model.VendingMachine;

public class IdleState implements State{

  @Override
  public void pressInsertCoinButton(VendingMachine vendingMachine) {
     vendingMachine.setState(new HasMoneyState() );

  }

  @Override
  public void insertCoin(VendingMachine vendingMachine, Coin coin) throws InvalidStateException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void pressSelectProductButton(VendingMachine vendingMachine) throws InvalidStateException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void selectProduct(VendingMachine vendingMachine, Integer itemCode) throws InvalidStateException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void refund(VendingMachine vendingMachine) throws InvalidStateException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }

  @Override
  public void dispense(VendingMachine vendingMachine, Item item)throws InvalidStateException {
    throw new InvalidStateException("Idle state doesn't support inserting coins");
  }
}
