package com.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.algaworks.osworks.api.model.Comentario;
import com.algaworks.osworks.domain.exception.NegocioException;

@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * A anotação @Validsobre a classe Cliente é usada para validar as propriedades
	 * que estão dentro de Cliente, e não apenas o
	 * 
	 * @NotNull
	 * 
	 *          Já a @ConvertGroup é uma anotação para modificar as validações de
	 *          uma classe mudando Bean Validation de Default para um personalizado
	 *          (a partir de uma interface que criarmos, nesse caso a
	 *          ValidationsGroups para que o cliente não seja validado pelo id .
	 * 
	 */

	@ManyToOne
	private Cliente cliente;

	private String descricao;
	private BigDecimal preco;

	/**
	 * @Enumerated(EnumType.STRING) devemos usar essa anotação quando utilizarmos
	 *                              Enum. Neste exemplo temos um Enum de Strings.
	 */
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;

	/**
	 * OffsetDateTime é usado para acertar o retorno da data na resposta da API pois
	 * por padrão o Spring usa o padrão ISO-8601 que representa o Meridiano de
	 * Greenwich (03 horas adiantado do horário de Brasília) assim usando o
	 * OffsetDateTime resolvemos esse problema
	 */

	private OffsetDateTime dataAbertura;

	/**
	 * @JsonProperty(access = Access.READ_ONLY) anotação para que este atributo seja
	 *                      considerado apenas leitura na nossa API, para que deste
	 *                      modo não seja possível criar uma dataFinalizacao na
	 *                      abertura de uma ordem de serviço
	 */

	private OffsetDateTime dataFinalizacao;

	/**
	 * Essa anotação com o complemento mappedBy está amarrando uma ordem de serviço
	 * com uma lista de comentário
	 */
	@OneToMany(mappedBy = "ordemServico")
	private List<Comentario> comentarios = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean podeSerFinalizada() {
		return StatusOrdemServico.ABERTA.equals(getStatus());
	}

	public boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}

	public void finalizar() {
		if (naoPodeSerFinalizada()) {
			throw new NegocioException("Ordem de serviço não pode ser finalizada");
		}
		setStatus(StatusOrdemServico.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());

	}

}
