package br.com.unyleya.util.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_final");

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
