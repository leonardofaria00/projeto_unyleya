package br.com.unyleya.util.dao;

import java.util.List;

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

	public List<Pessoa> getPessoas() {
		return em.createQuery("SELECT p FROM TAB_PESSOA p WHERE status = 1 ORDER BY id", Pessoa.class).getResultList();
	}

	public Pessoa listaPessoaPorId(Pessoa p) {
		return em.find(Pessoa.class, p.getId());
	}

	public void remover(Pessoa p) {
		Pessoa pessoa = listaPessoaPorId(p);
		em.remove(pessoa);
	}

}
