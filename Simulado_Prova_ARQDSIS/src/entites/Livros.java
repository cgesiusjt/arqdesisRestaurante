package entites;

public class Livros {
	
	private Integer idLivro;
	private String descricao = null;
	private Integer numPaginas = 0;
	private String autor = null;
	
	public Livros() {
		
		
	}
	
	public Integer geraCodigoLivro(Integer codigo) {
		int codigoInicial = 1;
		int codigo2 = 0;
		
		if(codigo == 0 || codigo == null) {
			codigo2 = codigoInicial;
		} else {
			codigo2 = codigoInicial + codigo;
		}
		return codigo2;
	}
	
	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
