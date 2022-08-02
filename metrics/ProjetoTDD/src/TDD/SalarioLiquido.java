package TDD;

public class SalarioLiquido {

		
		public double calcularINSS(double salarioBruto){
		
		double valorINSS = 0;
		if (salarioBruto<1693.72)
			valorINSS = (salarioBruto*8/100	);//8%
		else if ((salarioBruto>1693.73)&&(salarioBruto<2822.90))
			valorINSS = (salarioBruto * 9/100);//9%
		else if((salarioBruto>=2822.90)&&(salarioBruto<5645.80))
			valorINSS = (salarioBruto*11/100);//11%
		else
			//salarioBruto >=5645.80
			valorINSS = 621.04;
		return valorINSS;
		}
	
	}


