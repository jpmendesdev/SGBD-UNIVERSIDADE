package DAO;

public class CursoDAO {
	private int id_curso;
	private String nome;
	private String nivel;
	
	public CursoDAO(int id_curso, String nome, String nivel) {
		this.id_curso = id_curso;
		this.nome = nome;
		this.nivel = nivel;
	}

	public int getId_curso() {
		return id_curso;
	}

	public String getNome() {
		return nome;
	}

	public String getNivel() {
		return nivel;
	}

	
	 

}
