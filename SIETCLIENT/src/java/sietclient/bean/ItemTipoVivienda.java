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
public class ItemTipoVivienda  implements Serializable{
    private Long id=-1L;
    private String tipo;
    private String estructura;
    private String cubierta;
    private String piso;
    private String cielorazo;
    private String puertas;
    private String ventanas;
    private String revestido;
    private String paredes;
    private String plano;
    private Double presupuesto;
    private Double area;

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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the estructura
     */
    public String getEstructura() {
        return estructura;
    }

    /**
     * @param estructura the estructura to set
     */
    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    /**
     * @return the cubierta
     */
    public String getCubierta() {
        return cubierta;
    }

    /**
     * @param cubierta the cubierta to set
     */
    public void setCubierta(String cubierta) {
        this.cubierta = cubierta;
    }

    /**
     * @return the piso
     */
    public String getPiso() {
        return piso;
    }

    /**
     * @param piso the piso to set
     */
    public void setPiso(String piso) {
        this.piso = piso;
    }

    /**
     * @return the cielorazo
     */
    public String getCielorazo() {
        return cielorazo;
    }

    /**
     * @param cielorazo the cielorazo to set
     */
    public void setCielorazo(String cielorazo) {
        this.cielorazo = cielorazo;
    }

   
    public String getPuertas() {
        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }

    /**
     * @return the ventanas
     */
    public String getVentanas() {
        return ventanas;
    }

    /**
     * @param ventanas the ventanas to set
     */
    public void setVentanas(String ventanas) {
        this.ventanas = ventanas;
    }

   
    public String getPlano() {
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
     * @return the area
     */
    public Double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * @return the paredes
     */
    public String getParedes() {
        return paredes;
    }

    /**
     * @param paredes the paredes to set
     */
    public void setParedes(String paredes) {
        this.paredes = paredes;
    }

    /**
     * @return the revestido
     */
    public String getRevestido() {
        return revestido;
    }

    /**
     * @param revestido the revestido to set
     */
    public void setRevestido(String revestido) {
        this.revestido = revestido;
    }
}
