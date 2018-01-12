package br.com.prova.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.prova.entities.Entidade;
import br.com.prova.entities.EscolaSamba;
import br.com.prova.interfaces.GenericManagedBean;
import br.com.prova.repository.EscolaSambaRepository;

/**
 * @author Jaime Gomes
 *
 */
@ManagedBean(name = "EscolaSambaMB")
@ViewScoped
public class EscolaSambaMB implements GenericManagedBean {

	@ManagedProperty(value="#{entityManager}")
    private EntityManager entityManager;
	
	

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		EscolaSambaRepository escolaSambaRepository = new EscolaSambaRepository(this.entityManager);
		return (EscolaSamba) escolaSambaRepository.getPorId(id);
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		EscolaSambaRepository escolaSambaRepository = new EscolaSambaRepository(this.entityManager);
		return escolaSambaRepository.inserir(entidade);
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		EscolaSambaRepository escolaSambaRepository = new EscolaSambaRepository(this.entityManager);
		return escolaSambaRepository.editar(entidade);
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		EscolaSambaRepository escolaSambaRepository = new EscolaSambaRepository(this.entityManager);
		return escolaSambaRepository.remover(entidade);
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		EscolaSambaRepository escolaSambaRepository = new EscolaSambaRepository(this.entityManager);
		return escolaSambaRepository.removerPorId(id);
	}

	@Override
	public List<Entidade> listar() throws Exception {
		EscolaSambaRepository escolaSambaRepository = new EscolaSambaRepository(this.entityManager);
		return escolaSambaRepository.listar();
	}

}
