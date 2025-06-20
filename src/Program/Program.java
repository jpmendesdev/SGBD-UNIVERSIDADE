package program;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import DAO.Create;
import DAO.Read;
import criptografia.Criptografy;
import entities.Usuario;
import menus.MenuCursoCadeira;
import menus.menuAlunos;
import menus.menuProfessores;


public class Program {
	
	 
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//cria as tabelas estaticamente, caso não existam
		Create create = new Create();
		create.criarTabela();
		
		while(true) {
		System.out.print("Login: ");
		String loginOp = sc.nextLine();
		System.out.print("Senha: ");
		String senhaOp = sc.nextLine();
		Read readUsuario = new Read();
		Usuario usuarioTeste2 = new Usuario(loginOp,senhaOp);
		
		if(readUsuario.autenticarUsuarios(usuarioTeste2)) { 
			
		
		
		
		while(true) {
			System.out.println("1 - Alunos");
			System.out.println("2 - Professores");
			System.out.println("3 - Curso/Cadeira");
			System.out.println("4 - Cadastrar Usuário");
			System.out.println("5 - Sair");
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
				Criptografy cript = new Criptografy();
				System.out.print("Informe o login para cadastrar: ");
				String login = sc.nextLine();
				System.out.print("Informe a senha para cadastrar: ");
				String senhaTeste = sc.nextLine();
				//String senhaHash = cript.hashPassword(senhaTeste);
				Usuario usuarioTeste = new Usuario(login,senhaTeste);
				create.cadastrarUsuario(usuarioTeste);
				break;
			/*case "5":
				System.out.print("Login: ");
				String loginOp = sc.nextLine();
				System.out.print("Senha: ");
				String senhaOp = sc.nextLine();
				Read readUsuario = new Read();
				Usuario usuarioTeste2 = new Usuario(loginOp,senhaOp);
				readUsuario.autenticarUsuarios(usuarioTeste2);
				break; */
			}
			
			if(op.equals("5")) {
				System.out.println("Saindo...");
				break;
			}
		}
		break;
		
		}
		
		
		
		
		
		
		}
	}
}
