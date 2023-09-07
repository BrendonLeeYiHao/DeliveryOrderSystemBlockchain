/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchainassignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Delivery {
    
    private String sender;
    private String orderID;
    private String vehiclePlate;
    private String currentLocation;
    private String deliveryman;
    
    public Delivery(String sender, String orderID, String vehiclePlate, String currentLocation, String deliveryman) {
//    public ShipmentOrder(String orderID, String senderAddress, String recipientAddress, String parcelDimension, String weight, String fragility, String description, String paymentMethod, String paymentAmount, String deliveryman){
        this.sender = sender;
        this.orderID = orderID;
        this.vehiclePlate = "";
        this.currentLocation = "";
        this.deliveryman = deliveryman;
    }
    
    public Delivery() {
    }
    
    public void addBlockIndexIntoFile(String username, int index,String orderID, String secretKeyString, String deliveryman, String vehiclePlate, String currentLocation){
        Path indexFile = Paths.get("BlockIndex.txt");
        String indexLine = username + " , " + String.valueOf(index) + " , " + orderID + " , " + secretKeyString + " , " + deliveryman + " , " + vehiclePlate + " , " + currentLocation + "\n";
        
        try {
            Files.write(indexFile, indexLine.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}