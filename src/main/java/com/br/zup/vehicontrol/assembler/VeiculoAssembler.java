package com.br.zup.vehicontrol.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.zup.vehicontrol.model.Veiculo;
import com.br.zup.vehicontrol.model.VeiculoInput;
import com.br.zup.vehicontrol.model.VeiculoOutput;

@Component
public class VeiculoAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Veiculo toEntity(VeiculoInput veiculoInput) {
		return modelMapper.map(veiculoInput, Veiculo.class);
	}
	
	public VeiculoOutput toModel(Veiculo veiculo) {
		return modelMapper.map(veiculo, VeiculoOutput.class);	
	}
}
