package com.wordprocessor.domain;

public class DocumentCharacter implements ILetter{

  private char character;
  private int fontSize;
  private String fontType;

  public DocumentCharacter(char character, int fontSize, String fontType) {
    this.character = character;
    this.fontSize = fontSize;
    this.fontType = fontType;
  }

  @Override
  public void display(int row, int col) {
    //System.out.println("print " + character + " at position row = " + row + " , col = " + col);
    System.out.print(character);
  }
}
