package bonificacao;

public class Caixa extends Funcionario {
	private double salario;
	private double bonus;

	public Caixa() {
		super();
		this.salario = 0.0;
		this.bonus = 0.0;
	}
	public Caixa(String n, String departamentoOuSetor, double s, double b) {
		super(n, departamentoOuSetor);
		this.salario = s;
		this.bonus = b;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Caixa [salario=" + salario + ", bonus=" + bonus + "]";
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getBonificacao() {
		return (salario + bonus);
	}
}