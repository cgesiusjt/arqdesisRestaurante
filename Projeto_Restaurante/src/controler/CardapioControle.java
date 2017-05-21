package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.CardapioTO;
import persistence.CardapioDAO;
import service.CardapioService;


@WebServlet("/CardapioServelet")
public class CardapioControle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CardapioTO cardapioTO;
	private CardapioDAO cardapioDAO;
	private CardapioService cardapioService;

    public CardapioControle() {
    	cardapioTO = new CardapioTO();
    	cardapioDAO = new CardapioDAO();
    	cardapioService = new CardapioService();
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String acao = request.getParameter("acao");
    	
    	if(acao != null) {
    		if(acao.equalsIgnoreCase("cadastrar")) {
    			
    			try {
    				
    				cardapioTO.setCategoria(request.getParameter("comboCategoria"));
    				cardapioTO.setDescricao(request.getParameter("descricao"));
    				cardapioTO.setValorUnitario(Double.parseDouble(request.getParameter("preco").replaceAll(",", ".")));
    				cardapioTO.setDisponibilidade(request.getParameter("combo"));
    				
    				cardapioService.insert(cardapioTO);
    				
    				request.setAttribute("mensagem", "Cardápio: " + cardapioTO.getDescricao() + " Cadastrado com Sucesso");
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro." + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("cadastroCardapio.jsp").forward(request, response);
    			}
    		} else if(acao.equalsIgnoreCase("excluir")) {
    			
    			try { 
    				
    				Integer idCardapio = Integer.parseInt(request.getParameter("idDelete"));
    				CardapioTO cardapioTO = new CardapioTO();
    				CardapioService cardapioService = new CardapioService();
    				cardapioService.delete(idCardapio);
    				
    				request.setAttribute("cardapio", cardapioTO);
    				request.setAttribute("mensagem", "Cardápio " + cardapioTO.getDescricao() + " excluído com Sucesso");
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro" + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("consultaCardapio.jsp").forward(request, response);
    			}
    		} else if(acao.equalsIgnoreCase("editar")) {
    			try {
    				
    				Integer idCardapio = Integer.parseInt(request.getParameter("idEditar"));
    				
    				cardapioDAO = new CardapioDAO();
    				cardapioTO = cardapioDAO.consulta(idCardapio);
    				
    				request.setAttribute("cardapio", cardapioTO);
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro. " + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("atualizaCardapio.jsp").forward(request, response);
    			}
    		} else if(acao.equalsIgnoreCase("atualizar")) {
    			
    			try {
    				
    				CardapioTO cardapioTO = new CardapioTO();
    				
    				cardapioTO.setIdCardapio(Integer.parseInt(request.getParameter("id")));
    				cardapioTO.setCategoria(request.getParameter("categoria"));
    				cardapioTO.setDescricao(request.getParameter("descricao"));
    				cardapioTO.setValorUnitario(Double.parseDouble(request.getParameter("preco").replaceAll(",", ".")));
    				cardapioTO.setDisponibilidade(request.getParameter("disponibilidade")); 
    				
    				CardapioService cardapioService = new CardapioService();
    				cardapioService.update(cardapioTO);
    				
    				request.setAttribute("mensagem", "Cardapio: " + cardapioTO.getDescricao() + " Atualizado com sucesso");
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro. " + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("consultaCardapio.jsp").forward(request, response);
    			}
    		}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
