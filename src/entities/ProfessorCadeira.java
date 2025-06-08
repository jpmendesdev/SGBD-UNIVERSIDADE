package entities;

public class ProfessorCadeira {
	private int professor_cadeira;
	private String situacao;
	private int id_professor;
	private int id_cadeira;
	
	public ProfessorCadeira(){}
	
	public ProfessorCadeira(int professor_cadeira, String situacao, int id_professor, int id_cadeira) {
		this.professor_cadeira = professor_cadeira;
		this.situacao = situacao;
		this.id_professor = id_professor;
		this.id_cadeira = id_cadeira;
	}
	
	public ProfessorCadeira(String situacao, int id_professor, int id_cadeira) {
		this.situacao = "Lecionando";
		this.id_professor = id_professor;
		this.id_cadeira = id_cadeira;
	}
	
	public ProfessorCadeira(int id_cadeira) {
		this.id_cadeira = id_cadeira;
	}

	public int getProfessor_cadeira() {
		return professor_cadeira;
	}

	public void setProfessor_cadeira(int professor_cadeira) {
		this.professor_cadeira = professor_cadeira;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public int getId_cadeira() {
		return id_cadeira;
	}

	public void setId_cadeira(int id_cadeira) {
		this.id_cadeira = id_cadeira;
	}

	
	
}
