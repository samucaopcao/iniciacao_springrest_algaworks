package com.algaworks.osworks.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * CLASSE QUE REPRESENTA A TABELA CLIENTE NA BASE DE DADOS
 * ESSA ANOTAÇÃO @ ENTITY "TRANSFORMA" A CLASSE EM UMA ENTIDADE DO BANCO DE
 * DADOS
 * 
 * @author Samuel & Leticia
 */
@Entity
public class Cliente {

	/**
	 * @Id ANOTAÇÃO PARA CRIAÇÃO DO ID
	 * @@GeneratedValue ESSA ANOTAÇÃO SERVE PARA DETERMINAR QUAL A ESTRATÉGIA DE
	 *                  CRIAÇÃO DO ID, NO CASO AUTO_INCREMENT
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	/**
	 * @NotBlank VALIDA SE O VALOR NÃO ESTÁ NULO, VAZIO OU SÓ COM ESPAÇOS
	 * @Size(max = 255) DETERMINA O TAMANHO MAXIMO DO CAMPO
	 */
	@NotBlank
	@Size(max = 60)
	private String nome;

	@NotBlank
	@Email
	@Size(max = 255)
	private String email;

	/**
	 * @Column(name = "fone") ANOTAÇÃO PARA NOMEAR A COLUNA, USAMOS NORMALMENTE SE A
	 *              COLUNA DO BANCO TEM NOME DIFERENTE DO ATRIBUTO QUE A REPRESENTA
	 */
	@NotBlank
	@Size(max = 20)
	@Column(name = "fone")
	private String telefone;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
