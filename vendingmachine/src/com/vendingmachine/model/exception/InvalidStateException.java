package com.vendingmachine.model.exception;

public class InvalidStateException extends VendingMachineException{

  private String message;

  public InvalidStateException(String message){
    this.message = message;
  }
}
