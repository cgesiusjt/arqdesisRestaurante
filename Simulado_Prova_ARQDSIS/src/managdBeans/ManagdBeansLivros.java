package managdBeans;

import java.util.ArrayList;
import java.util.List;

import controller.LivrosController;
import entites.Livros;

public class ManagdBeansLivros {
	
	List<Livros> listaLivros = new ArrayList<Livros>();
	
	public List<Livros> getListaLivros() {
		
		listaLivros = LivrosController.lista;
		
		return listaLivros;
	}

}
