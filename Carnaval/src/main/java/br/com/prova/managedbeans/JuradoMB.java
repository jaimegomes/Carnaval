package br.com.prova.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prova.entities.Entidade;
import br.com.prova.entities.Jurado;
import br.com.prova.interfaces.GenericManagedBean;
import br.com.prova.repository.JuradoRepository;

/**
 * @author Jaime Gomes
 *
 */
@ManagedBean(name = "JuradoMB")
@ViewScoped
public class JuradoMB implements GenericManagedBean {

	private JuradoRepository juradoDAO = JuradoRepository.getInstance();

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		return (Jurado) juradoDAO.getPorId(id);
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		return juradoDAO.inserir(entidade);
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		return juradoDAO.editar(entidade);
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		return juradoDAO.remover(entidade);
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		return juradoDAO.removerPorId(id);
	}

	@Override
	public List<Entidade> listar() throws Exception {
		return juradoDAO.listar();
	}

}
