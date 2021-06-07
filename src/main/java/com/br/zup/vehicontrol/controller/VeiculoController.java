package com.br.zup.vehicontrol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.vehicontrol.assembler.VeiculoAssembler;
import com.br.zup.vehicontrol.model.TipoVeiculo;
import com.br.zup.vehicontrol.model.Veiculo;
import com.br.zup.vehicontrol.model.VeiculoInput;
import com.br.zup.vehicontrol.model.VeiculoOutput;
import com.br.zup.vehicontrol.repository.VeiculoRepository;
import com.br.zup.vehicontrol.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private VeiculoAssembler veiculoAssembler;
	
	@GetMapping
	public String testeVeiculo() {
		Veiculo veiculo = new Veiculo();
		
		veiculo.setMarca("GM - Chevrolet");
		veiculo.setModelo("Celta");
		veiculo.setTipoVeiculo(TipoVeiculo.CARRO);
		veiculo.setAno(2010);
		
		veiculoRepository.save(veiculo);
		
		return veiculo.toString();
	}
	
	@PostMapping
	public VeiculoOutput cadastrar(@Valid @RequestBody VeiculoInput veiculoInput) {
		Veiculo veiculo = veiculoAssembler.toEntity(veiculoInput);
		return veiculoAssembler.toModel(veiculoService.salvar(veiculo));
	}
	
}
