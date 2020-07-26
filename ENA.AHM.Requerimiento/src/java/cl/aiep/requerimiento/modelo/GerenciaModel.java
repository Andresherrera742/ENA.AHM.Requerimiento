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
public class GerenciaModel {

    /**
     * @return the departamento
     */
    public DepartamentoModel getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(DepartamentoModel departamento) {
        this.departamento = departamento;
    }
    
    
    public GerenciaModel(){
    
    }
    
     public GerenciaModel(int gerenciaId, String descripcionGerencia){
         
         this.gerenciaId = gerenciaId;
         this.descripcionGerencia = descripcionGerencia;
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

    /**
     * @return the descripcionGerencia
     */
    public String getDescripcionGerencia() {
        return descripcionGerencia;
    }

    /**
     * @param descripcionGerencia the descripcionGerencia to set
     */
    public void setDescripcionGerencia(String descripcionGerencia) {
        this.descripcionGerencia = descripcionGerencia;
    }
    
    private int gerenciaId;
    private String descripcionGerencia;
    private DepartamentoModel departamento;
    
}
