package com.br.zup.vehicontrol.model.fipemodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValorVeiculo {
	
	@JsonProperty("Valor")
	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ValorVeiculo [valor=" + valor + "]";
	}

}
