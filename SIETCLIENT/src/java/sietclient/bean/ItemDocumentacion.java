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
public class ItemDocumentacion implements Serializable {
    private Long id = -1L;
    private String imgCedula;
    private String imgTerreno;
    private String imgCertificado;
    private String imgLibreta;
    private String imgEscritura;

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
     * @return the imgCedula
     */
    public String getImgCedula() {
        return imgCedula;
    }

    /**
     * @param imgCedula the imgCedula to set
     */
    public void setImgCedula(String imgCedula) {
        this.imgCedula = imgCedula;
    }

    /**
     * @return the imgTerreno
     */
    public String getImgTerreno() {
        return imgTerreno;
    }

    /**
     * @param imgTerreno the imgTerreno to set
     */
    public void setImgTerreno(String imgTerreno) {
        this.imgTerreno = imgTerreno;
    }

    /**
     * @return the imgCertificado
     */
    public String getImgCertificado() {
        return imgCertificado;
    }

    /**
     * @param imgCertificado the imgCertificado to set
     */
    public void setImgCertificado(String imgCertificado) {
        this.imgCertificado = imgCertificado;
    }

    /**
     * @return the imgLibreta
     */
    public String getImgLibreta() {
        return imgLibreta;
    }

    /**
     * @param imgLibreta the imgLibreta to set
     */
    public void setImgLibreta(String imgLibreta) {
        this.imgLibreta = imgLibreta;
    }

    /**
     * @return the imgEscritura
     */
    public String getImgEscritura() {
        return imgEscritura;
    }

    /**
     * @param imgEscritura the imgEscritura to set
     */
    public void setImgEscritura(String imgEscritura) {
        this.imgEscritura = imgEscritura;
    }
}
