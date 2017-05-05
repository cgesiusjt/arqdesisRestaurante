package managdBeans;

import java.util.List;

import entidade.CardapioTO;
import persistence.CardapioDAO;

public class ManagdBeansCardapio {
	
	private List<CardapioTO> listagemCardapio;
	
	public List<CardapioTO> getListagemCardapio() {
		CardapioDAO cardapioDAO = new CardapioDAO();
		try {
			listagemCardapio = cardapioDAO.carregarCardapio();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listagemCardapio;
	}
	
	protected List<CardapioTO> getListaCardapio() {
		return listagemCardapio;
	}

}
