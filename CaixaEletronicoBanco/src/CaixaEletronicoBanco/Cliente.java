package CaixaEletronicoBanco;

public class Cliente {
	private String nome, endereco, cidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", cidade="
				+ cidade + "]";
	}
	public Cliente() {
		this.nome = "";
		this.endereco = "";
		this.cidade = "";
	}
	public Cliente(String n, String e, String c) {
		this.nome = n;
		this.endereco = e;
		this.cidade = c;
	}
}
