package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import connection.Conexao;

public class Read {
	
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
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
