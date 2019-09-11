package br.com.unyleya.controller;

import java.util.List;

import br.com.unyleya.modelo.Pessoa;
import br.com.unyleya.util.dao.FactoryDao;

public class PessoaController {

	FactoryDao factory = new FactoryDao();

	public void salvar(Pessoa p) {
		if (p.getNome() != null && p.getNome() != "")
			factory.salvar(p);
	}

	public Pessoa listaPessoaPorId(int id) {
		return factory.listaPessoaPorId(id);
	}

	public List<Pessoa> listaTodos() {
		List<Pessoa> list = factory.findAll();
		return list;
	}

}
