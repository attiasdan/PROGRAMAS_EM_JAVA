package CaixaEletronicoBanco;

public class Cheque extends Pagamento {
	private int nroCheque, banco;
	//banco, ex: 1 - do Brasil, 2 - Bradesco

	public Cheque() {
		super();//do Pagamento: String dataPagto, Cliente c, float valor
		nroCheque = 0;
		banco = 0;
	}
	public Cheque(String d, Cliente c, float valor, /*<- Até aqui argumentos do PAGAMENTO*/int nroCheque, int banco) {
		super(d, c, valor);//do Pagamento: String dataPagto, Cliente c, float valor
		this.nroCheque = nroCheque;
		this.banco = banco;
	}
	public int getNroCheque() {
		return nroCheque;
	}
	public void setNroCheque(int nroCheque) {
		this.nroCheque = nroCheque;
	}
	public int getBanco() {
		return banco;
	}
	public void setBanco(int banco) {
		this.banco = banco;
	}
	@Override
	public String toString() {
		return super.toString() + "Cheque [nroCheque=" + nroCheque + ", banco=" + banco + "]";
	}
	
}
