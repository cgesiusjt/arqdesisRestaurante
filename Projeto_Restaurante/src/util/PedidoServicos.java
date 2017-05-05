package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import entidade.Pedido;

public class PedidoServicos {

	private SimpleDateFormat sdf;
	private Calendar cal;
	private Object data;
	private String hora;
	private Pedido pedido;

	public PedidoServicos() {

	}
	
	

	public PedidoServicos(SimpleDateFormat sdf, Calendar cal, Object data, String hora, Pedido pedido) {
		this.sdf = sdf;
		this.cal = cal;
		this.data = data;
		this.hora = hora;
		this.pedido = pedido;
	}



	public String pegarHora() {

		String hora = null;

		cal = Calendar.getInstance();
		sdf = new SimpleDateFormat("HH:mm:ss");
		hora = sdf.format(cal.getTime());
		return hora;
	}

	public String pegarData() {

		String datap = null;

		cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY:MM:dd");
		data = new Date(System.currentTimeMillis());
		datap = sdf.format(data);

		return datap;
	}

	public Object getData() {

		return sdf.format(pegarData());
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getHora() {

		return sdf.format(pegarHora());
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
