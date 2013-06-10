/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietclient.bean;

import java.io.Serializable;

/**
 *
 * @author LENIN
 */
public class ItemProyecto implements Serializable {

    public ItemProyecto() {
    }

    private String contextPath = "";

    private Long id;
    private String ubicacion;
    private Double presupuesto = 0.0;
    private String estado = "";
    private String Avance = "";

    private ItemCliente propietario;
    private ItemTipoVivienda tipoVivienda;
    //private Empleado residente;

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
    public ItemCliente getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(ItemCliente propietario) {
        this.propietario = propietario;
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
     * @return the tipoVivienda
     */
    public ItemTipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    /**
     * @param tipoVivienda the tipoVivienda to set
     */
    public void setTipoVivienda(ItemTipoVivienda tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    /**
     * @return the contextPath
     */
    public String getContextPath() {
        return contextPath;
    }

    /**
     * @param contextPath the contextPath to set
     */
    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
