package br.com.unyleya.util.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.unyleya.modelo.Pessoa;

public class FactoryDao {

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

	public List<Pessoa> findAll() {
		System.out.println("Listando todas as Pessoas");
		return em.createQuery("SELECT p FROM pessoa p WHERE status=1 ORDER BY id", Pessoa.class).getResultList();
	}

}
