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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;



/**
 *
 * @author Patricia Chamba Franklin Andrade
 */
public class RecursoFile implements Resource, Serializable{

   
    private Date modified;
    private String archivo;
   

    public RecursoFile(String archivo) {
        
        this.modified = new Date();
        this.archivo = archivo;
    }

    public String calculateDigest() {
        return archivo;
    }

    public InputStream open() throws IOException {
        //desde = vista.getDesde();
        modified = new Date();
        byte[] data = toByte();

        if(data==null){
           ByteArrayOutputStream bo = new ByteArrayOutputStream();
           Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, bo);
                doc.open();
                doc.add(new Paragraph("NO SE ENCUENTRA EL RECURSO:"));
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

    public byte[] toByte(){

        try {
            File f = new File(archivo);
            FileInputStream fi = new FileInputStream(f);
            ByteArrayOutputStream bo = new ByteArrayOutputStream();

            int r;
            while((r = fi.read()) != -1){
                bo.write(r);
            }

            byte[] b = bo.toByteArray();

            bo.close();
            fi.close();

            return b;
        } catch (Exception e) {
        }

        return null;
    }
}