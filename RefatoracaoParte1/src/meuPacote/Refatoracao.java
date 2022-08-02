package meuPacote;

import java.util.Calendar;
import java.util.Scanner;

public class Refatoracao {
	private static final int QUANTIDADE = 3;
	static Calendar calendario;
	static Scanner entrada;
	public static void main(String[] args) {
		double mensalidade = 0;
		double novaMensalidae = 0;
		int mes = 0;
		int mesAtual = 0;
		double valorCalculadoMensalidade =1.10;
		
		entrada = new Scanner(System.in);
		int contador = 1;
		while (contador <= QUANTIDADE) {
			System.out.println("\nValor da mensalidade: ");
			mensalidade = entrada.nextInt();
			System.out.println("\nMês da referecia: ");
			mes = entrada.nextInt();
			calendario = Calendar.getInstance();
			mesAtual = calendario.get(Calendar.MONTH) + 1;
			novaMensalidae = verificarValorMensalidade(mensalidade, novaMensalidae, mes, mesAtual,valorCalculadoMensalidade);
			imprimirResultados(mensalidade, novaMensalidae, mes, mesAtual);
			contador++;
		}
		System.out.println("PROGRAMA FINALIZADO!");
	}
	private static void imprimirResultados(double mensalidade, double novaMensalidae, int mes, int mesAtual) {
		System.out.println("RESULTADO ");
		System.out.println("Mes Atual " + mesAtual);
		System.out.println("Referencia " + mes);
		System.out.println("Mesalidade " + mensalidade);
		System.out.println("Novo valor " + novaMensalidae);
	}
	private static double verificarValorMensalidade(double mensalidade, double novaMensalidae, int mes, int mesAtual,double valorCalculadoMensalidade) {
		
		if (mes < mesAtual)
			novaMensalidae = mensalidade * valorCalculadoMensalidade;
		else if (mes >= mesAtual)
			novaMensalidae = mensalidade;
		return novaMensalidae;
	}
}
