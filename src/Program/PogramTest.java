package program;

import java.sql.SQLException;
import java.util.Scanner;

import menus.MenuCursoCadeira;
import menus.menuAlunos;
import menus.menuProfessores;

public class PogramTest {
	public static void main(String[] args) throws SQLException {
		
	Scanner sc = new Scanner(System.in);
	
	

	while(true) {
		System.out.println("1 - Alunos");
		System.out.println("2 - Professores");
		System.out.println("3 - Curso/Cadeira");
		System.out.println("4 - Encerrar Menu Principal");
		String op = sc.nextLine();
		
		switch(op) {
		
		case "1":
			menuAlunos menuAlunos = new menuAlunos();
			menuAlunos.menuAlunos();
			break;
		case "2":
			menuProfessores menuProfessores = new menuProfessores();
			menuProfessores.menuProfessores();
			break;
		case "3":
			MenuCursoCadeira menuCursoCadeira = new MenuCursoCadeira();
			menuCursoCadeira.menuCursoCadeira();
			break;
		}
		
		if(op.equals("4")) {
			System.out.println("Saindo...");
			break;
		}
	}
	
	
	
	}
}
