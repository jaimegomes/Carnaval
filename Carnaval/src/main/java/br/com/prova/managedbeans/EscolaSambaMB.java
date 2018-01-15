package br.com.prova.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prova.dao.EscolaSambaDAO;
import br.com.prova.interfaces.GenericManagedBean;
import br.com.prova.model.Entidade;
import br.com.prova.model.EscolaSamba;

/**
 * @author Jaime Gomes
 *
 */
/**
 * @author Administrator
 * 
 */
@ManagedBean(name = "EscolaSambaMB")
@ViewScoped
public class EscolaSambaMB implements GenericManagedBean {

	private EscolaSambaDAO escolaSambaDAO = EscolaSambaDAO.getInstance();
	private EscolaSamba escola;
	private List<Entidade> escolas;

	@PostConstruct
	public void inicializa() {
		escola = new EscolaSamba();
		try {
			escolas = EscolaSambaDAO.getInstance().listar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar escolas de samba!", ""));
		}
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		return (EscolaSamba) escolaSambaDAO.getPorId(escola.getId());
	}

	@Override
	public void salvar() throws Exception {
		try {
			escola.setCnpj(escola.getCnpj().replaceAll("[^0-9]*", ""));

			if (escola.getId() == null) {
				escolaSambaDAO.inserir(escola);
				escolas.add(escola);
			} else {
				escolaSambaDAO.editar(escola);
			}

			escola = new EscolaSamba();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Escola de samba salva com sucesso!", "Escola de samba salva com sucesso!"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao salvar escola de samba!", "Erro ao salvar escola de samba!"));
		}

	}

	@Override
	public void remover() throws Exception {
		try {
			escolaSambaDAO.remover(this.escola);
			escolas.remove(this.escola);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Escola de samba removida com sucesso!", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover escola de samba!", ""));
		}

	}

	@Override
	public List<Entidade> listar() throws Exception {
		return escolaSambaDAO.listar();
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
	 * @return the escolas
	 */
	public List<Entidade> getEscolas() {
		return escolas;
	}

	/**
	 * @param escolas
	 *            the escolas to set
	 */
	public void setEscolas(List<Entidade> escolas) {
		this.escolas = escolas;
	}

}
