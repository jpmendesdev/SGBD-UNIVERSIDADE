package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conexao;
import entities.Aluno;


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
	
	public void desmatricularAluno(Aluno aluno) {
		
		String dropAluno = "DELETE FROM Aluno WHERE id_aluno = ?";
		
		try {
			ps = Conexao.getConexao().prepareStatement(dropAluno);
			
			ps.setInt(1, aluno.getId_aluno());
			
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
