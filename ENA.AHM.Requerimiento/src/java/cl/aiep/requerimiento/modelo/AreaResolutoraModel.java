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
public class AreaResolutoraModel {
    
        public AreaResolutoraModel(){
    
    }
    
     public AreaResolutoraModel(int areaResolutoraId, String descripcionArea){
         
         this.areaResolutoraId = areaResolutoraId;
         this.descripcionArea = descripcionArea;
    }

    /**
     * @return the areaResolutoraId
     */
    public int getAreaResolutoraId() {
        return areaResolutoraId;
    }

    /**
     * @param areaResolutoraId the areaResolutoraId to set
     */
    public void setAreaResolutoraId(int areaResolutoraId) {
        this.areaResolutoraId = areaResolutoraId;
    }

    /**
     * @return the descripcionArea
     */
    public String getDescripcionArea() {
        return descripcionArea;
    }

    /**
     * @param descripcionArea the descripcionArea to set
     */
    public void setDescripcionArea(String descripcionArea) {
        this.descripcionArea = descripcionArea;
    }
    
    private int areaResolutoraId;
    private String descripcionArea;
    
}
