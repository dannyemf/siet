/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.icesoft.faces.component.inputfile.InputFile;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import org.imgscalr.Scalr;
import siet.modelo.Proyecto;
import siet.servicio.*;
import siet.util.StringUtil;
import siet.util.ThumbailUtil;


public class EditarTipoVivienda extends AbstractPageBean {
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
     * <p>Construct a new Page bean instance.</p>
     */

    private File filePlano;
    private String nombrePlano = "";
    private Object proyectoId;

    public EditarTipoVivienda() {
    }

    public void editar(siet.modelo.TipoVivienda tipo){
        proyectoId = tipo.getProyecto() != null ? tipo.getProyecto().getId() : null;        

        //Borra de cache
        if(filePlano != null){
            filePlano.delete();
            filePlano = null;
        }
        
        if(StringUtil.isNullOrEmpty(tipo.getPlano())){
            nombrePlano = "/resources/no_plano.png";
        }else{
            ResourceBundle r = ResourceBundle.getBundle("conf");
            String rutaPlanos = r.getString("siet_files_server")+"/planos/thumb/";
            nombrePlano = rutaPlanos + tipo.getPlano();
        }
        
    }

 
    @Override
    public void init() {
        
        super.init();

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("EditarTipoVivienda Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
 
    }

    private ArrayList<SelectItem> estructura;
    private ArrayList<SelectItem> cubierta;
    private ArrayList<SelectItem> piso;
    private ArrayList<SelectItem> tipo;
    private ArrayList<SelectItem> cielorazo;
    private ArrayList<SelectItem> puertas;
    private ArrayList<SelectItem> ventanas;
    private ArrayList<SelectItem> paredes;
    private ArrayList<SelectItem> revestido;

    private ArrayList<SelectItem> proyectos =   new ArrayList<SelectItem>();

    @Override
    public void preprocess() {
    }

    @Override
    public void prerender() {
    }

    @Override
    public void destroy() {
    }

   

   public ServicioProyecto getServicioProyecto() {
        return (ServicioProyecto) getBean("ServicioProyecto");
    }

    public ServicioVivienda getServicioVivienda() {
        return (ServicioVivienda) getBean("ServicioVivienda");
    }

   
    public ArrayList<SelectItem> getEstructura() {
        estructura = new ArrayList<SelectItem>();
        estructura.add(new SelectItem("Metalica", "Metalica"));
        estructura.add(new SelectItem("Hormigon", "Hormigon Armado"));
        estructura.add(new SelectItem("Mixta", "Mixta"));
        return estructura;
    }

    /**
     * @param estructura the estructura to set
     */
    public void setEstructura(ArrayList<SelectItem> estructura) {
        this.estructura = estructura;
    }

    public String btnaceptar_action() {
        if(filePlano != null){
            //HttpSession session = (HttpSession)getExternalContext().getSession(true);
            //String rutaPlanos = session.getServletContext().getRealPath("/")+"planos/";

            ResourceBundle r = ResourceBundle.getBundle("conf");
            String rutaPlanos = r.getString("siet_files_path")+"/planos/";
            
            String nombre = new Date().getTime() + "_" + filePlano.getName();
            String newRuta = rutaPlanos + nombre;            
            filePlano.renameTo(new File(newRuta));

            //crear thumbail
            String newRutaThumb = rutaPlanos + "thumb/" + nombre;
            ThumbailUtil.crearThumbail(newRuta, newRutaThumb, 369, 232);
            
            getServicioVivienda().getTipoViviendaEdicion().setPlano(nombre);
        }

        Proyecto p = getServicioProyecto().buscarPorId(proyectoId);
        getServicioVivienda().getTipoViviendaEdicion().setProyecto(p);

        boolean b = getServicioVivienda().guardar();
        if(b){
            // restura
            nombrePlano = "";
            filePlano = null;
            return "case1";
        }else{
            return null;
        }
    }

    /**
     * @return the cubierta
     */
    public ArrayList<SelectItem> getCubierta() {
        cubierta = new ArrayList<SelectItem>();
        cubierta.add(new SelectItem("Eternit", "Eternit"));
        cubierta.add(new SelectItem("Losa", "Losa"));
        return cubierta;
    }

    /**
     * @param cubierta the cubierta to set
     */
    public void setCubierta(ArrayList<SelectItem> cubierta) {
        this.cubierta = cubierta;
    }

    /**
     * @return the piso
     */
    public ArrayList<SelectItem> getPiso() {
        piso = new ArrayList<SelectItem>();
        piso.add(new SelectItem("Cemento", "Cemento"));
        piso.add(new SelectItem("Ceramica", "Ceramica"));
        return piso;
    }

    /**
     * @param piso the piso to set
     */
    public void setPiso(ArrayList<SelectItem> piso) {
        this.piso = piso;
    }

    /**
     * @return the tipo
     */
    public ArrayList<SelectItem> getTipo() {

        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(ArrayList<SelectItem> tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cielorazo
     */
    public ArrayList<SelectItem> getCielorazo() {
        cielorazo = new ArrayList<SelectItem>();
        cielorazo.add(new SelectItem("Revestido", "Revestido"));
        cielorazo.add(new SelectItem("Est.vista", "Estructura Vista"));
         cielorazo.add(new SelectItem("Playwood", "Playwood"));
        return cielorazo;
    }

    /**
     * @param cielorazo the cielorazo to set
     */
    public void setCielorazo(ArrayList<SelectItem> cielorazo) {
        this.cielorazo = cielorazo;
    }

    /**
     * @return the puertas
     */
    public ArrayList<SelectItem> getPuertas() {
         puertas = new ArrayList<SelectItem>();
        puertas.add(new SelectItem("Madera", "Madera"));
        puertas.add(new SelectItem("Metalica", "Metalica"));

        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(ArrayList<SelectItem> puertas) {
        this.puertas = puertas;
    }

    /**
     * @return the ventanas
     */
    public ArrayList<SelectItem> getVentanas() {
        ventanas = new ArrayList<SelectItem>();
        ventanas.add(new SelectItem("Hierro", "Hierro y vidrio"));
        ventanas.add(new SelectItem("Aluminio", "Aluminio y vidrio"));
        return ventanas;
    }

    /**
     * @param ventanas the ventanas to set
     */
    public void setVentanas(ArrayList<SelectItem> ventanas) {
        this.ventanas = ventanas;
    }

    public void dropdowncubierta_processValueChange(ValueChangeEvent vce) {
    }

    /**
     * @return the filePlano
     */
    public File getFilePlano() {
        return filePlano;
    }

    /**
     * @param filePlano the filePlano to set
     */
    public void setFilePlano(File filePlano) {
        this.filePlano = filePlano;
    }

    /**
     * @return the nombrePlano
     */
    public String getNombrePlano() {
        return nombrePlano;
    }

    /**
     * @param nombrePlano the nombrePlano to set
     */
    public void setNombrePlano(String nombrePlano) {
        this.nombrePlano = nombrePlano;
    }

    public void fileUploadPlano_processAction(ActionEvent ae) {
        InputFile fi = (InputFile)ae.getSource();
        
        if(filePlano != null && (filePlano.getName().equals(fi.getFileInfo().getFileName())) == false){
            filePlano.delete();
        }

        filePlano = fi.getFile();

        //crear thumbail tempralmente
        HttpSession session = (HttpSession)getExternalContext().getSession(true);
        String rutaPlanos = session.getServletContext().getRealPath("/")+"tmpupload/thumb/";
        String newRutaThumb = rutaPlanos + fi.getFileInfo().getFileName();
        ThumbailUtil.crearThumbail(fi.getFile().getAbsolutePath(), newRutaThumb, 369, 232);
        
        this.nombrePlano = "/tmpupload/thumb/" + fi.getFileInfo().getFileName();
    }

    public String btncancelar_action() {
        //return null means stay on the same page
        return "ccancelar";
    }

    /**
     * @return the paredes
     */
    public ArrayList<SelectItem> getParedes() {
           paredes = new ArrayList<SelectItem>();
        paredes.add(new SelectItem("Ladrillo", "Ladrillo"));
        paredes.add(new SelectItem("Bloque", "Bloque"));
        return paredes;
    }

    /**
     * @param paredes the paredes to set
     */
    public void setParedes(ArrayList<SelectItem> paredes) {
        this.paredes = paredes;
    }

    /**
     * @return the revestido
     */
    public ArrayList<SelectItem> getRevestido() {
        revestido = new ArrayList<SelectItem>();
        revestido.add(new SelectItem("Enlucido", "Revestido y Enlucido"));
        revestido.add(new SelectItem("Revestido", "Revestido"));
        revestido.add(new SelectItem("SinRevestir", "Sin Revestir"));
        return revestido;
    }

    /**
     * @param revestido the revestido to set
     */
    public void setRevestido(ArrayList<SelectItem> revestido) {
        this.revestido = revestido;
    }    

    /**
     * @return the proyectoId
     */
    public Object getProyectoId() {
        return proyectoId;
    }

    /**
     * @param proyectoId the proyectoId to set
     */
    public void setProyectoId(Object proyectoId) {
        this.proyectoId = proyectoId;
    }

    /**
     * @return the proyectos
     */
    public ArrayList<SelectItem> getProyectos() {

        proyectos = new ArrayList<SelectItem>();
        proyectos.add(new SelectItem("", "--Seleccione--"));

        List<Proyecto> lista = getServicioProyecto().listarProyectos();
        for (Iterator<Proyecto> it = lista.iterator(); it.hasNext();) {
            Proyecto p = it.next();
            proyectos.add(new SelectItem(p.getId(), p.getNombre()));
        }

        return proyectos;
    }

    /**
     * @param proyectos the proyectos to set
     */
    public void setProyectos(ArrayList<SelectItem> proyectos) {
        this.proyectos = proyectos;
    }
}

