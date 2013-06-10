/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.icesoft.faces.context.Resource;
import com.icesoft.faces.context.Resource.Options;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import siet.servicio.Respaldo;




/**
 *
 * 
 */
public class RecursoRespaldo implements Resource, Serializable{

    private Date modified;
    private Respaldo respaldo;

    public RecursoRespaldo( Respaldo respaldo) {
        this.respaldo = respaldo;        
        this.modified = new Date();
    }

    public String calculateDigest() {

        return respaldo.getFile().getName();
    }

    public InputStream open() throws IOException {
        
        modified = new Date();
        
        byte[] data = getData()  ;

        if(data==null){
           ByteArrayOutputStream bo = new ByteArrayOutputStream();
           Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, bo);
                doc.open();
                doc.add(new Paragraph("ERROR OBTENER ARCHIVO DE RESPALDO:"));
                doc.add(new Paragraph("-----------------------------"));
                doc.close();
            } catch (Exception e) {}
            return new ByteArrayInputStream(bo.toByteArray());
        }else{
            return new ByteArrayInputStream(data);
        }        
    }

    public byte[] getData(){
        try {
            FileInputStream fi = new FileInputStream(respaldo.getFile());
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int ch;
            while((ch = fi.read()) != -1){
                bo.write(ch);
            }
            byte[] data =bo.toByteArray();

            bo.close();
            fi.close();
            return data;
        } catch (Exception e) {
        }
        return null;
    }

    public Date lastModified() {
        return new Date();
    }

    public void withOptions(Options arg0) throws IOException {
    }

    

}