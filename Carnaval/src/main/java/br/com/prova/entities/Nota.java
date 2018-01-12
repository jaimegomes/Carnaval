package br.com.prova.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa a entidade nota
 * 
 * @author Jaime Gomes
 *
 */
@Entity
@Table(name = "nota")
public class Nota extends Entidade {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nota", nullable = false)
	private String nota;

	private EscolaSamba escolaSamba;

	private Jurado jurado;

	private Quesito quesito;

	public Nota() {
	}

	/**
	 * @param id
	 * @param nota
	 * @param escolaSamba
	 * @param jurado
	 * @param quesito
	 */
	public Nota(String nota, EscolaSamba escolaSamba, Jurado jurado, Quesito quesito) {
		super();
		this.nota = nota;
		this.escolaSamba = escolaSamba;
		this.jurado = jurado;
		this.quesito = quesito;
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
	 * @return the nota
	 */
	public String getNota() {
		return nota;
	}

	/**
	 * @param nota
	 *            the nota to set
	 */
	public void setNota(String nota) {
		this.nota = nota;
	}

	/**
	 * @return the escolaSamba
	 */
	public EscolaSamba getEscolaSamba() {
		return escolaSamba;
	}

	/**
	 * @param escolaSamba
	 *            the escolaSamba to set
	 */
	public void setEscolaSamba(EscolaSamba escolaSamba) {
		this.escolaSamba = escolaSamba;
	}

	/**
	 * @return the jurado
	 */
	public Jurado getJurado() {
		return jurado;
	}

	/**
	 * @param jurado
	 *            the jurado to set
	 */
	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

	/**
	 * @return the quesito
	 */
	public Quesito getQuesito() {
		return quesito;
	}

	/**
	 * @param quesito
	 *            the quesito to set
	 */
	public void setQuesito(Quesito quesito) {
		this.quesito = quesito;
	}

}
