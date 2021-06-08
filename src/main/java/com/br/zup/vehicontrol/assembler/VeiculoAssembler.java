package com.br.zup.vehicontrol.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.zup.vehicontrol.model.Veiculo;
import com.br.zup.vehicontrol.model.VeiculoInput;
import com.br.zup.vehicontrol.model.VeiculoOutput;
import com.br.zup.vehicontrol.service.VeiculoService;
import com.br.zup.vehicontrol.utils.Utils;

@Component
public class VeiculoAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private VeiculoService veiculoService;
	
	public Veiculo toEntity(VeiculoInput veiculoInput) {
		return modelMapper.map(veiculoInput, Veiculo.class);
	}
	
	public VeiculoOutput toModel(Veiculo veiculo) {
		VeiculoOutput veiculoOutput = modelMapper.map(veiculo, VeiculoOutput.class);
		veiculoOutput.setRodizioAtivo(veiculo.rodizioAtivo(Utils.diaSemana()));
		veiculoOutput.setPreço(veiculoService.obtemValorVeiculo(veiculo));
		
		return veiculoOutput;	
	}
}
