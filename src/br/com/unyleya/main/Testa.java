package br.com.unyleya.main;

import javax.swing.JOptionPane;

import br.com.unyleya.controller.PessoaController;
import br.com.unyleya.modelo.Pessoa;

public class Testa {

	public static void main(String[] args) {
		int value;

		do {
			value = Integer
					.parseInt(JOptionPane.showInputDialog("Digite:\n1 para cadastrar \n2 para buscar \n0 para sair"));

			switch (value) {
			case 1:
				new Testa().cadastrar();
				break;
			case 2:
				new Testa().buscar();
			default:
				JOptionPane.showMessageDialog(null, "FIM!");
				break;
			}

		} while (value == 1 || value == 2);

	}

	public void cadastrar() {
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

	public void buscar() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID:"));
		System.out.println("Buscando Id: " + id);

		PessoaController controller = new PessoaController();
		Pessoa pessoa = controller.listaPessoaPorId(id);

		StringBuilder builder = new StringBuilder();
		builder.append("ID: " + pessoa.getId());
		builder.append("\nNome: " + pessoa.getNome());
		builder.append("\nIdade: " + pessoa.getIdade() + " anos");
		builder.append("\nEndereço: " + pessoa.getEndereco());

		JOptionPane.showMessageDialog(null, builder);
		System.out.println(pessoa);
	}
}
