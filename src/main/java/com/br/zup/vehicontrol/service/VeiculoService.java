package com.br.zup.vehicontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.vehicontrol.facade.ConsultaPrecoFacade;
import com.br.zup.vehicontrol.model.Usuario;
import com.br.zup.vehicontrol.model.Veiculo;
import com.br.zup.vehicontrol.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	ConsultaPrecoFacade consultaPrecoFacade;
	
	public Veiculo salvar(Veiculo veiculo) {
		consultaPrecoFacade.obtemValorVeiculo(veiculo);
		veiculo.setUsuario(usuarioService.buscar(veiculo.getUsuario().getId()));
		veiculo.calculaDiaRodizio();
		return veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> listarVeiculosUsuario(Usuario usuario) {
		return veiculoRepository.findByUsuario(usuario);
	}
	
}
