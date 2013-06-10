/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.FacesException;


/**
 *
 * @author Principal
 */
public class ServicioRespaldo extends AbstractSessionBean{




    private void _init() throws Exception {
    }

    public ServicioRespaldo() {

    }

    @Override
    public void init() {

        super.init();

        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
    }


    @Override
    public void passivate() {
    }

    @Override
    public void activate() {
    }


    @Override
    public void destroy() {
    }

    private static ResourceBundle obtenerBundle(){
        return ResourceBundle.getBundle("respaldo");
    }

    private static String obtenerRuta() throws Exception{

        ResourceBundle rb = obtenerBundle();
        String path = rb.getString("ruta");
        String prefijo = rb.getString("prefijo");
        String extension = rb.getString("extension");

        File f = new File(path);
        f.mkdirs();

        if(f.exists() == false){
            throw new Exception("El directoriro para sacar los respaldos no existe");
        }

        return path+File.separator + prefijo + new Date().getTime() + extension;
    }

    public static boolean respaldar(){
        try {
            ResourceBundle rb = obtenerBundle();
            String comando = rb.getString("respaldar");
            String ruta = obtenerRuta();

            Runtime runtime = Runtime.getRuntime();
            String comand = comando.replace("{path}", ruta);
            Process child = runtime.exec(comand);

            // Atrapo el error
            /*InputStream isError = child.getErrorStream();
            ByteArrayOutputStream boError = new ByteArrayOutputStream();
            int h = 0;
            while((h = isError.read()) != -1){
                boError.write(h);
            }
            String error = new String(boError.toByteArray());

            // Obtengo el texto del respaldo y lo escribo a un archivo
            InputStream sis = child.getInputStream();
            FileOutputStream sbo = new FileOutputStream(new File(ruta));
            int sh = 0;
            while((sh = sis.read()) != -1){
                sbo.write(sh);
            }
            sbo.close();
            */
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public  static boolean  restaurar(String path){

        try {
            ResourceBundle rb = obtenerBundle();
            String comando = rb.getString("restaurar");
            comando = comando.replace("{path}", path);

            Runtime runtime = Runtime.getRuntime();
            Process child = runtime.exec(comando);

            // Atrapo el error
            /*InputStream isError = child.getErrorStream();
            ByteArrayOutputStream boError = new ByteArrayOutputStream();
            int h = 0;
            while((h = isError.read()) != -1){
                boError.write(h);
            }
            String error = new String(boError.toByteArray());*/
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Respaldo> listarRespaldos(){
        try {
            ResourceBundle rb = obtenerBundle();

            String ruta = rb.getString("ruta");
            String prefijo = rb.getString("prefijo");
            String extension = rb.getString("extension");

            File folder = new File(ruta);
            List<Respaldo> lista = new ArrayList<Respaldo>();
            if(folder.exists()){
                File[] ofiles = folder.listFiles();
                for (File file : ofiles) {
                    String f = file.getName().replace(prefijo, "").replace(extension, "");
                    try {
                        lista.add(new Respaldo(file, new Date(Long.parseLong(f))));
                    } catch (Exception e) {
                    }
                    
                }
                Collections.sort(lista, new RespaldoComparator());
                return lista;
            }

        } catch (Exception e) {
            String ex = e.getMessage();
        }
        return new ArrayList<Respaldo>();
    }

    public static List<Respaldo> listarRespaldos(Date desde, Date hasta){
         List<Respaldo> lista = listarRespaldos();
         List<Respaldo> listaf = new ArrayList<Respaldo>();

        desde = new Date(desde.getYear(), desde.getMonth(), desde.getDate(), 0,0,0);
        hasta = new Date(hasta.getYear(), hasta.getMonth(), hasta.getDate(), 23,59,59);

         for (Iterator<Respaldo> it = lista.iterator(); it.hasNext();) {
            Respaldo Respaldo = it.next();
            if(Respaldo.getFecha().compareTo(desde) >= 0 && Respaldo.getFecha().compareTo(hasta) <= 0){
                listaf.add(Respaldo);
            }
         }

         return listaf;
    }

    public static boolean eliminar(Respaldo item){
        return item.getFile().delete();
    }

    public static boolean restaurar(Respaldo item){
        return restaurar(item.getFile().getPath());
    }

}
