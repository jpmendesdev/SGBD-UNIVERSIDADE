package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conexao;
import entities.Aluno;
import entities.AlunoCadeira;
import entities.Cadeira;
import entities.Curso;
import entities.Professor;
import entities.ProfessorCadeira;


public class Create {
	
	PreparedStatement ps = null;
	
	public void criarTabela() {
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		PreparedStatement ps5 = null;
		PreparedStatement ps6 = null;
		
		String sqlTabelaCurso = "CREATE TABLE IF NOT EXISTS Curso (\r\n"
				+ "	   id_curso INT PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,\r\n"
				+ "    nome VARCHAR(50),\r\n"
				+ "    nivel VARCHAR(50)\r\n"
				+ ");";
		
		String sqlTabelaAluno = "CREATE TABLE IF NOT EXISTS Aluno(\n"
				+ " id_aluno INT PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,\n"
				+ " nome VARCHAR(50),\n"
				+ " email VARCHAR(50),\n"
				+ " id_curso INT,\n"
				+ " FOREIGN KEY (id_curso) REFERENCES Curso(id_curso));";
		
		String sqlTabelaProfessor = "CREATE TABLE IF NOT EXISTS Professor(\n"
				+ " id_professor INT PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,\n"
				+ " nome VARCHAR(50),\n"
				+ " email VARCHAR(50),\n"
				+ " id_curso INT,\n"
				+ " FOREIGN KEY (id_curso) REFERENCES Curso(id_curso));";
		
		String sqlTabelaCadeira = "CREATE TABLE IF NOT EXISTS Cadeira (\n"
				+ " id_cadeira INT PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,\n"
				+ " nome VARCHAR(50),\n"
				+ " creditos INT,\n"
				+ " id_curso INT,\n"
				+ " FOREIGN KEY (id_curso) REFERENCES Curso(id_curso));";
		
		String sqlTabelaAlunoCadeira = "CREATE TABLE IF NOT EXISTS Aluno_Cadeira (\n"
				+ "    id_matricula_cadeira INT PRIMARY KEY AUTO_INCREMENT,\n"
				+ "    situacao VARCHAR(20),\n"
				+ "    id_aluno INT,\n"
				+ "    id_cadeira INT,\n"
				+ "    FOREIGN KEY (id_aluno) REFERENCES Aluno(id_aluno),\n"
				+ "    FOREIGN KEY (id_cadeira) REFERENCES Cadeira(id_cadeira)"
				+ ");";
		String sqlTabelaProfessorCadeira = "CREATE TABLE IF NOT EXISTS Professor_Cadeira (\n"
				+ " id_matricula_cadeira INT PRIMARY KEY AUTO_INCREMENT,\n"
				+ " situacao VARCHAR(20),\n"
				+ " id_professor INT,\n"
				+ " id_cadeira INT,\n"
				+ " FOREIGN KEY (id_professor) REFERENCES Professor(id_professor),\n"
				+ " FOREIGN KEY (id_cadeira)  REFERENCES Cadeira(id_cadeira));";
				

		
		try {
			
		ps = Conexao.getConexao().prepareStatement(sqlTabelaCurso);
		ps2 = Conexao.getConexao().prepareStatement(sqlTabelaAluno);
		ps3 = Conexao.getConexao().prepareStatement(sqlTabelaProfessor);
		ps4 = Conexao.getConexao().prepareStatement(sqlTabelaCadeira);
		ps5 = Conexao.getConexao().prepareStatement(sqlTabelaAlunoCadeira);
		ps6 = Conexao.getConexao().prepareStatement(sqlTabelaProfessorCadeira);
		
		ps.execute();
		ps.close();
		ps2.execute();
		ps2.close();
		ps3.execute();
		ps3.close();
		ps4.execute();
		ps4.close();
		ps5.execute();
		ps5.close();
		ps6.execute();
		ps6.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void InsereElementos(Curso curso) {
		
		String sqlElementoCurso = "INSERT INTO Curso (nome,nivel)\r\n"
				+ "VALUES (?, ?);";
		
		try {
			ps = Conexao.getConexao().prepareStatement(sqlElementoCurso);
			
			
			ps.setString(1, curso.getNome());
			ps.setString(2, curso.getNivel());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void inserirAluno(Aluno aluno) {
		
		String sqlAluno = "INSERT INTO Aluno (nome, email, id_curso)\n"
				+ "VALUES (?, ?, ?);";
		
		try {
			ps = Conexao.getConexao().prepareStatement(sqlAluno);
			
			ps.setString(1,aluno.getNome());
			ps.setString(2,aluno.getEmail());
			ps.setInt(3,aluno.getId_curso());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void inserirProfessor(Professor professor) {
		
		String sqlProfessor = "INSERT INTO Professor (nome, email, id_curso)\n"
							+ "VALUES (? , ?, ?);"; 
		
		try {
			ps = Conexao.getConexao().prepareStatement(sqlProfessor);
			
			ps.setString(1,professor.getNome());
			ps.setString(2, professor.getEmail());
			ps.setInt(3,professor.getId_curso());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void matricularAlunoCadeira(AlunoCadeira alunoCadeira) {
		
		String sqlAlunoCadeira = "INSERT INTO Aluno_Cadeira (situacao,id_aluno,id_cadeira)\n"
				+ "VALUES (?, ?, ?);";
		
		try {
			ps = Conexao.getConexao().prepareStatement(sqlAlunoCadeira);
			
			ps.setString(1,alunoCadeira.getSituacao());
			ps.setInt(2,alunoCadeira.getId_aluno());
			ps.setInt(3,alunoCadeira.getId_cadeira());
			
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void matricularProfessorCadeira(ProfessorCadeira professorCadeira) {
		
	  String sqlProfessorCadeira = "INSERT INTO Professor_Cadeira (situacao,id_professor,id_cadeira)\n"
			 + "VALUES (?, ?, ?)";
	  
	  try {
		  ps = Conexao.getConexao().prepareStatement(sqlProfessorCadeira);
		  ps.setString(1, professorCadeira.getSituacao());
		  ps.setInt(2, professorCadeira.getId_professor());
		  ps.setInt(3, professorCadeira.getId_cadeira());
		  
		  ps.execute();
		  ps.close();
		  
	  }catch (SQLException e) {
		  e.printStackTrace();
	  }
		
	}
	
	public void inserirCadeira(Cadeira cadeira) {
		
		String sqlNovaCadeira = "INSERT INTO Cadeira (nome,creditos,id_curso)\n"
						+ "VALUES (?, ?, ?)";
		
		try {
			ps = Conexao.getConexao().prepareStatement(sqlNovaCadeira);
			
			ps.setString(1,cadeira.getNome());
			ps.setInt(2,cadeira.getCreditos());
			ps.setInt(3,cadeira.getId_curso());
			
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
}
