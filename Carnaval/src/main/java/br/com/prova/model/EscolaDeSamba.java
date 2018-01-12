
package br.com.prova.model;

import java.util.List;

/**
 * Classe que representa a entidade escolasdesamba
 * @author Jaime Gomes
 *
 */
public class EscolaDeSamba {

	private String nome;
	private String cnpj;
	private List<Quesito> listQuesitos;

	public EscolaDeSamba() {

	}

	/**
	 * @param nome
	 * @param cnpj
	 * @param listQuesitos
	 */
	public EscolaDeSamba(String nome, String cnpj, List<Quesito> listQuesitos) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.listQuesitos = listQuesitos;
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
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj
	 *            the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the listQuesitos
	 */
	public List<Quesito> getListQuesitos() {
		return listQuesitos;
	}

	/**
	 * @param listQuesitos
	 *            the listQuesitos to set
	 */
	public void setListQuesitos(List<Quesito> listQuesitos) {
		this.listQuesitos = listQuesitos;
	}

}
