/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.icesoft.faces.webapp.http.servlet.InterceptingServletSession;
import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.model.ArrayDataModel;
import siet.modelo.Empleado;
import siet.servicio.ServicioEmpleado;
import sietice.reportes.RecursoFile;


public class AdministrarPersonal extends AbstractPageBean {
    private RecursoFile recursoAyuda;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AdministrarPersonal() {
    }
        private String apellido = "";
        private ArrayDataModel listaCriterio = new ArrayDataModel();
       private ArrayDataModel modelEmpleados = new ArrayDataModel();

    public ArrayDataModel getModelEmpleados() {
       modelEmpleados = new ArrayDataModel(getServicioEmpleado().listarCriterio(apellido).toArray());
        return modelEmpleados;
    }

    public void setModelEmpleados(ArrayDataModel modelEmpleados) {
        this.modelEmpleados = modelEmpleados;
    }

    public RecursoFile getRecursoAyuda() {
        InterceptingServletSession e = (InterceptingServletSession)getExternalContext().getSession(true);
        String c = e.getServletContext().getRealPath("/")+"recursos"+File.separator+"Ayuda_Admin.pdf";
        recursoAyuda = new RecursoFile(c);
        return recursoAyuda;
    }


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
            log("AdministrarEmpleado Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
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

    

    public String btnvolver_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return "case1";
    }

    public String button1_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }
 public ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }
    public String bntnuevoempleado_action() {
        // TODO: Process the button click action. Return value is a navigation
        getServicioEmpleado().nuevo();
        // case name where null will return to the same page.
        return "cregistrp";
    }

    public String linkActionEditar_action() {
     Empleado e = (Empleado)modelEmpleados.getRowData();
        getServicioEmpleado().editar(e);
        return "ceditp";
    }

    public String btnvolver1_action() {
        //return null means stay on the same page
        return null;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the listaCriterio
     */
    public ArrayDataModel getListaCriterio() {
        return listaCriterio;
    }

    /**
     * @param listaCriterio the listaCriterio to set
     */
    public void setListaCriterio(ArrayDataModel listaCriterio) {
        this.listaCriterio = listaCriterio;
    }

    public String btn_Buscar1_action() {
        List<Empleado> lista = getServicioEmpleado().listarCriterio(apellido);
        modelEmpleados = new ArrayDataModel(lista.toArray());
        //return null means stay on the same page
        return null;
    }
    
}

