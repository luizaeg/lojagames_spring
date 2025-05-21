package com.generation.lojagames.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255)
	@NotBlank(message = "O Atributo Nome é obrigatório e não pode ser vazio")
	@Pattern(regexp = "^[^0-9].*", message = "O nome não pode ser apenas numérico")
	private String nome;
	
	
	@Column(length = 255)
	@NotBlank(message = "O Atributo Descrição é obrigatório e não pode ser vazio")
	@Pattern(regexp = "^[^0-9].*", message = "A descrição não pode ser apenas numérica")
	private String descricao;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


			
	
}
