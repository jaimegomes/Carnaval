package br.com.prova.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prova.entities.Entidade;
import br.com.prova.entities.Nota;
import br.com.prova.interfaces.GenericManagedBean;
import br.com.prova.repository.NotaDAO;

/**
 * @author Jaime Gomes
 *
 */
@ManagedBean(name = "NotaMB")
@ViewScoped
public class NotaMB implements GenericManagedBean {

	private NotaDAO notaDAO = NotaDAO.getInstance();

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		return (Nota) notaDAO.getPorId(id);
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		return notaDAO.inserir(entidade);
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		return notaDAO.editar(entidade);
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		return notaDAO.remover(entidade);
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		return notaDAO.removerPorId(id);
	}

	@Override
	public List<Entidade> listar() throws Exception {
		return notaDAO.listar();
	}

}
