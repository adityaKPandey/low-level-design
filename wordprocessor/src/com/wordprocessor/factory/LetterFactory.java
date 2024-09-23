package com.wordprocessor.factory;

// letter cache for flyweight object of class DocumentCharacter

import com.wordprocessor.domain.DocumentCharacter;
import com.wordprocessor.domain.ILetter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class LetterFactory {
     private static Map<Character, ILetter> characterCache = new HashMap<>();

     public static final int DEFAULT_FONT_SIZE = 10;
     public static final String DEFAULT_FONT_TYPE = "Arial";


     public static ILetter createLetter(char letter){
          ILetter cachedLetter = characterCache.get(letter);
          if(Objects.isNull(cachedLetter)){
               cachedLetter = new DocumentCharacter(letter, DEFAULT_FONT_SIZE, DEFAULT_FONT_TYPE);
               characterCache.put(letter, cachedLetter);
          }

          return cachedLetter;
     }
}
