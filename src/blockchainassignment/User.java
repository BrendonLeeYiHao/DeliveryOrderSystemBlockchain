/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchainassignment;

import hashing.Hasher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Acer
 */
public class User {
    
    private String username;
    private String salt;
    private String hashedPassword;
    private String usertype;
    private String phone;
    private String email;
    
    public User(){}
    
    public User(String username, String salt, String hashedPassword, String usertype, String phone, String email){
        this.username = username;
        this.salt = salt;
        this.hashedPassword = hashedPassword;
        this.usertype = usertype;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getUserType(){
        return usertype;
    }
    
    public String getSalt() {
        return salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
    
    public static List<User> extractTextFile(String filePath){
        try {
            return Files.lines(Paths.get(filePath))
                    .map(line -> line.split(" , "))
                    .map(parts -> new User(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    static BiPredicate<List<User>,String> checkUserExistence = (users, name) -> users.stream().anyMatch(user -> user.getUsername().equals(name));
    
    static Predicate<String> validUsername = username -> username.length() > 2;
    
    static Predicate<String> validPassword = password -> password.length() > 4;
    
    static Predicate<String> validPhone = phone -> (phone.matches("^[0][1][2-9]-[0-9]{7}$") || phone.matches("^[0][1][1]-[0-9]{8}$"));
    
    static Predicate<String> validEmail = email -> email.matches("^[a-zA-Z0-9]{3,30}(@outlook.com)$") || 
            email.matches("^[a-zA-Z0-9]{3,30}(@gmail.com)$") ||
          email.matches("^[a-zA-Z0-9]{3,30}(@yahoo.com)$") || email.matches("^[a-zA-Z0-9]{3,30}(@hotmail.com)$");

    public static boolean confirmRegister(String username, String password, String usertype, String phone, String email){
        int dialogResult = JOptionPane.showConfirmDialog(null, "Check Registration details below:\nUsername: " + username + "\nPassword: "+password+"\nUserType: "+usertype+"\nPhone: "+ phone + "\nEmail: "+email,"Confirmation",JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    public void addRegister(){
        Path userFile = Paths.get("UserFile.txt");
        String userLine = username + " , " + salt + " , " + hashedPassword + " , " + usertype + " , " + phone + " , " + email + "\n";
        
        try {
            Files.write(userFile, userLine.getBytes(), StandardOpenOption.APPEND);
            JOptionPane.showMessageDialog(null, "Account successfully registered!");
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    //additional function to retrieve back actual password
    public void addPasswordIntoFile(String password){
        Path passwordFile = Paths.get("Password.txt");
        String passwordLine = username + " , " + password + " , " + usertype + "\n";
        
        try {
            Files.write(passwordFile, passwordLine.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean login(String username, String password, String userType) throws DecoderException {
        List<User> userLst = extractTextFile("UserFile.txt");
        Optional<User> optUser = userLst.stream()
                .filter(u -> u.getUsername().equals(username) && u.getUserType().equals(userType))
                .findFirst();
        if (optUser.isPresent()) {
            User user = optUser.get();
            String hashedPassword = Hasher.sha256(password, Hex.decodeHex(user.getSalt()));
            return hashedPassword.equals(user.getHashedPassword());
        } else {
            return false;
        }
    }


//    public boolean login(String username, String password, String usertype) throws DecoderException{
//        
//        try
//        {
//            //change the filename to UserFile.txt
//            BufferedReader myfile = new BufferedReader(new FileReader("Password.txt")); 
//            String [] lineArr;
//            String line;
//            while((line = myfile.readLine())!=null)
//            {
//                lineArr = line.split(" , ");
//                if(lineArr[0].equals(username) && lineArr[1].equals(password) && lineArr[2].equals(usertype))
//                { 
//                    return true;
//                }
//            }
//            return false;
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
