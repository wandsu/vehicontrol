package com.br.zup.vehicontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.zup.vehicontrol.model.Usuario;
import com.br.zup.vehicontrol.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	List<Veiculo> findByUsuario(Usuario usuario);
}
