package trabalhoHerancaBanco;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

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
	LinkedList<ContaCorrente> Lista = new LinkedList<>();
	JPanel panelContaC;
	JPanel panelContaE;
	JPanel panelPoupanca;
	JPanel panelNorte;
	JPanel panelCentro;
	JPanel panelSul;
	JButton btnInsere, btnExibe, btnSaque, btnDeposito;
	JRadioButton rbContaC, rbContaE, rbPoupanca;
	ButtonGroup grupo;
	JLabel lblNroConta, lblSaldo, lblLimite, lblDiaAniver, lblTaxa;
	JTextField tfNroConta, tfSaldo, tfLimite, tfDiaAniver, tfTaxa;
	
	public Tela() {
		super("Banco MinaDioro");
		getContentPane().setLayout(new BorderLayout());

		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelSul = new JPanel();
		panelContaC = new JPanel();
		panelContaE = new JPanel();
		panelPoupanca = new JPanel();
		
		btnInsere = new JButton("INSERE");
		btnExibe = new JButton("EXIBE");
		btnSaque = new JButton("SAQUE");
		btnDeposito = new JButton("DEPOSITO");

		rbContaC = new JRadioButton("Conta Corrente");
		rbContaE = new JRadioButton("Conta Especial");
		rbPoupanca = new JRadioButton("Poupança");
		
		grupo = new ButtonGroup();
		grupo.add(rbContaC);
		grupo.add(rbContaE);
		grupo.add(rbPoupanca);

		lblNroConta = new JLabel("Nº Conta:");
		lblSaldo = new JLabel("Saldo:");
		lblLimite = new JLabel("Limite:");
		lblDiaAniver = new JLabel("Dia Aniversário:");
		lblTaxa = new JLabel("Taxa de juros:");
		
		tfNroConta = new JTextField();
		tfSaldo = new JTextField();
		tfLimite = new JTextField();
		tfDiaAniver = new JTextField();
		tfTaxa = new JTextField();
		
		panelNorte.setLayout(new FlowLayout());
		panelCentro.setLayout(new GridLayout(3,1));
		panelSul.setLayout(new FlowLayout());
		
		panelContaC.setLayout(new GridLayout(2,2));
		panelContaE.setLayout(new GridLayout(1,2));
		panelPoupanca.setLayout(new GridLayout(2,2));


		panelNorte.add(rbContaC);
		panelNorte.add(rbContaE);
		panelNorte.add(rbPoupanca);

		BotoesRadio fazedor = new BotoesRadio();
		rbContaC.addItemListener(fazedor);
		rbContaE.addItemListener(fazedor);
		rbPoupanca.addItemListener(fazedor);

		panelContaC.add(lblNroConta);
		panelContaC.add(tfNroConta);
		panelContaC.add(lblSaldo);
		panelContaC.add(tfSaldo);

		panelContaE.add(lblLimite);
		panelContaE.add(tfLimite);

		panelPoupanca.add(lblDiaAniver);
		panelPoupanca.add(tfDiaAniver);
		panelPoupanca.add(lblTaxa);
		panelPoupanca.add(tfTaxa);
		
		panelCentro.add(panelContaC);
		panelCentro.add(panelContaE);
		panelCentro.add(panelPoupanca);
		
		panelSul.add(btnInsere);
		panelSul.add(btnExibe);
		panelSul.add(btnSaque);
		panelSul.add(btnDeposito);
		
		add(BorderLayout.NORTH, panelNorte);
		add(BorderLayout.CENTER, panelCentro);
		add(BorderLayout.SOUTH, panelSul);


		btnInsere.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String sNroConta, sSaldo, sLimite, sDiaAniver, sTaxa;
				
				int auxNroConta = 0, auxDiaAniver = 0;
				double auxSaldo = 0.0, auxLimite = 0.0, auxTaxa = 0.0;
				
				sNroConta = tfNroConta.getText();
				sSaldo = tfSaldo.getText();
				sLimite = tfLimite.getText();
				sDiaAniver = tfDiaAniver.getText();
				sTaxa = tfTaxa.getText();
				
				if (rbContaC.isSelected()) {
					try {
						auxNroConta = Integer.parseInt(sNroConta);
						auxSaldo = Double.parseDouble(sSaldo);
						
					} catch(NumberFormatException erro) {
						JOptionPane.showMessageDialog(null,"Use apenas numeros");
					}

					ContaCorrente cc = new ContaCorrente(auxNroConta, auxSaldo);
					Lista.add(cc);
				}
				
				if (rbContaE.isSelected()) {
					try {
						auxSaldo = Double.parseDouble(sSaldo);
						auxLimite = Double.parseDouble(sLimite);
						
					} catch (NumberFormatException erro) {
						JOptionPane.showMessageDialog(null,"Use apenas numeros");
					}

					ContaEspecial ce = new ContaEspecial(auxNroConta,auxSaldo,auxLimite);
					Lista.add(ce);
				}
				
				if (rbPoupanca.isSelected()) {
					try {
						auxSaldo = Double.parseDouble(sSaldo);
						auxTaxa = Double.parseDouble(sTaxa);
				
					} catch (NumberFormatException erro) {
						JOptionPane.showMessageDialog(null,"Use apenas numeros");
					}

					Poupanca p = new Poupanca(auxNroConta,auxSaldo,auxDiaAniver,auxTaxa);
					Lista.add(p);
				}
				
				JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
				tfNroConta.setText("");
				tfSaldo.setText("");
				tfLimite.setText("");
				tfDiaAniver.setText("");
				tfTaxa.setText("");
			}
		});

		btnDeposito.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String sNroConta, valor;
				double v = 0;
				int auxNroConta;
				sNroConta = JOptionPane.showInputDialog(null,"Insira o num da conta");
				valor = JOptionPane.showInputDialog(null,"Insira o Valor");

				auxNroConta = Integer.parseInt(sNroConta);
				
				for(ContaCorrente c:Lista)
				{
					if (auxNroConta == c.getNroConta())
					{
						try {
							v = Double.parseDouble(valor);
							
						} catch(NumberFormatException erro) {
							JOptionPane.showMessageDialog(null,"Insira apenas numeros");
						}
						
						c.deposito(v);
						
						if (c instanceof Poupanca) {
							((Poupanca) c).reajuste();
						}
						
						JOptionPane.showMessageDialog(null,"Sucesso");
						
					} else
						JOptionPane.showMessageDialog(null,"Conta não existe");
				}
			}
		});

		btnExibe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String saida = "\n Contas: \n";
				int i = 1;

				for(ContaCorrente c:Lista) {
					saida+="posicao:"+i+c.toString()+"\n";
					i++;
				}
				JTextArea area = new JTextArea(saida,30,30);
				JOptionPane.showMessageDialog(null,area);
			}
		});

		btnSaque.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String valor, sNroConta;
				int auxNroConta;
				double v = 0;
				sNroConta = JOptionPane.showInputDialog(null,"Insira numero da conta");
				valor = JOptionPane.showInputDialog(null,"Insira o valor do saque");
				
				auxNroConta = Integer.parseInt(sNroConta);
				
				
				for(ContaCorrente c:Lista)
				{
					if (auxNroConta == c.getNroConta())
					{
						try {
							v = Double.parseDouble(valor);
							
						} catch(NumberFormatException erro) {
							JOptionPane.showMessageDialog(null,"Insira apenas numeros");
						}
						c.saque(v);
						JOptionPane.showMessageDialog(null,"Saque realizado");
					} else
						JOptionPane.showMessageDialog(null,"Conta não existe");
				}//for
			}
		});

	}//construtor
	
	private class BotoesRadio implements ItemListener {
    //classe para tratar os radio buttons
		public void itemStateChanged(ItemEvent evento)
		{
			if (evento.getSource() == rbContaC) {
				panelContaC.setVisible(true);
				panelContaE.setVisible(false);
				panelPoupanca.setVisible(false);
			}
			else if (evento.getSource() == rbContaE) {
				panelContaC.setVisible(true);
				panelContaE.setVisible(true);
				panelPoupanca.setVisible(false);
			} else if (evento.getSource() == rbPoupanca) {
				panelContaC.setVisible(true);
				panelContaE.setVisible(false);
				panelPoupanca.setVisible(true);
			}
		}
    } //private class BotoesRadio

	public static void main(String[] args) {
		Tela t = new Tela();
		t.setSize(500, 500);
		t.setLocation(400,200);
		t.setVisible(true);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
