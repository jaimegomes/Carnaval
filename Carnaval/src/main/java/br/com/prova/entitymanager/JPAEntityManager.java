package br.com.prova.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Classe responsável pela criação do EntityManager
 * 
 * @author Jaime Gomes
 *
 */
public class JPAEntityManager {
	
	private static final String PERSISTENCE_UNIT = "apuracao_escola_samba";

    private static ThreadLocal<EntityManager>
            threadEntityManager = new ThreadLocal();

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        EntityManager entityManager = threadEntityManager.get();

        if(entityManager == null || !entityManager.isOpen()){
            entityManager =
                    entityManagerFactory.createEntityManager();
            JPAEntityManager.threadEntityManager.set(entityManager);
        }

        return entityManager;
    }


    public static void closeEntityManager(){
        EntityManager em = threadEntityManager.get();

        if(em != null){
            EntityTransaction transaction = em.getTransaction();

            if(transaction.isActive()){
                transaction.commit();
            }

            em.close();

            threadEntityManager.set(null);

        }

    }

    public static void closeEntityManagerFactory(){
        closeEntityManager();
        entityManagerFactory.close();
    }

}
