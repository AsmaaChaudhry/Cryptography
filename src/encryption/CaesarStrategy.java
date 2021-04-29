/**
 * @author asmaachaudhry
 * @date 4-26-21
 */
package encryption;

/**
 * Caesar Cipher Strategy Class, Encrpts and Decrypts a string 
 * Using a Ceaser Cipher method which shifts letters by a key value
 */
public class CaesarStrategy implements EncryptionStrategy {

    @Override
    /**
     * Encrypt Method with ASCII characters 32-126
     * 
     * @param original string to encrypt
     * @param key to shift
     * @return encrypted string
     */
    public String encryptWithKey(String plainText, int key) {
        // empty string
        String encryptedCaesar = "";

        // iterate through orginal string
        // if character are out of 32-126 ascii range, wrap around
        for (int i = 0; i < plainText.length(); i++) {
            int chr = plainText.charAt(i) + key;
            if (chr > 126) {
                chr -= 95;
            } else if (chr < 32) {
                chr += 95;
            }

            // add encrypted characters to string
            encryptedCaesar += (char) chr;
        }
        return encryptedCaesar;
    }

    @Override
    /**
     * Decrypt Method with ASCII characters 32-126
     * 
     * @param encrypted string to decrypt
     * @param key to shift
     * @return decrypted string
     */
    public String decryptWithKey(String cipherText, int key) {
        // calls on encrypt method
        // key is adjusted for depcrytion
        // subtract key amount to reverse encryption
        return encryptWithKey(cipherText, -key);

    }
}
