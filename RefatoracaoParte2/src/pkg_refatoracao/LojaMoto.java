package pkg_refatoracao;

import javax.swing.JOptionPane;

public class LojaMoto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			try {
				String nome = JOptionPane.showInputDialog("Informe a marca (acione [CANCELAR] para sair:");
				fabricaMoto(nome);
			} catch (Exception e) {
				break;
			}
		}
		System.out.println("\n PROGRAMA FINALIZADO");
	}

	private static void fabricaMoto(String nome) {
		if (nome.equalsIgnoreCase("Honda")) {
			Moto moto = new Honda();
			mostraDadosMoto(moto);
		} else if (nome.equalsIgnoreCase("Yamaha")) {
			Moto moto = new Yamaha();
			mostraDadosMoto(moto);
		} else if (nome.equalsIgnoreCase("Suzuki")) {
			Moto moto = new Suzuki();
			mostraDadosMoto(moto);
		}
	}

	private static void mostraDadosMoto(Moto moto) {
		JOptionPane.showMessageDialog(null,
				"\nNome: " + moto.nome + "\nCilindrada: " + moto.cilindrada + "\nCor: " + moto.cor, "Dados da Moto",
				JOptionPane.CLOSED_OPTION);
	}

}
