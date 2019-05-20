package bonificacao;

public abstract class Funcionario {
	private String nome;
	private String departamentoOuSetor;

	public Funcionario() {
		this.nome = "";
		this.departamentoOuSetor = "";
	}
	public Funcionario(String n, String departamentoOuSetor) {
		this.nome = n;
		this.departamentoOuSetor = departamentoOuSetor;
	}
	
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", departamentoOuSetor=" + departamentoOuSetor + "]";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamentoOuSetor() {
		return departamentoOuSetor;
	}

	public void setDepartamentoOuSetor(String departamentoOuSetor) {
		this.departamentoOuSetor = departamentoOuSetor;
	}

	public abstract double getBonificacao();
}