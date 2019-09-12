package br.com.unyleya.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;

import br.com.unyleya.controller.PessoaController;

@Entity(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String nome;

	@Column
	private int idade;

	@Column
	private String endereco;

	@Column
	private int status = 1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void cadastrar() {
		try {

			String nome = JOptionPane.showInputDialog("Informe seu Nome:");
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe sua Idade:"));
			String endereco = JOptionPane.showInputDialog("Informe seu Endereço:");

			Pessoa pessoa = new Pessoa();
			pessoa.setNome(nome);
			pessoa.setIdade(idade);
			pessoa.setEndereco(endereco);

			PessoaController controller = new PessoaController();

			if (pessoa.getNome().isEmpty() || pessoa.getEndereco().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Dados invalidos!");
				return;
			}
			controller.salvar(pessoa);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valores informados não são aceitos!");
		}
	}

	public void listaPorId() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID:"));
		System.out.println("Buscando Id: " + id);

		PessoaController controller = new PessoaController();
		Pessoa pessoa = controller.listaPessoaPorId(id);

		if (pessoa == null) {
			JOptionPane.showMessageDialog(null, "Id não encontrado. \nInforme um ID válido!");
			return;
		}

		StringBuilder builder = new StringBuilder();
		builder.append("ID: " + pessoa.getId());
		builder.append("\nNome: " + pessoa.getNome());
		builder.append("\nIdade: " + pessoa.getIdade() + " anos");
		builder.append("\nEndereço: " + pessoa.getEndereco());

		JOptionPane.showMessageDialog(null, builder);
		System.out.println(pessoa);
	}

	public void getPessoas() {
		PessoaController controller = new PessoaController();
		List<Pessoa> pessoas = controller.listaTodos();

		if (pessoas.size() == 0) {
			JOptionPane.showMessageDialog(null, "Não existe Pessoa cadastrada.");
			return;
		}

		StringBuilder builder = new StringBuilder();
		for (Pessoa p : pessoas) {
			builder.append("\n---------------------------------------\n");
			builder.append("ID: " + p.getId());
			builder.append("\nNome: " + p.getNome());
			builder.append("\nIdade: " + p.getIdade() + " anos");
			builder.append("\nEndereço: " + p.getEndereco());
		}
		JOptionPane.showMessageDialog(null, builder);

	}

	@Override
	public String toString() {
		return "Pessoa [Id= " + id + ", Nome= " + nome + ", Idade= " + idade + ", Endereço= " + endereco + "]";
	}
}