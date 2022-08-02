package meuSonar;
import javax.swing.*;

import meuSonar.TestePilha.Pilha;

public class consultaChapa {

	protected static void consultarChapas(Pilha topo) {
		Pilha aux;
		if (topo == null) {
		    mensagem(A_PILHA_ESTÁ_VAZIA);
		} else {
		    JTextArea saida = new JTextArea(6, 35); // HEIGHT X WIDTH
		    JScrollPane scroll = new JScrollPane(saida);
		    saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
		    saida.append("===============================\n");
		    aux = topo;
		    enderaco(aux, saida);
		    JOptionPane.showMessageDialog(null, scroll, 
		            "CONSULTAR CHAPAS CADASTRADAS", 
		            JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private consultaChapa() {
		super();
	}

}