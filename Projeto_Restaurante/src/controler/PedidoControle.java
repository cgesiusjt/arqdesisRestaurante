package controler;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.CardapioTO;
import entidade.Mesa;
import entidade.Pagamento;
import entidade.Pedido;
import entidade.Usuario;
import persistence.CardapioDAO;
import persistence.PedidoDAO;
import service.CalculoPedido;
import util.Numeros;
import util.PedidoServicos;


@WebServlet("/PedidoControle")
public class PedidoControle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static List<CardapioTO> listaCardapio = new ArrayList<CardapioTO>();
	public static List<Pedido> listaPedidoPag = new ArrayList<>();
	public static List<Pedido> listaPedidoCozinha = new ArrayList<>();
	private List<Pedido> listaPedido = new ArrayList<>();
	private List<Pedido> listPedido = new ArrayList<>();
	private CardapioTO cardapioTO;
	private CardapioDAO cardapioDAO;
	private CalculoPedido calculoPedido;
	private PedidoDAO pedidoDAO;
	private Pedido pedido;
	private PedidoServicos pedidoServicos;
	private Integer codPedido = 0;
	private String destino = null;
	private Pagamento pagamento = new Pagamento();
	private Mesa mesa = new Mesa();
	private Usuario usuario;
	NumberFormat formatValor = new DecimalFormat("0.00");
    
    public PedidoControle() {
    	cardapioTO = new CardapioTO();
    	cardapioDAO = new CardapioDAO();
    	calculoPedido = new CalculoPedido();
    	pedidoDAO = new PedidoDAO();
    	pedido = new Pedido();
    	pedidoServicos = new PedidoServicos();
    	usuario = new Usuario();
    }
    
	protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null) {
			if (acao.equalsIgnoreCase("adicionar")) {

				try {

					Integer idCardapio = Integer.parseInt(request.getParameter("codigo"));
					Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));

					cardapioTO = cardapioDAO.consulta(idCardapio);
					cardapioTO.setIdCardapio(cardapioTO.getIdCardapio());
					cardapioTO.setCategoria(cardapioTO.getCategoria());
					
					cardapioTO.setDescricao(cardapioTO.getDescricao());
					cardapioTO.setValorUnitario(cardapioTO.getValorUnitario());
					cardapioTO.setQuantidade(quantidade);
					
					listaCardapio.add(cardapioTO);

					cardapioTO.setValorTotal(formatValor.format(calculoPedido.calcValorTotalPedido()));
					
					pedido.setIdPedido(pedido.getIdPedido());
        			request.setAttribute("numPedido", pedido);
        			
					request.setAttribute("cardapio", cardapioTO);

				} catch (Exception e) {
					request.setAttribute("mensagem", "Erro. " + e.getMessage());
					
				} finally {
					request.getRequestDispatcher("pedido.jsp").forward(request, response);
				}

			} else if (acao.equalsIgnoreCase("remover")) {
    			
    			try {
    				Integer idCodigoRemover = Integer.parseInt(request.getParameter("codigoRemover"));
        			
        			for(int i = 0; i <= listaCardapio.size(); i++) {
        				if (idCodigoRemover.equals(listaCardapio.get(i).getIdCardapio())) {
        					listaCardapio.remove(listaCardapio.get(i));
        				}
        			}
        			
        			cardapioTO.setValorTotal(formatValor.format(calculoPedido.calcValorTotalPedido()));
        			
        			pedido.setIdPedido(pedido.getIdPedido());
        			request.setAttribute("numPedido", pedido);
    				
    				request.setAttribute("cardapio", cardapioTO);
    				
    			} catch (Exception e) {
    				request.setAttribute("mensagem", "Erro. " + e.getMessage());
    				
    			} finally {
    				request.getRequestDispatcher("pedido.jsp").forward(request, response);
    			}
    			
    		} else if (acao.equalsIgnoreCase("fecharPedido")) {
    			
    			destino = "mesa.jsp";
    			try {
    				if(listaCardapio.size() > Numeros.NUM_0 && !pedido.getIdPedido().equals(null) && pedido.getIdPedido() > Numeros.NUM_0) {
    					pedidoDAO.insertItemPedido(listaCardapio, pedido.getIdPedido());
    					pedidoDAO.insertItemPedidoAux(listaCardapio, pedido.getIdPedido(), mesa.getCodigoMesa());
    					destino = "pedido.jsp";
    				}
    				
    				request.setAttribute("sucesso", "Pedido realizado com Sucesso");
    			} catch (Exception e) {
    				request.setAttribute("mensagem", "Erro." + e.getMessage());
    				
    			} finally {
    				listaCardapio = new ArrayList<>();
    				listaPedidoPag = new ArrayList<>();
    				request.getRequestDispatcher(destino).forward(request, response);
    			}
    			
    		} else if (acao.equalsIgnoreCase("consPagamento")) {
    			
    			try {
    				Integer codigoMesa = Integer.parseInt(request.getParameter("codMesa"));
        			if(codigoMesa >= 1 && codigoMesa <= 50) {
        				listPedido = pedidoDAO.allPedidoPagamento();
            			
            			for(int i = 0; i < listPedido.size(); i++) {
            				if(codigoMesa == listPedido.get(i).getMesa().getCodigoMesa()) {
            					pedido = new Pedido();
            					pedido.setMesa(new Mesa());
            					pedido.setCardapioTO(new CardapioTO());
            					pedido.setIdPedido(listPedido.get(i).getIdPedido());
            					pedido.getMesa().setCodigoMesa(listPedido.get(i).getMesa().getCodigoMesa());
            					pedido.getCardapioTO().setDescricao(listPedido.get(i).getCardapioTO().getDescricao());
            					pedido.getCardapioTO().setQuantidade(listPedido.get(i).getCardapioTO().getQuantidade());
            					pedido.getCardapioTO().setValorUnitario(listPedido.get(i).getCardapioTO().getValorUnitario());
            					listaPedidoPag.add(pedido);
            				}
            			}
            			cardapioTO.setValorTotalPgto(formatValor.format(calculoPedido.calcValorPagamento()));
            			pagamento.setDisableBotao(false);
            			request.setAttribute("pgto", pagamento);
            			request.setAttribute("cardapio", cardapioTO);
            			
        			} else {
        				request.setAttribute("erroMesa", "Número da mesa precisa está entre 0 e 51");
        			}
        			
    			} catch (Exception e) {
    				request.setAttribute("mensagem", "Por favor informe um número");
    			} finally {
    				request.getRequestDispatcher("pagamento.jsp").forward(request, response);
    			}
    			
    		} else if(acao.equalsIgnoreCase("limpar")) {
    			try {
    				listaPedidoPag = new ArrayList<>();
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro." + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("pagamento.jsp").forward(request, response);
    			}
    		} else if(acao.equalsIgnoreCase("calcularTroco")) {
    			try {
    				double valorTroco = 0.0;
    				double valorCompra = 0.0;
    				double troco = Double.parseDouble(request.getParameter("dinheiro"));
    				
    				valorCompra = Double.parseDouble(cardapioTO.getValorTotalPgto().replace(",", "."));
    				valorTroco = (troco - valorCompra);
    				pagamento.setTroco(formatValor.format(valorTroco));
    				
    				request.setAttribute("trocoPagamento", pagamento);
    				request.setAttribute("cardapio", cardapioTO);
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", e.getMessage());
    			} finally {
    				request.getRequestDispatcher("pagamento.jsp").forward(request, response);
    			}
    			
    		} else if (acao.equalsIgnoreCase("informarCpf")) {
    			try {
    				String cpf = request.getParameter("cpf");
    				usuario.setCpf(cpf.replace("-", "."));
    				if (listaPedidoPag.size() > 0) {
    					List<Pedido> listaPedidoCliente = new ArrayList<>();
    					for (int i = 0; i < listaPedidoPag.size(); i ++) {
    						pedido = new Pedido();
    						pedido.setIdPedido(listaPedidoPag.get(i).getIdPedido());
    						listaPedidoCliente.add(pedido);
    					}
    					pedidoDAO.insertCpf(listaPedidoCliente, usuario.getCpf());
    				}
    				
    			} catch (Exception e) {
    				request.setAttribute("mensagem", e.getMessage());
    			} finally {
    				request.getRequestDispatcher("pagamento.jsp").forward(request, response);
    			}
    		}else if (acao.equalsIgnoreCase("pagamentoDinheiro")){
				try {
					
					pedidoDAO.updateDataHoraSaida(pedidoServicos, pedido.getIdPedido());
					pedidoDAO.deletePedidoAux(numMesaDelete());
					request.setAttribute("sucesso", "Pagamento realizado com sucesso.");
					
				} catch (Exception e) {
					request.setAttribute("mensagem", e.getMessage());
				} finally {
					listaPedidoPag = new ArrayList<>();
					request.getRequestDispatcher("pagamento.jsp").forward(request, response);
				}
    		} else if (acao.equalsIgnoreCase("pagamentoCartao")){
				try {
					pedidoDAO.updateDataHoraSaida(pedidoServicos, pedido.getIdPedido());
					pedidoDAO.deletePedidoAux(numMesaDelete());
					request.setAttribute("sucesso", "Pagamento realizado com sucesso.");
					
				} catch (Exception e) {
					request.setAttribute("mensagem", e.getMessage());
				} finally {
					listaPedidoPag = new ArrayList<>();
					request.getRequestDispatcher("pagamento.jsp").forward(request, response);
				}
    		} else if (acao.equalsIgnoreCase("addMesa")) {
    			
    			destino = "mesa.jsp";
    			try {
    				Integer numMesa = Integer.parseInt(request.getParameter("mesa"));
    				
    				mesa.setCodigoMesa(numMesa);
    				
    				if (numMesa != null && !numMesa.equals(Numeros.NUM_0) && numMesa >= 1 && numMesa <= 50) {
    					destino = "pedido.jsp";
    					
    					pedidoDAO.insertPedido(usuario.getNome(), pedidoServicos, mesa.getCodigoMesa());
    					
    					listaPedido = pedidoDAO.carregarPedido();
    					int ultimaPosico = 0;
        				if(listaPedido.size() == Numeros.NUM_1) {
        					ultimaPosico = Numeros.NUM_0;
        				} else {
        					ultimaPosico = listaPedido.size() - 1;
        				}
        				codPedido = listaPedido.get(ultimaPosico).getIdPedido();
        				pedido.setIdPedido(codPedido);
    					
    					request.setAttribute("numPedido", pedido);
    					
    				} else {
    					request.setAttribute("erro", "Informe um número para mesa de 1 a 50");
    				}
    				
    			} catch (Exception e) {
    				request.setAttribute("mensagem", "Número da mesa é obrigatorio");
    			} finally {
    				request.getRequestDispatcher(destino).forward(request, response);
    			}
    		} else if (acao.equalsIgnoreCase("listarPedidosCozinha")) {
    			try {
    				
    				listaPedidoCozinha = pedidoDAO.allPedidoCozinha();
    				
    				for(int i = 0; i < listaPedidoCozinha.size(); i++) {
    					pedido.setIdPedido(listaPedidoCozinha.get(i).getIdPedido());
    					pedido.getCardapioTO().setDescricao(listaPedidoCozinha.get(i).getCardapioTO().getDescricao());
    					pedido.getCardapioTO().setQuantidade(listaPedidoCozinha.get(i).getCardapioTO().getQuantidade());
    					listaPedidoCozinha.add(pedido);
    				}
    				
    				request.setAttribute("pedido", pedido);
    			} catch (Exception e) {
    				request.setAttribute("mensagem", "Erro." + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("pedidosCozinha.jsp").forward(request, response);
    			}
    		} else if (acao.equalsIgnoreCase("avaisaGarcom")) {
    			try {
    				
    				Integer numPedido = Integer.parseInt(request.getParameter("numPedido"));
    				
    				for(int i = 0; i < listaPedidoCozinha.size(); i++) {
    					if(numPedido == listaPedidoCozinha.get(i).getIdPedido()) {
    						request.setAttribute("avisa", "Pedido: " + listaPedidoCozinha.get(i).getIdPedido()
    								+ " Pronto para Retirar e Servir");
    						listaPedidoCozinha.remove(i);
    					}
    				}
    				
    				
    			} catch (Exception e) {
    				request.setAttribute("mensagem", e.getMessage());
     			} finally {
    				request.getRequestDispatcher("pedidosCozinha.jsp").forward(request, response);
    			}
    		}
		}
	}
	
	public Integer numMesaDelete() {
		
		int codigo = 0;
				if (listaPedidoPag.size() > 0) {
					codigo = listaPedidoPag.get(codigo).getMesa().getCodigoMesa();
				}
		return codigo;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
