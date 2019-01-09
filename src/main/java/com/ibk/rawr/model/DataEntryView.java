package com.ibk.rawr.model;

import org.springframework.web.multipart.MultipartFile;

public class DataEntryView {
	private MultipartFile file;
	private boolean telefono;
	private boolean email;
	private boolean direccion;
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Boolean getTelefono() {
		return telefono;
	}
	public void setTelefono(Boolean telefono) {
		this.telefono = telefono;
	}
	public Boolean getEmail() {
		return email;
	}
	public void setEmail(Boolean email) {
		this.email = email;
	}
	public Boolean getDireccion() {
		return direccion;
	}
	public void setDireccion(Boolean direccion) {
		this.direccion = direccion;
	}
	
}
