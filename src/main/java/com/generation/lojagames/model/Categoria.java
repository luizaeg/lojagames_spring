package com.generation.lojagames.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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
	
	@NotBlank(message = "Tipo é obrigatório!")
	@Size(min = 5)
	@Pattern(regexp = "^[^0-9].*", message = "O título não pode ser apenas numérico")
	private String tipo;
		
	@Column(length = 255)
	@NotBlank(message = "O Atributo Descrição é obrigatório e não pode ser vazio")
	@Pattern(regexp = "^[^0-9].*", message = "A descrição não pode ser apenas numérica")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;
	
	
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
	
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Produto> getProdutos() {
		return produto;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produto = produtos;
	}


			
	
}
