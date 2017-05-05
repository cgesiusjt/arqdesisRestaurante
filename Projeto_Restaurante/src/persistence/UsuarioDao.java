package persistence;

import criptografia.CriptografiaSenha;
import entidade.Usuario;

public class UsuarioDao extends DAO {
	
	public Usuario autenticar(String login, String senha) throws Exception {
		
		String query = "select * from login where usuario = ? and senha = ?";
		
		openConection();
		
		stmt = con.prepareStatement(query);
		stmt.setString(1, login);
		stmt.setString(2, CriptografiaSenha.encriptarSenha(senha));
		rs = stmt.executeQuery();
		
		Usuario usuario = null;
		
		if(rs.next()) {
			
			usuario = new Usuario();
			
			usuario.setNome(rs.getString("usuario"));
			usuario.setSenha(rs.getString("senha"));
		}
		
		stmt.close();
		closeConection();
		
		return usuario;
	}

}
