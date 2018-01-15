/**
 * 
 */
package br.com.prova.model;

/**
 * Classe que contem os campos do relatorio
 * 
 * @author Jaime Gomes
 *
 */
public class ApuracaoRelatorioDTO {

	private EscolaSamba escolaSamba;
	private Quesito quesito;
	private Double maiorNota;
	private Double menorNota;
	private Double media;
	private Double pontos;

	public ApuracaoRelatorioDTO() {

	}

	/**
	 * @param escolaSamba
	 * @param quesito
	 * @param maiorNota
	 * @param menorNota
	 * @param media
	 * @param pontos
	 */
	public ApuracaoRelatorioDTO(EscolaSamba escolaSamba, Quesito quesito, Double maiorNota, Double menorNota,
			Double media, Double pontos) {
		super();
		this.escolaSamba = escolaSamba;
		this.quesito = quesito;
		this.maiorNota = maiorNota;
		this.menorNota = menorNota;
		this.media = media;
		this.pontos = pontos;
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
	public Double getMaiorNota() {
		return maiorNota;
	}

	/**
	 * @param maiorNota
	 *            the maiorNota to set
	 */
	public void setMaiorNota(Double maiorNota) {
		this.maiorNota = maiorNota;
	}

	/**
	 * @return the menorNota
	 */
	public Double getMenorNota() {
		return menorNota;
	}

	/**
	 * @param menorNota
	 *            the menorNota to set
	 */
	public void setMenorNota(Double menorNota) {
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
