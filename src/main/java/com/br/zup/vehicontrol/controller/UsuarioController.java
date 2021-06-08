package com.br.zup.vehicontrol.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.vehicontrol.assembler.UsuarioAssembler;
import com.br.zup.vehicontrol.assembler.VeiculoAssembler;
import com.br.zup.vehicontrol.model.Usuario;
import com.br.zup.vehicontrol.model.Veiculo;
import com.br.zup.vehicontrol.model.dto.UsuarioInput;
import com.br.zup.vehicontrol.model.dto.UsuarioOutput;
import com.br.zup.vehicontrol.model.dto.VeiculoOutput;
import com.br.zup.vehicontrol.model.dto.VeiculosUsuarioOutput;
import com.br.zup.vehicontrol.service.UsuarioService;
import com.br.zup.vehicontrol.service.VeiculoService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioAssembler usuarioAssembler;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private VeiculoAssembler veiculoAssembler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioOutput cadastrar(@Valid @RequestBody UsuarioInput usuarioInput) {
		Usuario usuario = usuarioAssembler.toEntity(usuarioInput);
		Usuario usuarioCadastrado = usuarioService.salvar(usuario);
		return usuarioAssembler.toModel(usuarioCadastrado);
	}
	
	
	@GetMapping("/{usuarioId}/veiculos")
	public VeiculosUsuarioOutput listarVeiculo(@PathVariable Long usuarioId) {
		Usuario usuario = usuarioService.buscar(usuarioId);
		List<Veiculo> veiculos = veiculoService.listarVeiculosUsuario(usuario);
		UsuarioOutput usuarioOutput = usuarioAssembler.toModel(usuario);
		List<VeiculoOutput> veiculosOutput = veiculoAssembler.toCollection(veiculos);
		return new VeiculosUsuarioOutput(usuarioOutput, veiculosOutput);		
	}
	
	/*
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}*/


}
