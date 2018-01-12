package br.com.prova.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.entities.Entidade;
import br.com.prova.entities.EscolaSamba;
import br.com.prova.interfaces.GenericRepository;

public class EscolaSambaRepository implements GenericRepository {

	private EntityManager entityManager;

	public EscolaSambaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		try {
			return entityManager.find(EscolaSamba.class, id);
		} catch (Exception e) {
			throw new Exception("[EscolaSambaDAO] Erro ao buscar escola por id." + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		try {
			this.entityManager.persist((EscolaSamba) entidade);
			this.entityManager.flush();
			return Boolean.TRUE;
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			throw new Exception("[EscolaSambaDAO] Erro ao salvar escola de samba. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		try {
			this.entityManager.merge((EscolaSamba) entidade);
			this.entityManager.flush();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[EscolaSambaDAO] Erro ao editar escola de samba. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		try {
			this.entityManager.remove((EscolaSamba) entidade);
			this.entityManager.flush();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[EscolaSambaDAO] Erro ao editar escola de samba. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		try {
			this.remover((EscolaSamba) this.getPorId(id));
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception("[EscolaSambaDAO] Erro ao remover escola de samba por id." + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> listar() throws Exception {
		try {
			return entityManager.createQuery("FROM " + EscolaSamba.class.getName()).getResultList();
		} catch (Exception e) {
			throw new Exception("[EscolaSambaDAO] Erro ao listar escolas de samba. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

}
