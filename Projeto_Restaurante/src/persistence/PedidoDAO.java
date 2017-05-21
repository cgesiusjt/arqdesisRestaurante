package persistence;

import java.util.ArrayList;
import java.util.List;

import entidade.Cardapio;
import entidade.CardapioTO;
import entidade.Mesa;
import entidade.Pedido;
import entidade.Usuario;
import util.PedidoServicos;

public class PedidoDAO extends DAO {

	private CardapioTO cardapioTO;
	private Pedido pedido;

	public void insertPedido(String usuario, PedidoServicos ps, Integer mesa) throws Exception {

		String query = "insert into pedido(nomegarcom, dataentada, datasaida, horaentrada, horasaida, mesa) "
				+ "values(?, ?, ?, ?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setString(1, usuario);
		stmt.setString(2, ps.pegarData());
		stmt.setString(3, ps.pegarData());
		stmt.setString(4, ps.pegarHora());
		stmt.setString(5, ps.pegarHora());
		stmt.setInt(6, mesa);
		stmt.execute();
		stmt.close();

		closeConection();

	}

	public void insertItemPedido(List<CardapioTO> lista, Integer pedido) throws Exception {

		String query = "insert into itempedido(quantidade, idpedido, idcardapio) values(?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);

		for(int i = 0; i < lista.size(); i++) {
			stmt.setInt(1, lista.get(i).getQuantidade());
			stmt.setInt(2, pedido);
			stmt.setInt(3, lista.get(i).getIdCardapio());
			stmt.execute();
		}
		stmt.close();
		closeConection();

	}

	public void insertItemPedidoAux(List<CardapioTO> lista, Integer pedido, Integer mesa) throws Exception {

		String query = "insert into pedidoaux(quantidade, idpedido, idcardapio, mesa) values(?, ?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);

		for(int i = 0; i < lista.size(); i++) {
			stmt.setInt(1, lista.get(i).getQuantidade());
			stmt.setInt(2, pedido);
			stmt.setInt(3, lista.get(i).getIdCardapio());
			stmt.setInt(4, mesa);
			stmt.execute();
		}
		stmt.close();
		closeConection();

	}
	
	public List<Pedido> carregarPedido() throws Exception {

		String query = "select * from pedido order by idpedido";

		openConection();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		List<Pedido> lista = new ArrayList<Pedido>();

		while (rs.next()) {

			pedido = new Pedido();
			pedido.setUsuario(new Usuario());
			pedido.setMesa(new Mesa());
			pedido.setIdPedido(rs.getInt("idpedido"));
			pedido.getUsuario().setNome(rs.getString("nomegarcom"));
			/*
			pedido.setDataEntrada(FormatacaoData.converterData(rs.getString("dataentrada")));
			pedido.setDataSaida(FormatacaoData.converterData(rs.getString("datasaida"))); 
			pedido.setHoraEntrada(rs.getString("horaentrada"));
			pedido.setHoraSaida(rs.getString("horasaida"));
			 */
			pedido.getMesa().setCodigoMesa(rs.getInt("mesa"));
			lista.add(pedido);

		}
		closeConection();
		return lista;
	}
	
	public List<Pedido> allPedidoPagamento () throws Exception {
		
		String query = "select * from vw_pedidoAux";
		
		openConection();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		List<Pedido> lista = new ArrayList<>();
		
		while (rs.next()) {
			pedido = new Pedido();
			pedido.setCardapioTO(new CardapioTO());
			pedido.setMesa(new Mesa());
			
			pedido.setIdPedido(rs.getInt("idpedido"));
			pedido.getMesa().setCodigoMesa(rs.getInt("mesa"));
			pedido.getCardapioTO().setDescricao(rs.getString("descricao"));
			pedido.getCardapioTO().setQuantidade(rs.getInt("quantidade"));
			pedido.getCardapioTO().setValorUnitario(rs.getDouble("valor_unit"));
			lista.add(pedido);
		}
		stmt.close();
		closeConection();
		
		return lista;
	}
	
	public List<Pedido> allPedidoCozinha () throws Exception{
		
		String query = "select * from vw_pedidoAux";
		openConection();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		List<Pedido> lista = new ArrayList<>();
		
		while (rs.next()) {
			pedido = new Pedido();
			pedido.setCardapioTO(new CardapioTO());
			
			pedido.setIdPedido(rs.getInt("idpedido"));
			pedido.getCardapioTO().setDescricao(rs.getString("descricao"));
			pedido.getCardapioTO().setQuantidade(rs.getInt("quantidade"));
			lista.add(pedido);
		}
		stmt.close();
		closeConection();
		
		return lista;
	}
	
