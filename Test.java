package com.touch.weather.city;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String tt = desEncrypt();
		
		System.out.println(tt);

	}
	
	public static String encrypt() throws Exception {
        try {
            String data = "Test String中外";
            String key = "key1234567890key";
            String iv = "iv1234567890iviv";
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
 
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new sun.misc.BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String desEncrypt() throws Exception {
        try
        {
            String data = "4YzY6GLQANxGoF+FiPsOdr5w748JIHP5VqvyhJYo8S+C2agch7g8A1ZxwQYu7yDDnRGY0P0q4gIHe4H63Q1quzxdABAyMN227WRPzy2y/f8=";
            String key = "key1234567890key";
            String iv = "iv1234567890iviv";
 
            byte[] encrypted1 = new sun.misc.BASE64Decoder().decodeBuffer(data);
 
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
 
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
