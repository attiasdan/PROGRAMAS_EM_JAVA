package CaixaEletronicoBanco;

public class Cartao extends Pagamento {
	private String numCartao, operadora;

	public Cartao() {
		super();//do Pagamento: String dataPagto, Cliente c, float valor
		numCartao = "";
		operadora = "";
	}
	public Cartao(String d, Cliente c, float valor, /*<- Até aqui argumentos do PAGAMENTO*/String car, String oper) {
		super(d, c, valor);//do Pagamento: String dataPagto, Cliente c, float valor
		numCartao = car;
		operadora = oper;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	@Override
	public String toString() {
		return super.toString() + "Cartao [numCartao=" + numCartao + ", operadora=" + operadora + "]";
	}
}
