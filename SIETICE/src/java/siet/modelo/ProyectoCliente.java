package siet.modelo;
// Generated 25/05/2010 10:15:41 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;



/**
 * Cliente generated by hbm2java
 */
public class ProyectoCliente extends Object implements java.io.Serializable {

    private Long id = -1L;
    private Cliente propietario;
    private String ubicacion = "";
    private Double presupuesto = 0.0;
    private String estado = "EN PROCESO";
    private String Avance = "";
    private String observacion;
    private Date fechaCreacion = new Date();
    private Date fechaEntrega = new Date();
    private TipoVivienda tipoVivienda;
    private Empleado residente;
    private Proyecto proyecto;

    public ProyectoCliente() {
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    

    /**
     * @return the propietario
     */
    

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the Avance
     */
    public String getAvance() {
        return Avance;
    }

    /**
     * @param Avance the Avance to set
     */
    public void setAvance(String Avance) {
        this.Avance = Avance;
    }

    /**
     * @return the plano
     */
   

    /**
     * @return the tipo
     */
    public TipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipoVivienda(TipoVivienda tipo) {
        this.tipoVivienda = tipo;
    }

    /**
     * @return the propietario
     */
    public Cliente getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    /**
     * @return the residente
     */
    public Empleado getResidente() {
        return residente;
    }

    /**
     * @param residente the residente to set
     */
    public void setResidente(Empleado residente) {
        this.residente = residente;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "id: " + id + ", propietario: " + propietario.getNombre() +" "+ propietario.getApellido();
    }

    /**
     * @return the proyecto
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }


}


