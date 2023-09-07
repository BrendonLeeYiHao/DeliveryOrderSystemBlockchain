/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keygenerator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;


/**
 *
 * @author Acer
 */
public class MyKeyPair {
    
    private static final String ALGORITHM = "RSA";
	
    private KeyPairGenerator keygen;
    private KeyPair keyPair;
    private static PublicKey publicKey;
    private static PrivateKey privateKey;

    //get method for publicKey and privateKey
    public static PublicKey getPublicKey() {
        return publicKey;
    }

    public static PrivateKey getPrivateKey() {
        return privateKey;
    }

    public MyKeyPair() {
        try {
            keygen = KeyPairGenerator.getInstance(ALGORITHM);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void create() {
        MyKeyPair keyMaker = new MyKeyPair();
        //generate keypair
        keyMaker.keyPair = keyMaker.keygen.generateKeyPair();
        //get public key
        publicKey = keyMaker.keyPair.getPublic();
        //get private key
        privateKey = keyMaker.keyPair.getPrivate();
    }

    //DIR/publickey; DIR/privatekey
    public static void put(byte[] keyBytes, String path) {
        File f = new File(path);
        f.getParentFile().mkdir();
        try {
            Files.write(Paths.get(path), keyBytes, StandardOpenOption.CREATE);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
