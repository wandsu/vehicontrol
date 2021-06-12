package com.br.zup.vehicontrol.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.zup.vehicontrol.model.Usuario;
import com.br.zup.vehicontrol.model.dto.UsuarioInput;
import com.br.zup.vehicontrol.model.dto.UsuarioOutput;

@Component
public class UsuarioAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Usuario toEntity(UsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}
	
	public UsuarioOutput toModel(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioOutput.class);
	}
}
