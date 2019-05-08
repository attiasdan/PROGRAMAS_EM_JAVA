package CaixaEletronicoBanco;

public class Dinheiro extends Pagamento {
	public Dinheiro() {
		super();//do Pagamento: String dataPagto, Cliente c, float valor
	}
	public Dinheiro(String d, Cliente c, float valor) {
		super(d, c, valor);//do Pagamento: String dataPagto, Cliente c, float valor
	}
	@Override
	public String toString() {
		return super.toString() + "dinheiro";
	}
}
