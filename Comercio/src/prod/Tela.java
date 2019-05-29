package prod;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tela extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	
	List<Produto> vendas = new ArrayList<Produto>();
	JButton btnInsere, btnRelat;
	
	JPanel norte, centro, sul, radios, topo, livro, notebook;
	
	JLabel lFilial, lIdent, lDataCompra;
	JTextField tfFilial, tfIdent, tfDataCompra;
	
	JLabel lTitulo, lAutor, lEditor, lPrecoCustoLivro, lTipoPagtoLivro, lTipoPagtoNotebook, lFabricante, lMemoria, lSistemOperac, lMonitor, lProcessador, lPrecoCustoNotebook;
	JTextField tfTitulo, tfAutor, tfEditor, tfPrecoCustoLivro, tfTipoPagtoLivro, tfTipoPagtoNotebook, tfFabricante, tfMemoria, tfSistemOperac, tfMonitor, tfProcessador, tfPrecoCustoNotebook;
	
	JRadioButton rbLivro, rbNotebook;
	
	ButtonGroup grupo;
	
	public Tela() {
		super("Comércio");
		setLayout(new BorderLayout());

		btnInsere = new JButton("Inserir produto");
		btnRelat = new JButton("Relatório");
		rbLivro = new JRadioButton("Livro",false);
		rbNotebook = new JRadioButton("Notebook",false);
		grupo = new ButtonGroup();
		grupo.add(rbLivro);
		grupo.add(rbNotebook);
		
		btnInsere.addActionListener(this);
		btnRelat.addActionListener(this);
		rbLivro.addItemListener(this);
		rbNotebook.addItemListener(this);

		lFilial = new JLabel("Filial depósito:");
		lIdent = new JLabel("Identificação:");
		lDataCompra = new JLabel("Data da compra:");
		tfFilial = new JTextField();
		tfIdent = new JTextField();
		tfDataCompra = new JTextField();
		
		
		norte = new JPanel(new GridLayout(2,1));
		centro = new JPanel(new GridLayout(2,1));
		sul = new JPanel();
		radios = new JPanel();
		topo = new JPanel(new GridLayout(1,6));
		livro = new JPanel(new GridLayout(5,2));
		notebook = new JPanel(new GridLayout(7,2));
		
		radios.add(rbLivro);
		radios.add(rbNotebook);
	
		topo.add(lFilial);
		topo.add(tfFilial);
		topo.add(lIdent);
		topo.add(tfIdent);
		topo.add(lDataCompra);
		topo.add(tfDataCompra);
		
		norte.add(radios);
		norte.add(topo);
		
		
		lTitulo = new JLabel("Título");
		lAutor = new JLabel("Autor");
		lPrecoCustoLivro = new JLabel("Preço custo livro");
		lTipoPagtoLivro = new JLabel("Tipo pagto livro");
		
		
		lFabricante = new JLabel("Fabricante:");
		lMemoria = new JLabel("Memória");
		lSistemOperac = new JLabel("Sistema Operacional:");
		lMonitor = new JLabel("Monitor:");
		lProcessador = new JLabel("Processador:");
		lPrecoCustoNotebook = new JLabel("Preco custo notebook:");
		lTipoPagtoNotebook = new JLabel("Tipo pagto notebook:");
		
		tfTitulo = new JTextField();
		tfAutor = new JTextField();
		tfPrecoCustoLivro = new JTextField();
		tfTipoPagtoLivro = new JTextField();
		tfTipoPagtoNotebook = new JTextField();
		tfFabricante = new JTextField();
		tfMemoria = new JTextField();
		tfSistemOperac = new JTextField();
		tfMonitor = new JTextField();
		tfProcessador = new JTextField();
		tfPrecoCustoNotebook = new JTextField();
		
		livro.add(lTitulo);
		livro.add(tfTitulo);
		livro.add(lAutor);
		livro.add(tfAutor);
		livro.add(lPrecoCustoLivro);
		livro.add(tfPrecoCustoLivro);
		livro.add(lTipoPagtoLivro);
		livro.add(tfTipoPagtoLivro);

		notebook.add(lFabricante);
		notebook.add(tfFabricante);
		notebook.add(lMemoria);
		notebook.add(tfMemoria);
		notebook.add(lSistemOperac);
		notebook.add(tfSistemOperac);
		notebook.add(lMonitor);
		notebook.add(tfMonitor);
		notebook.add(lProcessador);
		notebook.add(tfProcessador);
		notebook.add(lPrecoCustoNotebook);
		notebook.add(tfPrecoCustoNotebook);
		notebook.add(lTipoPagtoNotebook);
		notebook.add(tfTipoPagtoNotebook);
		
		centro.add(livro);
		centro.add(notebook);
		
		sul.add(btnInsere);
		sul.add(btnRelat);

		add(norte, BorderLayout.NORTH);
		add(centro, BorderLayout.CENTER);
		add(sul, BorderLayout.SOUTH);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rbLivro) {
			livro.setVisible(true);
			notebook.setVisible(false);
		}
		
		if (e.getSource() == rbNotebook) {
			livro.setVisible(false);
			notebook.setVisible(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnInsere) {
			double precoCusto;
			Livro liv;
			//String nome, depOuSetor;
			
			
			if (rbLivro.isSelected()) {
				precoCusto = 0.0;
				try {
					precoCusto = Double.parseDouble(tfPrecoCustoLivro.getText());
				} catch (NumberFormatException erro) {
					JOptionPane.showMessageDialog(null,"Use apenas números");
					return;
				}

				
				liv = new Livro(tfFilial.getText(), tfIdent.getText(), tfDataCompra.getText(), tfTitulo.getText(), tfAutor.getText(), precoCusto, tfTipoPagtoLivro.getText().charAt(0));
				
				if(vendas.add(liv))
				{
					tfFilial.setText("");
					tfIdent.setText("");
					tfDataCompra.setText("");
					tfTitulo.setText("");
					tfAutor.setText("");
					tfPrecoCustoLivro.setText("");
					tfTipoPagtoLivro.setText("");
					JOptionPane.showMessageDialog(null,"Adicionado");
				}
			}//if rbLivro
			
			if (rbNotebook.isSelected()) {
				precoCusto = 0.0;
				Notebook not;
				
				try {
					precoCusto = Double.parseDouble(tfPrecoCustoNotebook.getText());
				} catch (NumberFormatException erro) {
					JOptionPane.showMessageDialog(null,"Use apenas números");
					return;
				}

				
				not = new Notebook(tfFilial.getText(), tfIdent.getText(), tfDataCompra.getText(), tfFabricante.getText(), tfMemoria.getText(), tfSistemOperac.getText(), tfProcessador.getText(), precoCusto, tfTipoPagtoNotebook.getText().charAt(0));
				
				if(vendas.add(not))
				{
					tfFilial.setText("");
					tfIdent.setText("");
					tfDataCompra.setText("");
					tfFabricante.setText("");
					tfMemoria.setText("");
					tfMonitor.setText("");
					tfSistemOperac.setText("");
					tfProcessador.setText("");
					tfPrecoCustoNotebook.setText("");
					tfTipoPagtoNotebook.setText("");
					JOptionPane.showMessageDialog(null,"Adicionado");
				}
			}//if rbNotebook
		}
		
		if (e.getSource() == btnRelat) {

			String saida="\n Vendas: \n";

			for(int i=0; i < vendas.size(); i++) {
				saida += "pos: " + i + vendas.get(i).toString() + "\n\n";
			}
			JTextArea area = new JTextArea(saida,30,70);
			JOptionPane.showMessageDialog(null,area);
		} 
	}
	public static void main(String[] args) {
		Tela t = new Tela();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setVisible(true);
		t.setSize(1000,500);
		t.setLocation(200,200);
	}

}
