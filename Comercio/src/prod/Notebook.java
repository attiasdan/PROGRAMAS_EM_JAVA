package prod;

public class Notebook extends Produto {
	private String fabricante, memoria, sistemaOperac, processador;
	private double precoCusto;
	private char tipoPagto;
	
	public Notebook() {
		super();
		this.fabricante = "";
		this.memoria = "";
		this.sistemaOperac = "";
		this.processador = "";
		this.precoCusto = 0.0;
		this.tipoPagto = ' ';
	}
	public Notebook(String f, String i, String dC, String fabricante, String memoria, String sistemaOperac,
			String processador, double pC, char tP) {
		super(f, i, dC);
		this.fabricante = fabricante;
		this.memoria = memoria;
		this.sistemaOperac = sistemaOperac;
		this.processador = processador;
		this.precoCusto = pC;
		this.tipoPagto = tP;
	}
	@Override
	public String toString() {
		return "Notebook [fabricante=" + fabricante + ", memoria=" + memoria
				+ ", sistemaOperac=" + sistemaOperac + ", processador="
				+ processador + "]";
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getMemoria() {
		return memoria;
	}
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	public String getSistemaOperac() {
		return sistemaOperac;
	}
	public void setSistemaOperac(String sistemaOperac) {
		this.sistemaOperac = sistemaOperac;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public double ValorCusto() {
		return precoCusto;
	}
	public char formaDePagamento() {
		return tipoPagto;
	}
	
	public double ValorVenda() {
		double t = 0, desc = 0, acresc = 0;
		
		switch(formaDePagamento())
		{
			case 'd':
				desc = ValorCusto() * 0.10;
				t = ValorCusto() - desc;
				break;
			case 'b':
				desc = ValorCusto() * 0.05;
				t = ValorCusto() - desc;
				break;
			case 'c':
				acresc = ValorCusto() * 0.05;
				t = ValorCusto() + acresc;
				break;
		}//switch
		return t;
	}
}
