/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchain;

import hashing.Hasher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Block implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Header blockHeader;
        
	public static List<Block> blocks = new ArrayList<>();

	public Header getBlockHeader() {
		return blockHeader;
	}
	
	//composition relationship
	public Block(String previousHash) {
            super();
            long now = System.currentTimeMillis();
            //Construct part object upon object construction
            this.blockHeader = new Header();
            this.blockHeader.setPreviousHash(previousHash);
            this.blockHeader.setTimeStamp(now);

            //hashing with sha256 - the input is joined with previousHash + now
            String currentHash = Hasher.sha256(String.join("+", previousHash, String.valueOf(now)));//hashing this block!
	    this.blockHeader.setCurrentHash(currentHash);
	}
	
	
	//composition relationship - inner class definition for part of object
        public class Header implements Serializable{

            private static final long serialVersionUID = 1L;

            //data member
            public int index;
            public String currentHash;
            public String previousHash;
            public long timeStamp;

            @Override
            public String toString() {
                    return "Header [index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash
                                    + ", timeStamp=" + timeStamp + "]";
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }
            
            public String getCurrentHash() {
                    return currentHash;
            }
            public void setCurrentHash(String currentHash) {
                    this.currentHash = currentHash;
            }
            public String getPreviousHash() {
                    return previousHash;
            }
            public void setPreviousHash(String previousHash) {
                    this.previousHash = previousHash;
            }
            public long getTimeStamp() {
                    return timeStamp;
            }
            public void setTimeStamp(long timeStamp) {
                    this.timeStamp = timeStamp;
            }
	}
	
	
	//aggregation relationship - weak relationship
	public Transaction tranxLst;
	
	public Transaction getTranx() {
            return tranxLst;  //return Transaction object
	}
	
	public void setTranxLst(Transaction tranxLst) {
            this.tranxLst = tranxLst;
	}
	
	@Override
	public String toString() {
            return "Block [blockHeader=" + blockHeader + ", tranxLst=" + tranxLst + "]";
	}

	
        public List<Block> getBlocksList() {
            return this.blocks;
        }

        public List<String> getTransactions() {
            List<String> transactions = new ArrayList<>();
            for (Block block : this.blocks) {
                List<String> transactionData = block.getTranx().getTranxLst();
                transactions.addAll(transactionData);
            }
            return transactions;
        }
	//Summary (Composition and Aggregation relationship)
	//Header will be instantiated upon block object construction. Transaction will be created outside of the block and we can set transaction in the block
}