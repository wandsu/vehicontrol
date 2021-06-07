package com.br.zup.vehicontrol.model;

public class VeiculoOutput {
	
	private Long Id;
	private TipoVeiculo tipoVeiculo;
	private String marca;
	private String modelo;
	private Integer ano;
	private String preço;
	private boolean rodizioAtivo;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getPreço() {
		return preço;
	}
	public void setPreço(String preço) {
		this.preço = preço;
	}
	public boolean isRodizioAtivo() {
		return rodizioAtivo;
	}
	public void setRodizioAtivo(boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
}
