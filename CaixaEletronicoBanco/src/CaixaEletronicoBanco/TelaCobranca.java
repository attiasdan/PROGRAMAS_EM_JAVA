package CaixaEletronicoBanco;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class TelaCobranca extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	List <Cliente> listaCli = new ArrayList<Cliente>();
	List <Pagamento> lista = new ArrayList<Pagamento>();
	
    JTabbedPane tabPainel;
    JPanel painelCli, painelPagto;
    JComboBox cComboCli;
    Cliente c = null;
    JButton btInsCli, btInsPagto, btRelat;
    JTextField tnome,tender,tcity, tdata, tvalor,tPrimCar,tSegCar,tPrimChe,tSegChe;
    JRadioButton rbDin, rbCar, rbChe;
    
    public TelaCobranca(){
		super("Tipos de Pagamento de Clientes - Exemplo Abstrata");
   	    setLayout(new BorderLayout());
   	    TelaCliente();
   	    TelaPagamento();
   	    tabPainel = new JTabbedPane();
   	    tabPainel.addTab("Cadastro Cliente",null,painelCli,"Cliente");
   	    tabPainel.addTab("Pagamento do Cliente",null,painelPagto,"Pagamento");
   	    add(tabPainel,BorderLayout.CENTER);
	}    
   	    
    
    public void TelaCliente() {
    	painelCli = new JPanel(new FlowLayout());
    	JPanel painelaux = new JPanel(new GridLayout(3,2,2,2));
    	JLabel lnome = new  JLabel("Nome....:",SwingConstants.RIGHT);
    	JLabel lender = new JLabel("Endereco:",SwingConstants.RIGHT);
    	JLabel lcidade =new JLabel("Cidade..:",SwingConstants.RIGHT);
    	tnome = new JTextField(30);
    	tender = new JTextField(30);
    	tcity = new JTextField(30);
    	painelaux.add(lnome);painelaux.add(tnome);
    	painelaux.add(lender);painelaux.add(tender);
    	painelaux.add(lcidade);painelaux.add(tcity);
    	btInsCli = new JButton("Insere Cliente");
    	painelCli.add(painelaux);
    	painelCli.add(btInsCli);
    	
    	btInsCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				/* Pega os dados dos campos tnome, tender, tcity
				 * insere na lista: 'listaCli'
				 * Pega o nome do cliente e insere no ComboBox: cComboCli
				 * */
				Cliente c = new Cliente(tnome.getText(),tender.getText(),tcity.getText()); 
				listaCli.add(c);
				cComboCli.addItem(c.getNome());
				JOptionPane.showMessageDialog(null,"cliente adicionado!");
				tnome.setText("");
				tender.setText("");
				tcity.setText("");
			}
    	});
    	
    }//TelaCliente
      
	public void TelaPagamento() { 
		painelPagto = new JPanel(new GridLayout());
		
		JPanel painelPrin = new JPanel(new GridLayout(3,2,3,3));
		JLabel ldata = new JLabel("Data de Pagto: ",SwingConstants.RIGHT);
		tdata = new JTextField(25);
		painelPrin.add(ldata);painelPrin.add(tdata);
		
		JLabel lvalor = new JLabel("Valor Pago: ",SwingConstants.RIGHT);
		tvalor = new JTextField(25);
		painelPrin.add(lvalor);painelPrin.add(tvalor);
			
		JLabel x1 = new JLabel("Escolha o cliente",SwingConstants.RIGHT);
		cComboCli = new JComboBox();
		cComboCli.setMaximumRowCount(4);
		painelPrin.add(x1);
		painelPrin.add(cComboCli);
		
		JPanel prox = new JPanel(new FlowLayout());
		prox.add(painelPrin);
			
		JLabel lforma = new JLabel("Forma de Pagto..: ",SwingConstants.LEFT);
		JPanel painelforma = new JPanel(new GridLayout(4,1,1,1));
		painelforma.add(lforma);
		ButtonGroup grupo = new ButtonGroup();
		rbDin = new JRadioButton("Dinheiro",false);
		rbChe= new JRadioButton("Cheque",false);
		rbCar = new JRadioButton("Cartão",false);
		grupo.add(rbDin);grupo.add(rbChe);grupo.add(rbCar);
		rbDin.addItemListener(new EventosRadio());
		rbChe.addItemListener(new EventosRadio());
		rbCar.addItemListener(new EventosRadio());
		painelforma.add(rbDin);
		painelforma.add(rbChe);
		painelforma.add(rbCar);
		prox.add(painelforma);
			
		JPanel painelCartao = new JPanel(new GridLayout(4,2,1,1));
		JLabel xCar = new JLabel("Nro.Cartão........: ",SwingConstants.RIGHT);
		JLabel xChe = new JLabel("Nro.Cheque........: ",SwingConstants.RIGHT);
		tPrimCar = new JTextField(20);
		JLabel xOper = new JLabel("Operadora.........: ",SwingConstants.RIGHT);
		JLabel xBan =  new JLabel("Banco.............: ",SwingConstants.RIGHT);
		tSegCar = new JTextField(20);
		tPrimChe = new JTextField(20);
		tSegChe = new JTextField(20);
		painelCartao.add(xCar);
		painelCartao.add(tPrimCar);
		painelCartao.add(xOper);
		painelCartao.add(tSegCar);
		painelCartao.add(xChe);
		painelCartao.add(tPrimChe);
		painelCartao.add(xBan);
		painelCartao.add(tSegChe);
		prox.add(painelCartao);
		
		btInsPagto = new JButton("Insere Pagto");
		btRelat = new JButton("Relatorio");
		prox.add(btInsPagto);
		prox.add(btRelat);
		painelPagto.add(prox); 
		
		cComboCli.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED) {
				int posicao = cComboCli.getSelectedIndex();
				c = listaCli.get(posicao);
				}
			}
		});
		btRelat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saida = "";
				int i = 0;
				
				for(Pagamento p : lista) {
					saida += "Posição: "+i+" - "+p.toString()+"\n";
					i++;
				}
				JOptionPane.showMessageDialog(null, saida);
			}
		});
		btInsPagto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				float tval = Float.parseFloat(tvalor.getText());
				
				if (rbDin.isSelected()) {
					Dinheiro d = new Dinheiro(tdata.getText(), c, tval);
					lista.add(d);
					
					JOptionPane.showMessageDialog(null,"dinheiro inserido");
				}
				if (rbCar.isSelected()) {					 
					Cartao car = new Cartao(tdata.getText(), c, tval, tPrimCar.getText(), tSegCar.getText());
					lista.add(car);
					
					JOptionPane.showMessageDialog(null,"cartao inserido");
				}
				if (rbChe.isSelected()) {
					
					int ch = Integer.parseInt(tPrimChe.getText());
					int ba = Integer.parseInt(tSegChe.getText());
					
					Cheque che = new Cheque(tdata.getText(), c, tval, ch, ba);
					lista.add(che);
					
					JOptionPane.showMessageDialog(null,"cheque inserido");
				}
			}
		});
		
	}//TelaPagamento
	
	private class EventosRadio implements ItemListener
	{		
		public void itemStateChanged(ItemEvent e)
		{
			if (rbDin.isSelected()) {
				tPrimCar.setVisible(false);
				tSegCar.setVisible(false);
				tPrimChe.setVisible(false);
				tSegChe.setVisible(false);
			}
			if (rbCar.isSelected()) {
				tPrimCar.setVisible(true);
				tSegCar.setVisible(true);
				tPrimChe.setVisible(false);
				tSegChe.setVisible(false);
			}
			if (rbChe.isSelected()) {
				tPrimCar.setVisible(false);
				tSegCar.setVisible(false);
				tPrimChe.setVisible(true);
				tSegChe.setVisible(true);
			}	
		}
	}
	
	public static void main(String[] args) {
	   TelaCobranca j = new TelaCobranca();
	   j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   j.setSize(600,350);
	   j.setLocation(300, 200);
	   j.setVisible(true);
	}
}
