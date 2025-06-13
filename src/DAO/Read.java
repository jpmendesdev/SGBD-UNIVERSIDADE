package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.Conexao;
import entities.Aluno;
import entities.AlunoCadeira;
import entities.Professor;
import entities.ProfessorCadeira;
import entities.Usuario;

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

public void alunosCursandoCadeira(AlunoCadeira alunoCadeira) throws SQLException {
	
	 
	String qtdAlunosCadeira = "SELECT COUNT(situacao)\n"
			+ "FROM Aluno_Cadeira\n"
			+ "WHERE situacao = 'Em curso' and id_cadeira = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(qtdAlunosCadeira)) {
		 ps.setInt(1, alunoCadeira.getId_cadeira());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 int count = rs.getInt(1);
				 System.out.println("Número de alunos na cadeira: "+count);
			 }
		 }
	 }
}


public void alunosTrancadosCadeira(AlunoCadeira alunoCadeira) throws SQLException {
	
	 
	String qtdAlunosCadeira = "SELECT COUNT(situacao)\n"
			+ "FROM Aluno_Cadeira\n"
			+ "WHERE situacao = 'trancado' and id_cadeira = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(qtdAlunosCadeira)) {
		 ps.setInt(1, alunoCadeira.getId_cadeira());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 int count = rs.getInt(1);
				 System.out.println("Número de alunos na cadeira: "+count);
			 }
		 }
	 }
}


public void alunosTrancados(Aluno aluno) throws SQLException {
	
	 
	String qtdAlunosTrancados = "SELECT COUNT(situacao)\n"
			+ "FROM Aluno\n"
			+ "WHERE situacao = 'trancado' and id_curso = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(qtdAlunosTrancados)) {
		 ps.setInt(1, aluno.getId_curso());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 int count = rs.getInt(1);
				 System.out.println("Número de alunos com o curso trancado: "+count);
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


public void professoresDemitidos(Professor professor) throws SQLException {
	
	 
	String qtdProfessoresDemitidos = "SELECT COUNT(situacao)\n"
			+ "FROM Professor\n"
			+ "WHERE situacao = 'afastado/demitido' and id_curso = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(qtdProfessoresDemitidos)) {
		 ps.setInt(1, professor.getId_curso());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 int count = rs.getInt(1);
				 System.out.println("Número de professores demitidos ou afastados no curso: "+count);
			 }
		 }
	
	
	 }
	}

public void alunosEmCadeiras(AlunoCadeira alunoCadeira) throws SQLException {
	
	 
	String qtdAlunos = "SELECT COUNT(situacao)\n"
			+ "FROM Aluno_Cadeira\n"
			+ "WHERE situacao = 'Em curso' and id_cadeira = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(qtdAlunos)) {
		 ps.setInt(1, alunoCadeira.getId_cadeira());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 int count = rs.getInt(1);
				 System.out.println("Número de alunos na cadeira: "+count);
			 }
		 }
	

}
}

public void professoresEmCadeiras(ProfessorCadeira professorCadeira) throws SQLException {
	
	 
	String qtdProfessores = "SELECT COUNT(situacao)\n"
			+ "FROM Professor_Cadeira\n"
			+ "WHERE situacao = 'Lecionando' and id_cadeira = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(qtdProfessores)) {
		 ps.setInt(1, professorCadeira.getId_cadeira());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 int count = rs.getInt(1);
				 System.out.println("Número de alunos na cadeira: "+count);
			 }
		 }
	

}
}


public boolean autenticarUsuarios(Usuario usuario) throws SQLException {
	
	 
	String autUsuarios =  "SELECT * FROM Usuario WHERE login = ? and senha = ?";
	
	 try (PreparedStatement ps = Conexao.getConexao().prepareStatement(autUsuarios)) {
		 ps.setString(1, usuario.getLogin());
		 ps.setString(2, usuario.getSenha());
		 try (ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
				 System.out.println("LOGADO COM SUCESSO!");
				 return true;
			 }else {
				 System.out.println("ERRO AO LOGAR");
				 return false;
			 }
	 }
}
	}
}

