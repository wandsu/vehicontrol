package com.br.zup.vehicontrol.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.zup.vehicontrol.model.fipemodel.Ano;
import com.br.zup.vehicontrol.model.fipemodel.Marca;
import com.br.zup.vehicontrol.model.fipemodel.Modelos;
import com.br.zup.vehicontrol.model.fipemodel.ValorVeiculo;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface FIPEClient {
	
	@GetMapping("/{tipoVeiculo}/marcas")
	public List<Marca> buscarMarcas(@PathVariable String tipoVeiculo);
	
	@GetMapping("/{tipoVeiculo}/marcas/{marca}/modelos")
	public Modelos buscarModelos(@PathVariable String tipoVeiculo, 
			@PathVariable Integer marca);
	
	@GetMapping("/{tipoVeiculo}/marcas/{marca}/modelos/{modelo}/anos")
	public List<Ano> buscarAnos(@PathVariable String tipoVeiculo, 
			@PathVariable Integer marca, @PathVariable Integer modelo);
	
	@GetMapping("/{tipoVeiculo}/marcas/{marca}/modelos/{modelo}/anos/{ano}")
	public ValorVeiculo buscarValorVeiculo(@PathVariable String tipoVeiculo,
			@PathVariable Integer marca, @PathVariable Integer modelo, 
			@PathVariable String ano);

}
