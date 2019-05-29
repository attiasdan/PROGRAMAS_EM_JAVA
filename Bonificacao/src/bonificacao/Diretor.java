package bonificacao;

public class Diretor extends Funcionario {
	private double salarioFixo;
	private double gratificacoes;
	private double taxaRendimentos;

	public Diretor() {
		super();
		this.salarioFixo = 0.0;
		this.gratificacoes = 0.0;
		this.taxaRendimentos = 0.0;
	}
	public Diretor(String n, String departamentoOuSetor, double salarioFixo, double gratif, double taxaRend) {
		super(n, departamentoOuSetor);
		this.salarioFixo = salarioFixo;
		this.gratificacoes = gratif;
		this.taxaRendimentos = taxaRend;
	}

	public double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public double getGratificacoes() {
		return gratificacoes;
	}

	public void setGratificacoes(double gratificacoes) {
		this.gratificacoes = gratificacoes;
	}

	public double getTaxaRendimentos() {
		return taxaRendimentos;
	}

	public void setTaxaRendimentos(double taxaRendimentos) {
		this.taxaRendimentos = taxaRendimentos;
	}

	@Override
	public String toString() {
		return super.toString() + " Diretor [salarioFixo=" + salarioFixo + ", gratificacoes=" + gratificacoes + ", taxaRendimentos="
				+ taxaRendimentos + "]";
	}

	public double getBonificacao() {
		return (salarioFixo + (salarioFixo*taxaRendimentos) + gratificacoes);
	}
}