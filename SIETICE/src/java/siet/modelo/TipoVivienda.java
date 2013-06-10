/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.modelo;

/**
 *
 * @author Principal
 */
public class TipoVivienda implements java.io.Serializable {

    private Long id=-1L;
    private String tipo="";
    private String estructura="Metalica";
    private String cubierta="Eternit";
    private String piso="Cemento";
    private String cielorazo="Revestido";
    private String paredes="Ladrillo";
    private String puertas="Madera";
    private String ventanas="Hierro";
    private String revestido="Enlucido";
    private double  presupuesto=0;
    private String plano="";
   
    private Double area = new Double(0);
    private Double valormetro = new Double(0);
    private String ambientes="";

    private Proyecto proyecto;

    /**
     * @return the id
     */

      public TipoVivienda() {
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

    /**
     * @return the instalelec
     */
    

    /**
     * @return the puertas
     */
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

    /**
     * @return the enlucido
     */
   
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
    public double getPresupuesto() {
        presupuesto = valormetro*area;
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
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

   
    public String getAmbientes() {
        return ambientes;
    }

    /**
     * @param ambientes the ambientes to set
     */
    public void setAmbientes(String ambientes) {
        this.ambientes = ambientes;
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
     * @return the valormetrocuadrado
     */
    public Double getValormetro() {
        return valormetro;
    }

    /**
     * @param valormetrocuadrado the valormetrocuadrado to set
     */
    public void setValormetro(Double valormetro) {
        this.valormetro = valormetro;
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
