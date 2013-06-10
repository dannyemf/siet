package siet.modelo;
import java.util.Date;

public class Cliente  implements java.io.Serializable {
     private Long id=-1L;
     
     private String ci = "";
     private String nombre = "";
     private String apellido= "";
     private String apellidodos= "";
     private String celular= "";
     private String direccion= "";
     private String sexo= "";
     private String clave= "";
     private String verificaclave= "";
     private Date fechaNac = new Date();
     private String estadoCivil = "";

    public Cliente() {
        fechaNac = new Date();
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCi() {
        return this.ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the apellidodos
     */
    public String getApellidodos() {
        return apellidodos;
    }

    /**
     * @param apellidodos the apellidodos to set
     */
    public void setApellidodos(String apellidodos) {
        this.apellidodos = apellidodos;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the fechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the verificaclave
     */
    public String getVerificaclave() {
        return verificaclave;
    }

    /**
     * @param verificaclave the verificaclave to set
     */
    public void setVerificaclave(String verificaclave) {
        this.verificaclave = verificaclave;
    }

   

    /**
     * @return the confirclave
     */
   




}


