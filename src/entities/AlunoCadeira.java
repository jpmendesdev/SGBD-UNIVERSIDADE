package entities;

public class AlunoCadeira {
	private int id_matricula_cadeira;
	private String situacao;
	private int id_aluno;
	private int id_cadeira;
	
	public AlunoCadeira() {}
	
	public AlunoCadeira(int id_matricula_cadeira, String situacao, int id_aluno, int id_cadeira) {
		this.id_matricula_cadeira = id_matricula_cadeira;
		this.situacao = situacao;
		this.id_aluno = id_aluno;
		this.id_cadeira = id_cadeira;
	}
	
	public AlunoCadeira(String situacao, int id_aluno, int id_cadeira) {
		this.situacao = "Em curso";
		this.id_aluno = id_aluno;
		this.id_cadeira = id_cadeira;
	}
	
	public AlunoCadeira (int id_aluno, int id_cadeira) {
		this.id_aluno = id_aluno;
		this.id_cadeira = id_cadeira;
	}
	
	public AlunoCadeira (int id_cadeira) {
		this.id_cadeira = id_cadeira;
	}

	

	public int getId_matricula_cadeira() {
		return id_matricula_cadeira;
	}

	
	public String getSituacao() {
		return situacao;
	}
	
	public String setSituacao (String situacao) {
		return situacao;
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public int getId_cadeira() {
		return id_cadeira;
	}

 
	
	
	
}
