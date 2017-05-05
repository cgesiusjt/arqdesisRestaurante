package service;

import java.util.ArrayList;
import java.util.List;

import controler.PedidoControle;
import entidade.CardapioTO;
import entidade.Pedido;

public class CalculoPedido {
	
	
	public CalculoPedido() {    
	}
	  
	public double calcValorTotalPedido() {
		
		double total = 0.0;
		List<CardapioTO> lista = new ArrayList<>();
		
		try {
			
			lista = PedidoControle.listaCardapio;
			int i = 0;
			
			while(i < lista.size()) {
				total += lista.get(i).getQuantidade() * lista.get(i).getValorUnitario();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public double calcValorPagamento() {
		
		double total = 0.0;
		List<Pedido> lista = new ArrayList<>();
		
		try {
			lista = PedidoControle.listaPedidoPag;
			if (lista.size() > 0) {
				for(int i = 0; i < lista.size(); i++) {
					total += lista.get(i).getCardapioTO().getQuantidade() * lista.get(i).getCardapioTO().getValorUnitario();
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}
