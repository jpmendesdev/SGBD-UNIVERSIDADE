package Program;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import DAO.Create;
import DAO.Read;
import DAO.Update;
import entities.Aluno;
import entities.AlunoCadeira;
import entities.Cadeira;
import entities.Curso;
import entities.Professor;
import entities.ProfessorCadeira;




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
			System.out.println("2 - Cria Cadeira");
			System.out.println("3 - Matricular Aluno em curso");
			System.out.println("4 - Matricular Professor em curso");
			System.out.println("5 - Visualizar Cursos");
			System.out.println("6 - Visualizar Alunos");
			System.out.println("7 - Matricular Aluno em Cadeira");
			System.out.println("8 - Matricular Professor em Cadeira");
			System.out.println("9 - Deletar tabela");
			System.out.println("10 - Aluno - Trancar Curso");
			System.out.println("11 - Professor - Afastar do curso");
			System.out.println("12 - Qtd Alunos matriculados em determinado curso");
			System.out.println("13 - Qtd Professores lecionando em determinado curso");
			System.out.println("14 - Qtd de alunos em determinada cadeira");
			System.out.println("15 - Qtd de professores lecionando em determinado curso");
			System.out.println("0 - Sair");
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
					System.out.print("Informe o nome da nova cadeira: ");
					String novaCadeira = sc.nextLine();
					System.out.print("Informe a quantidade de créditos: ");
					int creditos = sc.nextInt();
					sc.nextLine();
					System.out.print("Informe o curso da cadeira: ");
					int id_curso = sc.nextInt();
					sc.nextLine();
					Cadeira cadeira = new Cadeira(novaCadeira,creditos,id_curso);
					create.inserirCadeira(cadeira);
					break;
				case "3":
					Aluno alunoDefaultCurso = new Aluno();
					String situacao = alunoDefaultCurso.getSituacao();
					System.out.print("Digite o nome do aluno: ");
					String nomeAluno = sc.nextLine();
					System.out.print("Digite o e-mail do aluno: ");
					String emailAluno = sc.nextLine();
					System.out.print("Qual curso deseja matricular o aluno?: ");
					int idCurso = sc.nextInt();
					sc.nextLine();
					Aluno aluno = new Aluno(nomeAluno,emailAluno,idCurso,situacao);
					create.inserirAluno(aluno);
					break;
				case "4":
					Professor professorDefaultCurso = new Professor();
					String situacaoProfessor = professorDefaultCurso.getSituacao();
					System.out.print("Digite o nome do professor: ");
					String nomeProfessor = sc.nextLine();
					System.out.print("Digite o e-mail do professor: ");
					String emailProfessor = sc.nextLine();
					System.out.print("Qual curso deseja matricular o professor?: ");
					int idCursop = sc.nextInt();
					sc.nextLine();
					Professor professor = new Professor(nomeProfessor,emailProfessor,idCursop,situacaoProfessor);
					create.inserirProfessor(professor);
					break;
				case "5":
					 Read read = new Read();
					 read.visualizarCursos();
					break;
				case "6":
					Read readAlunos = new Read();
					readAlunos.visualizarAlunos();
				case "7":
					AlunoCadeira alunoDefault = new AlunoCadeira();
					String situacaoD = alunoDefault.getSituacao();
					System.out.print("Informe o id do aluno que deseja matricular: ");
					int id_aluno = sc.nextInt();
					sc.nextLine();
					System.out.print("Informe o id da cadeira que deseja matricular o aluno: ");
					int id_cadeira = sc.nextInt();
					sc.nextLine();
					AlunoCadeira alunoC = new AlunoCadeira(situacaoD,id_aluno,id_cadeira);
					create.matricularAlunoCadeira(alunoC);
					break;
				case "8":
					ProfessorCadeira professorDefault = new ProfessorCadeira();
					String situacaoP = professorDefault.getSituacao();
					
					System.out.print("Informe o id do professor que deseja matricular: ");
					int id_professor = sc.nextInt();
					sc.nextLine();
					System.out.print("Informe o id da cadeira que o professor vai lecionar: ");
					int id_cadeiraP = sc.nextInt();
					sc.nextLine();
					ProfessorCadeira professorC = new ProfessorCadeira(situacaoP,id_professor,id_cadeiraP);
					create.matricularProfessorCadeira(professorC);
					break;
				case "9":
					System.out.println("...");
					break;
				case "10":
					System.out.print("Informe o id do aluno que deseja trancar o curso: ");
					int id_alunoD = sc.nextInt();
					sc.nextLine();
					Aluno alunoUpdate = new Aluno(id_alunoD);
					Update updateAluno = new Update();
					updateAluno.desmatricularAluno(alunoUpdate);
					break;
				case "11":
					System.out.println("Informe o id do professor que deseja afastar: ");
					int id_professorD = sc.nextInt();
					sc.nextLine();
					Professor professorUpdate = new Professor(id_professorD);
					Update updateProfessor = new Update();
					updateProfessor.desmatricularProfessor(professorUpdate);
					break;
				case "12":
					 Read readQtdAlunos = new Read();
					 System.out.print("Id do curso: ");
					 int id_cursoQtd = sc.nextInt();
					 sc.nextLine();
					 Aluno alunoQtd = new Aluno(id_cursoQtd);
					 readQtdAlunos.alunosEmCurso (alunoQtd);
					break;
				case "13":
					Read readQtdProfessores = new Read();
					System.out.print("Id do curso: ");
					int id_cursoPqtd = sc.nextInt();
					sc.nextLine();
					Professor professorQtd = new Professor(id_cursoPqtd);
					readQtdProfessores.professoresLecionando(professorQtd);
					break;
				case "14":
					Read readQtdAlunosCadeira = new Read();
					System.out.print("Id da cadeira: ");
					int id_cadeiraQtd = sc.nextInt();
					sc.nextLine();
					AlunoCadeira alunoCadeiraQtd = new AlunoCadeira(id_cadeiraQtd);
					readQtdAlunosCadeira.alunosEmCadeiras(alunoCadeiraQtd);
					break;
				case "15":
					Read readQtdProfessoresCadeira = new Read();
					System.out.print("Id da cadeira: ");
					int id_cadeiraQtdProfessor = sc.nextInt();
					sc.nextLine();
					ProfessorCadeira professorCadeiraQtd = new ProfessorCadeira(id_cadeiraQtdProfessor);
					readQtdProfessoresCadeira.professoresEmCadeiras(professorCadeiraQtd);
					break;
			}
			
			if(op.equals("0")) {
				System.out.println("Saindo...");
				break;
			}
			
		}
		
		
		
		
		
		
	}
}
