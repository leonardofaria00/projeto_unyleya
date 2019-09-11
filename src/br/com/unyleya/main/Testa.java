package br.com.unyleya.main;

import javax.swing.JOptionPane;

import br.com.unyleya.modelo.Pessoa;

public class Testa {

	public static void main(String[] args) {
		int value;

		do {
			value = Integer.parseInt(
					JOptionPane.showInputDialog("Digite:\n1 Cadastrar \n2 Buscar por id \n3 Listar todos \n0 sair"));

			switch (value) {
			case 1:
				new Pessoa().cadastrar();
				break;
			case 2:
				new Pessoa().listaPorId();
				break;
			case 3:
				new Pessoa().getPessoas();
				break;
			default:
				JOptionPane.showMessageDialog(null, "FIM!");
				break;
			}

		} while (value == 1 || value == 2 || value == 3);

	}

}
