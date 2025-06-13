package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conexao;
import entities.Aluno;
import entities.AlunoCadeira;
import entities.Professor;

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

	public void desmatricularAlunoCadeira (AlunoCadeira alunoCadeira) {

		String desmatricularAlunoCadeira = "UPDATE Aluno_Cadeira\n"
				+ "SET situacao = 'trancado'\n"
				+ "WHERE id_cadeira = ?";
		
		try {
			ps = Conexao.getConexao().prepareStatement(desmatricularAlunoCadeira);
			
			ps.setInt(1,alunoCadeira.getId_cadeira());
			
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
  public void desmatricularProfessor (Professor professor) {
	  
	  String desmatricularProfessor = "UPDATE Professor\n"
			  + "SET situacao = 'afastado/demitido'\n"
			  + "WHERE id_professor = ?";
	  
	  try {
		  ps = Conexao.getConexao().prepareStatement(desmatricularProfessor);
		  
		  ps.setInt(1, professor.getId_professor());
		  
		  ps.execute();
		  ps.close();
	  }catch (SQLException e) {
		  e.printStackTrace();
	  }
	  
  }
	
	

}
