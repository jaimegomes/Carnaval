
package br.com.prova.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe que representa a entidade escola_samba
 * 
 * @author Jaime Gomes
 *
 */
@Entity
@Table(name = "escola_samba")
public class EscolaSamba extends Entidade {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "cnpj", nullable = false, unique = true)
	private String cnpj;
	@OneToMany(mappedBy = "escolaSamba", targetEntity = Nota.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Nota> notas;

	public EscolaSamba() {
	}

	/**
	 * @param nome
	 * @param cnpj
	 * @param listQuesitos
	 */
	public EscolaSamba(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
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
	 * @return the notas
	 */
	public List<Nota> getNotas() {
		return notas;
	}

	/**
	 * @param notas
	 *            the notas to set
	 */
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	/**
	 * Formatação do CNPJ para exibição na tabela
	 * 
	 * @return
	 */
	public String getCnpjFmt() {
		StringBuilder cnpjFmt = new StringBuilder();
		if (this.cnpj != null && this.cnpj.length() == 14) {
			cnpjFmt.append(this.cnpj.substring(0, 2));
			cnpjFmt.append(".");
			cnpjFmt.append(this.cnpj.substring(2, 5));
			cnpjFmt.append(".");
			cnpjFmt.append(this.cnpj.substring(5, 8));
			cnpjFmt.append("/");
			cnpjFmt.append(this.cnpj.substring(8, 12));
			cnpjFmt.append("-");
			cnpjFmt.append(this.cnpj.substring(12, 14));
		}

		return cnpjFmt.toString();
	}

}
