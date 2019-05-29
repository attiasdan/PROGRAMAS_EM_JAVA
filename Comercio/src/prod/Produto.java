package prod;

public abstract class Produto {
	private String filial, identificacao, dataCompra;

	public Produto() {
		this.filial = "";
		this.identificacao = "";
		this.dataCompra = "";
	}
	public Produto(String f, String i, String dC) {
		this.filial = f;
		this.identificacao = i;
		this.dataCompra = dC;
	}
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	@Override
	public String toString() {
		return "Produto [filial=" + filial + ", identificacao=" + identificacao
				+ ", dataCompra=" + dataCompra + "]";
	}
	
}
