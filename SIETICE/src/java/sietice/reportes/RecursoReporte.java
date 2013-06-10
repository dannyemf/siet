/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice.reportes;

import com.icesoft.faces.context.Resource;
import com.icesoft.faces.context.Resource.Options;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import siet.servicio.ServicioReportes;
import sietice.GenerarReporte;



/**
 *
 * @author Patricia Chamba Franklin Andrade
 */
public class RecursoReporte implements Resource, Serializable{

    private int tipo = 0;
    private Date desde;
    private Date hasta;
    private GenerarReporte vista;
    //private Usuario usuario;
    private Date modified;
    private ServicioReportes servicioRep;
    //private ServicioLog servicioLog;

    public RecursoReporte(int tipo, GenerarReporte view) {
        this.vista = view;
        servicioRep = vista.getServicioReportes();
        //servicioLog = vista.getServicioLog();
        
        this.tipo = tipo;
        this.modified = new Date();
    }

    public String calculateDigest() {
        return new Date().getTime()+""+tipo+"rep";
    }

    public InputStream open() throws IOException {
        //desde = vista.getDesde();
        modified = new Date();
        byte[] data = servicioRep.generarReporte(tipo);

        if(data==null){
           ByteArrayOutputStream bo = new ByteArrayOutputStream();
           Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, bo);
                doc.open();
                doc.add(new Paragraph("ERROR AL GENERAR EL REPORTE:"));
                doc.add(new Paragraph("-----------------------------"));
                doc.close();
            } catch (Exception e) {}
            return new ByteArrayInputStream(bo.toByteArray());
        }else{
            return new ByteArrayInputStream(data);
        }

        
        
       
    }

    public Date lastModified() {
        modified = new Date();
        return modified;
    }

    public void withOptions(Options arg0) throws IOException {
    }

    

    /**
     * @return the desde
     */
    public Date getDesde() {
        return desde;
    }

    /**
     * @param desde the desde to set
     */
    public void setDesde(Date desde) {
        this.desde = desde;
    }

    /**
     * @return the hasta
     */
    public Date getHasta() {
        return hasta;
    }

    /**
     * @param hasta the hasta to set
     */
    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }
}