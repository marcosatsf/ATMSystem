package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javafx.scene.text.Font;

public class InstaciaContaFrame extends JFrame{

	public InstaciaContaFrame(String qualConta, Dimension dimensaoFrame, GerenteJFrame jsource) {
		super("Criação de Conta");
		super.setLayout(new FlowLayout());
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(300,300);
		super.setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		
		SistemaBancario.getInstanceContaArray();
		
		JPanel gridLayoutPanel = new JPanel(new GridLayout(5,1));
		
		
		JLabel tipoConta = new JLabel(qualConta.toString());
		tipoConta.setHorizontalAlignment(SwingConstants.CENTER);
		tipoConta.setFont(MenuFrame.bankFont);
		gridLayoutPanel.add(tipoConta);
		
		
		JPanel infoText1 = new JPanel(new FlowLayout());
		JLabel nomeText = new JLabel("Nome: ");
		nomeText.setFont(MenuFrame.bankFont);
		nomeText.setAlignmentX(LEFT_ALIGNMENT);
		JTextField nomeTextInsert = new JTextField("Insira seu nome aqui!");
		nomeTextInsert.setAlignmentX(RIGHT_ALIGNMENT);
		
		infoText1.add(nomeText);
		infoText1.add(nomeTextInsert);
		gridLayoutPanel.add(infoText1);
		
		
		JPanel infoText2 = new JPanel(new FlowLayout());
		JLabel numContaInfo = new JLabel("Número conta: ");
		numContaInfo.setFont(MenuFrame.bankFont);
		numContaInfo.setAlignmentX(LEFT_ALIGNMENT);
		JTextField numContaTextInsert = new JTextField(SistemaBancario.getNumConta(), 5);
		numContaTextInsert.setEditable(false);
		numContaTextInsert.setHighlighter(null);
		numContaTextInsert.setHorizontalAlignment(JTextField.LEADING);
		numContaTextInsert.setAlignmentX(RIGHT_ALIGNMENT);
		//numContaTextInsert.setForeground(new Color(165,104,54)); RGB
		
		infoText2.add(numContaInfo);
		infoText2.add(numContaTextInsert);
		gridLayoutPanel.add(infoText2);
		
		
		JPanel infoText3 = new JPanel(new FlowLayout());
		JLabel limiteInfo = new JLabel("Limite: ");
		limiteInfo.setFont(MenuFrame.bankFont);
		limiteInfo.setAlignmentX(LEFT_ALIGNMENT);
		JTextField limiteInfoTextInsert = new JTextField(5);
		limiteInfoTextInsert.setEditable(false);
		limiteInfoTextInsert.setHighlighter(null);
		limiteInfoTextInsert.setAlignmentX(RIGHT_ALIGNMENT);
		//LimiteInfoTextInsert.setForeground(new Color(165,104,54));
		
		infoText3.add(limiteInfo);
		infoText3.add(limiteInfoTextInsert);
		gridLayoutPanel.add(infoText3);
	
		add(gridLayoutPanel);
		
		
		JPanel infoText4 = new JPanel(new FlowLayout());
		JLabel taxaInfo = new JLabel("Taxa: ");
		taxaInfo.setFont(MenuFrame.bankFont);
		taxaInfo.setAlignmentX(LEFT_ALIGNMENT);
		JTextField taxaInfoTextInsert = new JTextField(5);
		taxaInfoTextInsert.setEditable(false);
		taxaInfoTextInsert.setHighlighter(null);
		taxaInfoTextInsert.setAlignmentX(RIGHT_ALIGNMENT);
		//LimiteInfoTextInsert.setForeground(new Color(165,104,54));
		
		infoText4.add(taxaInfo);
		infoText4.add(taxaInfoTextInsert);
		gridLayoutPanel.add(infoText4);
	
		add(gridLayoutPanel);
		
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.setMinimumSize(new Dimension(100,80));
		JButton send = new JButton("Criar");
		send.setAlignmentX(CENTER_ALIGNMENT);
		
		buttonPanel.add(send);
		
		add(buttonPanel,BorderLayout.PAGE_END);
		
		
		qualConta.replaceAll("\\s+","");
		try {
			Object xyz = Class.forName(qualConta).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent event)
			{
				jsource.setEnabled(true);
				//X on close
			}
		});		
		
		setVisible(true);
		
	}

}
