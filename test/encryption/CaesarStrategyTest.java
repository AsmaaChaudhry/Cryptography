/**
 * @author asmaachaudhry
 * @date 4-26-21
 */
package encryption;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * CaesarStrategyTest class 
 * Testing JUNIT tests for Caesar Strategy class 
 * Encrypt & Decrypt Methods 
 * */
class CaesarStrategyTest {
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
     * Expected output is encrypted message in Ceasar Cipher 
     * 
     */
    void CaesarStrategyMethodEncryptTesting() {
        // create instance of CeasarStrategy class 
        EncryptionStrategy CaesarStrategy = new CaesarStrategy();
        
        // example string and key 
        String plainText = "Better encryption";
        int key = 3; 
        
        // passing string and key in encrypt method 
        String encrypted = CaesarStrategy.encryptWithKey(plainText, key);
        
        // check if encryption is done correctly 
        assertTrue(encrypted.equals("Ehwwhu#hqfu|swlrq"));

    }
    
    
    @Test
    /**
     * Testing Decrypt Method 
     * Passing in cipherText & key 
     * Expected output is decrypted message 
     * 
     */
    void CaesarStrategyMethodDecryptTesting() {
        // create instance of CeasarStrategy class 
        EncryptionStrategy CaesarStrategy = new CaesarStrategy();
        
        // example string and key 
        String cipherText = "Ehwwhu#hqfu|swlrq";
        int key = 3; 
        
        // passing string and key in decrypt method 
        String decrypted = CaesarStrategy.decryptWithKey(cipherText, key);
        
        // check if decryption is done correctly 
        assertTrue(decrypted.equals("Better encryption"));
    }
    
}

