package com.br.zup.vehicontrol.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.br.zup.vehicontrol.repository.UsuarioRepository;
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
	private UsuarioRepository usuarioRepository;
	
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
	
	
	@GetMapping("/{cpf}/veiculos")
	public ResponseEntity<VeiculosUsuarioOutput> listarVeiculo(
			@PathVariable String cpf) {

		Optional<Usuario> usuarioSolicitado =
				usuarioRepository.findByCpf(cpf);
		
		if(usuarioSolicitado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuario = usuarioSolicitado.get();
		List<Veiculo> veiculos =
				veiculoService.listarVeiculosUsuario(usuario);
		List<VeiculoOutput> veiculosOutput =
				veiculoAssembler.toCollection(veiculos);
		UsuarioOutput usuarioOutput =
				usuarioAssembler.toModel(usuario);
		
		
		return ResponseEntity.ok(
				new VeiculosUsuarioOutput(usuarioOutput, veiculosOutput));
				
	}

}
