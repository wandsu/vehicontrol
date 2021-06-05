package com.br.zup.vehicontrol.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.vehicontrol.model.Usuario;
import com.br.zup.vehicontrol.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public Usuario cadastrar(@Valid @RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}
}
