/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keygenerator;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;

/**
 *
 * @author Acer
 */
public class RandomSecretKey {
    
    public static Key create()
    {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(256, new SecureRandom());
            return kg.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
