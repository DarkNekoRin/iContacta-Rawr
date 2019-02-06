package com.ibk.rawr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DGOV_HALCON_PROMOCIONES_JSON",schema="DWHAC")
public class Campania {
	
    private Long id;   
    private String formulario;   
    private String codigoFb;   
    private String dni;  
    private Date fecha;   
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPANIA_SEQ")
    @SequenceGenerator(sequenceName = "campania_seq", allocationSize = 1, name = "CAMPANIA_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="FORMULARIO",nullable = false)
	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}
	@Column(name="CODIGO_FB")
	public String getCodigoFb() {
		return codigoFb;
	}

	public void setCodigoFb(String codigoFb) {
		this.codigoFb = codigoFb;
	}
	@Column(name="DNI", nullable=false)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	@Column(name = "FECHA", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
}
