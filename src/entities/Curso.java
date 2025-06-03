package entities;

public class Curso {
	private int curso_id;
	private String nome;
	private String nivel;
	
	
	public Curso(int curso_id, String nome, String nivel) {
		this.curso_id = curso_id;
		this.nome = nome;
		this.nivel = nivel;
	}
	
	public Curso (String nome, String nivel) {
		this.nome = nome;
		this.nivel = nivel;
	}


	public int getCurso_id() {
		return curso_id;
	}


	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	
	
	
}
