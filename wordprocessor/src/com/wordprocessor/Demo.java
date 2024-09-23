package com.wordprocessor;

import com.wordprocessor.domain.ILetter;
import com.wordprocessor.factory.LetterFactory;

public class Demo {

  public static void main(String [] args){
    //write "HelloHello"

    ILetter letterH = LetterFactory.createLetter('H');
    letterH.display(0,0);


    ILetter letterE = LetterFactory.createLetter('e');
    letterE.display(0,1);



    ILetter letterL = LetterFactory.createLetter('l');
    letterL.display(0,2);


    letterL.display(0,8);


    ILetter letterO = LetterFactory.createLetter('o');
    letterO.display(0,4);



    letterH.display(0,6);
    letterE.display(0,7);
    letterL.display(0,3);
    letterL.display(0,9);
    letterO.display(0,10);

  }
}
