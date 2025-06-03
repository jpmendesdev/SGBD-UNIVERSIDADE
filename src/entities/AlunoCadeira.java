package entities;

public class AlunoCadeira {
	private int cretidos;
	private String situacao;
	private int id_aluno;
	
	
	public AlunoCadeira(String nome, int cretidos, String situacao, int id_aluno) {
		this.cretidos = cretidos;
		this.situacao = situacao;
		this.id_aluno = id_aluno;
	}



	public int getCretidos() {
		return cretidos;
	}


	 


	public String getSituacao() {
		return situacao;
	}


 

	public int getId_aluno() {
		return id_aluno;
	}


	 
	
	
	
}
