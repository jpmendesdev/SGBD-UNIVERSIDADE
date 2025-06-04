package entities;

public class Cadeira {
	private int id_cadeira;
	private String nome;
	private int creditos;
	private int id_curso;
	
	
	public Cadeira(int id_cadeira, String nome, int creditos, int id_curso) {
		this.id_cadeira = id_cadeira;
		this.nome = nome;
		this.creditos = creditos;
		this.id_curso = id_curso;
	}
	
	public Cadeira(String nome, int creditos, int id_curso) {
		this.nome = nome;
		this.creditos = creditos;
		this.id_curso = id_curso;
	}

	public int getId_cadeira() {
		return id_cadeira;
	}

	public void setId_cadeira(int id_cadeira) {
		this.id_cadeira = id_cadeira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	
	
	
	
}
