package br.com.unyleya.util.dao;

import javax.persistence.EntityManager;

import br.com.unyleya.modelo.Pessoa;

public class FactoryDAO {

	EntityManager em = new JPAUtil().getEntityManager();

	public void salvar(Pessoa p) {
		try {
			em.getTransaction().begin();

			if (p.getNome() == null)
				em.persist(p);
			else
				em.merge(p);

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			System.out.println("Error: Ao persistir entidade: " + p.getNome());
			System.out.println("Error: " + e.getMessage());
		}
	}

	public Pessoa listaPessoaPorId(int id) {
		return em.find(Pessoa.class, id);
	}

}
