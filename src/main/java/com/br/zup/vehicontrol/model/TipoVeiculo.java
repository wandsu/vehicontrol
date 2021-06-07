package com.br.zup.vehicontrol.model;

public enum TipoVeiculo {
	MOTO("moto"), CARRO("carro"), CAMINHAO("caminhao");

	private final String tipo;
	
	TipoVeiculo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}


}
