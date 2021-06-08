package com.br.zup.vehicontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.vehicontrol.client.FIPEClient;
import com.br.zup.vehicontrol.exception.NegocioException;
import com.br.zup.vehicontrol.model.Usuario;
import com.br.zup.vehicontrol.model.Veiculo;
import com.br.zup.vehicontrol.model.fipemodel.Ano;
import com.br.zup.vehicontrol.model.fipemodel.Marca;
import com.br.zup.vehicontrol.model.fipemodel.Modelo;
import com.br.zup.vehicontrol.model.fipemodel.Modelos;
import com.br.zup.vehicontrol.model.fipemodel.ValorVeiculo;
import com.br.zup.vehicontrol.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	FIPEClient fipeClient;
	
	public Veiculo salvar(Veiculo veiculo) {
		veiculo.setUsuario(usuarioService.buscar(veiculo.getUsuario().getId()));
		veiculo.calculaDiaRodizio();
		return veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> listarVeiculosUsuario(Usuario usuario) {
		return veiculoRepository.findByUsuario(usuario);
	}
	
	public String obtemValorVeiculo(Veiculo veiculo) {
		Marca marca = carregarMarca(veiculo);
		Modelo modelo = carregarModelo(veiculo, marca.getCodigo());
		Ano ano = carregarAno(veiculo, marca.getCodigo(), modelo.getCodigo());
		ValorVeiculo valorVeiculo = carregarValor(veiculo, marca.getCodigo(), modelo.getCodigo(), ano.getCodigo());
		
		return valorVeiculo.getValor();
	}
	
	public Marca carregarMarca(Veiculo veiculo) {
		Optional<Marca> marcaSolicitada = fipeClient.buscarMarcas(veiculo.getTipoVeiculo().getTipo())
				.stream()
				.filter(marca -> marca.getNome().equals(veiculo.getMarca()))
				.findFirst();
		
		if(!marcaSolicitada.isPresent()) {
			throw new NegocioException("Marca não localizada!");	
		}
		
		return marcaSolicitada.get();
	}
	
	public Modelo carregarModelo(Veiculo veiculo, Integer codigoModelo) {
		
		Modelos modelos = fipeClient.buscarModelos(veiculo.getTipoVeiculo().getTipo(), codigoModelo);
		
		Optional<Modelo> modeloSolicitado = modelos.getModelos()
				.stream()
				.filter(modelo -> modelo
				.getNome()
				.equals(veiculo.getModelo()))
				.findFirst();
		
		if(!modeloSolicitado.isPresent()) {
			throw new NegocioException("Modelo não localizado!");	
		}
		
		return modeloSolicitado.get();
	}
	
	public Ano carregarAno(Veiculo veiculo, Integer codigoMarca, Integer codigoModelo) {
		String codigoAnoCombustivel = veiculo.getAno().toString() + "-" + veiculo.getCombustivel().getCodigoCombustivel();
		
		Optional<Ano> anoSolicitado = fipeClient.buscarAnos(veiculo.getTipoVeiculo().getTipo(), codigoMarca, codigoModelo)
				.stream()
				.filter(ano -> ano.getCodigo().equals(codigoAnoCombustivel))
				.findFirst();
		
		if(!anoSolicitado.isPresent()) {
			throw new NegocioException("Ano não localizado!");	
		}
		
		return anoSolicitado.get();
	}
	
	public ValorVeiculo carregarValor(Veiculo veiculo, Integer codigoMarca, Integer codigoModelo, String codigoAno) {
		
		ValorVeiculo valor = fipeClient.buscarValorVeiculo(veiculo.getTipoVeiculo().getTipo(), codigoMarca, codigoModelo, codigoAno);
		
		return valor;
	}

}
