package com.br.zup.vehicontrol.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://parallelum.com.br/fipe/api/v1", name = "fipe")
public interface FIPEClient {
	
	@GetMapping("/{tipoVeiculo}/marcas")
	public String buscarMarcas(@PathVariable String tipoVeiculo);
	
	@GetMapping("/{tipoVeiculo}/marcas/{marca}/modelos")
	
	public String buscarModelos(@PathVariable String tipoVeiculo, 
			@PathVariable Integer marca);
	
	@GetMapping("/{tipoVeiculo}/marcas/{marca}/modelos/{modelo}/anos")
	public String buscarAnos(@PathVariable String tipoVeiculo, 
			@PathVariable Integer marca, @PathVariable Integer modelo);
	
	@GetMapping("/{tipoVeiculo}/marcas/{marca}/modelos/{modelo}/anos/{ano}")
	public String buscarVeiculo(@PathVariable String tipoVeiculo,
			@PathVariable Integer marca, @PathVariable Integer modelo, 
			@PathVariable String ano);

}
