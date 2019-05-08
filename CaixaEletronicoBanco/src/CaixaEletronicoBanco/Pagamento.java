package CaixaEletronicoBanco;

public abstract class Pagamento {
	private String dataPagto;
	private Cliente cliente;
	private float valorPago;

	public Pagamento() {
		dataPagto = "";
		cliente = null;
		valorPago = 0.0f;
	}
	public Pagamento(String d, Cliente c, float v) {
		dataPagto = d;
		cliente = c;
		valorPago = v;
	}
	public String getDataPagto() {
		return dataPagto;
	}
	public void setDataPagto(String dataPagto) {
		this.dataPagto = dataPagto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public float getValorPago() {
		return valorPago;
	}
	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}
	@Override
	public String toString() {
		return "Pagamento [dataPagto=" + dataPagto + ", cliente=" + cliente.toString()
				+ ", valorPago=" + valorPago + "]";
	}
	
}
