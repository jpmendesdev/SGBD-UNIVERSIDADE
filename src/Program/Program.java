package Program;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import DAO.Create;
import entities.Usuario;
import menus.MenuCursoCadeira;
import menus.menuAlunos;
import menus.menuProfessores;




public class Program {
	
	 
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//cria as tabelas estaticamente, caso não existam
		Create create = new Create();
		create.criarTabela();
		
		
		String usuarioCorreto = "admin";
		int senhaCorreta = 123;
		
		System.out.print("Usuario: ");
		String usuario = sc.nextLine();
		System.out.print("Senha: ");
		int senha = sc.nextInt();
		sc.nextLine();
		
		if(usuario.equals(usuarioCorreto) && senha == senhaCorreta) {
			System.out.println("Usuário Autenticado!");
		
		while(true) {
			System.out.println("1 - Alunos");
			System.out.println("2 - Professores");
			System.out.println("3 - Curso/Cadeira");
			System.out.println("4 - Cadastrar Usuário");
			System.out.println("5 - Encerrar Menu Principal");
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
			case "4":
				System.out.print("Informe o login para cadastrar: ");
				String login = sc.nextLine();
				System.out.print("Informe a senha para cadastrar: ");
				String senhaTeste = sc.nextLine();
				Usuario usuarioTeste = new Usuario(login,senhaTeste);
				create.cadastrarUsuario(usuarioTeste);
				break;
			}
			
			if(op.equals("5")) {
				System.out.println("Saindo...");
				break;
			}
		}
	}else {
		System.out.println("Nome de usuário ou senha incorretos!");
	}
		
		
		
		
		
		
		
	}
}
