package br.scrumban;

import java.util.List;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaRepository dao;
	private CalculadoraComissao calculadoraComissao;

	public CalculadoraRoyalties(VendaRepository dao,
			CalculadoraComissao calculaComissao) {
		this.dao = dao;
		this.calculadoraComissao = calculaComissao;
	}

	public double calculaTotalRoyaltiesPorMesEAno(int mes, int ano) {
		List<Venda> vendas = dao.obterVendasPorMesEAno(ano, mes);
		double total = 0d;

		for (Venda venda : vendas) {
			total += venda.getValor() - this.calculadoraComissao.calculaComissao(venda.getValor());
		}

		return total * 0.2;
	}

}
