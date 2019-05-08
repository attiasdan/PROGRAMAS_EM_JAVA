package primeiraProvaPOO2019;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class jogo21 extends JFrame {
	JButton bot1, bot2, bot3, bot4, bot5, bot6;
	JButton btParar, btMonte;
	Baralho monte = new Baralho();
	ImageIcon iMonte = new ImageIcon(getClass().getResource("monteCartas.png"));
	int pontuacao = 0;
	JLabel pontos;
	Carta c;
	
	JPanel 	painelEventos,
			painelCartasAbertas;
	
	public jogo21() {
		super("Jogo 21");
		setLayout(new BorderLayout());
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		jogo21 j = new jogo21();
		j.setDefaultCloseOperation(EXIT_ON_CLOSE);
		j.setSize(400,250);
		j.setVisible(true);
	}
	
}
