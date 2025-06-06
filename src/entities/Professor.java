package entities;

public class Professor {
	private int id_professor;
	private String nome;
	private String email;
	private int id_curso;
	
	
	public Professor(int id_professor, String nome, String email, int id_curso) {
		this.id_professor = id_professor;
		this.nome = nome;
		this.email = email;
		this.id_curso = id_curso;
	}
	
	public Professor(String nome, String email, int id_curso) {
		this.nome = nome;
		this.email = email;
		this.id_curso = id_curso;
	}
	
	public Professor(int id_professor) {
		this.id_professor = id_professor;
	}


	public int getId_professor() {
		return id_professor;
	}
 
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public int getId_curso() {
		return id_curso;
	}

	
	
	
	
}
