package menus;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.Create;
import DAO.Read;
import DAO.Update;
import entities.Professor;
import entities.ProfessorCadeira;

public class menuProfessores {
	
	Scanner sc = new Scanner(System.in);
	Create create = new Create();

public void menuProfessores() throws SQLException {

		
		while(true) {
			System.out.println("1 - Matricular Professor em curso");
			System.out.println("2 - Matricular Professor em Cadeira");
			System.out.println("3 - Professor - Afastar/Demitir");
			System.out.println("4 - Qtd Professores matriculados em determinado curso");
			System.out.println("5 - Qtd de Professores em determinada cadeira");
			System.out.println("6 - Visualizar Professores");
			System.out.println("7 - Qtd de Professores afastados/demitidos");
			System.out.println("8 - Sair do Menu Professores");
			String op = sc.nextLine();
			
			switch(op) {
			case "1":
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
			case "2":
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
			case "3":
				System.out.println("Informe o id do professor que deseja afastar: ");
				Integer id_professorD = sc.nextInt();
				sc.nextLine();
				Professor professorUpdate = new Professor(id_professorD);
				Update updateProfessor = new Update();
				updateProfessor.desmatricularProfessor(professorUpdate);
				break;
			case "4":
				Read readQtdProfessores = new Read();
				System.out.print("Id do curso: ");
				int id_cursoPqtd = sc.nextInt();
				sc.nextLine();
				Professor professorQtd = new Professor(id_cursoPqtd);
				readQtdProfessores.professoresLecionando(professorQtd);
				break;
			case "5":
				Read readQtdProfessoresCadeira = new Read();
				System.out.print("Id da cadeira: ");
				int id_cadeiraQtdProfessor = sc.nextInt();
				sc.nextLine();
				ProfessorCadeira professorCadeiraQtd = new ProfessorCadeira(id_cadeiraQtdProfessor);
				readQtdProfessoresCadeira.professoresEmCadeiras(professorCadeiraQtd);
				break;
			case "6":
				Read readProfessores = new Read();
				readProfessores.visualizarProfessores();
				break;
			case "7":
				readQtdProfessores = new Read();
				System.out.print("Id do curso: ");
				id_cursoPqtd = sc.nextInt();
				sc.nextLine();
				professorQtd = new Professor(id_cursoPqtd);
				readQtdProfessores.professoresDemitidos(professorQtd);
				break;
			
				
			}
			
			if(op.equals("8")) {
				System.out.println("Saindo...");
				break;
			}
		}
		
	}
	
}
