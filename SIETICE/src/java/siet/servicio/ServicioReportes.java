/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import java.io.*;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import siet.dao.ProyectoDAO;
import siet.modelo.ProyectoCliente;
import sietice.SietApplicationBean;
import sietice.reportes.ItemProyecto;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version ServicioReportes.java
 * @version Created on 21/10/2010, 12:59:49 AM
 * @author LENIN
 */

public class ServicioReportes extends AbstractSessionBean {

    private static final String PATH_PLANTILLA = "/plantillas/";
    private static final String SUFIJO_PLANTILLA = ".jrxml";

    public static final int TIPO_PROYECTOS_APROBADOS = 1;
    public static final int TIPO_PROYECTOS_RECHAZADOS = 2;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public ServicioReportes() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ServicioReportes Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SietApplicationBean getSietApplicationBean() {
        return (SietApplicationBean) getBean("SietApplicationBean");
    }

    public byte[] generarReporte(int tipo){
        switch(tipo){
            case TIPO_PROYECTOS_APROBADOS: return genRepProyectosAprobados();
            case TIPO_PROYECTOS_RECHAZADOS: return genRepProyectosRechazados();
        }
        return null;
    }

    public byte[] genRepProyectosAprobados(){
        ProyectoDAO pdao = new ProyectoDAO();
        Map parametros = new HashMap();
        List<ItemProyecto> listaDatos = new ArrayList<ItemProyecto>();
        List<ProyectoCliente> lista = pdao.buscarProyectoClientePorEstado("APROBADO");
        for (Iterator<ProyectoCliente> it = lista.iterator(); it.hasNext();) {
            ProyectoCliente p = it.next();
            ItemProyecto item = new ItemProyecto(p.getUbicacion(), p.getPresupuesto(),p.getEstado(), p.getAvance(), p.getPropietario().getNombre()+ " " + p.getPropietario().getApellido(), p.getTipoVivienda().getTipo(),p.getFechaEntrega());
            listaDatos.add(item);
        }
        return compilarReporte(parametros, listaDatos, "ListaProyectoAprobados");
    }

    public byte[] genRepProyectosRechazados(){
        ProyectoDAO pdao = new ProyectoDAO();
        Map parametros = new HashMap();
        //parametros.put("TITULO", "reported de...");

        List<ItemProyecto> listaDatos = new ArrayList<ItemProyecto>();
        List<ProyectoCliente> lista = pdao.buscarProyectoClientePorEstado("RECHAZADO");
        for (Iterator<ProyectoCliente> it = lista.iterator(); it.hasNext();) {
            ProyectoCliente p = it.next();
            ItemProyecto item = new ItemProyecto(p.getUbicacion(), p.getPresupuesto(),p.getEstado(), p.getAvance(), p.getPropietario().getNombre()+" "+ p.getPropietario().getApellido(), p.getTipoVivienda().getTipo(), p.getFechaEntrega());
            listaDatos.add(item);
        }
        return compilarReporte(parametros, listaDatos, "ListaProyectoRechazados");
    }


    public byte[] compilarReporte(Map parametros, List listaDatos, String nombrePlantilla){
        byte[] data = null;

        JasperPrint jasperPrint = null;
        JasperReport jasperReport = null;
        JRDataSource dataSource = null;

        if(listaDatos.size() > 0){
             dataSource = new JRBeanCollectionDataSource(listaDatos);
        }else{
            dataSource = new JREmptyDataSource();
        }

        InputStream inputStream= null;
        try {
            inputStream = ServicioReportes.class.getResourceAsStream(PATH_PLANTILLA + nombrePlantilla + SUFIJO_PLANTILLA);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            jasperReport = JasperCompileManager.compileReport(inputStream);
            jasperPrint = JasperFillManager.fillReport( jasperReport, parametros, dataSource);
            data = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception ex) {
            Logger.getLogger(ServicioReportes.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                inputStream.close();
            } catch (Exception e) {}
        }
        return  data;
    }
    
}
