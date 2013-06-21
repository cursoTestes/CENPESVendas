package br.scrumban;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void testeVenda1000Comissao50() {
		double venda = 1000;
		double valorComissaoEsperado = 50;
		CalculadoraComissao calc = new CalculadoraComissao();
		double valorComissao = calc.calculaComissao(venda);
		
		assertEquals(valorComissaoEsperado, valorComissao, 0);
	}
	
	@Test
	public void testeVenda100Comissao5() {
		double venda = 100;
		double valorComissaoEsperado = 5;
		
		CalculadoraComissao calc = new CalculadoraComissao();
		double valorComissao = calc.calculaComissao(venda);
	
		assertEquals(valorComissaoEsperado, valorComissao, 0);
	}
	
	@Test
	public void testeVenda10000Comissao500() {
		double venda = 10000;
		double valorComissaoEsperado = 500;
		
		CalculadoraComissao calc = new CalculadoraComissao();
		double valorComissao = calc.calculaComissao(venda);
	
		assertEquals(valorComissaoEsperado, valorComissao, 0);
	}
	
	
	@Test
	public void testeVenda100000Comissao6000() {
		double venda = 100000;
		double valorComissaoEsperado = 6000;
		
		CalculadoraComissao calc = new CalculadoraComissao();
		double valorComissao = calc.calculaComissao(venda);
	
		assertEquals(valorComissaoEsperado, valorComissao, 0);
	}
	
	
	@Test
	public void testeVenda1000000Comissao60000() {
		double venda = 1000000;
		double valorComissaoEsperado = 60000;
		
		CalculadoraComissao calc = new CalculadoraComissao();
		double valorComissao = calc.calculaComissao(venda);
	
		assertEquals(valorComissaoEsperado, valorComissao, 0);
	}
	
	@Test
	public void testeVenda10000_50Comissao600_03() {
		double venda = 10000.50;
		double valorComissaoEsperado = 600.03;
		
		CalculadoraComissao calc = new CalculadoraComissao();
		double valorComissao = calc.calculaComissao(venda);
	
		assertEquals(valorComissaoEsperado, valorComissao, 0);
	}
	
	@Test
	public void testeVenda55_59Comissao2_77() {
		double venda = 55.59;
		double valorComissaoEsperado = 2.77;
		
		CalculadoraComissao calc = new CalculadoraComissao();
		double valorComissao = calc.calculaComissao(venda);
	
		assertEquals(valorComissaoEsperado, valorComissao, 0);
	}
}

