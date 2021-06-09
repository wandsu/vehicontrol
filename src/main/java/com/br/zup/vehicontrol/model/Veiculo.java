package com.br.zup.vehicontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@NotNull
	private Usuario usuario;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoVeiculo tipoVeiculo;
	
	@NotBlank
	@Size(max = 70)
	@Column(nullable=false)
	private String marca;
	
	@NotBlank
	@Size(max = 250)
	@Column(nullable=false)
	private String modelo;
	
	@NotNull
	@Column(nullable=false)
	private Integer ano;
	
	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Combustivel combustivel;

	@Size(max = 250)
	@Column(nullable=false)
	private String diaRodizio;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public String getDiaRodizio() {
		return diaRodizio;
	}

	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}
	
	public void calculaDiaRodizio() {
		int dia = this.ano % 10;
		
		switch(dia) {
			case 0:
			case 1:
				this.diaRodizio = "segunda-feira";
				break;
			case 2:
			case 3:
				this.diaRodizio = "terça-feira";
				break;
			case 4:
			case 5:
				this.diaRodizio = "quarta-feira";
				break;
			case 6:
			case 7:
				this.diaRodizio = "quinta-feira";
				break;
			case 8:
			case 9:
				this.diaRodizio = "sexta-feira";
				break;
		}
		
	}
	
	public boolean rodizioAtivo(String diaSemana) {
		return this.diaRodizio.equals(diaSemana);
	}
}
