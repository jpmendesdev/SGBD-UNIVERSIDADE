package entities;

public class Aluno {
	private int id_aluno;
	private String nome;
	private String email;
	private int id_curso;
	private String situacao;
	
	public Aluno() {}
	
	public Aluno(int id_aluno, String nome, String email, int id_curso, String situacao) {
		this.id_aluno = id_aluno;
		this.nome = nome;
		this.email = email;
		this.id_curso = id_curso;
		this.situacao = situacao;
	}
	
	public Aluno(String nome, String email, int id_curso, String situacao) {
		this.nome = nome;
		this.email = email;
		this.id_curso = id_curso;
		this.situacao = "matriculado";
	}
	
	public Aluno(int id_curso) {
		this.id_curso = id_curso;
	}
	
	
	public int getId_aluno() {
		return id_aluno;
	}


	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getId_curso() {
		return id_curso;
	}


	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
	
	
	
}
