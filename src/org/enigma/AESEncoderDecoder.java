package org.enigma;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;

public class AESEncoderDecoder implements EncoderDecoder
{
    private SecureRandom rng = new SecureRandom();
    private SecretKey secretKey = new SecretKeySpec(
            rng.generateSeed(16),
            "AES");

    @Override
    public String encode(String input) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] iv = cipher.getIV();

            byte[] plaintext = input.getBytes(StandardCharsets.UTF_8);
            byte[] ciphertext = cipher.doFinal(plaintext);

            return DatatypeConverter.printHexBinary(iv) + ':' + DatatypeConverter.printHexBinary(ciphertext);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String decode(String input) {
        try {
            int colonIndex = input.indexOf(':');
            String ivHex = input.substring(0, colonIndex);
            String cipherHex = input.substring(colonIndex + 1);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(128, DatatypeConverter.parseHexBinary(ivHex)));

            byte[] plaintext = cipher.doFinal(DatatypeConverter.parseHexBinary(cipherHex));

            return new String(plaintext, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        EncoderDecoder cipher = new AESEncoderDecoder();

        String encrypted = cipher.encode("Hello World!");

        System.out.println(encrypted);


        String decrypted = cipher.decode((encrypted));

        System.out.println(decrypted);

    }
}
