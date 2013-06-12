/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.util;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

/**
 *
 * @author uti
 */
public class ThumbailUtil {

    public static void crearThumbail(String fromFile, String toFile, int width, int height){
        //crear thumbail para optimizar carga
        try {
            File toF = new File(toFile);
            if(toF.exists()){
                toF.delete();
            }
            
            BufferedImage img = ImageIO.read(new File(fromFile));
            BufferedImage thumbnail = Scalr.resize(img,  Scalr.Method.SPEED, Scalr.Mode.AUTOMATIC, width, height, Scalr.OP_ANTIALIAS);
            ImageIO.write(thumbnail,"jpg", new File(toFile));
        } catch (Exception e) {
            System.out.println("Error crear thum: " + e);
        }
    }
}
