package entidade;

public class Pagamento {
	
	private Boolean disableBotao = true;
	private String troco;
	
	public Pagamento() {
		
	}

	public Pagamento(Boolean disableBotao, String troco) {
		this.disableBotao = disableBotao;
		this.troco = troco;
	}

	public Boolean getDisableBotao() {
		return disableBotao;
	}

	public void setDisableBotao(Boolean disableBotao) {
		this.disableBotao = disableBotao;
	}

	public String getTroco() {
		return troco;
	}

	public void setTroco(String troco) {
		this.troco = troco;
	}

}
