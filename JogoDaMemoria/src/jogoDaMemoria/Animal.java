package jogoDaMemoria;

public class Animal {
	private String nome;
	private boolean aberta;

	public Animal() {
		this.nome = null;
		this.aberta = false;
	}
	public Animal(String nome) {
		this.nome = nome;
		this.aberta = false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean getAberta() {
		return aberta;
	}
	public void setaFechada() {
		this.aberta = false;
	}
	public void setAberta() {
		this.aberta = true;
	}
}//class Animal
