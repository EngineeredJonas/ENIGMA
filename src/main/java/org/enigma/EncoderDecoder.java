package org.enigma;

import java.security.GeneralSecurityException;

public interface EncoderDecoder {

    String encode(String input) throws GeneralSecurityException;
    default void passwort (String input){

    }
    String decode(String input)throws GeneralSecurityException;

}