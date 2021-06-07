package com.br.zup.vehicontrol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://parallelum.com.br/fipe/api/v1", name = "fipe")
public interface FIPEClient {
	
	@GetMapping("/carros/marcas/{marca}/modelos/{modelo}/anos/{ano}")
	public String buscarVeiculo(@PathVariable Integer marca, @PathVariable Integer modelo, @PathVariable String ano);

}
