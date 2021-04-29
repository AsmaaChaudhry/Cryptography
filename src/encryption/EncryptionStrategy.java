/**
 * @author asmaachaudhry
 * @date 4-26-21
 */
package encryption;

/**
 * Interface for 3 classes: Copy, Caesar, Scytale 
 * Methods: encryptWithKey and decryptWithKey
 *
 */
public interface EncryptionStrategy {

    /**
     * @param plainText String
     * @param int key
     * @return
     */
    String encryptWithKey(String plainText, int key);

    /**
     * @param cipherText String
     * @param int key
     * @return
     */
    String decryptWithKey(String cipherText, int key);

}
