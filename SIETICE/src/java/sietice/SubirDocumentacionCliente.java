/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sietice;

import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.webapp.http.servlet.InterceptingServletSession;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import java.util.Date;
import java.util.ResourceBundle;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import siet.servicio.ServicioCliente;
import siet.modelo.Documentacion;
import siet.servicio.ServicioDocumentacion;
import siet.util.StringUtil;
import siet.util.ThumbailUtil;
import sietice.reportes.RecursoFile;

public class SubirDocumentacionCliente extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private siet.modelo.Documentacion currenDocumentacion;
    private Object cliente = null;
    private RecursoFile recursoAyuda;

    private void _init() throws Exception {
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SubirDocumentacionCliente() {
    }

    @Override
    public void init() {
// Perform initializations inherited from our superclass
        // Perform initializations inherited from our superclass
        super.init();
// Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
// <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
// Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

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
    private Boolean bandcedula;

    public void editar(Documentacion doc) {
        msgCedula = doc.getImgCedula();
        //ok1=doc.getImgCedula();
        msgCertificado = doc.getImgCertificado();
        msgEscritura = doc.getImgEscritura();
        msgLibreat = doc.getImgLibreta();
        msgTerreno = doc.getImgTerreno();

    }

    public ServicioCliente getServicioCliente() {
        return (ServicioCliente) getBean("ServicioCliente");
    }

    public ServicioDocumentacion getServicioDocumentacion() {
        return (ServicioDocumentacion) getBean("ServicioDocumentacion");
    }

    //value="#{SubirDocumentacionCliente.servicioDocumentacion.documentacionEdicion.imgCedula}"
    public boolean isImagenValida(InputFile file) {
        boolean b = false;

        if (file.getFileInfo() != null) {
            String ct = file.getFileInfo().getContentType();
            if (ct.equals("image/jpg") || ct.equals("image/jpeg") || ct.equals("image/png") || ct.equals("application/pdf")) {
                b = true;
            }
        }

        if (b == false) {
            FacesMessage fm = new FacesMessage("Formato de archivo no permitido");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(file.getClientId(FacesContext.getCurrentInstance()), fm);
        } else {
            FacesMessage fm = new FacesMessage("Archivo subido correctamente");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(file.getClientId(FacesContext.getCurrentInstance()), fm);
        }

        return b;
    }
    private File fileCeddula;
    private File fileLibreta;
    private File fileEscritura;
    private File fileFotoTerreno;
    private File fileCertRegistro;
    private String msgCedula;
    private String msgLibreat;
    private String msgEscritura;
    private String msgTerreno;
    private String msgCertificado;

    /**
     * @return the fileCeddula
     */
    public File getFileCeddula() {
        return fileCeddula;
    }

    /**
     * @param fileCeddula the fileCeddula to set
     */
    public void setFileCeddula(File fileCeddula) {
        this.fileCeddula = fileCeddula;
    }

    /**
     * @return the fileLibreta
     */
    public File getFileLibreta() {
        return fileLibreta;
    }

    /**
     * @param fileLibreta the fileLibreta to set
     */
    public void setFileLibreta(File fileLibreta) {
        this.fileLibreta = fileLibreta;
    }

    /**
     * @return the fileEscritura
     */
    public File getFileEscritura() {
        return fileEscritura;
    }

    public void setFileEscritura(File fileEscritura) {
        this.fileEscritura = fileEscritura;
    }

    /**
     * @return the fileFotoTerreno
     */
    public File getFileFotoTerreno() {
        return fileFotoTerreno;
    }

    /**
     * @param fileFotoTerreno the fileFotoTerreno to set
     */
    public void setFileFotoTerreno(File fileFotoTerreno) {
        this.fileFotoTerreno = fileFotoTerreno;
    }

    public File getFileCertRegistro() {
        return fileCertRegistro;
    }

    /**
     * @param fileCertRegistro the fileCertRegistro to set
     */
    public void setFileCertRegistro(File fileCertRegistro) {
        this.fileCertRegistro = fileCertRegistro;
    }
//     public void fileUpcedula_validate(FacesContext context, UIComponent component, Object value) {
//        FileInfo x = (FileInfo)value;
//        if(isImagenValida(x) == false){
//            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir una imagen jpg", "");
//            throw new ValidatorException(fm);
//        }
//    }
//
//    public void fileUplibreta_validate(FacesContext context, UIComponent component, Object value) {
//        if(value != null){
//            FileInfo x = (FileInfo)value;
//            long z = x.getSize();
//
//            String r = x.getFileName();
//
//            if(isImagenValida(x) == false){
//                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir solo jpg", "");
//                throw new ValidatorException(fm);
//            }
//        }else{
//            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir un archivo", "");
//            throw new ValidatorException(fm);
//        }
//    }
//
//    public void fileUpescritura_validate(FacesContext context, UIComponent component, Object value) {
//        if(value != null){
//            FileInfo x = (FileInfo)value;
//            if(isImagenValida(x) == false){
//                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir solo jpg", "");
//                throw new ValidatorException(fm);
//            }
//        }else{
//            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir un archivo", "");
//            throw new ValidatorException(fm);
//        }
//    }
//
//    public void fileUpcertRegistra_validate(FacesContext context, UIComponent component, Object value) {
//        if(value != null){
//            FileInfo x = (FileInfo)value;
//            if(isImagenValida(x) == false){
//                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir solo jpg", "");
//                throw new ValidatorException(fm);
//            }
//        }else{
//            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir un archivo", "");
//            throw new ValidatorException(fm);
//        }
//    }
//
//    public void fileUpfototerreno_validate(FacesContext context, UIComponent component, Object value) {
//        if(value != null){
//            FileInfo x = (FileInfo)value;
//            if(isImagenValida(x) == false){
//                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir solo jpg", "");
//                throw new ValidatorException(fm);
//            }
//        }else{
//            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe subir un archivo", "");
//            throw new ValidatorException(fm);
//        }
//    }

    public void fileUpcedula_processAction(ActionEvent ae) {
        InputFile fi = (InputFile) ae.getSource();

        if (isImagenValida(fi)) {
            if (fileCeddula != null) {
                fileCeddula.delete();
            }

            File f = new File(fi.getFile().getParent() + File.separator + new Date().getTime() + "_" + fi.getFile().getName());
            fi.getFile().renameTo(f);
            fileCeddula = f;

            this.msgCedula = fileCeddula.getName();
            setBandcedula(true);
        }else{
            if(StringUtil.isNullOrEmpty(this.msgCedula)){
                getServicioDocumentacion().setProgreso(0);
            }
        }

    }

    public void fileUplibreta_processAction(ActionEvent ae) {
        InputFile fi = (InputFile) ae.getSource();

        if (isImagenValida(fi)) {
            if (fileLibreta != null) {
                fileLibreta.delete();
            }
            File f = new File(fi.getFile().getParent() + File.separator + new Date().getTime() + "_" + fi.getFile().getName());
            fi.getFile().renameTo(f);
            fileLibreta = f;
            this.msgLibreat = fileLibreta.getName();
        }else{
            if(StringUtil.isNullOrEmpty(this.msgLibreat)){
                getServicioDocumentacion().setProgreso2(0);
            }
        }
    }

    public void fileUpescritura_processAction(ActionEvent ae) {
        InputFile fi = (InputFile) ae.getSource();

        if (isImagenValida(fi)) {
            if (fileEscritura != null) {
                fileEscritura.delete();
            }
            File f = new File(fi.getFile().getParent() + File.separator + new Date().getTime() + "_" + fi.getFile().getName());
            fi.getFile().renameTo(f);
            fileEscritura = f;
            this.msgEscritura = fileEscritura.getName();
        }else{
            if(StringUtil.isNullOrEmpty(this.msgEscritura)){
                getServicioDocumentacion().setProgreso3(0);
            }
        }
    }

    public void fileUpcertRegistra_processAction(ActionEvent ae) {
        InputFile fi = (InputFile) ae.getSource();

        if (isImagenValida(fi)) {
            if (fileCertRegistro != null) {
                fileCertRegistro.delete();
            }
            File f = new File(fi.getFile().getParent() + File.separator + new Date().getTime() + "_" + fi.getFile().getName());
            fi.getFile().renameTo(f);
            fileCertRegistro = f;
            this.msgCertificado = fileCertRegistro.getName();
        }else{
            if(StringUtil.isNullOrEmpty(this.msgCertificado)){
                getServicioDocumentacion().setProgreso4(0);
            }
        }
    }

    public void fileUpfototerreno_processAction(ActionEvent ae) {
        InputFile fi = (InputFile) ae.getSource();

        if (isImagenValida(fi)) {
            if (fileFotoTerreno != null) {
                fileFotoTerreno.delete();
            }
            File f = new File(fi.getFile().getParent() + File.separator + new Date().getTime() + "_" + fi.getFile().getName());
            fi.getFile().renameTo(f);
            fileFotoTerreno = f;
            this.msgTerreno = fileFotoTerreno.getName();
        }else{
            if(StringUtil.isNullOrEmpty(this.msgTerreno)){
                getServicioDocumentacion().setProgreso5(0);
            }
        }
    }

    public RecursoFile getRecursoAyuda() {
        InterceptingServletSession e = (InterceptingServletSession) getExternalContext().getSession(true);
        String c = e.getServletContext().getRealPath("/") + "recursos" + File.separator + "Ayuda_Cliente.pdf";
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
     * @return the msgCedula
     */
    public String getMsgCedula() {
        return msgCedula;
    }

    /**
     * @param msgCedula the msgCedula to set
     */
    public void setMsgCedula(String msgCedula) {
        this.msgCedula = msgCedula;
    }

    /**
     * @return the msgLibreat
     */
    public String getMsgLibreat() {
        return msgLibreat;
    }

    /**
     * @param msgLibreat the msgLibreat to set
     */
    public void setMsgLibreat(String msgLibreat) {
        this.msgLibreat = msgLibreat;
    }

    /**
     * @return the msgEscritura
     */
    public String getMsgEscritura() {
        return msgEscritura;
    }

    /**
     * @param msgEscritura the msgEscritura to set
     */
    public void setMsgEscritura(String msgEscritura) {
        this.msgEscritura = msgEscritura;
    }

    /**
     * @return the msgTerreno
     */
    public String getMsgTerreno() {
        return msgTerreno;
    }

    /**
     * @param msgTerreno the msgTerreno to set
     */
    public void setMsgTerreno(String msgTerreno) {
        this.msgTerreno = msgTerreno;
    }

    /**
     * @return the msgCertificado
     */
    public String getMsgCertificado() {
        return msgCertificado;
    }

    /**
     * @param msgCertificado the msgCertificado to set
     */
    public void setMsgCertificado(String msgCertificado) {
        this.msgCertificado = msgCertificado;
    }

    /**
     * @return the bandcedula
     */
    public Boolean getBandcedula() {
        return bandcedula;
    }

    /**
     * @param bandcedula the bandcedula to set
     */
    public void setBandcedula(Boolean bandcedula) {
        this.bandcedula = bandcedula;
    }

    public String fileUplibreta_action() {

        return null;
    }

    public String btnaceptar_action() {
        ResourceBundle r = ResourceBundle.getBundle("conf");
        String rutaDocs = r.getString("siet_files_path") + "/documentos/";

        Documentacion d = getServicioDocumentacion().getDocumentacionEdicion();
        boolean b = true;

        if (b) {
            if (fileCeddula != null) {
                fileCeddula.renameTo(new File(rutaDocs + fileCeddula.getName()));
                //File f = new File(rutaDocs+d.getImgCedula());
                // f.delete();
                d.setImgCedula(msgCedula);

                ThumbailUtil.crearThumbail(rutaDocs + fileCeddula.getName(), rutaDocs + "thumb/" + fileCeddula.getName(), 200, 200);
            }
            if (fileCertRegistro != null) {
                fileCertRegistro.renameTo(new File(rutaDocs + fileCertRegistro.getName()));
                File f = new File(rutaDocs + d.getImgCertificado());
                f.delete();
                d.setImgCertificado(msgCertificado);

                ThumbailUtil.crearThumbail(rutaDocs + fileCertRegistro.getName(), rutaDocs + "thumb/" + fileCertRegistro.getName(), 200, 200);
            }
            if (fileEscritura != null) {
                fileEscritura.renameTo(new File(rutaDocs + fileEscritura.getName()));
                File f = new File(rutaDocs + d.getImgEscritura());
                f.delete();
                d.setImgEscritura(msgEscritura);

                ThumbailUtil.crearThumbail(rutaDocs + fileEscritura.getName(), rutaDocs + "thumb/" + fileEscritura.getName(), 200, 200);
            }
            if (fileFotoTerreno != null) {
                fileFotoTerreno.renameTo(new File(rutaDocs + fileFotoTerreno.getName()));
                File f = new File(rutaDocs + d.getImgTerreno());
                f.delete();
                d.setImgTerreno(msgTerreno);

                ThumbailUtil.crearThumbail(rutaDocs + fileFotoTerreno.getName(), rutaDocs + "thumb/" + fileFotoTerreno.getName(), 200, 200);
            }
            if (fileLibreta != null) {
                fileLibreta.renameTo(new File(rutaDocs + fileLibreta.getName()));
                File f = new File(rutaDocs + d.getImgLibreta());
                f.delete();
                d.setImgLibreta(msgLibreat);

                ThumbailUtil.crearThumbail(rutaDocs + fileLibreta.getName(), rutaDocs + "thumb/" + fileLibreta.getName(), 200, 200);
            }

            getServicioDocumentacion().guardar();

            fileCeddula = null;
            fileCertRegistro = null;
            fileEscritura = null;
            fileFotoTerreno = null;
            fileLibreta = null;
            msgCedula = null;
            msgCertificado = null;
            msgEscritura = null;
            msgLibreat = null;
            msgTerreno = null;
            return "case-aceptadoc";
        }

        return null;
    }

    public void limpiar() {
    }

    public String btnatras_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        fileCeddula = null;
        fileCertRegistro = null;
        fileEscritura = null;
        fileFotoTerreno = null;
        fileLibreta = null;
        msgCedula = null;
        msgCertificado = null;
        msgEscritura = null;
        msgLibreat = null;
        msgTerreno = null;
        return "case1";
    }

    public String btnvolver_action() {
        // boorrar los files subidos
        fileCeddula = null;
        fileCertRegistro = null;
        fileEscritura = null;
        fileFotoTerreno = null;
        fileLibreta = null;
        msgCedula = null;
        msgCertificado = null;
        msgEscritura = null;
        msgLibreat = null;
        msgTerreno = null;
        return "case2";
    }

    public siet.modelo.Documentacion getCurrenDocumentacion() {
        //currenDocumentacion = new DocumentacionDAO().buscarPorCliente());
        if (currenDocumentacion == null) {
            currenDocumentacion = new siet.modelo.Documentacion();
        }
        return currenDocumentacion;
    }

    /**
     * @param currenDocumentacion the currenDocumentacion to set
     */
    public void setCurrenDocumentacion(siet.modelo.Documentacion currenDocumentacion) {
        this.currenDocumentacion = currenDocumentacion;
    }

    /**
     * @return the cliente
     */
    public Object getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Object cliente) {
        this.cliente = cliente;
    }
}

