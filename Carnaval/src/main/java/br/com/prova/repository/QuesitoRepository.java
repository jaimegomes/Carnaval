package br.com.prova.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.entities.Entidade;
import br.com.prova.entities.Quesito;
import br.com.prova.entitymanager.JPAEntityManager;
import br.com.prova.interfaces.GenericRepository;

public class QuesitoRepository implements GenericRepository {

	private EntityManager entityManager;
	private static QuesitoRepository instance;

	public static QuesitoRepository getInstance() {
		if (instance == null) {
			instance = new QuesitoRepository();
		}

		return instance;
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		try {
			return entityManager.find(Quesito.class, id);
		} catch (Exception e) {
			throw new Exception("[QuesitoDAO] Erro ao buscar escola por id." + e.getMessage());
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
			entityManager.close();
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
			return entityManager.createQuery("FROM " + Quesito.class.getName()).getResultList();
		} catch (Exception e) {
			throw new Exception("[QuesitoDAO] Erro ao listar quesitos. " + e.getMessage());
		}
	}

}
