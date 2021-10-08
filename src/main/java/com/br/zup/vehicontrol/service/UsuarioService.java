package com.br.zup.vehicontrol.service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		try{
			return usuarioRepository.save(usuario);
		}
		catch (DataIntegrityViolationException error){
			throw error;
		}
	}
	
	public Usuario buscar(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new NegocioException("Usuario não encontrado."));
	}

}
