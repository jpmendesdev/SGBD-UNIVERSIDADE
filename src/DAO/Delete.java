package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conexao;


public class Delete {
	
	PreparedStatement ps = null;
	
	public void excluirTabela () {
		
		String dropTable = "DROP TABLE Aluno_Cadeira";
		
		try {
			ps = Conexao.getConexao().prepareStatement(dropTable);
			
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void desmatricularAluno() {
		
		String dropAluno = "DELETE FROM Aluno WHERE aluno_id = ?";
		
		try {
			ps = Conexao.getConexao().prepareStatement(dropAluno);
			
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
