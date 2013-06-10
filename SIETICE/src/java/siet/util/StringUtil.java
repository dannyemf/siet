/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.util;

/**
 *
 * @author LENIN
 */
public class StringUtil {

    public static boolean isNullOrEmpty(Object cadena){
        if (cadena == null){
            return true;
        }else{
            if(cadena.toString().trim().length() == 0){
                return true;
            }else{
                return false;
            }
        }
    }

}
