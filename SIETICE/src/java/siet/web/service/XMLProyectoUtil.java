/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.web.service;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import siet.dao.DocumentacionDAO;
import siet.modelo.Cliente;
import siet.modelo.Documentacion;
import siet.modelo.ProyectoCliente;
import siet.modelo.TipoVivienda;

/**
 *
 * @author LENIN
 */
public class XMLProyectoUtil {
    public XMLProyectoUtil(){
    }
    public String obtenerTexto(List<ProyectoCliente> proyectos){
        SimpleDateFormat dfSimple = new SimpleDateFormat("yyyy/MM/dd");
        Element root = new Element("proyectos");
        Document doc = new Document(root);

        for (Iterator<ProyectoCliente> it = proyectos.iterator(); it.hasNext();) {
            ProyectoCliente proyecto = it.next();
            // creacion de los atributos
            Element eProy = new Element("proyecto");
            root.addContent(eProy);
            
            eProy.setAttribute("avance", proyecto.getAvance());
            eProy.setAttribute("estado", proyecto.getEstado());
            eProy.setAttribute("ubicacion", proyecto.getUbicacion());
            eProy.setAttribute("id", proyecto.getId().toString());
            eProy.setAttribute("presupuesto", proyecto.getPresupuesto().toString());

            // creacion del cliente

            Cliente propietario = proyecto.getPropietario();
            Element eProp = new Element("propietario");
            eProy.addContent(eProp);
            eProp.setAttribute("apellido", propietario.getApellido());
            eProp.setAttribute("apellidodos", propietario.getApellidodos());
            eProp.setAttribute("celular", propietario.getCelular());
            eProp.setAttribute("ci", propietario.getCi());
            eProp.setAttribute("clave", propietario.getClave());
            eProp.setAttribute("direccion", propietario.getDireccion());
            eProp.setAttribute("estadoCivil", propietario.getEstadoCivil());
            eProp.setAttribute("fechaNac", dfSimple.format(propietario.getFechaNac()));
            eProp.setAttribute("id", propietario.getId().toString());
            eProp.setAttribute("nombre", propietario.getNombre());
            eProp.setAttribute("sexo", propietario.getSexo());

                Documentacion docu = new DocumentacionDAO().buscarPorCliente(propietario);
                if(docu == null){
                    docu = new Documentacion();
                }
                Element eDocu = new Element("documentacion");
                eProp.addContent(eDocu);
                eDocu.setAttribute("imgCedula", docu.getImgCedula());
                eDocu.setAttribute("imgCertificado",  docu.getImgCertificado());
                eDocu.setAttribute("imgEscritura",  docu.getImgEscritura());
                eDocu.setAttribute("imgLibreta",  docu.getImgLibreta());
                eDocu.setAttribute("imgTerreno", docu.getImgTerreno());
                eDocu.setAttribute("id", docu.getId().toString());

            TipoVivienda tipo = proyecto.getTipoVivienda() != null ? proyecto.getTipoVivienda() : new TipoVivienda() ;
            Element eTipo = new Element("tipoVivienda");
            eProy.addContent(eTipo);
            eTipo.setAttribute("cielorazo", tipo.getCielorazo());
            eTipo.setAttribute("cubierta", tipo.getCubierta());
            eTipo.setAttribute("revestido", tipo.getRevestido());
            eTipo.setAttribute("estructura", tipo.getEstructura());
            eTipo.setAttribute("paredes", tipo.getParedes());
            eTipo.setAttribute("presupuesto", ""+tipo.getPresupuesto());
            eTipo.setAttribute("piso", tipo.getPiso());
            eTipo.setAttribute("plano",  tipo.getPlano());
            eTipo.setAttribute("puertas", tipo.getPuertas());
            eTipo.setAttribute("tipo", tipo.getTipo());
            eTipo.setAttribute("ventanas", tipo.getVentanas());
            eTipo.setAttribute("id", tipo.getId().toString());
             eTipo.setAttribute("area", ""+tipo.getArea());
            
        }
        

        try {
            XMLOutputter o = new XMLOutputter(Format.getPrettyFormat());
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            o.output(doc, bo);
            return bo.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String args[]){
        ProyectoCliente p = new ProyectoCliente();
        p.setPropietario(new Cliente());

        List<ProyectoCliente> lst = new ArrayList<ProyectoCliente>();
        lst.add(p);

        XMLProyectoUtil u = new XMLProyectoUtil();
        
        System.out.println(u.obtenerTexto(lst));
    }

}
