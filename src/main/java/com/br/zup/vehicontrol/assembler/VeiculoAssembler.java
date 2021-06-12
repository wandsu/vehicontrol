package com.br.zup.vehicontrol.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.zup.vehicontrol.facade.ConsultaPrecoFacade;
import com.br.zup.vehicontrol.model.Veiculo;
import com.br.zup.vehicontrol.model.dto.VeiculoInput;
import com.br.zup.vehicontrol.model.dto.VeiculoOutput;
import com.br.zup.vehicontrol.utils.Utils;

@Component
public class VeiculoAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ConsultaPrecoFacade consultaPrecoFacade;
	
	public Veiculo toEntity(VeiculoInput veiculoInput) {
		return modelMapper.map(veiculoInput, Veiculo.class);
	}
	
	public VeiculoOutput toModel(Veiculo veiculo) {
		VeiculoOutput veiculoOutput =
				modelMapper.map(veiculo, VeiculoOutput.class);
		veiculoOutput.setRodizioAtivo(
				veiculo.rodizioAtivo(Utils.diaSemana()));
		veiculoOutput.setPreco(
				consultaPrecoFacade.obtemValorVeiculo(veiculo));
		
		return veiculoOutput;
	}
	
	public List<VeiculoOutput> toCollection(List<Veiculo> veiculos){
		return veiculos.stream()
				.map(veiculo -> toModel(veiculo))
				.collect(Collectors.toList());
	}
}
