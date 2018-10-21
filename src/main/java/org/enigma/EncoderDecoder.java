package org.enigma;

import java.io.File;
import java.security.GeneralSecurityException;

public interface EncoderDecoder {

    String encode(String input) throws Exception;

    String encode(File input) throws Exception;

     void passwort(String input);



    String decode(String input) throws Exception;

    String decode(File input) throws Exception;



}
