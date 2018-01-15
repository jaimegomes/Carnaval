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
 * Classe que representa a entidade jurado
 * 
 * @author Jaime Gomes
 *
 */
@Entity
@Table(name = "jurado")
public class Jurado extends Entidade {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "cpf", nullable = false)
	private String cpf;
	@OneToMany(mappedBy = "jurado", targetEntity = Nota.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Nota> notas;

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
	 * Formatação do CPF para exibição na tabela
	 * 
	 * @return
	 */
	public String getCpfFmt() {
		StringBuilder cpfFmt = new StringBuilder();
		if (this.cpf != null && this.cpf.length() == 11) {
			cpfFmt.append(this.cpf.substring(0, 3));
			cpfFmt.append(".");
			cpfFmt.append(this.cpf.substring(3, 6));
			cpfFmt.append(".");
			cpfFmt.append(this.cpf.substring(6, 9));
			cpfFmt.append("-");
			cpfFmt.append(this.cpf.substring(9, 11));
		}

		return cpfFmt.toString();
	}
}
