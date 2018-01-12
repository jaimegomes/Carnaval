package br.com.prova.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.entities.Entidade;
import br.com.prova.entities.Jurado;
import br.com.prova.entitymanager.JPAEntityManager;
import br.com.prova.interfaces.GenericRepository;

public class JuradoRepository implements GenericRepository {

	private EntityManager entityManager;
	private static JuradoRepository instance;

	public static JuradoRepository getInstance() {
		if (instance == null) {
			instance = new JuradoRepository();
		}

		return instance;
	}

	@Override
	public Entidade getPorId(Integer id) throws Exception {
		try {
			return entityManager.find(Jurado.class, id);
		} catch (Exception e) {
			throw new Exception("[JuradoDAO] Erro ao buscar escola por id." + e.getMessage());
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
			entityManager.close();
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
			return entityManager.createQuery("FROM " + Jurado.class.getName()).getResultList();
		} catch (Exception e) {
			throw new Exception("[JuradoDAO] Erro ao listar jurados. " + e.getMessage());
		}
	}

}
