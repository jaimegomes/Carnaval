package br.com.prova.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

	private QuesitoDAO quesitoDAO = QuesitoDAO.getInstance();

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		return (Quesito) quesitoDAO.getPorId(id);
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		return quesitoDAO.inserir(entidade);
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		return quesitoDAO.editar(entidade);
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		return quesitoDAO.remover(entidade);
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		return quesitoDAO.removerPorId(id);
	}

	@Override
	public List<Entidade> listar() throws Exception {
		return quesitoDAO.listar();
	}

}
