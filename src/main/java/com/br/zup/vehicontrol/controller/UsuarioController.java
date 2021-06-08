package com.br.zup.vehicontrol.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.vehicontrol.assembler.UsuarioAssembler;
import com.br.zup.vehicontrol.model.Usuario;
import com.br.zup.vehicontrol.model.dto.UsuarioInput;
import com.br.zup.vehicontrol.model.dto.UsuarioOutput;
import com.br.zup.vehicontrol.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioAssembler usuarioAssembler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioOutput cadastrar(@Valid @RequestBody UsuarioInput usuarioInput) {
		Usuario usuario = usuarioAssembler.toEntity(usuarioInput);
		return usuarioService.salvar(usuario);
	}
}
