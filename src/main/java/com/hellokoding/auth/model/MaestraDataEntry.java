package com.hellokoding.auth.model;

import javax.persistence.Basic;
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
@Table(name = "DGOV_MAESTRA_DATAENTRY",schema="dwhac")
public class MaestraDataEntry {
	private Long id;  
    private String idSolicitud;   
    private String tipoDocumento;   
    private String documento;  
    private Boolean flgTelefono;   
    private Boolean flgEmail;
    private Boolean flgDireccion;
    private String apePaterno;  
    private String apeMaterno;  
    private String primerNombre;  
    private String segundoNombre;
    
    private String numCelular1;
    private String numCelular2;
    private String numCelular3;
    private String numTelefono;
    
    private String email1;
    private String email2;
    private String email3;
    
    private String direccion;
    private String distrito; 	
    private String provincia; 	
    private String departamento;
    private String ubigeo;
    private Boolean flgVentaTelefono;
    private Boolean flgPromoVentaTelefono;
    private Boolean flgVentaEmail;
    private Boolean flgPromoEmail;
    private String flgLpd; 
    private User usuarioSolicitud;
    private java.util.Calendar fechaRegistro;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATAENTRY_SEQ")
    @SequenceGenerator(sequenceName = "maestra_data_entry_seq", allocationSize = 1, name = "DATAENTRY_SEQ")
    public Long getId() {
        return id;
    }
    
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="ID_SOLICITUD")
	public String getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
    @Column(name="TIPDOC")
    public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	@Column(name="CODDOC")
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
	
    
    @Column(name="APE_PATERNO")
	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	 @Column(name="APE_MATERNO")
	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	@Column(name="PRIMER_NOMBRE")
	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	@Column(name="SEGUNDO_NOMBRE")
	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	@Column(name="NUMCELULAR1")
	public String getNumCelular1() {
		return numCelular1;
	}

	public void setNumCelular1(String numCelular1) {
		this.numCelular1 = numCelular1;
	}
	@Column(name="NUMCELULAR2")
	public String getNumCelular2() {
		return numCelular2;
	}

	public void setNumCelular2(String numCelular2) {
		this.numCelular2 = numCelular2;
	}
	@Column(name="NUMCELULAR3")
	public String getNumCelular3() {
		return numCelular3;
	}

	public void setNumCelular3(String numCelular3) {
		this.numCelular3 = numCelular3;
	}
	@Column(name="NUMTELRES1")
	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	@Column(name="EMAIL_01")
	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	@Column(name="EMAIL_02")
	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	@Column(name="EMAIL_03")
	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}
	@Column(name="DIRECCION")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Column(name="DISTRITO")
	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	@Column(name="PROVINCIA")
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Column(name="DEPARTAMENTO")
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	@Column(name="UBIGEO")
	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	@Column(name="FLG_VENTA_TELF")
	public Boolean getFlgVentaTelefono() {
		return flgVentaTelefono;
	}

	public void setFlgVentaTelefono(Boolean flgVentaTelefono) {
		this.flgVentaTelefono = flgVentaTelefono;
	}
	
	@Column(name="FLG_PROMO_TELF")
	public Boolean getFlgPromoVentaTelefono() {
		return flgPromoVentaTelefono;
	}

	public void setFlgPromoVentaTelefono(Boolean flgPromoVentaTelefono) {
		this.flgPromoVentaTelefono = flgPromoVentaTelefono;
	}

	@Column(name="FLG_VENTA_EMA")
	public Boolean getFlgVentaEmail() {
		return flgVentaEmail;
	}

	public void setFlgVentaEmail(Boolean flgVentaEmail) {
		this.flgVentaEmail = flgVentaEmail;
	}
	@Column(name="FLG_PROMO_EMA")
	public Boolean getFlgPromoEmail() {
		return flgPromoEmail;
	}

	public void setFlgPromoEmail(Boolean flgPromoEmail) {
		this.flgPromoEmail = flgPromoEmail;
	}

	@Column(name="FLG_LPDP")
	public String getFlgLpd() {
		return flgLpd;
	}

	public void setFlgLpd(String flgLpd) {
		this.flgLpd = flgLpd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USU_SOLICITUD")
	public User getUsuarioSolicitud() {
		return usuarioSolicitud;
	}

	public void setUsuarioSolicitud(User usuarioSolicitud) {
		this.usuarioSolicitud = usuarioSolicitud;
	}

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
	public java.util.Calendar getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.util.Calendar fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	
}
