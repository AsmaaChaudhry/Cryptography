/**
 * @author asmaachaudhry
 * @date 4-26-21
 * Only did some edits for Strategy Pattern Implementation
 */

package encryption;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class provides a graphical user interface that allows a user to enter
 * text and select an encryption algorithm and key to encrypt the text. The user
 * can also enter encrypted text, select an algorithm and key to decrypt the
 * text.
 *
 */
public class CryptographyGUI extends JPanel {
    // Error message if the user does not enter a number for the key.
    private static final String KEY_ERROR_MESSAGE = "Enter a number for the key.";

    // The width of the text areas for entering encrypted and decrypted text,
    // in characters
    private static final int TEXT_WIDTH = 50;

    // The number of rows in the text areas for entering encrypted and decrypted
    // text,
    // in characters
    private static final int TEXT_HEIGHT = 5;

    // The three kinds of encryption we know. These go in the menu.
    private static final String CAESAR = "Caesar cipher";
    private static final String SCYTALE = "Scytale";
    private static final String COPY = "Copy";

    // Where the unencrypted text appears on the screen
    private JTextArea plainTextArea = new JTextArea(TEXT_HEIGHT, TEXT_WIDTH);

    // Where the encrypted text appears on the screen
    private JTextArea cipherTextArea = new JTextArea(TEXT_HEIGHT, TEXT_WIDTH);

    // The menu to select encryption algorithm.
    private JComboBox<String> encryptionMenu = new JComboBox<>();

    // The text field where the user enters the key to use
    private JTextField keyField = new JTextField(10);

    // Instance variable for EncryptionStraegy interface
    private EncryptionStrategy Strategy;

    /**
     * Constructs the user interface for the program.
     */
    public CryptographyGUI() {
        // Create the two text areas for plain text and cipher text.
        plainTextArea.setBorder(BorderFactory.createTitledBorder("Plain text"));
        cipherTextArea
                .setBorder(BorderFactory.createTitledBorder("Cipher text"));

        // Create the menu containing encryption options
        createMenu();
        selectEncryption(COPY);

        // Add the buttons and key field to control the encryption and
        // decryption.
        JPanel buttonPanel = new JPanel();
        JButton encryptButton = createEncryptButton();
        JButton decryptButton = createDecryptButton();
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        buttonPanel.add(encryptionMenu);
        buttonPanel.add(new JLabel("Key:"));
        buttonPanel.add(keyField);

        // Add all the GUI elements to the display.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(plainTextArea);
        add(cipherTextArea);
        add(buttonPanel);
    }

    /**
     * Creates the decrypt button.
     * 
     * @return the button
     */
    private JButton createDecryptButton() {
        JButton decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener() {
            // Define the action to take when the user clicks the decrypt
            // button.
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Get the key
                    String keyText = keyField.getText();
                    int key = Integer.parseInt(keyText);

                    // Do the decryption.
                    String decryptedText = decryptWithKey(
                            cipherTextArea.getText(), key);

                    // Display the decrypted text.
                    plainTextArea.setText(decryptedText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(CryptographyGUI.this,
                            KEY_ERROR_MESSAGE);
                }
            }

        });
        return decryptButton;
    }

    /**
     * Creates the encrypt button.
     * 
     * @return the button
     */
    private JButton createEncryptButton() {
        JButton encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new ActionListener() {
            // Define the action to take when the user clicks the encrypt
            // button.
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Get the key
                    String keyText = keyField.getText();
                    int key = Integer.parseInt(keyText);

                    // Do the encryption
                    String encryptedText = encryptWithKey(
                            plainTextArea.getText(), key);

                    // Display the encrypted text
                    cipherTextArea.setText(encryptedText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(CryptographyGUI.this,
                            KEY_ERROR_MESSAGE);
                }
            }
        });
        return encryptButton;
    }

    /**
     * Creates the menu containing the encryption algorithms to choose from.
     */
    private void createMenu() {
        encryptionMenu.addItem(COPY);
        encryptionMenu.addItem(CAESAR);
        encryptionMenu.addItem(SCYTALE);
        encryptionMenu.addItemListener(new ItemListener() {

            // Define the action to take when the user changes which
            // algorithm to use.
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    String selected = encryptionMenu.getSelectedItem()
                            .toString();
                    selectEncryption(selected);
                }
            }
        });
    }

    /**
     * Selects the encryption algorithm to use
     * 
     * @param selected the name of the algorithm
     */
    private void selectEncryption(String selected) {
        if (selected.equals(COPY)) {
            Strategy = new CopyStrategy();

        } else if (selected.equals(CAESAR)) {
            Strategy = new CaesarStrategy();

        } else if (selected.equals(SCYTALE)) {
            Strategy = new ScytaleStrategy();
        }
    }

    /**
     * Encrypts text using the currently selected algorithm
     * 
     * @param plainText the text to encrypt
     * @param key       the key the algorithm should use
     * @return the encrypted text
     */
    private String encryptWithKey(String plainText, int key) {
        // return the encrypted string.
        return Strategy.encryptWithKey(plainText, key);
    }

    /**
     * Decrypts text using the currently selected algorithm
     * 
     * @param cipherText the text to encrypt
     * @param key        the key the algorithm should use
     * @return the decrypted text
     */
    private String decryptWithKey(String cipherText, int key) {
        // return the unencrypted string.
        return Strategy.decryptWithKey(cipherText, key);
    }

    /**
     * The main method to start the program.
     * 
     * @param args None required
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new CryptographyGUI());
        frame.pack();
        frame.setVisible(true);
    }

}
