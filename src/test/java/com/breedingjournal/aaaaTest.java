package com.breedingjournal;


import com.breedingjournal.crypto.Crypto;
import org.junit.Test;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Base64;


public class aaaaTest {

   Crypto crypto = new Crypto();


@Test

public void aas() throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidParameterSpecException, InvalidKeyException, InvalidKeySpecException {
   byte[] hasss = "Qgx1_mztc".getBytes();
    byte[] haslo = crypto.aesEncryptData(hasss);
    String zaszys = Base64.getEncoder().encodeToString(haslo);
   System.out.println(zaszys);
}
    @Test
    public void aaws() throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidParameterSpecException, InvalidKeyException, InvalidKeySpecException {
 byte[]  encodedPass = Base64.getDecoder().decode("jws4PQOAL6ak4EnxCR+EHQ==");

    byte[] decodedPass = crypto.aesDecryptData(encodedPass);

        System.out.println(new String(decodedPass));

    }
   }