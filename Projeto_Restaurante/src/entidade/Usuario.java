package entidade;

public class Usuario {

	private String nome;
	private String senha;
	private String cpf;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String senha, String cpf) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
