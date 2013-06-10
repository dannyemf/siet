/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.util;

/**
 *
 * @author uti
 */
public class CedulaUtil {

    public static boolean validar(String cedula) {
        int sumaA = 0;
        int sumaB = 0;
        if (cedula.length() != 10) {
            return false;
        }
        try {
            new Long(cedula);
        } catch (Exception e) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7) {
                sumaA = sumaA + (new Integer(cedula.substring(i, i + 1)));
            } else {
                int valmul = (new Integer(cedula.substring(i, i + 1))) * 2;
                if (valmul > 9) {
                    valmul = valmul - 9;
                }
                sumaB = sumaB + valmul;
            }
        }
        //paso 3
        int total = sumaA + sumaB;
        int residuo = total / 10;
        int Vericador = total - (residuo * 10);
        Vericador = 10 - Vericador;
        if (Vericador == new Integer(cedula.substring(9, 10))) {
            System.out.println(cedula + " ok");
            return true;
        }
        System.out.println(cedula + " invalida");
        return false;

    }

}
