package br.com.prova.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.prova.model.EscolaDeSamba;

public class EscolaDeSambaDAO {

	// TODO CORRIGIR O PERSISTENCE.XML COM OS DADOS DO BANCO
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("carnaval");
	private EntityManager em = factory.createEntityManager();

}
