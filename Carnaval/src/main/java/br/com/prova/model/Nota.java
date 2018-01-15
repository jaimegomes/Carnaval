package br.com.prova.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Integer nota;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "escola_samba_id")
	private EscolaSamba escolaSamba;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "jurado_id")
	private Jurado jurado;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "quesito_id")
	private Quesito quesito;

	private Integer maiorNota;
	private Integer menorNota;
	private Double media;
	private Double pontos;

	public Nota() {
	}

	/**
	 * @param nota
	 * @param escolaSamba
	 * @param jurado
	 * @param quesito
	 */
	public Nota(Integer nota, EscolaSamba escolaSamba, Jurado jurado, Quesito quesito) {
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
	public Integer getNota() {
		return nota;
	}

	/**
	 * @param nota
	 *            the nota to set
	 */
	public void setNota(Integer nota) {
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

	/**
	 * @return the maiorNota
	 */
	public Integer getMaiorNota() {
		return maiorNota;
	}

	/**
	 * @param maiorNota
	 *            the maiorNota to set
	 */
	public void setMaiorNota(Integer maiorNota) {
		this.maiorNota = maiorNota;
	}

	/**
	 * @return the menorNota
	 */
	public Integer getMenorNota() {
		return menorNota;
	}

	/**
	 * @param menorNota
	 *            the menorNota to set
	 */
	public void setMenorNota(Integer menorNota) {
		this.menorNota = menorNota;
	}

	/**
	 * @return the media
	 */
	public Double getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(Double media) {
		this.media = media;
	}

	/**
	 * @return the pontos
	 */
	public Double getPontos() {
		return pontos;
	}

	/**
	 * @param pontos
	 *            the pontos to set
	 */
	public void setPontos(Double pontos) {
		this.pontos = pontos;
	}

}
