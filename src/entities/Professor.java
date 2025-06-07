package entities;

public class Professor {
	private int id_professor;
	private String nome;
	private String email;
	private int id_curso;
	private String situacao;
	
	public Professor() {}
	
	
	public Professor(int id_professor, String nome, String email, int id_curso, String situacao) {
		this.id_professor = id_professor;
		this.nome = nome;
		this.email = email;
		this.id_curso = id_curso;
		this.situacao = situacao;
	}
	
	public Professor(String nome, String email, int id_curso, String situacao) {
		this.nome = nome;
		this.email = email;
		this.id_curso = id_curso;
		this.situacao = "Lecionando";
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
	

	
	
	
	
}