	public void updateDataHoraSaida(PedidoServicos pedidoServicos, Integer codPedido) throws Exception {

		String query = "update pedido set datasaida =?, horasaida =?" + "where idpedido =? ";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setString(1, pedidoServicos.pegarData());
		stmt.setString(2, pedidoServicos.pegarHora());
		stmt.setInt(3, codPedido);
		stmt.execute();
		stmt.close();

		closeConection();
	}
	
	public void insertCpf(List<Pedido> lista, String cpf) throws Exception {

		String query = "insert into cpfUsuario(cpf, idpedido) values(?,?)";

		openConection();

		stmt = con.prepareStatement(query);
		
		for (int i = 0; i < lista.size(); i++) {
			stmt.setString(1, cpf);
			stmt.setInt(2, lista.get(i).getIdPedido());
			stmt.execute();
		}
		
		stmt.close();

		closeConection();
	}
	
	
	public void deletePedidoAux(Integer mesa) throws Exception {

		String query = "delete from pedidoaux where mesa = ?";
		
		openConection();

		stmt = con.prepareStatement(query);
		stmt.setInt(1, mesa);
		stmt.execute();
		stmt.close();

		closeConection();
	}
	
	public void deletePedidoPgtAux(Integer idpedido) throws Exception {

		String query = "delete from pagamentoaux where idpedido = ?";
		
		openConection();

		stmt = con.prepareStatement(query);
		stmt.setInt(1, idpedido);
		stmt.execute();
		stmt.close();

		closeConection();
	}
	/*
	public List<Pedido> carregarPedidoAux() throws Exception {

		String query = "select * from vw_pedidoAux";

		openConection();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		List<Pedido> lista = new ArrayList<Pedido>();

		while (rs.next()) {

			p = new Pedido();
			p.setCardapio(new Cardapio());
			p.setMesa2(new Mesa());

			p.getCardapio().setQuantidade(rs.getInt("quantidade"));
			p.getCardapio().setDescricao(rs.getString("descricao"));
			p.getCardapio().setValorUnitario(rs.getDouble("valor_unit"));
			p.setIdPedido(rs.getInt("idpedido"));
			p.getCardapio().setIdcardapio(rs.getInt("idcardapio"));
			p.getMesa2().setNumeroMesa(rs.getInt("mesa"));
			lista.add(p);

		}
		closeConection();
		return lista;
	}
	*/
	
	public void insertPedido(List<CardapioTO> lista) throws Exception {

		String query = "insert into pedidotabela(idpedidotabela, categoria, descricao, valorunitario, quantidade, disponibilidade)"
				+ "values(?, ?, ?, ?, ?, ?)";
		openConection();
		stmt = con.prepareStatement(query);
		for (int i = 0; i <= lista.size(); i++) {
			stmt.setInt(1, lista.get(i).getIdCardapio());
			stmt.setString(2, lista.get(i).getCategoria());
			stmt.setString(3, lista.get(i).getDescricao());
			stmt.setDouble(4, lista.get(i).getValorUnitario());
			stmt.setInt(5, lista.get(i).getQuantidade());
			stmt.setString(6, lista.get(i).getDisponibilidade());
			stmt.execute();

		}
		stmt.close();
		closeConection();
	}
	
	public void insertPagamentoAux(Cardapio c, Integer pedido, Integer mesa) throws Exception {

		String query = "insert into pagamentoaux(quantidade, idpedido, idcardapio, mesa) values(?, ?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, c.getQuantidade());
		stmt.setInt(2, pedido);
		stmt.setInt(3, c.getIdcardapio());
		stmt.setInt(4, mesa);
		stmt.execute();
		stmt.close();

		closeConection();

	}
	
	public void delete(Integer idCardapio) throws Exception {
		String query = "delete from pedidotabela where idpedidotabela = ?";
		
		openConection();
		
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idCardapio);
		stmt.execute();
		stmt.close();
		
		closeConection();
	}
	
public List<CardapioTO> allTabelaPedido() throws Exception {
		
		String query = "select * from pedidotabela";
		
		openConection();
		
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		
		List<CardapioTO> lista = new ArrayList<CardapioTO>();
		
		while (rs.next()) {
			
			cardapioTO = new CardapioTO();
			
			cardapioTO.setIdCardapio(rs.getInt("idpedidotabela"));
			cardapioTO.setCategoria(rs.getString("categoria"));
			cardapioTO.setDescricao(rs.getString("descricao"));
			cardapioTO.setValorUnitario(rs.getDouble("valorunitario"));
			cardapioTO.setQuantidade(rs.getInt("quantidade"));
			cardapioTO.setDisponibilidade(rs.getString("disponibilidade"));
			lista.add(cardapioTO);
		}
		
		closeConection();
		return lista;
	}
	
}
