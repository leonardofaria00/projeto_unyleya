package br.com.unyleya.controller;

import br.com.unyleya.modelo.Pessoa;
import br.com.unyleya.util.dao.FactoryDAO;

public class PessoaController {

	FactoryDAO dao = new FactoryDAO();

	public void salvar(Pessoa p) {
		if (p.getNome() != null && p.getNome() != "")
			dao.salvar(p);
	}

	public Pessoa listaPessoaPorId(int id) {
		return dao.listaPessoaPorId(id);
	}

}
