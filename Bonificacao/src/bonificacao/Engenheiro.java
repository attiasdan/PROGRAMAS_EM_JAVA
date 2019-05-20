package bonificacao;

public class Engenheiro extends Funcionario{
	private int qtdadeVistorias;
	private double valorVistoria;

	public Engenheiro() {
		super();
		this.qtdadeVistorias = 0;
		this.valorVistoria = 0.0;
	}
	public Engenheiro(String n, String departamentoOuSetor, int quantVist, double valorVist) {
		super(n, departamentoOuSetor);
		this.qtdadeVistorias = quantVist;
		this.valorVistoria = valorVist;
	}

	@Override
	public String toString() {
		return super.toString() + " Engenheiro [qtdadeVistorias=" + qtdadeVistorias + ", valorVistoria=" + valorVistoria + "]";
	}

	public int getQtdadeVistorias() {
		return qtdadeVistorias;
	}

	public void setQtdadeVistorias(int qtdadeVistorias) {
		this.qtdadeVistorias = qtdadeVistorias;
	}

	public double getValorVistoria() {
		return valorVistoria;
	}

	public void setValorVistoria(double valorVistoria) {
		this.valorVistoria = valorVistoria;
	}

	public double getBonificacao() {
		return (qtdadeVistorias*valorVistoria);
	}
}