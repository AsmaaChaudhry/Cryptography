/**
 * @author asmaachaudhry
 * @date 4-26-21
 */
package encryption;

/**
 * Copy Strategy class, encrypts and decrypts string using copy method
 *
 */
public class CopyStrategy implements EncryptionStrategy {

    @Override
    /**
     * Encrypt Method
     * 
     * @param original string to encrypt
     * @param key to shift
     * @return encrypted string --> copied original string
     */
    public String encryptWithKey(String plainText, int key) {
        // set new encrypted string equal to original value
        String copyPlainText = plainText;
        return copyPlainText;
    }

    @Override
    /**
     * Decrypt Method
     * 
     * @param encrypted string to decrypt
     * @param key to shift
     * @return decrypted string --> copied encrypted string
     */
    public String decryptWithKey(String cipherText, int key) {
        // set new decrupted string equal to encrypted value
        String copyCipherText = cipherText;
        return copyCipherText;
    }

}
