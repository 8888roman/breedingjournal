package com.breedingjournal.crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;

/**
 * Created by b0663474 on 2017-10-26.
 */
public class Crypto {

    /*Hasło które posłuży do wygenerowania klucza dla algorytmu AES. Klucz szyfrujący to nie hasło.
    Hasło służy do wygenerowania klucza szyfrującego*/
    private static final char[] PASS = "haslo1234".toCharArray();
    private static final byte[] IV = "asde34rfasde34rf".getBytes();
    /*Sól dla dodatkowego bezpieczeństwa hasła*/
    private static final byte[] SALT = "agdrBTy1".getBytes();

    public byte[] aesEncryptData( byte[] dataToEncrypt) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidParameterSpecException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(PASS, SALT, 65536, 256);
        SecretKey secretKey = secretKeyFactory.generateSecret(spec);
        secretKey = new SecretKeySpec(secretKey.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(IV));
        return cipher.doFinal(dataToEncrypt);
    }

    public byte[] aesDecryptData(byte[] encryptedData) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidParameterSpecException, InvalidAlgorithmParameterException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(PASS, SALT, 65536, 256);
        SecretKey secretKey = secretKeyFactory.generateSecret(spec);
        secretKey = new SecretKeySpec(secretKey.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(IV));

        return cipher.doFinal(encryptedData);
    }
}
