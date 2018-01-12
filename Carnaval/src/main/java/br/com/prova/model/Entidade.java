/**
 * 
 */
package br.com.prova.model;

/**
 * Classe abstrata que representa uma entidade
 * 
 * @author Jaime
 *
 */
public abstract class Entidade {

	private Integer id;

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

}
