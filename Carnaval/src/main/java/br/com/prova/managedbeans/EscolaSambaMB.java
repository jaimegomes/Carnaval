package br.com.prova.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prova.dao.EscolaSambaDAO;
import br.com.prova.interfaces.GenericManagedBean;
import br.com.prova.model.Entidade;
import br.com.prova.model.EscolaSamba;

/**
 * @author Jaime Gomes
 *
 */
@ManagedBean(name = "EscolaSambaMB")
@ViewScoped
public class EscolaSambaMB implements GenericManagedBean {

	private EscolaSambaDAO escolaSambaDAO = EscolaSambaDAO.getInstance();

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		return (EscolaSamba) escolaSambaDAO.getPorId(id);
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		return escolaSambaDAO.inserir(entidade);
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		return escolaSambaDAO.editar(entidade);
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		return escolaSambaDAO.remover(entidade);
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		return escolaSambaDAO.removerPorId(id);
	}

	@Override
	public List<Entidade> listar() throws Exception {
		return escolaSambaDAO.listar();
	}

}
