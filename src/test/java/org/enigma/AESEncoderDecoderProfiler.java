package org.enigma;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class AESEncoderDecoderProfiler {

    private AESEncoderDecoder encoderDecoder;

    @Setup(Level.Invocation)
    public void setUp() {
        encoderDecoder = new AESEncoderDecoder();
    }

    @Benchmark
    public void keyDerivation() {
        encoderDecoder.passwort("secret password");
    }

    @Benchmark
    public void encryptionRoundtrip() throws Exception {
        String text = "short text";
        String encoded = encoderDecoder.encode(text);
        String decoded = encoderDecoder.decode(encoded);
        if (!text.equals(decoded)) {
            throw new IllegalStateException("decoded not equal to source");
        }
    }



    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
