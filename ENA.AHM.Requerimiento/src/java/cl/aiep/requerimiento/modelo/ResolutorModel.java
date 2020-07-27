/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.modelo;

/**
 *
 * @author aeherrera
 */
public class ResolutorModel {
    
    /**
     * @return the resolutorId
     */
    public int getResolutorId() {
        return resolutorId;
    }

    /**
     * @param resolutorId the resolutorId to set
     */
    public void setResolutorId(int resolutorId) {
        this.resolutorId = resolutorId;
    }

    /**
     * @return the nombreResolutor
     */
    public String getNombreResolutor() {
        return nombreResolutor;
    }

    /**
     * @param nombreResolutor the nombreResolutor to set
     */
    public void setNombreResolutor(String nombreResolutor) {
        this.nombreResolutor = nombreResolutor;
    }

    /**
     * @return the areaResolutorId
     */
    public int getAreaResolutorId() {
        return areaResolutorId;
    }

    /**
     * @param areaResolutorId the areaResolutorId to set
     */
    public void setAreaResolutorId(int areaResolutorId) {
        this.areaResolutorId = areaResolutorId;
    }
    
    private int resolutorId;
    private String nombreResolutor;
    private int areaResolutorId;
    
}
