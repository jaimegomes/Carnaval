package br.com.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.entitymanager.JPAEntityManager;
import br.com.prova.interfaces.GenericDAO;
import br.com.prova.model.Entidade;
import br.com.prova.model.EscolaSamba;

public class EscolaSambaDAO implements GenericDAO {

	private EntityManager entityManager;
	private static EscolaSambaDAO instance;

	public static EscolaSambaDAO getInstance() {
		if (instance == null) {
			instance = new EscolaSambaDAO();
		}

		return instance;
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
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
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist((EscolaSamba) entidade);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[EscolaSambaDAO] Erro ao salvar escola de samba. " + e.getMessage());
		} finally {
			JPAEntityManager.getEntityManager();
		}
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge((EscolaSamba) entidade);
			entityManager.getTransaction().commit();
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
			EscolaSamba escolaSamba = (EscolaSamba) entidade;
			entityManager = JPAEntityManager.getEntityManager();
			EscolaSamba escolaRemover = entityManager.find(EscolaSamba.class, escolaSamba.getId());
			entityManager.getTransaction().begin();
			entityManager.remove(escolaRemover);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[EscolaSambaDAO] Erro ao remover escola de samba. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		try {
			EscolaSamba escolaSamba = (EscolaSamba) this.getPorId(id);
			this.remover(escolaSamba);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception("[EscolaSambaDAO] Erro ao remover escola de samba por id." + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> listar() throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			return entityManager.createQuery("FROM " + EscolaSamba.class.getName()).getResultList();
		} catch (Exception e) {
			throw new Exception("[EscolaSambaDAO] Erro ao listar escolas de samba. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

}
