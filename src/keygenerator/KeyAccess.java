/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keygenerator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author Acer
 */
public class KeyAccess {
    
    public static PublicKey getPublicKey(String path) throws Exception {
            byte[] keyBytes = Files.readAllBytes(Paths.get(path));
            //note convert the keyBytes into appropriate keyspec
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            return KeyFactory.getInstance("RSA").generatePublic(spec);

    }

    public static PrivateKey getPrivateKey(String path) throws Exception {
            byte[] keyBytes = Files.readAllBytes(Paths.get(path));
            //note convert the keyBytes into appropriate keyspec
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            return KeyFactory.getInstance("RSA").generatePrivate(spec);

    }

    public static Key getSecretKey(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
