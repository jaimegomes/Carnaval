package br.com.prova.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prova.dao.JuradoDAO;
import br.com.prova.interfaces.GenericManagedBean;
import br.com.prova.model.Entidade;
import br.com.prova.model.Jurado;

/**
 * @author Jaime Gomes
 *
 */
@ManagedBean(name = "JuradoMB")
@ViewScoped
public class JuradoMB implements GenericManagedBean {

	private JuradoDAO juradoDAO;
	private Jurado jurado;
	private List<Entidade> jurados;

	@PostConstruct
	public void inicializa() {
		jurado = new Jurado();
		juradoDAO = JuradoDAO.getInstance();
		try {
			jurados = JuradoDAO.getInstance().listar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar jurados!", ""));
		}
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		return (Jurado) juradoDAO.getPorId(jurado.getId());
	}

	@Override
	public void salvar() throws Exception {
		try {
			jurado.setCpf(jurado.getCpf().replaceAll("[^0-9]*", ""));

			if (jurado.getId() == null) {
				juradoDAO.inserir(jurado);
				jurados.add(jurado);
			} else {
				juradoDAO.editar(jurado);
			}

			jurado = new Jurado();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Jurado salvo com sucesso!", "Jurado salvo com sucesso!"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar jurado!", "Erro ao salvar jurado!"));
		}

	}

	@Override
	public void remover() throws Exception {
		try {
			juradoDAO.remover(this.jurado);

			jurados.remove(this.jurado);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Jurado removido com sucesso!", ""));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover jurado!", ""));
		}

	}

	@Override
	public List<Entidade> listar() throws Exception {
		return juradoDAO.listar();
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
	 * @return the jurados
	 */
	public List<Entidade> getJurados() {
		return jurados;
	}

	/**
	 * @param jurados
	 *            the jurados to set
	 */
	public void setJurados(List<Entidade> jurados) {
		this.jurados = jurados;
	}
}
