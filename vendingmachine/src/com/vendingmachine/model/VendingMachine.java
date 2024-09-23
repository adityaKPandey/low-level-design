package com.vendingmachine.model;

import com.vendingmachine.state.IdleState;
import com.vendingmachine.state.State;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

  private State state = new IdleState();
  private Inventory inventory;
  private List<Coin> coins = new ArrayList<>();

  public State getState() {
    return state;
  }

  public VendingMachine setState(State state) {
    this.state = state;
    return this;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public VendingMachine setInventory(Inventory inventory) {
    this.inventory = inventory;
    return this;
  }

  public List<Coin> getCoins() {
    return coins;
  }

  public VendingMachine setCoins(List<Coin> coins) {
    this.coins = coins;
    return this;
  }
}
