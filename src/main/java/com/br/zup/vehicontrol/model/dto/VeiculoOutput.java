package com.br.zup.vehicontrol.model.dto;

import com.br.zup.vehicontrol.model.Combustivel;
import com.br.zup.vehicontrol.model.TipoVeiculo;

public class VeiculoOutput {
	
	private Long id;
	private TipoVeiculo tipoVeiculo;
	private String marca;
	private String modelo;
	private Integer ano;
	private Combustivel combustivel;
	private String preço;
	private String diaRodizio;
	private boolean rodizioAtivo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Combustivel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	public String getPreço() {
		return preço;
	}
	public void setPreço(String preço) {
		this.preço = preço;
	}
	public String getDiaRodizio() {
		return diaRodizio;
	}
	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}
	public boolean isRodizioAtivo() {
		return rodizioAtivo;
	}
	public void setRodizioAtivo(boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
}
