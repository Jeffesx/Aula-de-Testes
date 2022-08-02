package pkg.metricas;

import javax.swing.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Atendimento {

	private static final String NOME = "NOME: ";
	private static final String VALOR = "VALOR: ";
	private static final String SOBRENOME = "SOBRENOME: ";
	private static final String NOME_ESPACO = "NOME\t";
	private static final String SERIE_DE_TRACOS = "-------------------------------------------------------------\n";
	private static final String MENSAGEM_DO_PROGRAMA = "MENSAGEM DO PROGRAMA";

	private static class Atende {
		 public int cartao;
		 public String nome;
		 public String sobreNome;
		 double valor;
		 public Atende prox;
	}
	
	static Atende inicio = null;
	static Atende fim = null;
	static Atende aux;
	static int op = 0;

	public static void main(String[] args) {



		do {
			try {
				op = mostrarMenu();
			} catch (Exception e) {
				cancelar();
				continue;
			}
			if (op < 1 || op > 13)
				System.out.println("Opção Inválida!!");

			if (op == 1) {
				int numero = 0;
				try {
					numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO CARTÃO: ", "0"));
				} catch (NumberFormatException e) {
					agenteDeErro(e);
					continue;
				}
				boolean achou = verificaNumeroDoCartao(numero);
				if (!achou) {
					Atende novo = new Atende();
					novo.cartao = numero;

					try {
						novo.nome = JOptionPane.showInputDialog(NOME, "");
						novo.sobreNome = JOptionPane.showInputDialog(SOBRENOME, "");
						novo.valor = Double.parseDouble(JOptionPane.showInputDialog(VALOR, "0"));
					} catch (NumberFormatException e) {
						agenteDeErro(e);
						continue;
					}
					insereNumeroDeCartao(novo);
				}
			}

			if (op == 2) {
				consultarCliente();
			}

			if (op == 3) {
				atenderCliente();

			}

			if (op == 4) {
				liberarTodosClientes();
			}

			if (op == 5) {
				verificarQtdClientesAtender();
			}

			if (op == 6) {
				localizarClientePorNumero();
			}

			if (op == 7) {
				localizarClientePorNome();
			}

			if (op == 8) {
				emitirRelatorioDeClientes();
			}

			if (op == 9) {

				verRelatorioDeClientes();
			}

			if (op == 10) {
				filtrarClientePorValor();
			}

			if (op == 11) {
				verEnderecoHash();
			}

			if (op == 12) {
				sobre();
			}

		} while (op != 13);
		JOptionPane.showMessageDialog(null, " * PROGRAMA FINALIZADO * ");

	}

	private static void insereNumeroDeCartao(Atende novo) {
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			fim.prox = novo;
			fim = novo;
		}

		JOptionPane.showMessageDialog(null,
				"O cartão número " + novo.cartao + ", foi inserido para atendimento: ",
				MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
	}

	private static boolean verificaNumeroDoCartao(int numero) {
		aux = inicio;
		boolean achou = false;
		while (aux != null) {
			if (aux.cartao == numero) {
				achou = true;
				JOptionPane.showMessageDialog(null, "Esse número do cartão já foi usado.\nFavor verificar!");
				break;
			}
			aux = aux.prox;
		}
		return achou;
	}

	private static void cancelar() {
		JOptionPane.showMessageDialog(null,
				"A tecla <<Cancelar>> foi acionada!\nEscolha a opção 6 para encerrar.", "Mensagem",
				JOptionPane.CLOSED_OPTION);
	}

	private static void sobre() {
		JTextArea saida = new JTextArea(8, 30); // HEIGHT X WIDTH
		if (true) {
			saida.append("\n");
			saida.append("PROGRAMA DE ATENDIMENTO AO CLIENTE\n");
			saida.append(SERIE_DE_TRACOS);
			saida.append("Copyright (c) Byta Bug Informática Ltda\n");
			saida.append("Programadores: Asdrubal, Indalécio e Quelé\n");
			saida.append("Versão 1.0\n");
			saida.append(SERIE_DE_TRACOS);
			saida.append("Data: Fevereiro de 2019\n");
			saida.append(SERIE_DE_TRACOS);
			saida.append("\n");
			JOptionPane.showMessageDialog(null, saida, "SOBRE O PROGRAMA", JOptionPane.CLOSED_OPTION);
		}
	}

	private static void verEnderecoHash() {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			JTextArea saida = new JTextArea(7, 45); // HEIGHT X WIDTH
			JScrollPane scroll = new JScrollPane(saida);
			saida.append(NOME_ESPACO + "ENDEREÇO\tPROX\t\n");
			saida.append(SERIE_DE_TRACOS);
			aux = inicio;
			while (aux != null) {
				if (aux.prox != null)
					saida.append(aux.nome + "\t" + aux.hashCode() + "\t" + aux.prox.hashCode() + "\n");
				else
					saida.append(aux.nome + "\t" + aux.hashCode() + "\tfim\n");

				aux = aux.prox;
			}
			saida.append("\n");
			JOptionPane.showMessageDialog(null, scroll, "CONSULTAR DADOS DO ATENDIMENTO",
					JOptionPane.CLOSED_OPTION);
		}
	}

	private static void filtrarClientePorValor() {
		double filtro = Double.parseDouble(
				JOptionPane.showInputDialog("FILTRAR ATENDIMENTOS PARA VALORES SUPERIORES A: ", ""));
		JTextArea saida = new JTextArea(6, 45); // HEIGHT X WIDTH
		JScrollPane scroll = new JScrollPane(saida);
		saida.append("CARTÃO\t" + NOME_ESPACO + "SOBRENOME\t" + "VALOR\n");
		saida.append("----------------------------------------------------------------------------\n");
		aux = inicio;
	
		saida.append("\n");
		JOptionPane.showMessageDialog(null, scroll, "ATENDIMENTOS COM VALORES SUPERIORES A: " + filtro,
				JOptionPane.CLOSED_OPTION);
	}

	private static void verRelatorioDeClientes() {
		int resposta = JOptionPane.showConfirmDialog(null, "DESEJA VER ARQUIVO?", "MENSAGEM",
				JOptionPane.YES_NO_OPTION);

		if (resposta == JOptionPane.YES_OPTION) {
			try {
				Process pro = Runtime.getRuntime().exec("cmd.exe /c  Atendimento.txt");
				pro.waitFor();
			} catch (Exception e) {
				System.out.println("Erro . . . ");
			}
		}
	}

	private static void emitirRelatorioDeClientes() {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			aux = inicio;

			try {
				FileWriter arq = new FileWriter("Atendimento.txt");
				PrintWriter gravar = new PrintWriter(arq);

				while (aux != null) {

					gravar.printf("%d, %s, %s, %.2f %n", aux.cartao, aux.nome, aux.sobreNome, +aux.valor);
					aux = aux.prox;
				
				}
				gravar.printf("%s %n", "--------------------------");
				gravar.printf("%s %n", "copyright (c) by: Fulano de Tal, Sicrano de Tal");
				arq.close();
			} catch (IOException e) {
				System.out.println("MENSAGEM / CLASS ArquivoTexto:\nErro ao tentar gravar no arquivo");
			}

			JOptionPane.showMessageDialog(null,
					"ARQUIVO GRAVADO COM SUCESSO" + "\n(Na própria pasta do projeto)...", "MENSAGEM DO SISTEMA",
					JOptionPane.CLOSED_OPTION);
			System.out.println("Arquivo gravado com sucesso na própria pasta do projeto ...");
		}
	}

	private static void localizarClientePorNome() {
		String nome = JOptionPane.showInputDialog("Nome do cliente", "");
		aux = inicio;
		int posicao = 1;
		while (aux != null) {
			if (aux.nome.equals(nome)) {
				String texto = "CARTÃO: " + aux.cartao + "\n" + NOME + aux.nome + "\n" + SOBRENOME
						+ aux.sobreNome + "\n" + VALOR + aux.valor + "\n" + "POSIÇÃO: " + posicao
						+ "a. POSIÇÃO";
				JOptionPane.showMessageDialog(null, "DADOS DO CLIENTE: \n\n" + texto, MENSAGEM_DO_PROGRAMA,
						JOptionPane.CLOSED_OPTION);
			}


			posicao++;
			aux = aux.prox;
		}
	}

	private static void localizarClientePorNumero() {
		int cartao = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do cartão", "0"));
		aux = inicio;
		int posicao = 1;
		while (aux != null) {
			if (cartao == aux.cartao) {
				String texto = "CARTÃO: " + aux.cartao + "\n" + NOME + aux.nome + "\n" + SOBRENOME
						+ aux.sobreNome + "\n" + VALOR + aux.valor + "\n" + "POSIÇÃO: " + posicao
						+ "a. POSIÇÃO";
				JOptionPane.showMessageDialog(null, "DADOS DO CLIENTE: \n\n" + texto, MENSAGEM_DO_PROGRAMA,
						JOptionPane.CLOSED_OPTION);
			}

			posicao++;
			aux = aux.prox;
		}
	}

	private static void verificarQtdClientesAtender() {
		aux = inicio;
		int n = 0;
		double soma = 0;
		while (aux != null) {
			soma = soma + aux.valor;
			aux = aux.prox;
			n++;
		}
		JOptionPane.showMessageDialog(null,
				"O ATENDIMENTO CONTÉM: " + n + " ELEMENTOS.\nVALOR TOTAL: " + soma + "\n",
				MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
	}

	private static void liberarTodosClientes() {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			inicio = null;
			JOptionPane.showMessageDialog(null, " * * O ATENDIMENTO FOI LIBERADO * *", MENSAGEM_DO_PROGRAMA,
					JOptionPane.CLOSED_OPTION);
		}

	}

	private static void atenderCliente() {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			JOptionPane.showMessageDialog(null,
					"CARTÃO:  " + inicio.cartao + ", NOME: " + inicio.nome + " foi atendido(a)!",
					MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
			inicio = inicio.prox;
		}

	}

	private static void consultarCliente() {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			JTextArea saida = new JTextArea(6, 45); // HEIGHT X WIDTH
			JScrollPane scroll = new JScrollPane(saida);
			saida.append("CARTÃO\t" + NOME_ESPACO + "SOBRENOME\t" + "VALOR\n");
			saida.append("-------------------------------------------------------------------------\n");
			aux = inicio;
			while (aux != null) {
				saida.append(aux.cartao + "\t" + aux.nome + "\t" + aux.sobreNome + "\t" + aux.valor + "\n");
				aux = aux.prox;
			}

			saida.append("\n");
			JOptionPane.showMessageDialog(null, scroll, "CONSULTAR DADOS DO ATENDIMENTO",
					JOptionPane.CLOSED_OPTION);
		}
	}

	private static void agenteDeErro(NumberFormatException e) {
		JOptionPane.showMessageDialog(null,
				"ERRO AO TENTAR CONVERTER UM VALOR\nFAVOR VERIRIFICAR\nMENSAGEM ORIGINAL: " + e.getMessage(),
				"AGENTE DE ERRO", JOptionPane.CLOSED_OPTION);
	}

	private static void atendimentoVazio() {
		JOptionPane.showMessageDialog(null, "NÃO HÁ ATENDIMENTOS", MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
	}

	private static int mostrarMenu() {
			
		return  Integer.parseInt(JOptionPane.showInputDialog("\nMENU DE OPÇÕES\n" + "\n1  - Recepcionar cliente"
				+ "\n2  - Consultar clientes a serem atendidos" + "\n3  - Atender cliente"
				+ "\n4  - Liberar todos os clientes" + "\n5  - Verificar quantidade de clientes a atender"
				+ "\n6  - Localizar cliente por número" + "\n7  - Localizar cliente por nome"
				+ "\n8  - Emitir relatório de clientes" + "\n9  - Ver relatório de clientes"
				+ "\n10 - Filtrar clientes por valor" + "\n11 - Ver endereços hash" + "\n12 - Sobre" + "\n13 - Sair\n", "1"));

	}

}
