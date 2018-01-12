package br.com.prova.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa a entidade quesito
 * 
 * @author Jaime Gomes
 *
 */
@Entity
@Table(name = "quesito")
public class Quesito extends Entidade {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "peso", nullable = false)
	private Integer peso;

	public Quesito() {

	}

	/**
	 * @param nome
	 * @param peso
	 */
	public Quesito(String nome, Integer peso) {
		super();
		this.nome = nome;
		this.peso = peso;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the peso
	 */
	public Integer getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *            the peso to set
	 */
	public void setPeso(Integer peso) {
		this.peso = peso;
	}

}
