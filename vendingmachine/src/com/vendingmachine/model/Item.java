package com.vendingmachine.model;

import java.util.Objects;

public class Item {

  private ItemType type;
  private long price;

  public Item(ItemType type, long price) {
    this.type = type;
    this.price = price;
  }

  public long getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return type == item.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public String toString() {
    return "Item{" +
        "type=" + type +
        ", price=" + price +
        '}';
  }
}
