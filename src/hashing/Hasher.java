/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashing;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Acer
 */
public class Hasher {
    
    	public static String sha256(String input) {
            return hash(input, "SHA256");
	}
        
        public static String sha256(String input, byte[] salt){
            return hash(input, "SHA256", salt);
        }
        
        private static String hash(String input, String algorithm) {
            var hashCode = "";
            try {
                //getInstance() method is used to return an object of MessageDigest type that applies the assigned MessageDigest algorithm
                var md = MessageDigest.getInstance(algorithm);
                //fetch the input byte arr into MessageDigest Instance
                md.update(input.getBytes());
                //digest the input byte arr
                byte[] hashBytes = md.digest();
                hashCode = Hex.encodeHexString(hashBytes);
            }catch(Exception e) {
                    e.printStackTrace();
            }
            return hashCode;
	}
        
        
        private static String hash(String input, String algorithm, byte[] salt) {
            var hashCode = "";
            try {
                var md = MessageDigest.getInstance(algorithm);
                //fetch the input byte arr into MessageDigest Instance
                md.update(input.getBytes());
                md.update(salt);
                //digest the input byte arr
                byte[] hashBytes = md.digest();
                //we can also convert it into hex format
                hashCode = Hex.encodeHexString(hashBytes);
            }catch(Exception e) {
                    e.printStackTrace();
            }
            return hashCode;
	}
        
        
}
