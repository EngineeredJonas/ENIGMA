package org.enigma;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AESEncoderDecoder implements EncoderDecoder {

    private SecureRandom rng = new SecureRandom();
    private byte[] salt = "constant salt".getBytes(StandardCharsets.US_ASCII);
    private SecretKey secretKey = new SecretKeySpec(
            rng.generateSeed(16),
            "AES");


    public void passwort(String input) {


        try {
            SecretKeyFactory keyFactory =
                    SecretKeyFactory.getInstance("PBKDF2WithHmacSHA384");
            KeySpec keySpec = new PBEKeySpec(input.toCharArray(), salt, 100000, 128);
            SecretKey pbeKey = keyFactory.generateSecret(keySpec);
            secretKey = new SecretKeySpec(pbeKey.getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();

        }

    }

    @Override
    public String encode(String input) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {

        byte[] plaintext = input.getBytes(StandardCharsets.UTF_8);
        return encodeBytes(plaintext);

    }

    public String encode(File input) throws IOException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {


        byte[] plaintext = Files.readAllBytes(input.toPath());
        Files.write(Paths.get(input.getAbsolutePath() + ".encrypted"), encodeBytes(plaintext).getBytes());
        return "ok";

    }

    public String encodeBytes(byte[] plaintext) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] iv = cipher.getIV();


        byte[] ciphertext = cipher.doFinal(plaintext);

        return Base64.getEncoder().encodeToString(iv) + ':' + Base64.getEncoder().encodeToString(ciphertext);


    }


    @Override
    public String decode(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        return new String(decodeBytes(input), StandardCharsets.UTF_8);

    }

    public byte[] decodeBytes(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {
        int colonIndex = input.indexOf(':');
        String ivBase64 = input.substring(0, colonIndex);
        String cipherBase64 = input.substring(colonIndex + 1);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(128, Base64.getDecoder().decode(ivBase64)));
        return cipher.doFinal(Base64.getDecoder().decode(cipherBase64));
    }

    public String decode(File input) throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        String content = new String(Files.readAllBytes(input.toPath()));
        byte[] plaintext = decodeBytes(content);
        String decrytedfilename = input.getAbsolutePath().replaceAll(".encrypted", "");
        Files.write(Paths.get(decrytedfilename), plaintext);
        return "ok!";
    }

    public static void main(String[] args) throws URISyntaxException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, IOException {
        AESEncoderDecoder cipher = new AESEncoderDecoder();
        cipher.passwort("secret");

        String encrypted = cipher.encode("Mac Book 2013");
        System.out.println("encrypted: " + encrypted);

        String decrypted = cipher.decode((encrypted));
        System.out.println("decrypted: " + decrypted);

        System.out.println("Dateitest");

        //File f = new File(AESEncoderDecoder.class.getResource("rain.mp3").toURI());
       // System.out.println(f.exists());
       // System.out.println(cipher.encode(f));

        System.out.println(cipher.decode(new File(AESEncoderDecoder.class.getResource("Rain.mp3.encrypted").toURI())));

    }
}
