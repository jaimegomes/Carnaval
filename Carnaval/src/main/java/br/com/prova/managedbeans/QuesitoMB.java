package br.com.prova.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.prova.dao.QuesitoDAO;
import br.com.prova.interfaces.GenericManagedBean;
import br.com.prova.model.Entidade;
import br.com.prova.model.Quesito;

/**
 * @author Jaime Gomes
 *
 */
@ManagedBean(name = "QuesitoMB")
@ViewScoped
public class QuesitoMB implements GenericManagedBean {

	private QuesitoDAO quesitoDAO;
	private Quesito quesito;
	private List<Entidade> quesitos;

	@PostConstruct
	public void inicializa() {
		try {
			quesitoDAO = QuesitoDAO.getInstance();
			quesito = new Quesito();
			quesitos = quesitoDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar quesitos!", ""));
		}
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		return (Quesito) quesitoDAO.getPorId(quesito.getId());
	}

	@Override
	public void salvar() throws Exception {
		try {

			if (quesito.getId() == null) {
				quesitoDAO.inserir(quesito);
				quesitos.add(quesito);
			} else {
				quesitoDAO.editar(quesito);
			}

			quesito = new Quesito();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Quesito salvo com sucesso!", "Quesito salvo com sucesso!"));

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao salvar quesito!", "Erro ao salvar quesito!"));
		}

	}

	@Override
	public void remover() throws Exception {
		try {
			quesitoDAO.remover(this.quesito);
			quesitos.remove(this.quesito);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Quesito removido com sucesso!", ""));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover quesito!", ""));
		}

	}

	public void selecionarQuesito(ValueChangeEvent event) {
		quesito = (Quesito) event.getNewValue();
		System.out.println("quesito: " + quesito.getNome());

	}

	@Override
	public List<Entidade> listar() throws Exception {
		return quesitoDAO.listar();
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
	 * @return the quesitos
	 */
	public List<Entidade> getQuesitos() {
		return quesitos;
	}

	/**
	 * @param quesitos
	 *            the quesitos to set
	 */
	public void setQuesitos(List<Entidade> quesitos) {
		this.quesitos = quesitos;
	}
}
