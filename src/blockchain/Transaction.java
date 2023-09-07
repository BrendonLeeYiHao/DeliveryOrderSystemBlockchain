/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Transaction implements Serializable {

	// So, implement the Serializable interface when you need to store a
	// copy of the object, send them to another process which runs on the
	// same system or over the network. Because you want to store or send an
	// object. It makes storing and sending objects easy. It has nothing to do
	// with security.

	private static final long serialVersionUID = 1L;
	
	public String merkleRoot;

	public List<String> dataLst = new ArrayList<>();

	public void add(String tranx) {
            dataLst.add(tranx);
	}
	
	public String getMerkleRoot() {
		return merkleRoot;
	}
	
	public void setMerkleRoot(String merkleRoot) {
		this.merkleRoot = merkleRoot;
	}
	
	//newly added
	public List<String> getTranxLst(){
		return dataLst;
	}

        @Override
        public String toString() {
            return "Transaction{" + "merkleRoot=" + merkleRoot + ", dataLst=" + dataLst + '}';
        }
        
}
