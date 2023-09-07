/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchain;

import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 *
 * @author Acer
 */
public class Blockchain {
    // data structure
    private static LinkedList<Block> db = new LinkedList<>();
    /**
     * singleton pattern
     */
    private static Blockchain _instance;
    public static Blockchain getInstance( String chainFile ) {
        if(_instance == null)
            _instance = new Blockchain( chainFile );
        return _instance;
    }
    
    public String chainFile;
    public Blockchain(String chainFile) {
        super();
        this.chainFile = chainFile;
        System.out.println( "> Blockchain object is created!" );
    }
    /**
     * genesis()
     */
    public void genesis()
    {
        Block genesis = new Block("0");
        db.add(genesis);
        persist();
    }
    /**
     * nextBlock()
     */
    public void nextBlock(Block newBlock)
    {
    	//Newly Added
    	MerkleTree mt = MerkleTree.getInstance(newBlock.getTranx().getTranxLst());
    	mt.build();
    	String merkleRoot = mt.getRoot();
    	newBlock.getTranx().setMerkleRoot(merkleRoot);
    	//
    	
    	
        db = get();
        db.add(newBlock);
        persist();
    }
    /**
     * get()
     */
    public LinkedList<Block> get()
    {
        try( FileInputStream fin = new FileInputStream( this.chainFile ); 
             ObjectInputStream in = new ObjectInputStream( fin );
            ) {
            return (LinkedList<Block>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * persist()
     */
    private void persist()
    {
        try( FileOutputStream fout = new FileOutputStream( this.chainFile );
             ObjectOutputStream out = new ObjectOutputStream( fout );
            ) {
            out.writeObject(db);
            System.out.println( ">> Master file is updated!" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * distribute()
     */
    public void distribute()
    {
        String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
        System.out.println( chain );
    }
    
    
    
    //persist()
    //This line starts a try-with-resources block, which is a convenient way to open resources (in this case, a FileOutputStream and an ObjectOutputStream) and ensure they are properly closed when the block is exited, even if an exception is thrown.
    //Inside the parentheses, two objects are created: a FileOutputStream object that writes to the file specified by the chainFile field, and an ObjectOutputStream object that wraps the FileOutputStream. This allows objects to be written to the file 
    //as a sequence of bytes using Java serialization.
    
    
    //distribute()
    //This line creates a new GsonBuilder object, which is a class from the Gson library that provides methods for configuring how JSON is generated from Java objects. The setPrettyPrinting() method is called on the GsonBuilder object to enable pretty 
    //printing of the JSON output. Then the create() method is called on the GsonBuilder object to create a new Gson object, which is the main class in the Gson library used for converting Java objects to JSON.
    //The toJson() method is called on the Gson object, passing in the db object as an argument. This method converts the db object to a JSON string, which is stored in the chain variable.
    //***distribute() method serializes the 'db'object to a JSON string with pretty printing and prints it to the console. This could be used for example distributing the blockchain data to other nodes in a decentralized network.
}
