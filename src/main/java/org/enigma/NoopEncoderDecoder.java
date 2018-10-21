package org.enigma;

public abstract class NoopEncoderDecoder implements EncoderDecoder {

    @Override
    public String encode(String input) {
        return input;
    }

    @Override
    public String decode(String input) {
        return input;
    }

}
