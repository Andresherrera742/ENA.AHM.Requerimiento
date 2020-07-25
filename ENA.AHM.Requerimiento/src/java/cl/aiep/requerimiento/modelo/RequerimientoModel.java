/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.modelo;

import java.util.Date;

/**
 *
 * @author aeherrera
 */
public class RequerimientoModel {


    
    public RequerimientoModel(){
    
    }
    
     public RequerimientoModel(int requerimientoId, int gerenciaId, int departamentoId, int areaResolutoraId, int resolutorId, Date fechaIngreso, String requerimiento, String estado, Date fechaCierre){
         
         this.requerimientoId = requerimientoId;
         this.gerenciaId = gerenciaId;
         this.departamentoId = departamentoId;
         this.areaResolutoraId = areaResolutoraId;
         this.resolutorId = resolutorId;
         this.fechaIngreso = fechaIngreso;
         this.requerimiento = requerimiento;
         this.estado = estado;
         this.fechaCierre = fechaCierre;
         this.gerencia =  gerencia;
         this.departamento =  departamento;
         this.areaResolutora =  areaResolutora;
         this.resolutor =  resolutor;
         
    }
     
    public GerenciaModel getGerencia() {
        return gerencia;
    }

    /**
     * @param gerencia the gerencia to set
     */
    public void setGerencia(GerenciaModel gerencia) {
        this.gerencia = gerencia;
    }

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

    /**
     * @return the areaResolutora
     */
    public AreaResolutoraModel getAreaResolutora() {
        return areaResolutora;
    }

    /**
     * @param areaResolutora the areaResolutora to set
     */
    public void setAreaResolutora(AreaResolutoraModel areaResolutora) {
        this.areaResolutora = areaResolutora;
    }

    /**
     * @return the resolutor
     */
    public ResolutorModel getResolutor() {
        return resolutor;
    }

    /**
     * @param resolutor the resolutor to set
     */
    public void setResolutor(ResolutorModel resolutor) {
        this.resolutor = resolutor;
    }
    
    /**
     * @return the requerimientoId
     */
    public int getRequerimientoId() {
        return requerimientoId;
    }

    /**
     * @param requerimientoId the requerimientoId to set
     */
    public void setRequerimientoId(int requerimientoId) {
        this.requerimientoId = requerimientoId;
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
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the requerimiento
     */
    public String getRequerimiento() {
        return requerimiento;
    }

    /**
     * @param requerimiento the requerimiento to set
     */
    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
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
     * @return the fechaCierre
     */
    public Date getFechaCierre() {
        return fechaCierre;
    }

    /**
     * @param fechaCierre the fechaCierre to set
     */
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    private int requerimientoId;
    private int gerenciaId;
    private int departamentoId;
    private int areaResolutoraId;
    private int resolutorId;
    private Date fechaIngreso;
    private String requerimiento;
    private String estado;
    private Date fechaCierre;
    
    private GerenciaModel gerencia;
    private DepartamentoModel departamento;
    private AreaResolutoraModel areaResolutora;
    private ResolutorModel resolutor;
    
    
    
}
