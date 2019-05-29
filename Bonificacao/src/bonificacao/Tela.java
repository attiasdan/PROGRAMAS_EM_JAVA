package bonificacao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	JPanel painelEscolha, painelNome, painelnorte, painelcentro, painelsul, painelEng, painelDiret, painelCaixa;
	JButton btnExibe, btnAdiciona;
	JTextField tfNome;
	ButtonGroup grupo;
	JRadioButton rbEng, rbDir, rbCxa;
	
	JLabel lblQtdVist, lblValorVist, lblSalario, lblBonus, lblSalarioFixo, lblTaxaRend, lblGratif;
	JTextField tfQtdVist, tfValorVist, tfSalario, tfBonus, tfSalarioFixo, tfTaxaRend, tfGratif;
	
	
	public Tela() {
		super("Bonificação");
		setLayout(new BorderLayout());
		
		//Instanciando componentes
		rbEng = new JRadioButton("Engenheiro");
		rbDir = new JRadioButton("Diretor");
		rbCxa = new JRadioButton("Caixa");
		grupo = new ButtonGroup();
		grupo.add(rbEng);
		grupo.add(rbDir);
		grupo.add(rbCxa);
		
		tfNome = new JTextField();

		lblQtdVist = new JLabel("Qtdade Vistorias:");
		lblValorVist = new JLabel("Valor da Vistoria:");
		lblSalario = new JLabel("Salário:");
		lblBonus = new JLabel("Bônus:");
		lblSalarioFixo = new JLabel("Salário Fixo:");
		lblTaxaRend = new JLabel("Taxa de Rendimentos:");
		lblGratif = new JLabel("Gratificações:");

		tfQtdVist = new JTextField();
		tfValorVist = new JTextField();
		tfSalario = new JTextField();
		tfBonus = new JTextField();
		tfSalarioFixo = new JTextField();
		tfTaxaRend = new JTextField();
		tfGratif = new JTextField();
		
		btnExibe = new JButton("Exibe bonificação de todos");
		btnAdiciona = new JButton("Adiciona");

		painelEscolha = new JPanel();
		painelNome = new JPanel();
		painelEng = new JPanel();
		painelDiret = new JPanel();
		painelCaixa = new JPanel();
		painelnorte = new JPanel();
		painelcentro = new JPanel();
		painelsul = new JPanel();
		
		painelEng.setVisible(false);
		painelDiret.setVisible(false);
		painelCaixa.setVisible(false);
		
		//Configura gerenciadores de layout dos paineis:
		painelEscolha.setLayout(new BoxLayout(painelEscolha,BoxLayout.Y_AXIS));
		painelNome.setLayout(new BoxLayout(painelNome,BoxLayout.X_AXIS));
		painelEng.setLayout(new BoxLayout(painelEng,BoxLayout.Y_AXIS));
		painelDiret.setLayout(new BoxLayout(painelDiret,BoxLayout.Y_AXIS));
		painelCaixa.setLayout(new BoxLayout(painelCaixa,BoxLayout.Y_AXIS));
		
		painelnorte.setLayout(new GridLayout(1,2));
		painelcentro.setLayout(new GridLayout(1,3,10,10));

		
		//Adiciona componentes aos paineis:
		painelEscolha.add(new JLabel("Tipo:"));
		painelEscolha.add(rbEng);
		painelEscolha.add(rbCxa);
		painelEscolha.add(rbDir);

		painelNome.add(new JLabel("Nome:"));
		painelNome.add(tfNome);
		
		painelnorte.add(painelEscolha);
		painelnorte.add(painelNome);

		painelEng.add(lblQtdVist);
		painelEng.add(tfQtdVist);
		painelEng.add(lblValorVist);
		painelEng.add(tfValorVist);
		
		painelCaixa.add(lblSalario);
		painelCaixa.add(tfSalario);
		painelCaixa.add(lblBonus);
		painelCaixa.add(tfBonus);

		painelDiret.add(lblSalarioFixo);
		painelDiret.add(tfSalarioFixo);
		painelDiret.add(lblTaxaRend);
		painelDiret.add(tfTaxaRend);
		painelDiret.add(lblGratif);
		painelDiret.add(tfGratif);
		
		painelcentro.add(painelEng);
		painelcentro.add(painelCaixa);
		painelcentro.add(painelDiret);
		
		painelsul.add(btnExibe);
		painelsul.add(btnAdiciona);
		
		//Adiciona paineis ao JFrame
		add(painelnorte,BorderLayout.NORTH);
		add(painelcentro,BorderLayout.CENTER);
		add(painelsul,BorderLayout.SOUTH);
		
		BotoesRadio fazedor = new BotoesRadio();
		rbEng.addItemListener(fazedor);
		rbDir.addItemListener(fazedor);
		rbCxa.addItemListener(fazedor);
		
		//tratadores de eventos dos botões:
		btnExibe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saida="\n Funcionários: \n";

    			for(int i=0; i < funcionarios.size(); i++) {
    				saida += "pos: " + i + funcionarios.get(i).toString() +"\n"+ 
    						funcionarios.get(i).getBonificacao()+ "\n\n";
    			}
    			JTextArea area = new JTextArea(saida,30,30);
    			JOptionPane.showMessageDialog(null,area);
			}
		});
		btnAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Engenheiro eng;
				Caixa cxa;
				Diretor dir;
				
				String nome, depOuSetor;
				
				nome = tfNome.getText();
				
				if (rbEng.isSelected()) {
					depOuSetor = "Engenheiro";
					int qtdadeVistorias;
					double valorVistoria;
					
					try {
						qtdadeVistorias = Integer.parseInt(tfQtdVist.getText());
						valorVistoria = Double.parseDouble(tfValorVist.getText());
					} catch (NumberFormatException erro) {
						JOptionPane.showMessageDialog(null,"Use apenas números");
						return;
					}
					
					eng = new Engenheiro(nome,depOuSetor,qtdadeVistorias,valorVistoria);
					
					if(funcionarios.add(eng))
					{
						tfQtdVist.setText("");
						tfValorVist.setText("");
						JOptionPane.showMessageDialog(null,"Adicionado");
					}
				}//if
				
				if (rbDir.isSelected()) {
					depOuSetor = "Diretor";
					double salarioFixo;
					double gratificacoes;
					double taxaRendimentos;
					
					try {
						salarioFixo = Double.parseDouble(tfSalarioFixo.getText());
						taxaRendimentos = Double.parseDouble(tfTaxaRend.getText());
						gratificacoes = Double.parseDouble(tfGratif.getText());
					} catch (NumberFormatException erro) {
						JOptionPane.showMessageDialog(null,"Use apenas números");
						return;	
					}
					
					dir = new Diretor(nome,depOuSetor,salarioFixo,gratificacoes,taxaRendimentos);
					
					if(funcionarios.add(dir))
					{
						tfSalarioFixo.setText("");
						tfTaxaRend.setText("");
						tfGratif.setText("");
						JOptionPane.showMessageDialog(null,"Adicionado");
					}
				}//if
				
				if (rbCxa.isSelected()) {
					depOuSetor = "Caixa";
					double salario;
					double bonus;
					
					try {
						salario = Double.parseDouble(tfSalario.getText());
						bonus = Double.parseDouble(tfBonus.getText());
					} catch (NumberFormatException erro) {
						JOptionPane.showMessageDialog(null,"Use apenas números");
						return;	
					}
					
					cxa = new Caixa(nome,depOuSetor,salario,bonus);
					
					if(funcionarios.add(cxa))
					{
						tfSalario.setText("");
						tfBonus.setText("");
						JOptionPane.showMessageDialog(null,"Adicionado");
					}
				}//if
			}
		});
		
	}//construtor
	
	private class BotoesRadio implements ItemListener {
		public void itemStateChanged(ItemEvent evento) {
			if(evento.getSource() == rbEng) {
				painelEng.setVisible(true);
				painelDiret.setVisible(false);
				painelCaixa.setVisible(false);
			}
			if(evento.getSource() == rbDir) {
				painelEng.setVisible(false);
				painelDiret.setVisible(true);
				painelCaixa.setVisible(false);
			}
			if(evento.getSource() == rbCxa) {
				painelEng.setVisible(false);
				painelDiret.setVisible(false);
				painelCaixa.setVisible(true);
			}
		}
	}
	
	public static void main(String[] args) {
		Tela t = new Tela();
		t.setSize(700, 400);
		t.setLocation(100, 100);
		t.setVisible(true);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}