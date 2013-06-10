/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package siet.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author LENIN
 */
public class EncrypUtil {

    public static final String MD5 = "MD5";

    /***
     * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
     * @param message texto a encriptar
     * @param algorithm algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
     * @return mensaje encriptado
     */
    public static String encriptar(String clave) {
        System.out.println("clave original " + clave);
        byte[] digest = null;
        byte[] buffer = clave.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
            System.out.println("digest " + digest);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return toHexadecimal(digest);
    }

    /***
     * Convierte un arreglo de bytes a String usando valores hexadecimales
     * @param digest arreglo de bytes a convertir
     * @return String creado a partir de <code>digest</code>
     */
    private static String toHexadecimal(byte[] digest) {
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        System.out.println("Encript clave " + hash);

        return hash;
    }
}
