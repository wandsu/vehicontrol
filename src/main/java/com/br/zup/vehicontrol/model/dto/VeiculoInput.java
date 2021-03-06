package com.br.zup.vehicontrol.model.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.zup.vehicontrol.model.Combustivel;
import com.br.zup.vehicontrol.model.TipoVeiculo;

public class VeiculoInput {

	@NotNull
	private TipoVeiculo tipoVeiculo;
	
	@NotBlank
	@Size(max = 70)
	private String marca;
	
	@NotBlank
	@Size(max = 250)
	private String modelo;
	
	@NotNull
	private Integer ano;
	
	@NotNull
	private Combustivel combustivel;
	
	@Valid
	@NotNull
	private UsuarioIdInput usuario;

	//Getters and Setters
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public UsuarioIdInput getUsuario() {
		return usuario;
	}
	
}
