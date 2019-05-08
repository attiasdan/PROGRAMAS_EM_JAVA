package trabalhoHerancaBanco;

import java.util.Calendar;

public class Poupanca extends ContaCorrente{
	private int diaAniver;
	private double taxa;

	public Poupanca() {
		super();
		this.diaAniver = 0;
		this.taxa = 0.0;
	}
	public Poupanca(int n, double s, int d, double t) {
		super(n, s);
		this.diaAniver = d;
		this.taxa = t;
	}
	public int getDiaAniver() {
		return diaAniver;
	}
	public void setDiaAniver(int diaAniver) {
		this.diaAniver = diaAniver;
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public void reajuste() {
		String dia = String.format("%d", this.getDiaAniver());
        String dd = dia.charAt(0) +""+ dia.charAt(1);

        Calendar agora = Calendar.getInstance();
        int hoje = agora.DAY_OF_MONTH;
        int aniver = Integer.parseInt(dd);

        if (aniver == hoje) {
            setSaldo(getSaldo() * this.taxa);
        }
	}
	@Override
	public String toString() {
        return super.toString()+"Taxa: "+String.format("%.2f",this.taxa)+ "\n" + String.format("Saldo da Poupanca:%.2f",this.getSaldo())+"\n"+"Aniversario:"+this.diaAniver;
    }
}
