/**
 * @author asmaachaudhry
 * @date 4-26-21
 */
package encryption;

/**
 * Scytale Strategy class Encrpts and Decrypts a string Using Scytale method of
 * using key as number of rows to encrypt/decrypt Decoded by reading the
 * character in the columns
 *
 */
public class ScytaleStrategy implements EncryptionStrategy {

    @Override
    /**
     * Encrypt Method, creating rows (key value) to read encrypted message
     * 
     * @param original string to encrypt
     * @param key to shift
     * @return encrypted string
     * 
     */
    public String encryptWithKey(String plainText, int key) {
        // create empty string to store encrypted message
        StringBuilder encryptedScytale = new StringBuilder();
        // length of orginal string
        int textLength = plainText.length();

        // iterate through length of key
        for (int i = 0; i < key; i++) {

            // iterate through characters in original string
            // append to encrypted string in order of columns that are read
            for (int m = 0; i + m < textLength; m += key) {
                encryptedScytale.append(plainText.charAt(i + m));
            }
        }
        return encryptedScytale.toString();
    }

    @Override
    /**
     * Decrpyt Method
     * 
     * Using encrypt method with adjustment to key value
     * 
     * @param encrypted string to decrypt
     * @param key to shift
     * @return decrypted string
     * 
     */
    public String decryptWithKey(String cipherText, int key) {
        // adjusting key value to -1 to decrypt message
        return encryptWithKey(cipherText, key - 1);
    }

}
