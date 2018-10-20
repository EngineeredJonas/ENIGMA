package org.enigma;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AESEncoderDecoder implements EncoderDecoder {

    private SecureRandom rng = new SecureRandom();
    private byte[] salt = "constant salt".getBytes(StandardCharsets.US_ASCII);
    private SecretKey secretKey = new SecretKeySpec(
            rng.generateSeed(16),
            "AES");


    public void passwort(String input){


        try {
            SecretKeyFactory keyFactory =
                    SecretKeyFactory.getInstance("PBKDF2WithHmacSHA384");
            KeySpec keySpec = new PBEKeySpec(input.toCharArray(), salt, 100000, 128);
            SecretKey pbeKey =  keyFactory.generateSecret(keySpec);
            secretKey = new SecretKeySpec(pbeKey.getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();

        }

    }
    @Override
    public String encode(String input) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] iv = cipher.getIV();

            byte[] plaintext = input.getBytes(StandardCharsets.UTF_8);
            byte[] ciphertext = cipher.doFinal(plaintext);

            return Base64.getEncoder().encodeToString(iv) + ':' + Base64.getEncoder().encodeToString(ciphertext);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String decode(String input) {
        try {
            int colonIndex = input.indexOf(':');
            String ivBase64 = input.substring(0, colonIndex);
            String cipherBase64 = input.substring(colonIndex + 1);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(128, Base64.getDecoder().decode(ivBase64)));

            byte[] plaintext = cipher.doFinal(Base64.getDecoder().decode(cipherBase64));

            return new String(plaintext, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args){
        EncoderDecoder cipher = new AESEncoderDecoder();
        cipher.passwort("secret");

        String encrypted = cipher.encode("Hello World!");
        System.out.println("encrypted: " + encrypted);

        String decrypted = cipher.decode((encrypted));
        System.out.println("decrypted: "+decrypted);

    }
}
