/**
 * @author asmaachaudhry
 * @date 4-26-21
 */
package encryption;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ScytaleStrategyTest class Testing JUNIT tests for Scytale Strategy class
 * Encrypt & Decrypt Methods
 */
class ScytaleStrategyTest {
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
     * Testing Encrypt Method Passing in plainText & key Expected output is
     * encrypted message copied
     * 
     */
    void ScytaleStrategyMethodEncryptTesting() {
        // create instance of ScytaleStrategy class
        EncryptionStrategy ScytaleStrategy = new ScytaleStrategy();

        // example string and key
        String plainText = "Hello, world";
        int key = 4;

        // passing string and key in encrypt method
        String encrypted = ScytaleStrategy.encryptWithKey(plainText, key);

        // check if encryption is done correctly
        assertTrue(encrypted.equals("Hooe,rl llwd"));
    }

    @Test
    /**
     * Testing Decrypt Method Passing in cipherText & key Expected output is
     * decrypted message copied
     * 
     */
    void ScytaleStrategyMethodDecryptTesting() {
        // create instance of ScytaleStrategy class
        EncryptionStrategy ScytaleStrategy = new ScytaleStrategy();

        // example string and key
        String plainText = "Hooe,rl llwd";
        int key = 4;

        // passing string and key in decrypt method
        String decrypted = ScytaleStrategy.decryptWithKey(plainText, key);

        // check if decryption is done correctly
        assertTrue(decrypted.equals("Hello, world"));
    }

}
