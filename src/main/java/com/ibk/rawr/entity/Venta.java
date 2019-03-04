package com.ibk.rawr.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "DGOV_VENTA_DIGITAL_JSON",schema="DWHAC")
public class Venta {
	
    private Long idExpediente;   
    private String documento;   
    private String correo;   
    private String celular; 
    private String estado;  
    private String codigoSiebel; 
    private String tipDocumento;
    
    private java.util.Calendar fechaRegistroBD;   
    private String fechaRegistro;  
    
    private String campaniaWeb;
    private String lpdp;
    private String num;
    
    
    @Id
    @Column(name="ID_EXPEDIENTE")
    public Long getIdExpediente() {
        return idExpediente;
    }
   
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Column(name="CODIGO_SIEBEL")
	public String getCodigoSiebel() {
		return codigoSiebel;
	}

	public void setCodigoSiebel(String codigoSiebel) {
		this.codigoSiebel = codigoSiebel;
	}
	@Column(name="TIPO_DOCUMENTO")
	public String getTipDocumento() {
		return tipDocumento;
	}

	public void setTipDocumento(String tipDocumento) {
		this.tipDocumento = tipDocumento;
	}
	@Column(name="CAMPANIA_WEB")
	public String getCampaniaWeb() {
		return campaniaWeb;
	}

	public void setCampaniaWeb(String campaniaWeb) {
		this.campaniaWeb = campaniaWeb;
	}

	public String getLpdp() {
		return lpdp;
	}

	public void setLpdp(String lpdp) {
		this.lpdp = lpdp;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}
	@Basic
	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	public java.util.Calendar getFechaRegistroBD() {
		return fechaRegistroBD;
	}
	public void setFechaRegistroBD(java.util.Calendar fechaRegistroBD) {
		this.fechaRegistroBD = fechaRegistroBD;
	}
	@Transient
	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}	
	
	 
}
