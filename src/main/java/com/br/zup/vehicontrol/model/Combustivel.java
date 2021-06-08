package com.br.zup.vehicontrol.model;

public enum Combustivel {
	
	GASOLINA(1), ALCOOL(2), DISEL(3);

	private final int codigoCombustivel;
	
	Combustivel(int codigoCombustivel) {
		this.codigoCombustivel = codigoCombustivel;
	}
	
	public int getCodigoCombustivel() {
		return codigoCombustivel;
	}


}
