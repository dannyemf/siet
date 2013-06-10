/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import com.icesoft.faces.component.inputfile.InputFile;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.EventObject;
import javax.faces.FacesException;
import siet.dao.*;
import siet.modelo.Documentacion;
import siet.util.StringUtil;
import sietice.SietApplicationBean;
import sietice.SubirDocumentacionCliente;





public class ServicioDocumentacion extends AbstractSessionBean {

    private Documentacion DocumentacionEdicion = null;
    private Documentacion DodumentacionLogeado = null;
    private int progreso;
    private int progreso2;
    private int progreso3;
    private int progreso4;
    private int progreso5;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">


    private void _init() throws Exception {
    }

    public ServicioDocumentacion() {
    }

    @Override
    public void init() {

        super.init();

        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
    }


    @Override
    public void passivate() {
    }

    @Override
    public void activate() {
    }


    @Override
    public void destroy() {
    }

    public ServicioCliente getServicioCliente(){
        return (ServicioCliente)getBean("ServicioCliente");
    }

    public SubirDocumentacionCliente getSubirDocumentacionCliente(){
        return (SubirDocumentacionCliente)getBean("SubirDocumentacionCliente");
    }

    public void nuevo(){
        Documentacion doc = new DocumentacionDAO().buscarPorCliente(getServicioCliente().getClienteLogeado());
        if(doc == null){
            doc = new Documentacion();
            doc.setCliente(getServicioCliente().getClienteLogeado());
        }
        fijarProgreso(doc);
        setDocumentacionEdicion(doc);
        getSubirDocumentacionCliente().editar(doc);
    }
    public void editar(Documentacion doc){
        fijarProgreso(doc);
        this.setDocumentacionEdicion(doc);
        getSubirDocumentacionCliente().editar(doc);
    }

    private void fijarProgreso(Documentacion doc){
        if(StringUtil.isNullOrEmpty(doc.getImgCedula())){
            progreso = 0;
        }else{
            progreso = 100;
        }

        if(StringUtil.isNullOrEmpty(doc.getImgCertificado())){
            progreso2 = 0;
        }else{
            progreso2 = 100;
        }

        if(StringUtil.isNullOrEmpty(doc.getImgEscritura())){
            progreso3 = 0;
        }else{
            progreso3 = 100;
        }

        if(StringUtil.isNullOrEmpty(doc.getImgLibreta())){
            progreso4 = 0;
        }else{
            progreso4 = 100;
        }

        if(StringUtil.isNullOrEmpty(doc.getImgTerreno())){
            progreso5 = 0;
        }else{
            progreso5 = 100;
        }
    }

    public boolean guardar(){
        boolean b = false;
        if(getDocumentacionEdicion().getId().longValue() == -1){
            b = new DocumentacionDAO().guardar(getDocumentacionEdicion());
        }else{
            b = new DocumentacionDAO().actualizar(getDocumentacionEdicion());
        }
        return b;

    }
    public boolean verificaCed(){
         boolean b = false;
         if(getDocumentacionEdicion().getImgCedula().isEmpty()){
         b=true;
         return b;
         }else{b=false;
         return b;}
        
    }

    public void progresoCargaArchivo(EventObject event)
    {
    InputFile ifile = (InputFile) event.getSource();
        setProgreso(ifile.getFileInfo().getPercent());
    }
       public void progresoCargaArchivo2(EventObject event)
    {
    InputFile ifile = (InputFile) event.getSource();
        setProgreso2(ifile.getFileInfo().getPercent());
    }
         public void progresoCargaArchivo3(EventObject event)
    {
    InputFile ifile = (InputFile) event.getSource();
        setProgreso3(ifile.getFileInfo().getPercent());
    }

     public void progresoCargaArchivo4(EventObject event)
    {
    InputFile ifile = (InputFile) event.getSource();
        setProgreso4(ifile.getFileInfo().getPercent());
    }
      public void progresoCargaArchivo5(EventObject event)
    {
    InputFile ifile = (InputFile) event.getSource();
        setProgreso5(ifile.getFileInfo().getPercent());
    }
    /**
     * @return the DocumentacionEdicion
     */
    public Documentacion getDocumentacionEdicion() {
        return DocumentacionEdicion;
    }

    /**
     * @param DocumentacionEdicion the DocumentacionEdicion to set
     */
    public void setDocumentacionEdicion(Documentacion DocumentacionEdicion) {
        this.DocumentacionEdicion = DocumentacionEdicion;
    }

    /**
     * @return the DodumentacionLogeado
     */
    public Documentacion getDodumentacionLogeado() {
        return DodumentacionLogeado;
    }

    /**
     * @param DodumentacionLogeado the DodumentacionLogeado to set
     */
    public void setDodumentacionLogeado(Documentacion DodumentacionLogeado) {
        this.DodumentacionLogeado = DodumentacionLogeado;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SietApplicationBean getSietApplicationBean() {
        return (SietApplicationBean) getBean("SietApplicationBean");
    }

    /**
     * @return the progreso
     */
    public int getProgreso() {
        return progreso;
    }

    /**
     * @param progreso the progreso to set
     */
    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    /**
     * @return the progreso2
     */
    public int getProgreso2() {
        return progreso2;
    }

    /**
     * @param progreso2 the progreso2 to set
     */
    public void setProgreso2(int progreso2) {
        this.progreso2 = progreso2;
    }

    /**
     * @return the progreso3
     */
    public int getProgreso3() {
        return progreso3;
    }

    /**
     * @param progreso3 the progreso3 to set
     */
    public void setProgreso3(int progreso3) {
        this.progreso3 = progreso3;
    }

    /**
     * @return the progreso4
     */
    public int getProgreso4() {
        return progreso4;
    }

    /**
     * @param progreso4 the progreso4 to set
     */
    public void setProgreso4(int progreso4) {
        this.progreso4 = progreso4;
    }

    /**
     * @return the progreso5
     */
    public int getProgreso5() {
        return progreso5;
    }

    /**
     * @param progreso5 the progreso5 to set
     */
    public void setProgreso5(int progreso5) {
        this.progreso5 = progreso5;
    }

}