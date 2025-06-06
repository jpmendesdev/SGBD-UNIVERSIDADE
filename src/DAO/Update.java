package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conexao;
import entities.Aluno;

public class Update {
	
	PreparedStatement ps = null;
	
	public void desmatricularAluno (Aluno aluno) {

		String desmatricularAluno = "UPDATE Aluno\n"
				+ "SET situacao = 'trancado'\n"
				+ "WHERE id_aluno = ?";
		
		try {
			ps = Conexao.getConexao().prepareStatement(desmatricularAluno);
			
			ps.setInt(1,aluno.getId_aluno());
			
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
