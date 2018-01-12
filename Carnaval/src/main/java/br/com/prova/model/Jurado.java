package br.com.prova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe que representa a entidade jurado
 * @author Jaime Gomes
 *
 */
@Entity
public class Jurado {
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	private Integer id;
	@Column(name="nome", nullable=false)
	private String nome;
	@Column(name="cpf", nullable=false)
	private String cpf;

	public Jurado() {

	}

	/**
	 * @param nome
	 * @param cpf
	 */
	public Jurado(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
