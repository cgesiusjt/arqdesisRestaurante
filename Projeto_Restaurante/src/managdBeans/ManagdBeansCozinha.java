package managdBeans;

import java.util.List;

import controler.PedidoControle;
import entidade.Pedido;

public class ManagdBeansCozinha {
	
	private List<Pedido> listaPedidoCozinha;
	
	public List<Pedido> getListaPedidoCozinha() {
		listaPedidoCozinha = PedidoControle.listaPedidoCozinha;
		return listaPedidoCozinha;
	}
}
