package com.vendingmachine.model;

public class ItemShelf {
    private Item item;
    private int code;
    private boolean soldOut;

  public ItemShelf(Item item, int code, boolean soldOut) {
    this.item = item;
    this.code = code;
    this.soldOut = soldOut;
  }

  public Item getItem() {
    return item;
  }

  public ItemShelf setItem(Item item) {
    this.item = item;
    return this;
  }

  public int getCode() {
    return code;
  }

  public ItemShelf setCode(int code) {
    this.code = code;
    return this;
  }

  public boolean isSoldOut() {
    return soldOut;
  }

  public ItemShelf setSoldOut(boolean soldOut) {
    this.soldOut = soldOut;
    return this;
  }
}
