package com.br.zup.vehicontrol.model.dto;

import java.util.List;

public class VeiculosUsuarioOutput {
	
	private UsuarioOutput usuario;
	private List<VeiculoOutput> veiculos;
	
	public VeiculosUsuarioOutput(UsuarioOutput usuario, List<VeiculoOutput> veiculos) {
		this.usuario = usuario;
		this.veiculos = veiculos;
	}
	
	public UsuarioOutput getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioOutput usuario) {
		this.usuario = usuario;
	}
	public List<VeiculoOutput> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<VeiculoOutput> veiculos) {
		this.veiculos = veiculos;
	}
}