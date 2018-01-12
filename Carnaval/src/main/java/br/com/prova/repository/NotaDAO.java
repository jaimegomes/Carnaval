package br.com.prova.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.entities.Entidade;
import br.com.prova.entities.Nota;
import br.com.prova.entitymanager.JPAEntityManager;
import br.com.prova.interfaces.GenericDAO;

public class NotaDAO implements GenericDAO {

	private EntityManager entityManager;
	private static NotaDAO instance;

	public static NotaDAO getInstance() {
		if (instance == null) {
			instance = new NotaDAO();
		}

		return instance;
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		try {
			return entityManager.find(Nota.class, id);
		} catch (Exception e) {
			throw new Exception("[NotaDAO] Erro ao buscar escola por id." + e.getMessage());
		}
	}

	@Override
	public Boolean inserir(Entidade entidade) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist((Nota) entidade);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[NotaDAO] Erro ao salvar nota. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean editar(Entidade entidade) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge((Nota) entidade);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[NotaDAO] Erro ao editar nota. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean remover(Entidade entidade) throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge((Nota) entidade);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[NotaDAO] Erro ao editar nota. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		try {
			Nota nota = (Nota) this.getPorId(id);
			this.remover(nota);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception("[NotaDAO] Erro ao remover nota por id." + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> listar() throws Exception {
		try {
			return entityManager.createQuery("FROM " + Nota.class.getName()).getResultList();
		} catch (Exception e) {
			throw new Exception("[NotaDAO] Erro ao listar notas. " + e.getMessage());
		}
	}

}
