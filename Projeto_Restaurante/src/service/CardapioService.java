package service;

import entidade.CardapioTO;
import persistence.CardapioDAO;
import persistence.PedidoDAO;

public class CardapioService {

	CardapioDAO cardapioDAO;
	PedidoDAO daoPedido;

	public CardapioService() {
		cardapioDAO = new CardapioDAO(); 
	}
	
	public void insert(CardapioTO to) {
		try {
			cardapioDAO.insert(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(CardapioTO to) {
		try {
			cardapioDAO.update(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer idCardapio) {
		try {
			cardapioDAO.delete(idCardapio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void select(Integer idCardapio) {
		try {
			cardapioDAO.consulta(idCardapio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAll() {
		try {
			cardapioDAO.carregarCardapio();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
