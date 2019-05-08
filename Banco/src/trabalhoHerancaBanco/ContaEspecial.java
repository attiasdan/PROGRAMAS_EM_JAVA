package trabalhoHerancaBanco;

public class ContaEspecial extends ContaCorrente{
	private double limite;

	public ContaEspecial() {
		super();
		this.limite = 0.0;
	}
	public ContaEspecial(int n, double s, double l) {
		super(n, s);
		this.limite = l;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean saque(double valor) {
		double t = this.getSaldo() + limite;
		
		if (t < valor) {
            System.out.println("O saldo é insuficiente!");
            return false;
		} else {
            this.setSaldo(this.getSaldo()-valor);
            System.out.println("Saque efetuado com sucesso!");
            return true;
		}
	}

	@Override
	public String toString() {
        return super.toString() + ", Limite: " + String.format("%.2f", this.limite)+ "\n" + String.format("Saldo da Poupanca:%.2f", this.getSaldo()) + "\n";
    }
}
