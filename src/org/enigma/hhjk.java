package org.enigma;

public class hhjk {
public static void main (final String[] args) {

    EncoderDecoder cipher = new FancyDecoderEncoder();
    System.out.println(cipher.encode("Ich bin da!"));
    System.out.println(cipher.decode("Jcnnq\"Ygnv#"));
  }
}

