package org.enigma;

public interface EncoderDecoder {

    String encode(String input);
    default void passwort (String input){

    }
    String decode(String input);

}
