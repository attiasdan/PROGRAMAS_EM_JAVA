package trabalhoHerancaBanco;

public class ContaCorrente {
	private int nroConta;
	private double saldo;

	public ContaCorrente() {
		this.nroConta = 0;
		this.saldo = 0.0;
	}
	public ContaCorrente(int n, double s) {
		this.nroConta = n;
		this.saldo = s;
	}
	public String toString() {
		return "\n nº conta: "+this.nroConta+", saldo:"+this.saldo;
	}
	public int getNroConta() {
		return nroConta;
	}
	public void setNroConta(int nroConta) {
		this.nroConta = nroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// +saldo
	public void deposito(double valor)
	{
		this.setSaldo(this.getSaldo()+valor);
	}
	// -saldo
	public boolean saque(double valor)
	{
		if (valor > this.saldo)
			return false;
		
		this.saldo -= valor;
		return true;
	}
}
