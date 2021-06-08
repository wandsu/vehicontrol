package com.br.zup.vehicontrol.model;

public enum TipoVeiculo {
	MOTO("motos"), CARRO("carros"), CAMINHAO("caminhoes");

	private final String tipo;
	
	TipoVeiculo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}


}
