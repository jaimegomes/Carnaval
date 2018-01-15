package br.com.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.entitymanager.JPAEntityManager;
import br.com.prova.interfaces.GenericDAO;
import br.com.prova.model.Entidade;
import br.com.prova.model.Nota;

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
			entityManager = JPAEntityManager.getEntityManager();
			return entityManager.find(Nota.class, id);
		} catch (Exception e) {
			throw new Exception("[NotaDAO] Erro ao buscar escola por id." + e.getMessage());
		} finally {
			entityManager.close();
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
			JPAEntityManager.getEntityManager();
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
			Nota escolaSamba = (Nota) entidade;
			entityManager = JPAEntityManager.getEntityManager();
			Nota escolaRemover = entityManager.find(Nota.class, escolaSamba.getId());
			entityManager.getTransaction().begin();
			entityManager.remove(escolaRemover);
			entityManager.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("[NotaDAO] Erro ao remover nota. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean removerPorId(Integer id) throws Exception {
		try {
			Nota escolaSamba = (Nota) this.getPorId(id);
			this.remover(escolaSamba);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception("[NotaDAO] Erro ao remover nota por id." + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> listar() throws Exception {
		try {
			entityManager = JPAEntityManager.getEntityManager();
			return entityManager.createQuery("FROM " + Nota.class.getName()).getResultList();
		} catch (Exception e) {
			throw new Exception("[NotaDAO] Erro ao listar notas. " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	public List<Entidade> getApuracao(Integer idEscola) throws Exception {
		entityManager = JPAEntityManager.getEntityManager();

		List<Nota> results = (List<Nota>) entityManager
				.createQuery("SELECT n FROM Nota n WHERE n.escolaSamba = '" + idEscola + "' GROUP BY n.quesito").getResultList();

		for (Entidade e : results) {
			Nota nota = (Nota) e;
			nota.setMaiorNota(this.getMaiorNota(nota.getQuesito().getId(), idEscola));
			nota.setMenorNota(this.getMenorNota(nota.getQuesito().getId(), idEscola));
			nota.setMedia(nota.getQuesito().getId(), nota.getEscolaSamba().getId(), nota.get);
		}
		return null;
	}

	public Integer getMenorNota(Integer quesito, Integer escola) {
		List<Integer> results = (List<Integer>) JPAEntityManager.getEntityManager()
				.createQuery("SELECT MIN(n.nota) FROM Nota n WHERE n.quesito = '" + quesito + "' AND n.escolaSamba = '"
						+ escola + "'")
				.getResultList();

		return results.get(0);
	}

	public Integer getMaiorNota(Integer quesito, Integer escola) {
		List<Integer> results = (List<Integer>) JPAEntityManager.getEntityManager()
				.createQuery("SELECT MAX(n.nota) AS maior FROM Nota n WHERE n.quesito = '" + quesito
						+ "' AND n.escolaSamba = '" + escola + "'")
				.getResultList();

		return results.get(0);
	}
	
	public Double getMedia(Nota nota, Integer idMaiorNota, Integer idMenorNota) {
		List<Double> results = (List<Double>) JPAEntityManager.getEntityManager()
				.createQuery("SELECT AVG(n.nota) AS media FROM Nota n WHERE n.id <> '" + idMaiorNota
						+ "' AND n.id <> = '" + idMenorNota + "'")
				.getResultList();

		return results.get(0);
	}
}
