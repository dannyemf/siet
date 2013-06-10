
package sietice.reportes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LENIN
 */


public class ItemProyecto {

    private String ubicacion;
    private Double presupuesto;
    private String estado;
    private String avance;
    private String propietario;
    private String tipovivienda;
    private String fechaEntrega;

    public ItemProyecto(String ubicacion, Double presupuesto, String estado, String Avance, String propietario, String tipoVivienda, Date fechaEntrega) {
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
        this.estado = estado;
        this.avance = Avance;
        this.propietario = propietario;
        this.tipovivienda = tipoVivienda;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaEntrega=f.format(fechaEntrega);

    }

    
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
        return avance;
    }

    /**
     * @param Avance the Avance to set
     */
    public void setAvance(String Avance) {
        this.avance = Avance;
    }

    /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * @return the tipoVivienda
     */
    public String getTipovivienda() {
        return tipovivienda;
    }

    /**
     * @param tipoVivienda the tipoVivienda to set
     */
    public void setTipovivienda(String tipoVivienda) {
        this.tipovivienda = tipoVivienda;
    }

    /**
     * @return the fechaEntrega
     */
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

}
