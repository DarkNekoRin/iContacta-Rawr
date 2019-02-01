package com.ibk.rawr.entity;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "dgov_dataentry_usuario",schema="DWHAC")
public class User {
    private Long id;
    private String username;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;
    private Boolean bloqueado;
    private Boolean resetPassword;
    private java.util.Calendar ultimaSesion;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
    public Long getId() {
        return id;
    }
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FECH_ULTIMA_SESION")  
    public java.util.Calendar getUltimaSesion() {
		return ultimaSesion;
	}

	public void setUltimaSesion(java.util.Calendar ultimaSesion) {
		this.ultimaSesion = ultimaSesion;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "dgov_dataentry_usuario_rol",schema="DWHAC", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	@Column(name="NOMBRES")  
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
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
	public Boolean getResetPassword() {
		return resetPassword;
	}
	@Column(name="RESET_PASSWORD")  
	public void setResetPassword(Boolean resetPassword) {
		this.resetPassword = resetPassword;
	}
	@Column(name="FLAG_BLOQUEADO")  
	public Boolean getBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
}
