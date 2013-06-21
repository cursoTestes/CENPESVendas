package br.scrumban;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.Venda;


public class TestCalculadoraRoyalties {
	
	
	@Test
	public void testeTotalRoyaltiesParaUmMesSemVendas() {
		int mes = 1;
		int ano = 2000;
		double esperado = 0;
		double resultado;
		
		VendaRepository dao = mock(VendaRepository.class);
		
		List<Venda> listaVendas = new ArrayList<Venda>();
		
		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(listaVendas);
		CalculadoraComissao mockedCalculaComissao = mock(CalculadoraComissao.class);
		double comissaoEsperada = 500;
		
		when(mockedCalculaComissao.calculaComissao(0)).thenReturn(comissaoEsperada);
		
		CalculadoraRoyalties calc = new CalculadoraRoyalties(dao, mockedCalculaComissao);
		resultado = calc.calculaTotalRoyaltiesPorMesEAno(mes, ano);
		
		Assert.assertEquals(esperado, resultado, 0);
	}	


	
	@Test
	public void testeTotalRoyaltiesParaUmMesComUmaVenda() {
		int mes = 1;
		int ano = 2000;
		double valorVenda = 10000;
		double esperado = 2000;
		
		double resultado;
		VendaRepository mockedDao = mock(VendaRepository.class);
		
		List<Venda> listaVendas = new ArrayList<Venda>();
		listaVendas.add(new Venda(1, 1, mes, ano, valorVenda));
		
		when(mockedDao.obterVendasPorMesEAno(ano, mes)).thenReturn(listaVendas);
		
		CalculadoraComissao mockedCalculaComissao = mock(CalculadoraComissao.class);
		double comissaoEsperada = 0;
		
		when(mockedCalculaComissao.calculaComissao(valorVenda)).thenReturn(comissaoEsperada);
		
		CalculadoraRoyalties calc = new CalculadoraRoyalties(mockedDao, mockedCalculaComissao );
		resultado = calc.calculaTotalRoyaltiesPorMesEAno(mes, ano);
		
		Assert.assertEquals(esperado, resultado, 0);
	
	}	
}