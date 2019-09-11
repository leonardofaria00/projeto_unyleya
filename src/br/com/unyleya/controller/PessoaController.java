package br.com.unyleya.controller;

import java.util.List;

import br.com.unyleya.modelo.Pessoa;
import br.com.unyleya.util.dao.FactoryDAO;

public class PessoaController {

	FactoryDAO dao = new FactoryDAO();

	public void salvar(Pessoa p) {
		if (p.getNome() != null && p.getNome() != "")
			dao.salvar(p);
	}

	public List<Pessoa> listaPessoas() {
		List<Pessoa> pessoas = dao.getPessoas();
		return pessoas;
	}

	public Pessoa listaPessoaPorId(Pessoa p) {
		return dao.listaPessoaPorId(p);
	}

	public void removePesoa(Pessoa p) {
		dao.remover(p);
	}
}
