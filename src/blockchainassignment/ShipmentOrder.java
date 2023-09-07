/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchainassignment;

import blockchain.Block;
import blockchain.Blockchain;
import blockchain.Transaction;
import com.google.gson.GsonBuilder;
import crypto.Symmetric;
import digitalsignature.MySignature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import keygenerator.KeyAccess;
import keygenerator.RandomSecretKey;

/**
 *
 * @author Acer
 */
public class ShipmentOrder {
    
    private String sender;
    private String orderID;
    private String senderAddress;
    private String recipientAddress;
    private String parcelDimension;
    private String weight;
    private String fragility;
    private String description;
    private String paymentMethod;
    private String paymentAmount;
    private String deliveryman;
    
    public ShipmentOrder(String sender, String orderID, String senderAddress, String recipientAddress, String parcelDimension, String weight, String fragility, String description, String paymentMethod, String paymentAmount, String deliveryman) {
        this.sender = sender;
        this.orderID = orderID;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.parcelDimension = parcelDimension;
        this.weight = weight;
        this.fragility = fragility;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.deliveryman = deliveryman;
    }

//

    @Override
    public String toString() {
        return "ShipmentOrder{" + "sender=" + sender + ", orderID=" + orderID + ", senderAddress=" + senderAddress + ", recipientAddress=" + recipientAddress + ", parcelDimension=" + parcelDimension + ", weight=" + weight + ", fragility=" + fragility + ", description=" + description + ", paymentMethod=" + paymentMethod + ", paymentAmount=" + paymentAmount + ", deliveryman=" + deliveryman + '}';
    }
    

    public void addOrder(String username) throws Exception{
        Symmetric symm = new Symmetric();
        Key secretKey = RandomSecretKey.create();
        String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        senderAddress = symm.encrypt(senderAddress, secretKey);
        recipientAddress = symm.encrypt(recipientAddress, secretKey);
        paymentMethod = symm.encrypt(paymentMethod, secretKey);
        paymentAmount = symm.encrypt(paymentAmount, secretKey);
        
        String transaction = sender + " , " + orderID + " , " + senderAddress + " , " + recipientAddress + " , " + parcelDimension + " , " + weight + " , " + fragility + " , " + description + " , " + paymentMethod + " , " + paymentAmount + " , " + deliveryman;
        
        PublicKey publicKey = KeyAccess.getPublicKey("AllKeyPair/"+username+"PublicKey");
        PrivateKey privateKey = KeyAccess.getPrivateKey("AllKeyPair/"+username+"PrivateKey");
        MySignature sig = new MySignature();
        String signature = sig.sign(transaction, privateKey);
        
        if(sig.verify(transaction, signature, publicKey)){
            TimeUnit.SECONDS.sleep(5);
            JOptionPane.showMessageDialog(null, "Verified Successfully!");
            Transaction tranxLst = new Transaction();
            tranxLst.add(transaction);
            
            Blockchain bc = Blockchain.getInstance("master/chain.bin");
            String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
            int index = bc.get().getLast().getBlockHeader().getIndex();
            Block b1 = new Block( previousHash );
            b1.getBlockHeader().setIndex( index + 1);
            b1.setTranxLst(tranxLst);
            bc.nextBlock(b1);
            bc.distribute();
            addBlockIndexIntoFile(username, index+1, secretKeyString, deliveryman);
        }
        else{
            System.out.println("Verification failed!");
        }      
    }
    
    static Predicate<String> validAddress = address -> address.length() > 10;
    
    static Predicate<String> validWeights = weights -> {
        try{
            return Double.parseDouble(weights) >= 0.1 && Double.parseDouble(weights) <= 100;
        }
        catch(NumberFormatException e){
            return false;
        }
    };
    
    static Predicate<String> validDescription = itemDescription -> itemDescription.length() > 2;
    
    static Function<Double,Integer> showDeliveryFees = weights -> {
        if(weights >= 0.1 && weights <= 10){
            return 5;
        }
        else if(weights > 10 && weights <= 30){
            return 8;
        }
        else if(weights > 30 && weights <= 50){
            return 10;
        }
        else{
            return 15;
        }
    };
    
    public static boolean confirmAddOrder(String orderID, String sender, String recipient, String dimension, String weight, String fragility, String description, String paymentMethod, String amount, String deliveryman){
        int dialogResult = JOptionPane.showConfirmDialog(null, "Check Shipment order details below:\nOrderID: " + orderID + "\nSender Address: "+sender+"\nRecipient Address: "+recipient+"\nDimension: "
                + ""+dimension+"\nWeight: "+weight+"\nFragility: "+fragility+"\nDescription: "+description+"\nPayment Method: "+paymentMethod+"\nPayment Amount: "+amount+"\nDeliveryman: "+deliveryman,"Confirmation",JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    public void addBlockIndexIntoFile(String username, int index, String secretKeyString, String deliveryman){
        Path indexFile = Paths.get("BlockIndex.txt");
        String indexLine = username + " , " + String.valueOf(index) + " , " + secretKeyString + " , " + deliveryman + "\n";
        
        try {
            Files.write(indexFile, indexLine.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
