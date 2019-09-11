package br.com.unyleya.main;

import javax.swing.JOptionPane;

import br.com.unyleya.controller.PessoaController;
import br.com.unyleya.modelo.Pessoa;

public class Testa {

	public static void main(String[] args) {

		String nome = JOptionPane.showInputDialog("Informe seu Nome:");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe sua Idade:"));
		String endereco = JOptionPane.showInputDialog("Informe seu Endereço:");

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setEndereco(endereco);

		PessoaController controller = new PessoaController();
		controller.salvar(pessoa);
	}

}
