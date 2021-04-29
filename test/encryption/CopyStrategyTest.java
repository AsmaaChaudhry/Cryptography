/**
 * @author asmaachaudhry
 * @date 4-26-21
 */
package encryption;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * CopyStrategyTest class 
 * Testing JUNIT tests for Copy Strategy class 
 * Encrypt & Decrypt Methods 
 * */
class CopyStrategyTest {
    // set instance variables 
    String plainText; 
    String cipherText; 
    String encrypted; 
    String decrypted; 
    int key; 
    

    @BeforeEach
    /**
     * initialize instance variables before testing 
     */
    void setUp() throws Exception {
        String plainText = ""; 
        String cipherText = ""; 
        String encrypted = ""; 
        String decrypted = "";
        int key = 0; 
    }

    @Test
    /**
     * Testing Encrypt Method 
     * Passing in plainText & key 
     * Expected output is encrypted message copied 
     * 
     */
    void CopyStrategyMethodEncryptTesting() {
        // create instance of CopyStrategy class 
        EncryptionStrategy CopyStrategy = new CopyStrategy();
        
        // example string and key  
        String plainText = "asmaaChaudhry";
        int key = 1; 
        
        // passing string and key in encrypt method 
        String encrypted = CopyStrategy.encryptWithKey(plainText, key);
       
        // check if encryption is done correctly
        assertTrue(encrypted.equals(encrypted));
         
    }
    
    @Test
    /**
     * Testing Decrypt Method 
     * Passing in cipherText & key 
     * Expected output is decrypted message copied 
     * 
     */
    void CopyStrategyMethodDecryptTesting() {
        // create instance of CopyStrategy class 
        EncryptionStrategy CopyStrategy = new CopyStrategy();
        
        // example string and key
        String cipherText = "chaudhryAsmaa";
        int key = 2; 
        
        // passing string and key in decrypt method 
        String decrypted = CopyStrategy.decryptWithKey(cipherText, key);
        
        // check if decryption is done correctly 
        assertTrue(decrypted.equals(decrypted));
    }
        

}
    
