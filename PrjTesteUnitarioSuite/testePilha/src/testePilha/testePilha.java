package testepilha;
import javax.swing.*;
public class testePilha extends opcoes {   
	private static class Pilha {   
		private int numero;   
		private Pilha prox;  }  
	public static void main(final String[] args) {  
		Pilha topo = null; 
		Pilha aux; 
		int op = 0;  
		do      {     
			op = Integer.parseInt(JOptionPane.showInputDialog(opcoesMenu(),"1"));
			if (op<1 || op>6)     
				System.out.println("Opção Inválida!");       
			if (op == 1) 
			{     final Pilha novo = new Pilha();   
			novo.numero = Integer.parseInt(JOptionPane.showInputDialog("Número: ","0"));   
			novo.prox = topo; 
			topo = novo;        }  
			if (op == 2 )     {    
				if (topo == null) {     
					System.out.println("A PILHA está vazia!");           } else {       aux = topo;             while (aux != null) {        System.out.println(aux.numero);       aux = aux.prox;      }             }     }       }      while ( op != 3);      System.out.println("PROGRAMA FINALIZADO!");   } 
			}

