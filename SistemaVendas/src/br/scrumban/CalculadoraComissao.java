package br.scrumban;

public class CalculadoraComissao {

	public static double calculaComissao(double venda) {
		
		double comissao;
		
		if(venda > 10000){
			comissao = venda * 0.06;
		} else {
			comissao = venda * 0.05;
		}
		
		comissao = (Math.floor(comissao * 100)/100);
		
		 return comissao;
		
	}

}
