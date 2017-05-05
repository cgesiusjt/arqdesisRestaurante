package entidade;

import java.util.Date;
import util.PedidoServicos;

public class Pedido {

	private Integer idPedido;
	private Date dataEntrada;
	private Date dataSaida;
	private String horaEntrada;
	private String horaSaida;
	private Mesa mesa;
	private CardapioTO cardapioTO;
	private Usuario usuario;
	private PedidoServicos pedidoServicos;

	public Pedido() {

	}

	public Pedido(Integer idPedido, Date dataEntrada, Date dataSaida, String horaEntrada, String horaSaida, Mesa mesa,
			CardapioTO cardapioTO, Usuario usuario, PedidoServicos pedidoServicos) {

		this.idPedido = idPedido;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.mesa = mesa;
		this.cardapioTO = cardapioTO;
		this.usuario = usuario;
		this.pedidoServicos = pedidoServicos;

	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PedidoServicos getPedidoServicos() {
		return pedidoServicos;
	}

	public void setPedidoServicos(PedidoServicos pedidoServicos) {
		this.pedidoServicos = pedidoServicos;
	}

	public CardapioTO getCardapioTO() {
		return cardapioTO;
	}

	public void setCardapioTO(CardapioTO cardapioTO) {
		this.cardapioTO = cardapioTO;
	}
	
	
	
}
