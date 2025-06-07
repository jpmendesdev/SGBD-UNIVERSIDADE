package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.Conexao;
import entities.Aluno;
import entities.Professor;

public class Read {
	
	PreparedStatement ps = null;
	
	public void visualizarCursos() throws SQLException {
		
		 String selectCursos = "SELECT * FROM Curso";
	
		
		Statement stmt = Conexao.getConexao().createStatement();
		ResultSet rs = stmt.executeQuery(selectCursos);
	try{
	    while(rs.next()) {
	    	System.out.println("ID: " + rs.getInt("id_curso"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Nível: " + rs.getString("nivel"));
	    }
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public void visualizarAlunos() throws SQLException {
		
		String selectAlunos = "SELECT * FROM Aluno";
		
		Statement stmt = Conexao.getConexao().createStatement();
		ResultSet rs = stmt.executeQuery(selectAlunos);
	try {
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("id_aluno"));
			System.out.println("Nome: " + rs.getString("nome"));
			System.out.println("Email: " + rs.getString("email"));
			System.out.println("Curso: " + rs.getInt("id_curso"));
			System.out.println("Situacao: " + rs.getString("situacao"));
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void visualizarProfessores() throws SQLException {
		
		String selectAlunos = "SELECT * FROM Professor";
		
		Statement stmt = Conexao.getConexao().createStatement();
		ResultSet rs = stmt.executeQuery(selectAlunos);
	try {
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("id_professor"));
			System.out.println("Nome: " + rs.getString("nome"));
			System.out.println("Email: " + rs.getString("email"));
			System.out.println("Curso: " + rs.getInt("id_curso"));
			System.out.println("Situacao: " + rs.getString("situacao"));
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
public void visualizarCadeiras() throws SQLException {
		
		String selectAlunos = "SELECT * FROM Cadeira";
		
		Statement stmt = Conexao.getConexao().createStatement();
		ResultSet rs = stmt.executeQuery(selectAlunos);
	try {
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("id_professor"));
			System.out.println("Nome: " + rs.getString("nome"));
			System.out.println("Email: " + rs.getString("email"));
			System.out.println("Curso: " + rs.getInt("id_curso"));
			System.out.println("Situacao: " + rs.getString("situacao"));
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


public void alunosEmCurso(Aluno aluno) throws SQLException {
	
	 
	String qtdAlunos = "SELECT COUNT(situacao)\n"
			+ "FROM Aluno\n"
			+ "WHERE situacao = 'matriculado' and id_curso = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(qtdAlunos)) {
		 ps.setInt(1, aluno.getId_curso());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 int count = rs.getInt(1);
				 System.out.println("Número de alunos no curso: "+count);
			 }
		 }
	 }
}

public void professoresLecionando(Professor professor) throws SQLException {
	
	 
	String qtdProfessores = "SELECT COUNT(situacao)\n"
			+ "FROM Professor\n"
			+ "WHERE situacao = 'Lecionando' and id_curso = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(qtdProfessores)) {
		 ps.setInt(1, professor.getId_curso());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 int count = rs.getInt(1);
				 System.out.println("Número de professores lecionando no curso: "+count);
			 }
		 }
	
	
}
}
}
