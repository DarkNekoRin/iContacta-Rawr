package com.hellokoding.auth.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DGOV_DATAENTRY_TMP",schema="dwhac")
public class DataEntry {
	
    private Long id;   
    private String tipoDocumento;   
    private String documento;  
    private Boolean flgTelefono;   
    private Boolean flgEmail;
    private Boolean flgDireccion;
	private User usuarioSolicitud;
    private Date fechaRegistro;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATAENTRY_SEQ")
    @SequenceGenerator(sequenceName = "dataentry_seq", allocationSize = 1, name = "DATAENTRY_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	@Column(name="TIPDOC")
    public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	 @Column(name="CODOC")
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	  @Column(name="FLG_TELEFONO")
	public Boolean getFlgTelefono() {
		return flgTelefono;
	}

	public void setFlgTelefono(Boolean flgTelefono) {
		this.flgTelefono = flgTelefono;
	}
	 @Column(name="FLG_EMAIL")
	public Boolean getFlgEmail() {
		return flgEmail;
	}

	public void setFlgEmail(Boolean flgEmail) {
		this.flgEmail = flgEmail;
	}
	@Column(name="FLG_DIRECCION")
	public Boolean getFlgDireccion() {
		return flgDireccion;
	}

	public void setFlgDireccion(Boolean flgDireccion) {
		this.flgDireccion = flgDireccion;
	}
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USU_SOLICITUD")
	public User getUsuarioSolicitud() {
		return usuarioSolicitud;
	}

	public void setUsuarioSolicitud(User usuarioSolicitud) {
		this.usuarioSolicitud = usuarioSolicitud;
	}
	@Column(name="FEC_REGISTRO", columnDefinition = "date")
    @Temporal(TemporalType.DATE)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
