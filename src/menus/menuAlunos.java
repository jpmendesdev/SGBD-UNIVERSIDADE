package menus;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.Create;
import DAO.Read;
import DAO.Update;
import entities.Aluno;
import entities.AlunoCadeira;

public class menuAlunos {
	
	Scanner sc = new Scanner(System.in);
	Create create = new Create();
	
	public void menuAlunos() throws SQLException {
		
		while(true) {
			System.out.println("1 - Matricular Aluno em curso");
			System.out.println("2 - Matricular Aluno em Cadeira");
			System.out.println("3 - Aluno - Trancar Curso");
			System.out.println("4 - Qtd Alunos matriculados em determinado curso");
			System.out.println("5 - Qtd de alunos em determinada cadeira");
			System.out.println("6 - Visualizar Alunos");
			System.out.println("7 - Qtd Alunos trancados");
			System.out.println("8 - Qtd Alunos cursando em determinada cadeira");
			System.out.println("9 - Qtd Alunos trancados em determinada cadeira");
			System.out.println("10 - Aluno - Trancar Cadeira");
			System.out.println("11 - Sair do Menu Alunos");
			String op = sc.nextLine();
			
			switch(op) {
			case "1":
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
			case "2":
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
			case "3":
				System.out.print("Informe o id do aluno que deseja trancar o curso: ");
				Integer id_alunoD = sc.nextInt();
				sc.nextLine();
				Aluno alunoUpdate = new Aluno(id_alunoD);
				Update updateAluno = new Update();
				updateAluno.desmatricularAluno(alunoUpdate);
				break;
			case "4":
				 Read readQtdAlunos = new Read();
				 System.out.print("Id do curso: ");
				 int id_cursoQtd = sc.nextInt();
				 sc.nextLine();
				 Aluno alunoQtd = new Aluno(id_cursoQtd);
				 readQtdAlunos.alunosEmCurso (alunoQtd);
				break;
			case "5":
				Read readQtdAlunosCadeira = new Read();
				System.out.print("Id da cadeira: ");
				int id_cadeiraQtd = sc.nextInt();
				sc.nextLine();
				AlunoCadeira alunoCadeiraQtd = new AlunoCadeira(id_cadeiraQtd);
				readQtdAlunosCadeira.alunosEmCadeiras(alunoCadeiraQtd);
				break;
			case "6":
				Read readAlunos = new Read();
				readAlunos.visualizarAlunos();
				break;
			case "7":
			     readQtdAlunos = new Read();
				 System.out.print("Id do curso: ");
				 id_cursoQtd = sc.nextInt();
				 sc.nextLine();
				 alunoQtd = new Aluno(id_cursoQtd);
				 readQtdAlunos.alunosTrancados(alunoQtd);
				 break;
			case "8":
				 readQtdAlunos = new Read();
				 System.out.print("Id da cadeira: ");
				 id_cadeiraQtd = sc.nextInt();
				 sc.nextLine();
				 AlunoCadeira alunoCadeira = new AlunoCadeira(id_cadeiraQtd);
				 readQtdAlunos.alunosCursandoCadeira(alunoCadeira);
				break;
			case "9":
				 readQtdAlunos = new Read();
				 System.out.print("Id da cadeira: ");
				 id_cadeiraQtd = sc.nextInt();
				 sc.nextLine();
				 alunoCadeira = new AlunoCadeira(id_cadeiraQtd);
				 readQtdAlunos.alunosTrancadosCadeira(alunoCadeira);
				break;
			case "10":
				System.out.print("Informe o id do aluno que deseja trancar o curso: ");
				id_alunoD = sc.nextInt();
				sc.nextLine();
				alunoCadeira = new AlunoCadeira(id_alunoD);
			    updateAluno = new Update();
				updateAluno.desmatricularAlunoCadeira(alunoCadeira);
				break;
			
			}
			
			if(op.equals("11")) {
				System.out.println("Saindo...");
				break;
			}
		}
		
	}
	
}
