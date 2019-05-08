package primeiraProvaPOO2019;

public class Carta {
	String imagem;
	int numero;
	char naipe;

	public Carta() {
		this.imagem = "";
		this.numero = 0;
		this.naipe = ' ';
	}
	public Carta(String i, int nro, char naipe) {
		this.imagem = i;
		this.numero = nro;
		this.naipe = naipe;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public char getNaipe() {
		return naipe;
	}
	public void setNaipe(char naipe) {
		this.naipe = naipe;
	}
	public String toString() {
		return "Número: "+this.numero+", Naipe: "+this.naipe+", Imagem: "+this.imagem;
	}
}
