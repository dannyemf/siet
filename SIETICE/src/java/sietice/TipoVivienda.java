/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.icesoft.faces.webapp.http.servlet.InterceptingServletSession;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import siet.servicio.ServicioEmpleado;
import siet.servicio.ServicioCliente;
import siet.servicio.ServicioProyecto;
import siet.dao.*;
import siet.modelo.Proyecto;
import siet.modelo.ProyectoCliente;
import siet.servicio.ServicioVivienda;
import sietice.reportes.RecursoFile;


public class TipoVivienda extends AbstractPageBean {
    
    private siet.modelo.TipoVivienda currenTipoVivienda;
    private siet.modelo.Proyecto currenProyecto;
    private Object tipo=null;
    private Object proyecto=null;
    private String plano = "";
    
    private RecursoFile recursoAyuda;
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

    private Double presupuesto;
    private ArrayList<SelectItem> tiposVivienda = null;
    private ArrayList<SelectItem> proyectos = null;

    public  ArrayList<SelectItem> getTiposVivienda() {
        
        tiposVivienda = new  ArrayList<SelectItem>();
        tiposVivienda.add(new SelectItem(null, "--Seleccione--"));

        List<siet.modelo.TipoVivienda> lst = new ArrayList<siet.modelo.TipoVivienda>();
        try {
            lst = new TipoViviendaDAO().buscarPorEq(siet.modelo.TipoVivienda.class, "proyecto.id", Long.parseLong(proyecto.toString()));
        } catch (Exception e) {}
        
        for (int i = 0; i < lst.size(); i++) {
            siet.modelo.TipoVivienda tp = lst.get(i);
            tiposVivienda.add(new SelectItem(tp.getId(), tp.getTipo()));
        }
        
        return tiposVivienda;
    }

    public void setTiposVivienda(ArrayList<SelectItem> tipos) {
        this.tiposVivienda = tipos;
    }


    public TipoVivienda() {
        
    }

    public void editar(ProyectoCliente pro){
        if(pro.getTipoVivienda() != null){
            tipo = pro.getTipoVivienda().getId();
        }else{
            tipo = null;
        }

        if(pro.getProyecto() != null){
            proyecto = pro.getProyecto().getId();
        }else{
            proyecto = null;
        }
    }

    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
       
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("TipoVivienda Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        
    }

    @Override
    public void preprocess() {
    }

    @Override
    public void prerender() {
    }

    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ServicioCliente getServicioCliente() {
        return (ServicioCliente) getBean("ServicioCliente");
    }

    

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    public  ServicioProyecto getServicioProyecto() {
        return (ServicioProyecto) getBean("ServicioProyecto");
    }

    public  ServicioVivienda getServicioVivienda() {
        return (ServicioVivienda) getBean("ServicioVivienda");
    }
    

    public void radioButton2_processValueChange(ValueChangeEvent event) {
    }

    public String btnaceptarvivienda_action() {
       // public boolean  =true;
            siet.modelo.TipoVivienda tp = getServicioVivienda().buscarPorId(tipo);
            getServicioProyecto().getProyectoClienteEdicion().setTipoVivienda(tp);
           // getServicioProyecto().getProyectoClienteEdicion().setProyecto(currenProyecto);
           siet.modelo.Proyecto p = getServicioProyecto().buscarPorId(proyecto);
           getServicioProyecto().getProyectoClienteEdicion().setProyecto(p);
           getServicioProyecto().getProyectoClienteEdicion().setPresupuesto(currenTipoVivienda.getPresupuesto());

            getServicioProyecto().guardarProyectoCliente();
        return "case1";
    }

    /**
     * @return the presupuesto
     */
   

    public String button1_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String btnvolver_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return "case2";
    }

   public RecursoFile getRecursoAyuda() {
        InterceptingServletSession e = (InterceptingServletSession)getExternalContext().getSession(true);
        String c = e.getServletContext().getRealPath("/")+"recursos"+File.separator+"Ayuda_Cliente.pdf";
        recursoAyuda = new RecursoFile(c);
        return recursoAyuda;
    }

    /**
     * @param recursoAyuda the recursoAyuda to set
     */
    public void setRecursoAyuda(RecursoFile recursoAyuda) {
        this.recursoAyuda = recursoAyuda;
    }

    /**
     * @return the currenTipoVivienda
     */
    public siet.modelo.TipoVivienda getCurrenTipoVivienda() {
        currenTipoVivienda = new TipoViviendaDAO().buscarPorId(tipo);
        if(currenTipoVivienda == null){
            currenTipoVivienda = new siet.modelo.TipoVivienda();
        }
        return currenTipoVivienda;
    }

    /**
     * @param currenTipoVivienda the currenTipoVivienda to set
     */
    public void setCurrenTipoVivienda(siet.modelo.TipoVivienda currenTipoVivienda) {
        this.currenTipoVivienda = currenTipoVivienda;
    }

    /**
     * @return the tipo
     */
    public Object getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    public void dropDown1_processValueChange(ValueChangeEvent event) {
        tipo = event.getNewValue();
    }
    
    /**
     * @return the plano
     */
    public String getPlano() {
        plano = "/planos/" + getCurrenTipoVivienda().getPlano();
        return plano;
    }

    /**
     * @param plano the plano to set
     */
    public void setPlano(String plano) {
        this.plano = plano;
    }

    /**
     * @return the presupuesto
     */
    public Double getPresupuesto() {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    
    /**
     * @return the proyecto
     */
    public Object getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
   

    public void setProyecto(Object proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * @return the proyectos
     */
    public ArrayList<SelectItem> getProyectos() {
        proyectos = new  ArrayList<SelectItem>();
        proyectos.add(new SelectItem(null, "--Seleccione--"));
        
        List<siet.modelo.Proyecto> lst = new ProyectoDAO().buscarTodos();
        for (int i = 0; i < lst.size(); i++) {
            siet.modelo.Proyecto p = lst.get(i);
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

    public void somTipoVivienda_processValueChange(ValueChangeEvent vce) {
    }

    public void somProyecto_processValueChange(ValueChangeEvent vce) {
    }

    /**
     * @return the currenProyecto
     */
    public siet.modelo.Proyecto getCurrenProyecto() {
        currenProyecto = new ProyectoDAO().buscarPorId(proyecto);
        if(currenProyecto == null){
            currenProyecto = new siet.modelo.Proyecto();
        }
        
        return currenProyecto;
    }

    /**
     * @param currenProyecto the currenProyecto to set
     */
    public void setCurrenProyecto(siet.modelo.Proyecto currenProyecto) {
        this.currenProyecto = currenProyecto;
    }

   



    
}

