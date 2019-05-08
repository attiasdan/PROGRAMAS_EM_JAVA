package jogoDaMemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Bichos {
	private List<Animal> zoologico = new ArrayList<Animal>();
	
	public Bichos() {
		Animal a;
		String nome0, nome1, nome2, nome3, nome4, nome5;

		nome0 = "borboleta.png";
		nome1 = "cachorro.png";
		nome2 = "caranguejo.png";
		nome3 = "cobra.png";
		nome4 = "elefante.png";
		nome5 = "urso.png";
		
		int conta, j;
		for (j = 0;  j < 2; j++)
		{//p/ duplicar os mesmos animais 2x
			conta = 0;
			
			while (conta < 6)
			{
				a = new Animal();
				
				switch (conta)
				{
					case 0: a.setNome(nome0); break;
					case 1: a.setNome(nome1); break;
					case 2: a.setNome(nome2); break;
					case 3: a.setNome(nome3); break;
					case 4: a.setNome(nome4); break;
					case 5: a.setNome(nome5); break;
				}//switch
				conta++;
				zoologico.add(a);
			}//while
		}//for j
		
	}//construtor
	public void zerazoologico() {
		zoologico.clear();
	}
	public int qtdade() {
		return zoologico.size();
	}
	public void embaralha() {
		Collections.shuffle(zoologico);
	}
	public Animal getAnimal(int posicao) {
		Animal c = zoologico.get(posicao);
		return c;
	}
	public ImageIcon getIcone(int posicao) {
		Animal a = zoologico.get(posicao);
		String nome = a.getNome();
		ImageIcon ic = new ImageIcon(getClass().getResource(nome));
		return (ic);
	}
	public String getNome(int posicao) {
		Animal a = zoologico.get(posicao);
		return a.getNome();
	}
}//class Bichos
