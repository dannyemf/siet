/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietclient;

import sietclient.bean.ItemProyecto;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import sietclient.bean.ItemCliente;
import sietclient.bean.ItemDocumentacion;
import sietclient.bean.ItemTipoVivienda;

/**
 *
 * @author LENIN
 */
public class XMLProyectoUtil {

    public static List<ItemProyecto> obtenerProyectos(String xml){
        List<ItemProyecto> lst = new ArrayList<ItemProyecto>();

        ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes());
        SAXBuilder sax = new SAXBuilder();

        try {
            Document doc = sax.build(in);
            // <Proyectos>
            Element root = doc.getRootElement();
            List<Element> proyectos = root.getChildren();
            for (Iterator<Element> it = proyectos.iterator(); it.hasNext();) {
                // El proyecto
                Element eProy = it.next();
                ItemProyecto proyecto = new ItemProyecto();
                lst.add(proyecto);
                //proyecto.setContextPath(root.getText());
                proyecto.setAvance(eProy.getAttributeValue("avance"));
                proyecto.setEstado(eProy.getAttributeValue("estado"));
                proyecto.setId(Long.parseLong(eProy.getAttributeValue("id")));
                proyecto.setPresupuesto(Double.parseDouble(eProy.getAttributeValue("presupuesto")));
                proyecto.setUbicacion(eProy.getAttributeValue("ubicacion"));
                {
                    // Propietario del proyecto
                    Element eProp = eProy.getChild("propietario");
                    ItemCliente propietario = new ItemCliente();
                    proyecto.setPropietario(propietario);
                    propietario.setApellido(eProp.getAttributeValue("apellido"));
                    propietario.setApellidodos(eProp.getAttributeValue("apellidodos"));
                    propietario.setCelular(eProp.getAttributeValue("celular"));
                    propietario.setCi(eProp.getAttributeValue("ci"));
                    propietario.setClave(eProp.getAttributeValue("clave"));
                    propietario.setDireccion(eProp.getAttributeValue("direccion"));
                    propietario.setEstadoCivil(eProp.getAttributeValue("estadoCivil"));
                    propietario.setFechaNac(new Date(eProp.getAttributeValue("fechaNac")));
                    propietario.setId(Long.parseLong(eProp.getAttributeValue("id")));
                    propietario.setNombre(eProp.getAttributeValue("nombre"));
                    propietario.setSexo(eProp.getAttributeValue("sexo"));
                    {
                        // documentacion del propietario
                        Element eDoc = eProp.getChild("documentacion");
                        ItemDocumentacion documentacion = new ItemDocumentacion();
                        propietario.setDocumentacion(documentacion);
                        documentacion.setId(Long.parseLong(eDoc.getAttributeValue("id")));
                        documentacion.setImgCedula(eDoc.getAttributeValue("imgCedula"));
                        documentacion.setImgCertificado(eDoc.getAttributeValue("imgCertificado"));
                        documentacion.setImgEscritura(eDoc.getAttributeValue("imgEscritura"));
                        documentacion.setImgLibreta(eDoc.getAttributeValue("imgLibreta"));
                        documentacion.setImgTerreno(eDoc.getAttributeValue("imgTerreno"));
                    }

                    // tipo de vivienda del proyecto
                    Element eTipo = eProy.getChild("tipoVivienda");
                    ItemTipoVivienda tipo = new ItemTipoVivienda();
                    proyecto.setTipoVivienda(tipo);
                    tipo.setCielorazo(eTipo.getAttributeValue("cielorazo"));
                    tipo.setParedes(eTipo.getAttributeValue("paredes"));
                    tipo.setCubierta(eTipo.getAttributeValue("cubierta"));
                    tipo.setRevestido(eTipo.getAttributeValue("revestido"));
                    tipo.setEstructura(eTipo.getAttributeValue("estructura"));
                    tipo.setId(Long.parseLong(eTipo.getAttributeValue("id")));
                             
                    tipo.setPiso(eTipo.getAttributeValue("piso"));
                    tipo.setPlano(eTipo.getAttributeValue("plano"));
                    tipo.setPuertas(eTipo.getAttributeValue("puertas"));
                    tipo.setTipo(eTipo.getAttributeValue("tipo"));
                    tipo.setVentanas(eTipo.getAttributeValue("ventanas"));
                    tipo.setPresupuesto(Double.parseDouble(eTipo.getAttributeValue("presupuesto")));
                    tipo.setArea(Double.parseDouble(eTipo.getAttributeValue("area")));
                }
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        return lst;
    }

}
