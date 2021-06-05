package com.br.zup.vehicontrol.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.vehicontrol.exception.NegocioException;
import com.br.zup.vehicontrol.model.Usuario;
import com.br.zup.vehicontrol.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail()).isPresent();
		boolean cpfEmUso = usuarioRepository.findByCpf(usuario.getCpf()).isPresent();
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um usuário cadastrado com esse email");	
		}
		
		if(cpfEmUso) {
			throw new NegocioException("Já existe um usuário cadastrado com esse CPF");	
		}
		
		return usuarioRepository.save(usuario);
	}

}
