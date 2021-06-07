package com.br.zup.vehicontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.vehicontrol.model.Veiculo;
import com.br.zup.vehicontrol.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Veiculo salvar(Veiculo veiculo) {
		veiculo.setUsuario(usuarioService.buscar(veiculo.getUsuario().getId()));
		return veiculoRepository.save(veiculo);
	}

}
