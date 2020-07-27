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
public class DepartamentoModel {
    

    
    /**
     * @return the departamentoId
     */
    public int getDepartamentoId() {
        return departamentoId;
    }

    /**
     * @param departamentoId the departamentoId to set
     */
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    /**
     * @return the descripcionDepartamento
     */
    public String getDescripcionDepartamento() {
        return descripcionDepartamento;
    }

    /**
     * @param descripcionDepartamento the descripcionDepartamento to set
     */
    public void setDescripcionDepartamento(String descripcionDepartamento) {
        this.descripcionDepartamento = descripcionDepartamento;
    }

    /**
     * @return the gerenciaId
     */
    public int getGerenciaId() {
        return gerenciaId;
    }

    /**
     * @param gerenciaId the gerenciaId to set
     */
    public void setGerenciaId(int gerenciaId) {
        this.gerenciaId = gerenciaId;
    }
    
    
    private int departamentoId;
    private String descripcionDepartamento;
    private int gerenciaId;
    
}
