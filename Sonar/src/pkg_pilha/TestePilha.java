package pkg_pilha;

import java.util.logging.Logger;

import javax.swing.*;

public class TestePilha {

	// Definindo a classe que representará cada elemento da Pilha
	private static class Pilha {
		private int numero;
		private double valor;
		private int pedido;
		private Pilha prox;
	}

	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(TestePilha.class.getName());
		Pilha topo = null;

		String pilhaVazia = "A PILHA está vazia!";
		int op = 0;

		do {
			try {
				op = Integer.parseInt(JOptionPane.showInputDialog(opcoesMenu(), "1"));

			} catch (Exception e) {
				// Silent exception
				logger.info("");

			}

			topo = opcoesChapas(topo, pilhaVazia, op);

		} while (op != 7);
		logger.info(">>> PROGRAMA FINALIZADO!");

	} // FIM MÉTODO MAIN()

	private static Pilha opcoesChapas(Pilha topo, String pilhaVazia, int op) {
		if (op < 1 || op > 8) {
			mensagem("Opção Inválida!");

		}
		// INSERIR/EMPILHAR CHAPAS - DESAFIO 1
		if (op == 1) {
			topo = inserirEmpilharChapas(topo);

		}
		// CONSULTAR CHAPAS CADASTRADAS
		if (op == 2) {
			if (topo == null) {
				mensagem(pilhaVazia);
			} else {
				consultarChapasCadastradas(topo);
			}
		}
		// DESEMPILHAR CHAPA
		if (op == 3) {
			topo = desempilharChapas(topo, pilhaVazia);
		}
		// ESVAZIAR PÁTIO
		if (op == 4) {
			topo = esvaziarPatio(topo);
		}
		// QUANTIDADE E CHAPAS
		if (op == 5) {
			quantidadeDeChapas(topo);
		}
		// FILTRAR CHAPAS CADASTRADAS - DESAFIO 3
		if (op == 6) {
			filtrarChapasCadastradas(topo, pilhaVazia);
		}
		return topo;
	}

	private static void quantidadeDeChapas(Pilha topo) {
		Pilha aux;
		aux = topo;
		int n = 0;
		while (aux != null) {
			aux = aux.prox;
			n++;
		}
		mensagem("A Pilha contém: " + n + " elementos.");
	}

	private static Pilha esvaziarPatio(Pilha topo) {
		if (topo == null) {
			mensagem("A Pilha está vazia!");
		} else {
			topo = null;
			mensagem("A Pilha foi esvaziada!");
		}
		return topo;
	}

	private static Pilha desempilharChapas(Pilha topo, String pilhaVazia) {
		if (topo == null) {
			mensagem(pilhaVazia);
		} else {
			mensagem("Número: " + topo.numero + ", foi removido.");
			topo = topo.prox;
		}
		return topo;
	}

	private static void filtrarChapasCadastradas(Pilha topo, String pilhaVazia) {
		Pilha aux;
		if (topo == null) {
			mensagem(pilhaVazia);
		} else {
			int npedido = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
			JTextArea saida = new JTextArea(6, 35); // HEIGHT X WIDTH
			JScrollPane scroll = new JScrollPane(saida);
			saida.append("FILTRO, CHAPAS PARA O PEDIDO NRO: " + npedido + "\n");
			saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
			saida.append("================================\n");
			aux = topo;
			while (aux != null) {
				if (aux.pedido == npedido) {
					saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
				}
				aux = aux.prox;
			}
			JOptionPane.showMessageDialog(null, scroll, "CONSULTAR CHAPAS CADASTRADAS",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void consultarChapasCadastradas(Pilha topo) {
		final Logger logger = Logger.getLogger(TestePilha.class.getName());
		Pilha aux;
		JTextArea saida = new JTextArea(6, 35); // HEIGHT X WIDTH
		JScrollPane scroll = new JScrollPane(saida);
		saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
		saida.append("===============================\n");
		aux = topo;
		while (aux != null) {
			// VERIFICAR ENDER E PROX (DESAFIO 2)
			if (aux.prox != null) {
				String msg = "Num: " + aux.numero + ", endereço: " + aux.hashCode() + " => " + " Prox => "
						+ aux.prox.hashCode() + "\n";
				logger.info(msg);
			}

			saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
			aux = aux.prox;
		}
		JOptionPane.showMessageDialog(null, scroll, "CONSULTAR CHAPAS CADASTRADAS", JOptionPane.INFORMATION_MESSAGE);
	}

	private static Pilha inserirEmpilharChapas(Pilha topo) {
		Pilha aux;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DA CHAPA", "0"));
		aux = topo;
		boolean achou = false;
		while (aux != null) {
			if (aux.numero == numero) {
				achou = true;
				mensagem("Esse número de chapa já foi empilhado.\nFavor verificar!");
				break;
			}
			aux = aux.prox;
		}
		if (!achou) {
			Pilha novo = new Pilha();
			novo.numero = numero;
			novo.valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR DA CHAPA", "0"));
			novo.pedido = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
			novo.prox = topo;
			topo = novo;
		}
		return topo;
	}

	// STRING - OPÇÕES MENU
	private static String opcoesMenu() {

		return "\nMENU DE OPÇÕES\n" + "\n1 - Empilhar Chapas." + "\n2 - Consultar Todas as Chapas."
				+ "\n3 - Desempilhar Chapas." + "\n4 - Remover Todas as Chapas Da Pilha."
				+ "\n5 - Verificar Quantidade de Chapas." + "\n6 - Filtrar Chapas Por Pedido." + "\n7 - Sair";
	}
	// MÉTODO VOID MENSAGEM()

	private static void mensagem(String a) {
		JOptionPane.showMessageDialog(null, a, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
	}
} // FIM CLASSE
