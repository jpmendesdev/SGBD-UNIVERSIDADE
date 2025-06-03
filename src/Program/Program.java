package Program;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import DAO.Create;
import DAO.Read;
import entities.Aluno;
import entities.Curso;
import entities.Professor;




public class Program {
	
	 
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//cria as tabelas estaticamente, caso não existam
		Create create = new Create();
		create.criarTabela();
		
		
		 
		while(true) {
			System.out.println("--BEM VINDO AO SGBD-X---");
			System.out.println("MENU");
			System.out.println("1 - Criar Curso");
			System.out.println("2 - Matricular Aluno");
			System.out.println("3 - Matricular Professor");
			System.out.println("4 - Visualizar Cursos");
			System.out.println("5 - Visualizar Alunos");
			System.out.println("6 - Matricular Aluno em Cadeira");
			System.out.println("7 - Sair");
			String op = sc.nextLine();
			
			switch(op) {
				case "1":
					System.out.print("Informe o nome do curso: ");
					String nomeCurso = sc.nextLine();
					System.out.print("Nível do curso Bacharelado/Mestrado/Doutorado: ");
					String nivelCurso = sc.nextLine();
				    create = new Create();
					Curso curso = new Curso(nomeCurso,nivelCurso);
					create.InsereElementos(curso);
					break;
				case "2":
					System.out.print("Digite o nome do aluno: ");
					String nomeAluno = sc.nextLine();
					System.out.print("Digite o e-mail do aluno: ");
					String emailAluno = sc.nextLine();
					System.out.print("Qual curso deseja matricular o aluno?: ");
					int idCurso = sc.nextInt();
					sc.nextLine();
					Aluno aluno = new Aluno(nomeAluno,emailAluno,idCurso);
					create.inserirAluno(aluno);
					break;
				case "3":
					System.out.print("Digite o nome do professor: ");
					String nomeProfessor = sc.nextLine();
					System.out.print("Digite o e-mail do professor: ");
					String emailProfessor = sc.nextLine();
					System.out.print("Qual curso deseja matricular o professor?: ");
					int idCursop = sc.nextInt();
					sc.nextLine();
					Professor professor = new Professor(nomeProfessor,emailProfessor,idCursop);
					create.inserirProfessor(professor);
					break;
				case "4":
					 Read read = new Read();
					 read.visualizarCursos();
					break;
				case "5":
					Read readAlunos = new Read();
					readAlunos.visualizarAlunos();
				case "6":
					System.out.print("Digite a matricula do aluno que deseja matricular nessa cadeira:");
					int 
			}
			
			if(op.equals("7")) {
				System.out.println("Saindo...");
				break;
			}
			
		}
		
		
		
		
		
		
	}
}
