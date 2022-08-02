package meuSonar;

import javax.swing.*;
public class TestePilha extends consultaChapa implements opcaoMenu {
    static final String pilhaVazia = "A PILHA está vazia!";

	// Definindo a classe que representará cada elemento da Pilha
    static class Pilha {
        private int numero;
        private double valor;
        private int pedido;
        private Pilha prox;
    }
    public static void main(String[] args) {
        Pilha topo = null;
        Pilha aux;
        int op = 0;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(opcoesMenu(), "1"));
            } catch (Exception e) {
                // Silent exception
                System.out.println("");
            }

            if (op < 1 || op > 8) {
                mensagem("Opção Inválida!");
            }
            // INSERIR/EMPILHAR CHAPAS - DESAFIO 1
            if (op == 1) {
                int numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DA CHAPA", "0"));
                aux = topo;
                boolean achou = false;
                achou = empilharChapas(aux, numero, achou);
                topo = criaPilha(topo, numero, achou);
            }
            // CONSULTAR CHAPAS CADASTRADAS
            if (op == 2) {
                consultarChapas(topo);
            }
            // DESEMPILHAR CHAPA
            if (op == 3) {
                topo = desempilhar(topo);
            }
            // ESVAZIAR PÁTIO
            if (op == 4) {
                topo = esvaziar(topo);
            }
            // QUANTIDADE E CHAPAS 
            if (op == 5) {
                aux = topo;
                int n = 0;
                n = quantidadeChapas(aux, n);
                mensagem("A Pilha contém: " + n + " elementos.");
            }
            // FILTRAR CHAPAS CADASTRADAS - DESAFIO 3
            if (op == 6) {
                filtraChapas(topo);
            } 
            
        } while (op != 7);
        System.out.println(">>> PROGRAMA FINALIZADO!");

    } // FIM MÉTODO MAIN()

	private static Pilha criaPilha(Pilha topo, int numero, boolean achou) {
		topo = criarPilha(topo, numero, achou);
		return topo;
	}

	private static Pilha criarPilha(Pilha topo, int numero, boolean achou) {
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

	private static void filtraChapas(Pilha topo) {
		Pilha aux;
		if (topo == null) {
		    mensagem(pilhaVazia);
		} else {
		    int npedido = Integer.parseInt(JOptionPane.showInputDialog(
		            "NÚMERO DO PEDIDO", "0"));
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
		    JOptionPane.showMessageDialog(null, scroll, 
		            "CONSULTAR CHAPAS CADASTRADAS", 
		            JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static int quantidadeChapas(Pilha aux, int n) {
		while (aux != null) {
		    aux = aux.prox;
		    n++;
		}
		return n;
	}

	private static Pilha esvaziar(Pilha topo) {
		if (topo == null) {
		    mensagem("A Pilha está vazia!");
		} else {
		    topo = null;
		    mensagem("A Pilha foi esvaziada!");
		}
		return topo;
	}

	private static Pilha desempilhar(Pilha topo) {
		if (topo == null) {
		    mensagem(pilhaVazia);
		} else {
		    mensagem("Número: " + topo.numero + ", foi removido.");
		    topo = topo.prox;
		}
		return topo;
	}

	static void enderaco(Pilha aux, JTextArea saida) {
		while (aux != null) {
		    // VERIFICAR ENDER E PROX (DESAFIO 2)
		    enderaco(aux);

		    saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
		    aux = aux.prox;
		}
	}

	private static void enderaco(Pilha aux) {
		if (aux.prox != null) {
		    System.out.println("Num: " + aux.numero + ", endereço: " 
		            + aux.hashCode() + " => " + " Prox => " 
		            + aux.prox.hashCode() + "\n");
		}
	}

	private static boolean empilharChapas(Pilha aux, int numero, boolean achou) {
		while (aux != null) {
		    if (aux.numero == numero) {
		        achou = true;
		        mensagem("Esse número de chapa já foi empilhado.\nFavor verificar!");
		        break;
		    }
		    aux = aux.prox;
		}
		return achou;
	}

    // STRING - OPÇÕES MENU
    private static String opcoesMenu() {
     
        return  "\nMENU DE OPÇÕES\n"
                + "\n1 - Empilhar Chapas."
                + "\n2 - Consultar Todas as Chapas."
                + "\n3 - Desempilhar Chapas."
                + "\n4 - Remover Todas as Chapas Da Pilha."
                + "\n5 - Verificar Quantidade de Chapas."
                + "\n6 - Filtrar Chapas Por Pedido."
                + "\n7 - Sair";
    }
    // MÉTODO VOID MENSAGEM()

    static void mensagem(String a) {
        voidMensagem(a);
    }

	private static void voidMensagem(String a) {
		JOptionPane.showMessageDialog(null, a, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
	}
} // FIM CLASSE
