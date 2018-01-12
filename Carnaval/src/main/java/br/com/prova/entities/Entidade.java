/**
 * 
 */
package br.com.prova.entities;

import java.io.Serializable;

/**
 * Classe abstrata que representa uma entidade
 * 
 * @author Jaime
 *
 */
public abstract class Entidade implements Serializable{

	private static final long serialVersionUID = 1L;
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
