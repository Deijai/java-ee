package com.dev.model;

public class Telefone {
	
	private Long id;
	private String numero;
	private String tipo;
	private Long idUsuario;
	
	public Telefone(Long id, String numero, String tipo, Long idUsuario) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
	}
	
	public Telefone() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
	

}
