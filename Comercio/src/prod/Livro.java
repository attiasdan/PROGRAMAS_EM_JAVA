package prod;

public class Livro extends Produto implements Vendavel {
	private String titulo, autor;
	private double precoCusto;
	private char tipoPagto;

	public Livro() {
		super();
		this.titulo = "";
		this.autor = "";
		this.precoCusto = 0.0;
		this.tipoPagto = ' ';
	}
	public Livro(String f, String i, String dC, String t, String a, double pC, char tP) {
		super(f,i,dC);
		this.titulo = t;
		this.autor = a;
		this.precoCusto = pC;
		this.tipoPagto = tP;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public char getTipoPagto() {
		return tipoPagto;
	}
	public void setTipoPagto(char tipoPagto) {
		this.tipoPagto = tipoPagto;
	}
	@Override
	public String toString() {
		return super.toString() + " Livro [titulo=" + titulo + ", autor=" + autor + ", precoCusto="
				+ precoCusto + ", tipoPagto=" + tipoPagto + "]";
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
