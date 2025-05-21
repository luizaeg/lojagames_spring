package com.generation.lojagames.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

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
	
	@NotNull(message = "O atributo preço é obrigatório")
	@DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
	@Digits(integer = 6, fraction = 2, message = "O preço deve ter no máximo 6 dígitos inteiros e 2 decimais")
	@Column(precision = 8, scale = 2)
    private BigDecimal preco;
    
	@NotBlank(message = "A URL da imagem é obrigatória")
	@Size(max = 1000, message = "A URL deve ter no máximo 1000 caracteres")
	@Column(length = 1000)
	private String imagemUrl;
	

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

		
	
}
