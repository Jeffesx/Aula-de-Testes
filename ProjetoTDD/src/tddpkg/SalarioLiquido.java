package tddpkg;

public class SalarioLiquido {
	
	public double calcularINSS(double salarioBruto) {
		double valorINSS = 0;
		if(salarioBruto < 1693.72)
			valorINSS = (salarioBruto * 8/100);
		else if ((salarioBruto>=1693.73)&(salarioBruto <2822.90))
			valorINSS = (salarioBruto * 9/100);
		else if ((salarioBruto>=2822.90)&(salarioBruto<5645.80))
			valorINSS = (salarioBruto * 11/100);
		else
			valorINSS = 621.04;
		return valorINSS;
			
	}
	
	public double calcularIRRF(double salarioBruto) {
		double valorIRRF=0;
		if(salarioBruto<=1903.98)
			valorIRRF=0;
		else if((salarioBruto>1903.98)&(salarioBruto<=2826.65))
			valorIRRF = 150.00;
		else if((salarioBruto>2826.65)&(salarioBruto<=3751.05))
			valorIRRF = 350.00;
		else if((salarioBruto>3751.05)&(salarioBruto<=4664.68))
			valorIRRF = 600.00;
		else
			valorIRRF=900.00;
		return valorIRRF;
	}
	public double calcularPlanoOdontologico(double salarioBruto) {
		double valorOdontologico = 0;
		valorOdontologico = (salarioBruto*5/100);
		return valorOdontologico;
	}
	public double calcularPlanoSaude(double salarioBruto) {
		double valorSaude = 0;
		valorSaude = (salarioBruto*10/100);
		return valorSaude;
	}
	public double calcularValorHora(double salarioBruto) {
		double valorHora=0;
		if(salarioBruto>=3000)
			valorHora=13.64;
		else if(salarioBruto >= 2000)
			valorHora=9.09;
		else if(salarioBruto <= 1000)
			valorHora=4.55;
		return valorHora;
	
}
	public double calcularValorHoraExtra(double salarioBruto) {
		double valorHoraExtra=0;
		double quantidadeHoraExtra =30;
		if(salarioBruto>=3000)
			valorHoraExtra =quantidadeHoraExtra*13.64;
		else if(salarioBruto >= 2000)
			valorHoraExtra =quantidadeHoraExtra*9.09;
		else if(salarioBruto >= 1000)
			valorHoraExtra =quantidadeHoraExtra*4.55;
		return valorHoraExtra;
	
}
	public double calcularSalarioLiquido(double salarioBruto) {
		
			
			double salarioLiquido = salarioBruto - calcularINSS(salarioBruto)
			- calcularIRRF(salarioBruto) - calcularPlanoOdontologico(salarioBruto)
			- calcularPlanoSaude(salarioBruto) + calcularValorHoraExtra(salarioBruto);	
			return salarioLiquido;
	}	
}