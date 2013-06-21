package br.scrumban;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.scrumban.dao.VendaDAO;
import br.scrumban.dao.VendedorDAO;
import br.scrumban.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testTotal_Vendas_Vendedor_2_Em_2011_Retorno_100() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}
	
	@Test
	public void testTotal_Vendas_Vendedor_3_Em_2010_Retorno_1000() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2010;
		double resultado;
		double esperado = 1000.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}
	
	@Test
	public void testTotal_Vendas_Vendedor_4_Em_2010_Retorno_0() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 4;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2010;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}
	
	@Test
	public void testTotal_Vendas_Vendedor_5_Em_2010_Retorno_3000() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 5;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2010;
		double resultado;
		double esperado = 3000.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}

	@Test
	public void testTotalVendasDeUmVendedorComUmaVendaCompartilhadaPorDois() {

		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 7;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 2500.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}

	public void testTotalVendasDeUmVendedorComUmaVendaCompartilhadaEOutraVendaSozinha(){}
	
	public void testTotalVendasDeUmVendedorComUmaVendaCompartilhadaPorTres(){}
}
