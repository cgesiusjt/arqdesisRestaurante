package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entites.Livros;


@WebServlet("/LivrosController")
public class LivrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static List<Livros> lista = new ArrayList<Livros>();
	private Livros livros = new Livros();
	private Integer codigo = 0;
       
    
    public LivrosController() {
        super();
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String acao = request.getParameter("acao");
    	
    	if(acao != null) {
    		
    		if(acao.equalsIgnoreCase("cadastrar")) {
    			try {
    				
    				String titulo = request.getParameter("titulo");
    				Integer numeroPaginas = Integer.parseInt(request.getParameter("numPaginas"));
    				String autor = request.getParameter("autor");
    				
    				codigo = livros.geraCodigoLivro(codigo);
    				livros = new Livros();
    				livros.setIdLivro(codigo);
    				livros.setDescricao(titulo);
    				livros.setNumPaginas(numeroPaginas);
    				livros.setAutor(autor);
    				
    				lista.add(livros);
    				
    				request.setAttribute("mensagem", "Livro ID : " + livros.getIdLivro() + " Cadastrado com sucesso");
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro" + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("mensagemCadastro.jsp").forward(request, response);
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
