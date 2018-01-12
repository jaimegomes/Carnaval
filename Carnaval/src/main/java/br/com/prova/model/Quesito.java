package br.com.prova.model;

/**
 * Classe que representa a entidade quesito
 * @author Jaime Gomes
 *
 */
public class Quesito {
	
	private String nome;
	private Jurado jurado;
	private Double pontuacao;

	public Quesito() {
		
	}

	/**
	 * @param nome
	 * @param jurado
	 * @param pontuacao
	 */
	public Quesito(String nome, Jurado jurado, Double pontuacao) {
		super();
		this.nome = nome;
		this.jurado = jurado;
		this.pontuacao = pontuacao;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the jurado
	 */
	public Jurado getJurado() {
		return jurado;
	}

	/**
	 * @param jurado the jurado to set
	 */
	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

	/**
	 * @return the pontuacao
	 */
	public Double getPontuacao() {
		return pontuacao;
	}

	/**
	 * @param pontuacao the pontuacao to set
	 */
	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	

}
