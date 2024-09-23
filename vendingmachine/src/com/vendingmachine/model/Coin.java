package com.vendingmachine.model;

public enum Coin {
  PENNY(10),
  NICKEL(20),
  DIME(30);

  private int value;


  Coin(int value) {
    this.value = value;
  }

  public int getValue(){
    return value;
  }
}
