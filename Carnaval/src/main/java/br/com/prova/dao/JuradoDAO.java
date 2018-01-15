package br.com.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.entitymanager.JPAEntityManager;
import br.com.prova.interfaces.GenericDAO;
import br.com.prova.model.Entidade;
import br.com.prova.model.Jurado;

public class JuradoDAO implements GenericDAO {
	private EntityManager entityManager;
	private static JuradoDAO instance;

	public static JuradoDAO getInstance() {
		if (instance == null) {
			instance = new JuradoDAO();
		}

		return instance;
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			return entityManager.find(Jurado.class, id);
		} catch (Exception e) {
			throw new Exception("[JuradoDAO] Erro ao buscar escola por id." + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist((Jurado) entidade);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[JuradoDAO] Erro ao salvar jurado. " + e.getMessage());
		} finally {
			JPAEntityManager.getEntityManager();
		}
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge((Jurado) entidade);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[JuradoDAO] Erro ao editar jurado. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		try {
			Jurado jurado = (Jurado) entidade;
			entityManager = JPAEntityManager.getEntityManager();
			Jurado juradorRemover = entityManager.find(Jurado.class, jurado.getId());
			entityManager.getTransaction().begin();
			entityManager.remove(juradorRemover);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[JuradoDAO] Erro ao remover jurado. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		try {
			Jurado jurado = (Jurado) this.getPorId(id);
			this.remover(jurado);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception("[JuradoDAO] Erro ao remover jurado por id." + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> listar() throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			return entityManager.createQuery("FROM " + Jurado.class.getName()).getResultList();
		} catch (Exception e) {
			throw new Exception("[JuradoDAO] Erro ao listar jurados. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

}
