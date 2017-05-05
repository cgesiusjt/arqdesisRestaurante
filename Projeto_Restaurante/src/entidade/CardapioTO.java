package entidade;

public class CardapioTO {

	private Integer idCardapio;
	private String categoria;
	private String descricao; 
	private Double valorUnitario;
	private String disponibilidade;
	private Integer quantidade;     
	private String valorTotal;
	private String valorTotalPgto;

	public CardapioTO() {
		
	}

	public CardapioTO(Integer idcardapio, String categoria, String descricao, Double valorUnitario,
			String disponibilidade, Integer quantidade, String valorTotal, String valorTotalPgto) {
		this.idCardapio = idcardapio;
		this.categoria = categoria;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.disponibilidade = disponibilidade;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.valorTotalPgto = valorTotalPgto;
	}	

	public Integer getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Integer idCardapio) {
		this.idCardapio = idCardapio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getValorTotalPgto() {
		return valorTotalPgto;
	}

	public void setValorTotalPgto(String valorTotalPgto) {
		this.valorTotalPgto = valorTotalPgto;
	}
	
	public String toString() {

		return "Codigo: " + getIdCardapio() + "\nCategoria:" + getCategoria() 
		+ "\nDescrição: " + getDescricao() + "\nValor Unitario: " + getValorUnitario() 
		+ "\nDisponibilidade: " + getDisponibilidade() + "Quantidade: " + getQuantidade();
	}

}
