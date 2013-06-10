/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import java.io.File;
import java.util.Date;
import sietice.RecursoRespaldo;

/**
 *
 * @author LENIN
 */
public class Respaldo {
    public static final double MEGABYTE_LENGTH_BYTES = 1048000;
    public static final double KILOBYTE_LENGTH_BYTES = 1024;

    private File file;
    private Date fecha;
    private boolean seleccionado;
    private String tamaño;
    private long length;
    private RecursoRespaldo recurso;

    public Respaldo(File file, Date fecha) {
        this.file = file;
        this.fecha = fecha;
        this.length = file.length();
         this.recurso = new RecursoRespaldo(this);
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the seleccionado
     */
    public boolean isSeleccionado() {
        return seleccionado;
    }

    /**
     * @param seleccionado the seleccionado to set
     */
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    /**
     * @return the tamaÃ±o
     */
    public String getTamaño() {
        if (length >= MEGABYTE_LENGTH_BYTES) {
            return length / MEGABYTE_LENGTH_BYTES + " MB";
        }
        else if (length >= KILOBYTE_LENGTH_BYTES) {
            return length / KILOBYTE_LENGTH_BYTES + " KB";
        }
        else if (length == 0) {
            return "0";
        }
        else if (length < KILOBYTE_LENGTH_BYTES) {
            return length + " B";
        }

        return Long.toString(length);
    }


    /**
     * @param tamaÃ±o the tamaÃ±o to set
     */
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * @return the recurso
     */
    public RecursoRespaldo getRecurso() {
       
        return recurso;
    }

}
