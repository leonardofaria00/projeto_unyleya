package br.com.unyleya.main;

import javax.swing.JOptionPane;

import br.com.unyleya.modelo.Pessoa;

public class Testa {

	public static void main(String[] args) {
		int value;

		do {
			value = Integer.parseInt(
					JOptionPane.showInputDialog("Digite:\n1 Cadastrar \n2 Listar todos \n3 Buscar por id \n0 sair"));

			switch (value) {
			case 1:
				new Pessoa().cadastrar();
				break;
			case 2:
				new Pessoa().getPessoas();
				break;
			case 3:
				new Pessoa().listaPorId();
				break;
			case 4:
				new Pessoa().getPessoas();
				break;
			default:
				JOptionPane.showMessageDialog(null, "FIM!");
				break;
			}

		} while (value == 1 || value == 2 || value == 3);

	}

}
