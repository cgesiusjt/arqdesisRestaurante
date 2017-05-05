package managdBeans;

import java.util.ArrayList;
import java.util.List;

import controler.PedidoControle;
import entidade.Pedido;

public class ManagdBeansPagamento {
	
	private List<Pedido> listaPagamento = new ArrayList<>();
	
	public List<Pedido> getListaPagamento() {
		try {
			listaPagamento = PedidoControle.listaPedidoPag;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPagamento;
	}

}
