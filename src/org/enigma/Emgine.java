package org.enigma;

public class Emgine {

    public static void main(final String[] args) {
        final EncoderDecoder encoderDecoder = new FancyDecoderEncoder();

        System.out.println(encoderDecoder.encode("Hello world"));
    }

}
