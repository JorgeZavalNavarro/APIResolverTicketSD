package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Jorge Zavala Navarro
 */
public class AESSymetricCryptoBean {

    // Constantes de la clase
    private static final String PASSWORD = "123456789012345*0000000";

    public static String encrypt(String cadena) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Valor de retorno de la funciòn
        String retorno = null;
        // Generamos una clave de 128 bits adecuada para AES
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = new SecretKeySpec(PASSWORD.getBytes(), 0, 16, "AES");
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Se inicializa para encriptacion y se encripta el texto,
        // que debemos pasar como bytes.
        aes.init(Cipher.ENCRYPT_MODE, key);
        byte[] encriptado = aes.doFinal(cadena.getBytes());

        // Se escribe byte a byte en hexadecimal el texto
        // encriptado para ver su pinta.
        retorno = "";
        String elemByte = "";
        System.out.println("");
        for (byte b : encriptado) {
            elemByte = Integer.toHexString(0xFF & b);
            retorno = retorno + (elemByte.length()==1 ? "0" + elemByte : elemByte);
            
        }

        return retorno;
    }

    public static String decrypt(String cadena) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String retorno = null;
        Key key = new SecretKeySpec(PASSWORD.getBytes(), 0, 16, "AES");
        // Tenemos que ir desglosando la cadena que viene en pares de codigo hexadecimal
        String cadHex = null;
        byte[] arrBytes = new byte[cadena.length() / 2];
        int increm = 2;
        int cont = 0;
        byte valByte;
        for (int i = 0; i < cadena.length(); i = i + increm) {
            cadHex = cadena.substring(i, i + increm);
            if (cadHex != null && !cadHex.isEmpty()) {
                System.out.println("CadHex: " + cadHex);
                valByte = (byte) Integer.parseInt(cadHex, 16);
                System.out.println("valByte: " + valByte);
                arrBytes[cont++] = (byte) Integer.parseInt(cadHex, 16);
                
            }
        }

        // Pasamos este arreglo por el decrypt
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aes.init(Cipher.DECRYPT_MODE, key);
        byte[] desencriptado = aes.doFinal(arrBytes);
        retorno = new String(desencriptado);
        return retorno;
    }

    public static void main(String[] args) throws Exception {

        String nombre = "Mi nombre es Jorge Zavala Navarro";
        System.out.println("Cadena Origen: " + nombre);
        String encriptada = encrypt(nombre);
        System.out.println("Encriptada: " + encriptada);
        String desencriptada = decrypt(encriptada);
        System.out.println("Desencriptada: " + desencriptada);
    }
}
