/**
* PROGRAMA: Jogo da Forca.
* CLASSE: Tela
* AUTORES: Daniel Attias e Paulo Victor.
* DATA: 11/06/2019.
*/

package JogoDaForca;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela extends JFrame
{
	int erros = 0;
	int acertos = 0;
	int posicao = -1;
	ImageIcon imagem;
	
	JPanel oeste,centro,botoesPalavraADescobrir, entradaLetra;
	String palavra;
	
	//componentes do painel 'entrada letra':
	JTextField tfLetra;
	JButton btnOK;
	
	JButton[] botoes;
	
	JButton btnCorpo;

	char letra;
	
	public void entradaInicial()
	{
		palavra = JOptionPane.showInputDialog("Qual a palavra a ser descoberta?");
		
		if (palavra.length() == 0)
			entradaInicial();
	}
	
	public Tela() {
		setLayout(new BorderLayout());
		
		entradaInicial();
		
		botoes = new JButton[palavra.length()];
		
//====================================================================================//
		
		for (int i = 0; i < palavra.length(); i++) {

			botoes[i] = new JButton(" ");
		}
		
//====================================================================================//
		
		tfLetra = new JTextField(10);
		btnOK = new JButton("OK");
		
		btnCorpo = new JButton();
		
		oeste = new JPanel();
		centro = new JPanel(new GridLayout(2,1));
		botoesPalavraADescobrir = new JPanel(new FlowLayout());
		entradaLetra = new JPanel(new FlowLayout());
		
		
		for (int i = 0; i < palavra.length(); i++)
			botoesPalavraADescobrir.add(botoes[i]);
	
		entradaLetra.add(tfLetra);
		entradaLetra.add(btnOK);
		
//====================================================================================//
		
		centro.add(botoesPalavraADescobrir);
		centro.add(entradaLetra);
	
		oeste.add(btnCorpo);
		
		add(oeste, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		
		btnOK.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (tfLetra.getText().length() != 0)
				{
					letra = tfLetra.getText().charAt(0);
					
					posicao = palavra.indexOf(letra);
					if(posicao != -1 ) {
						while(posicao != -1)
						{
							if (posicao != -1) { //acertou uma letra
								acertos++;
								botoes[posicao].setText(""+palavra.charAt(posicao)+"");
								
								if(acertos == palavra.length()) {
									JOptionPane.showMessageDialog(null, "Ganhou :D");
								}
							}
							posicao = palavra.indexOf(letra, posicao+1);
						}//while
					} else if (posicao == -1) { //não encontrou a letra digitada na palavra, logo Errou a letra
						erros++;
						switch(erros) {
							case 1: btnCorpo.setIcon(new ImageIcon(getClass().getResource("img/soTronco.jpg")));
								break;
							case 2: btnCorpo.setIcon(new ImageIcon(getClass().getResource("img/troncoUmaPerna.jpg")));
								break;
							case 3: btnCorpo.setIcon(new ImageIcon(getClass().getResource("img/troncoDuasPernas.jpg")));
								break;
							case 4: btnCorpo.setIcon(new ImageIcon(getClass().getResource("img/semUmBraço.jpg")));
								break;
							case 5: btnCorpo.setIcon(new ImageIcon(getClass().getResource("img/semCabeça.jpg")));
								break;
							case 6: btnCorpo.setIcon(new ImageIcon(getClass().getResource("img/bonecoCompleto.jpg")));
								break;
						}
					
						if (erros > 5)
							JOptionPane.showMessageDialog(null, "Perdeu :(");
					}

				}
				else return;
				
			}
		});
	}
	
	public static void main(String[] args) {
		Tela t = new Tela();
		t.setVisible(true);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setSize(500,500);
		t.setLocation(200,200);
	}

}
