/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blockchainassignment;

import blockchain.Block;
import blockchain.Blockchain;
import blockchain.Transaction;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.security.MessageDigest;
import java.util.LinkedList;
import org.apache.commons.codec.binary.Hex;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.JSONObject;
import org.json.JSONArray;
/**
 *
 * @author Acer
 */
public class BlockchainAssignment {

    private static final String masterFolder = "master";
    private static final String fileName = masterFolder + "/chain.bin";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        LoginPage lp = new LoginPage();
        lp.setVisible(true);
        
        Blockchain bc = Blockchain.getInstance(fileName);
        if(!new File(masterFolder).exists()) {
            System.err.println("> creating Blockchain binary!");
            new File(masterFolder).mkdir();
            bc.genesis();
        } 
    }
    
}
