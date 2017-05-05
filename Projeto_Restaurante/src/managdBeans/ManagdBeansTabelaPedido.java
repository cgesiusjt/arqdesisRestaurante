package managdBeans;

import java.util.List;

import controler.PedidoControle;
import entidade.CardapioTO;
import persistence.PedidoDAO;

public class ManagdBeansTabelaPedido {
	
	private List<CardapioTO> listaTabelaPedido;

	public List<CardapioTO> getListaTabelaPedido() {
		
		PedidoDAO daoPedido = new PedidoDAO();
		
		try {
			//listaTabelaPedido = daoPedido.allTabelaPedido();
			listaTabelaPedido = PedidoControle.listaCardapio;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return listaTabelaPedido;
	}
	
	

}
