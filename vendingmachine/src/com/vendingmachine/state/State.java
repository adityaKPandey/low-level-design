package com.vendingmachine.state;

import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Item;
import com.vendingmachine.model.exception.InvalidStateException;
import com.vendingmachine.model.VendingMachine;
import com.vendingmachine.model.exception.VendingMachineException;

public interface State {

   void pressInsertCoinButton(VendingMachine vendingMachine) throws VendingMachineException;
   void insertCoin(VendingMachine vendingMachine, Coin coin) throws VendingMachineException;
   void pressSelectProductButton(VendingMachine vendingMachine) throws VendingMachineException;
   void selectProduct(VendingMachine vendingMachine, Integer itemCode) throws VendingMachineException;
   void refund(VendingMachine vendingMachine) throws VendingMachineException;
   void dispense(VendingMachine vendingMachine, Item item) throws VendingMachineException;

}
