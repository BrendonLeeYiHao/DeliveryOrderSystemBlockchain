/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashing;

import java.security.SecureRandom;

/**
 *
 * @author Acer
 */
public class Salt {
    public static byte[] generate(){
        //In summary, the generate() method of the Salt class creates a random byte 
        //array of length 16 using a cryptographically secure random number generator,
        //which can be used as a salt for cryptographic operations such as password hashing.
        int amount = 16;
        SecureRandom sr = new SecureRandom();
        byte[] b = new byte[amount];

        //generating user-specified number of random bytes 
        sr.nextBytes(b);
        return b;
    }
    
}
