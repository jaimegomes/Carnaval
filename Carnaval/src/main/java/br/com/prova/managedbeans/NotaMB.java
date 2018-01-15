package br.com.prova.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.prova.dao.JuradoDAO;
import br.com.prova.dao.NotaDAO;
import br.com.prova.dao.QuesitoDAO;
import br.com.prova.model.Entidade;
import br.com.prova.model.EscolaSamba;
import br.com.prova.model.Jurado;
import br.com.prova.model.Nota;
import br.com.prova.model.Quesito;

/**
 * @author Jaime Gomes
 *
 */
@ManagedBean(name = "NotaMB")
@ViewScoped
public class NotaMB {

	private NotaDAO notaDAO;
	private Nota nota;
	private List<Entidade> notas;
	private List<Entidade> notasApuracao;
	private Quesito quesito;
	private Jurado jurado;
	private EscolaSamba escola;
	private List<Entidade> listEscolas;

	@PostConstruct
	public void inicializa() {
		nota = new Nota();
		notaDAO = NotaDAO.getInstance();
		try {
			notas = notaDAO.listar();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar notas!", ""));
		}
	}

	public void remover() {
		try {
			notaDAO.remover(this.nota);
			notas.remove(this.nota);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota removida com sucesso!", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover nota!", ""));
		}
	}

	public void selecionarQuesito(ValueChangeEvent event) throws Exception {
		try {
			Integer id = Integer.parseInt((String) event.getNewValue());
			quesito = (Quesito) QuesitoDAO.getInstance().getPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selecionarJurado(ValueChangeEvent event) throws Exception {
		try {
			Integer id = Integer.parseInt((String) event.getNewValue());
			jurado = (Jurado) JuradoDAO.getInstance().getPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void avaliar() throws Exception {
		try {
			Boolean erro = Boolean.FALSE;
			if (escola != null) {
				nota.setEscolaSamba(escola);
			} else {
				erro = Boolean.TRUE;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Nescessário selecionar uma escola de samba!", "Nescessário selecionar uma escola de samba!"));
			}

			if (jurado != null) {
				nota.setJurado(jurado);
			} else {

				erro = Boolean.TRUE;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Nescessário selecionar um jurado!", "Nescessário selecionar um jurado!"));
			}

			if (quesito != null) {
				nota.setQuesito(quesito);
			} else {
				erro = Boolean.TRUE;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Nescessário selecionar um quesito!", "Nescessário selecionar um quesito!"));
			}

			if (nota.getNota() == null) {
				erro = Boolean.TRUE;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Nescessário selecionar um quesito!", "Nescessário selecionar um quesito!"));
			}

			if (!erro) {
				if (nota.getId() == null) {
					notaDAO.inserir(nota);
				} else {
					notaDAO.editar(nota);
				}

				notas.add(nota);
				nota = new Nota();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Nota salva com sucesso!", "Nota salva com sucesso!"));

			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir notas!", ""));
		}
	}

	/**
	 * @return the nota
	 */
	public Nota getNota() {
		return nota;
	}

	/**
	 * @param nota
	 *            the nota to set
	 */
	public void setNota(Nota nota) {
		this.nota = nota;
	}

	/**
	 * @return the notas
	 */
	public List<Entidade> getNotas() {
		return notas;
	}

	/**
	 * @param notas
	 *            the notas to set
	 */
	public void setNotas(List<Entidade> notas) {
		this.notas = notas;
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
	 * @return the escola
	 */
	public EscolaSamba getEscola() {
		return escola;
	}

	/**
	 * @param escola
	 *            the escola to set
	 */
	public void setEscola(EscolaSamba escola) {
		this.escola = escola;
	}

	/**
	 * @return the listEscolas
	 */
	public List<Entidade> getListEscolas() {
		return listEscolas;
	}

	/**
	 * @param listEscolas
	 *            the listEscolas to set
	 */
	public void setListEscolas(List<Entidade> listEscolas) {
		this.listEscolas = listEscolas;
	}

	/**
	 * @return the notasApuracao
	 */
	public List<Entidade> getNotasApuracao() {
		return notasApuracao;
	}

	/**
	 * @param notasApuracao
	 *            the notasApuracao to set
	 */
	public void setNotasApuracao(List<Entidade> notasApuracao) {
		this.notasApuracao = notasApuracao;
	}

}
