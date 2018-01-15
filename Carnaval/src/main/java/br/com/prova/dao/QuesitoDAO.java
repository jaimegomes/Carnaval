package br.com.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.entitymanager.JPAEntityManager;
import br.com.prova.interfaces.GenericDAO;
import br.com.prova.model.Entidade;
import br.com.prova.model.Quesito;

public class QuesitoDAO implements GenericDAO {

	private EntityManager entityManager;
	private static QuesitoDAO instance;

	public static QuesitoDAO getInstance() {
		if (instance == null) {
			instance = new QuesitoDAO();
		}

		return instance;
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			return entityManager.find(Quesito.class, id);
		} catch (Exception e) {
			throw new Exception("[QuesitoDAO] Erro ao buscar quesito por id." + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist((Quesito) entidade);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[QuesitoDAO] Erro ao salvar quesito. " + e.getMessage());
		} finally {
			JPAEntityManager.getEntityManager();
		}
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge((Quesito) entidade);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[QuesitoDAO] Erro ao editar quesito. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		try {
			Quesito quesito = (Quesito) entidade;
			entityManager = JPAEntityManager.getEntityManager();
			Quesito quesitoRemover = entityManager.find(Quesito.class, quesito.getId());
			entityManager.getTransaction().begin();
			entityManager.remove(quesitoRemover);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[QuesitoDAO] Erro ao remover quesito. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		try {
			Quesito quesito = (Quesito) this.getPorId(id);
			this.remover(quesito);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception("[QuesitoDAO] Erro ao remover quesito por id." + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> listar() throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			return entityManager.createQuery("FROM " + Quesito.class.getName()).getResultList();
		} catch (Exception e) {
			throw new Exception("[QuesitoDAO] Erro ao listar quesitos. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}
}
