/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Programador 1
 */
public class EncryptDescryptString {

    private static final String UNICODE_FORMAT = "UTF-8";
    private final SecretKey secretKey;
    private Cipher cipher;

//    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException {
//        Conexion cnx = new Conexion();
//        EncryptDescryptString encryptDescryptString = new EncryptDescryptString();
//
//        PreparedStatement prm = null;
//        try {
//            prm = cnx.getConexion().prepareStatement("UPDATE usuarios set pwd_user = ?");
//        } catch (SQLException ex) {
//            Logger.getLogger(EncryptDescryptString.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//
//            prm.setBytes(1, encryptDescryptString.encryptString("0000"));
//        } catch (SQLException ex) {
//            Logger.getLogger(EncryptDescryptString.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            prm.executeUpdate();
//          System.out.println("Todas las claves actualizadas");
//        } catch (SQLException ex) {
//            Logger.getLogger(EncryptDescryptString.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public EncryptDescryptString() {
         secretKey = generateKey("AES");
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(EncryptDescryptString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SecretKey generateKey(String encryptionType) {
        KeyGenerator keyGenerator;
        SecretKey myKey = null;
        try {

            keyGenerator = KeyGenerator.getInstance(encryptionType);
            myKey = keyGenerator.generateKey();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptDescryptString.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myKey;
    }

    public byte[] encryptString(String dataToEcrypt) throws IllegalBlockSizeException, BadPaddingException {
        byte[] textEncrypted = null;

        try {
            byte[] text = dataToEcrypt.getBytes(UNICODE_FORMAT);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            textEncrypted = cipher.doFinal(text);

        } catch (UnsupportedEncodingException | InvalidKeyException ex) {
            Logger.getLogger(EncryptDescryptString.class.getName()).log(Level.SEVERE, null, ex);
        }

        return textEncrypted;

    }

    public String DescryptString(byte[] dataToDecrypt) throws IllegalBlockSizeException, BadPaddingException {

        String text = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textEncrypted = cipher.doFinal(dataToDecrypt);
            text = new String(textEncrypted);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(EncryptDescryptString.class.getName()).log(Level.SEVERE, null, ex);
        }

        return text;

    }

}
