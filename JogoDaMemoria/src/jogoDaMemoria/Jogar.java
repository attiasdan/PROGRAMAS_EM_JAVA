package jogoDaMemoria;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Jogar extends JFrame implements ActionListener {
	Bichos b;
	JButton btMatriz[][] = new JButton[2][6];
	Icon iconeFechado;
	boolean primeiro = true;
	String primeiroNome = null;
	int iant, jant;
	
	public int retornaPosicao(int lin, int col) { //retorna posição no vetor
		int posicao = 0;

		if (lin == 0 && col == 0) posicao = 0;
		if (lin == 0 && col == 1) posicao = 1;
		if (lin == 0 && col == 2) posicao = 2;
		if (lin == 0 && col == 3) posicao = 3;
		if (lin == 0 && col == 4) posicao = 4;
		if (lin == 0 && col == 5) posicao = 5;
		if (lin == 1 && col == 0) posicao = 6;
		if (lin == 1 && col == 1) posicao = 7;
		if (lin == 1 && col == 2) posicao = 8;
		if (lin == 1 && col == 3) posicao = 9;
		if (lin == 1 && col == 4) posicao = 10;
		if (lin == 1 && col == 5) posicao = 11;
		
		return posicao;
	}
	public Jogar() {
		super("Jogo da Memória");
		setLayout(new BorderLayout());
		
		//criaComponentes:
		int i, j;
		b = new Bichos();
		b.embaralha();
		iconeFechado = new ImageIcon(getClass().getResource("fechado.png"));
		JPanel painelcentro = new JPanel(new GridLayout(2,6,5,5));
		
		for(i = 0; i < 2; i++) {
			for(j = 0; j < 6; j++) {
				btMatriz[i][j] = new JButton();
				btMatriz[i][j].setIcon(iconeFechado);
				btMatriz[i][j].addActionListener(this);
				painelcentro.add(btMatriz[i][j]);
			}//for j
		}//for i
		
		add(painelcentro, BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int i, j, segundaPosicao, posicao = 0, primeiraPosicao = 0;
		
		for (i = 0; i < 2; i++)
		{
			for (j = 0; j < 6; j++)
			{
				if (e.getSource() == btMatriz[i][j])
				{
					posicao = retornaPosicao(i,j);
					Animal a = b.getAnimal(posicao);
					
					if (a.getAberta()) {
						JOptionPane.showMessageDialog(null, "carta já estava aberta...erro");
						break;
					}
					if (primeiro == true) {
						primeiraPosicao = retornaPosicao(i,j);
						primeiro = false;
						a.setAberta();
						primeiroNome = b.getNome(primeiraPosicao);
						btMatriz[i][j].setIcon(b.getIcone(primeiraPosicao));
						iant = i;
						jant = j;
					}
					else {
						segundaPosicao = retornaPosicao(i,j);
						String segundoNome = b.getNome(segundaPosicao);
						
						if (primeiroNome.equals(segundoNome)) {
							btMatriz[i][j].setIcon(b.getIcone(segundaPosicao));
							a.setAberta();
							primeiro = true;
							
						}//if
					}//else
				}//if
				else {//botoes diferentes

					Animal a = b.getAnimal(posicao);
					btMatriz[i][j].setIcon(b.getIcone(posicao));
					JOptionPane.showMessageDialog(null,"Mostrando para fechar em seguida");
					btMatriz[iant][jant].setIcon(iconeFechado);
					Animal posterior = b.getAnimal(primeiraPosicao);
					posterior.setaFechada();
					a.setaFechada();
					btMatriz[i][j].setIcon(iconeFechado);
					primeiro = true;
				}//else
			}//for j
		}//for i
		
	}
	public static void main(String[] args) {
		Jogar j = new Jogar();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(1000,400);
		j.setLocation(250,150);
		j.setVisible(true);
	}
}
