package edu.guilford;

/**
 *
 * @author bousabacw
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8"); // makes myKey into a byte array
            sha = MessageDigest.getInstance("SHA-1"); // creates a SHA-1 hash // secure hash algorithm 
            key = sha.digest(key); 
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES"); // makes the secret key using the array of bytes
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret);  
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);// this line encrypts the string
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);  // this line decrypts the string
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));// returns the decoded string
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    //get the key to be used in driver method 
    public static String getKey(){
        return new String(key);
    }
    //get the secret key to be used in driver method
    public static String getSecretKey(){
        return new String(secretKey.getEncoded());
    }
}
