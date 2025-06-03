package entities;

public class MatriculaAluno {
	private int id_matricula;
	private int id_aluno;
	private int ano_matricula;
	private int semestre;
	private Aluno aluno;
	private String status;
	
	public MatriculaAluno(int id_matricula, int ano_matricula,int semestre, String status) {
		this.id_matricula = id_matricula;
		this.ano_matricula = ano_matricula;
		this.semestre = semestre;
		this.status = status;
	}

	public int getId_matricula() {
		return id_matricula;
	}

	public void setId_matricula(int id_matricula) {
		this.id_matricula = id_matricula;
	}

	public int getAno_matricula() {
		return ano_matricula;
	}

	public void setAno_matricula(int ano_matricula) {
		this.ano_matricula = ano_matricula;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
