package persistence;

import java.util.ArrayList;
import java.util.List;

import entidade.CardapioTO;

public class CardapioDAO extends DAO {
	
	private CardapioTO to;

	public void insert(CardapioTO to) throws Exception {

		String query = "insert into cardapio(categoria, descricao, valor_unit, disponibilidade)"
				+ "values(?, ?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);
		stmt.setString(1, to.getCategoria());
		stmt.setString(2, to.getDescricao());
		stmt.setDouble(3, to.getValorUnitario());
		stmt.setString(4, to.getDisponibilidade());
		stmt.execute();
		stmt.close();

		closeConection();

	}

	public void update(CardapioTO to) throws Exception {

		String query = "update cardapio set categoria =?, descricao =?, valor_unit =?, disponibilidade =?"
				+ "where idcardapio =? ";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setString(1, to.getDescricao());
		stmt.setString(2, to.getCategoria());
		stmt.setDouble(3, to.getValorUnitario());
		stmt.setString(4, to.getDisponibilidade());
		stmt.setInt(5, to.getIdCardapio());
		stmt.execute();
		stmt.close();

		closeConection();

	}

	public void delete(Integer idCardapio) throws Exception {

		String query = "delete from cardapio where idcardapio = ?";
		
		openConection();

		stmt = con.prepareStatement(query);
		stmt.setInt(1, idCardapio);
		stmt.execute();
		stmt.close();

		closeConection();
	}

	public CardapioTO consulta(Integer idCardapio) throws Exception {

		String query = "select * from cardapio where idcardapio = ? ";

		openConection();

		stmt = con.prepareStatement(query);
		stmt.setInt(1, idCardapio);
		rs = stmt.executeQuery();


		if (rs.next()) {
			
			to = new CardapioTO();
			
			to.setIdCardapio(rs.getInt("idcardapio"));
			to.setCategoria(rs.getString("categoria"));
			to.setDescricao(rs.getString("descricao"));
			to.setValorUnitario(rs.getDouble("valor_unit"));
			to.setDisponibilidade(rs.getString("disponibilidade"));

		}
		stmt.close();
		closeConection();

		return to;
	}

	public List<CardapioTO> carregarCardapio() throws Exception {

		String query = "select * from cardapio order by categoria";

		openConection();

		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();

		List<CardapioTO> lista = new ArrayList<CardapioTO>();

		while (rs.next()) {
			
			to = new CardapioTO();

			to.setIdCardapio(rs.getInt("idcardapio"));
			to.setCategoria(rs.getString("categoria"));
			to.setDescricao(rs.getString("descricao"));
			to.setValorUnitario(rs.getDouble("valor_unit"));
			to.setDisponibilidade(rs.getString("disponibilidade"));
			lista.add(to);
		}

		closeConection();
		return lista;
	}

}
