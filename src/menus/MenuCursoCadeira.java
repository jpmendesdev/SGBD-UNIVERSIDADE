package menus;

import java.util.Scanner;

import DAO.Create;
import entities.Cadeira;
import entities.Curso;

public class MenuCursoCadeira {

Scanner sc = new Scanner(System.in);
Create create = new Create();
	
public void menuCursoCadeira() {
		
		while(true) {
			System.out.println("1 - Criar Curso");
			System.out.println("2 - Cria Cadeira");
			System.out.println("3 - Qtd de Alunos em determindada Cadeira");
			System.out.println("4 - Sair do Menu Curso/Cadeira");
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
				
				break;
			
			}
			
			if(op.equals("4")) {
				System.out.println("Saindo...");
				break;
			}
		}
		
	}
	
}
