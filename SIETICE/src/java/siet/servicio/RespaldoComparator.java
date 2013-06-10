/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Desarrollador
 */
public class RespaldoComparator implements Comparator<Respaldo>{
    public int compare(Respaldo o1, Respaldo o2) {
        Date s1 = o1.getFecha();
        Date s2 = o2.getFecha();
        try {
            return s2.compareTo(s1);
        } catch (Exception e) {
        }
        return -1;
    }

}
