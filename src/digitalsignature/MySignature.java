/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalsignature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

/**
 *
 * @author Acer
 */
public class MySignature {
    
    private Signature sig;
    public MySignature() {
        super();
        try {
            sig = Signature.getInstance( "SHA256WithRSA" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**     
     * * sign()    
     * @param data
     * @param key
     * @return    
     * @throws java.lang.Exception  */    
    public String sign(String data, PrivateKey key) throws Exception    {
        sig.initSign( key );
        sig.update(data.getBytes());
        return Base64.getEncoder().encodeToString(sig.sign());
    }
    
    /**     
     * * verify()    
     * @param data    
     * @param signature    
     * @param key    
     * @return     
     * @throws java.lang.Exception */    
    public boolean verify(String data, String signature, PublicKey key) throws Exception    {
        sig.initVerify( key );
        sig.update(data.getBytes());
        return sig.verify( Base64.getDecoder().decode(signature));
    }
}
