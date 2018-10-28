package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javafx.scene.text.Font;

public class InstanciaContaFrame extends JFrame{
	
	private final String[] textVar = {"Nome", "Número", "Limite", "Taxa"};
	private int maxForms = textVar.length;
	public int c;

	public InstanciaContaFrame(String qualConta, Dimension dimensaoFrame, GerenteJFrame jsource) {
		super("Criação de Conta");
		URL iconURL = getClass().getResource("iconMB.png");
		ImageIcon iconFrame = new ImageIcon(iconURL);
		super.setIconImage(iconFrame.getImage());
		super.setLayout(new BorderLayout());
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(300,300);
		super.setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		
		JPanel layoutPanel = new JPanel(new SpringLayout());
		layoutPanel.setBackground(Color.ORANGE);
		layoutPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		JPanel topText = new JPanel();
		topText.setBackground(new Color(186, 138, 82));
		topText.setAlignmentY(topText.getAlignmentY()/4);
		JLabel tipoConta = new JLabel(qualConta.toString());
		tipoConta.setHorizontalAlignment(SwingConstants.CENTER);
		tipoConta.setFont(MenuFrame.bankFont.deriveFont(1, 20));
		topText.add(tipoConta);
		
		add(topText,BorderLayout.NORTH);
		
		JTextField entradaDados[] = new JTextField[4];
		
		for(int i=0;i<maxForms;i++)
		{
			JLabel textoAtual = new JLabel(textVar[i], JLabel.TRAILING);
			textoAtual.setFont(MenuFrame.bankFont);
			layoutPanel.add(textoAtual);
			entradaDados[i] = new JTextField(10);
			if(i==1)
			{
				entradaDados[i].setEditable(false);
				entradaDados[i].setBackground(new Color(186, 138, 82));
				entradaDados[i].setText(SistemaBancario.getNumConta());
			}
			layoutPanel.add(entradaDados[i]);
		}
		
		switch(qualConta.toString())
		{
		case "Conta Simples":
			for(int i=2; i<=3;i++)
			{
				entradaDados[i].setEditable(false);
				entradaDados[i].setBackground(new Color(186, 138, 82));
				entradaDados[i].setText("Conta não suportada");
			}
			break;
		case "Conta Especial":
			entradaDados[3].setEditable(false);
			entradaDados[3].setBackground(new Color(186, 138, 82));
			entradaDados[3].setText("Conta não suportada");
			break;
		case "Conta Poupança":
			entradaDados[2].setEditable(false);
			entradaDados[2].setBackground(new Color(186, 138, 82));
			entradaDados[2].setText("Conta não suportada");
			break;
		}
		
		SpringUtilities.makeCompactGrid(layoutPanel, maxForms, 2, 10, 10, 6, 6);
	
		add(layoutPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(186, 138, 82));
		JButton send = new JButton("Criar");
		send.setAlignmentX(CENTER_ALIGNMENT);
		buttonPanel.setPreferredSize(new Dimension(50,50));
		
		buttonPanel.add(send);
		
		add(buttonPanel,BorderLayout.SOUTH);
		
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				boolean sucesso=false;
				// TODO Auto-generated method stub				
				//SistemaBancario.getInstanceContaArray();
				//qualConta.replaceAll("\\s+","");
				switch(qualConta)
				{
				case "Conta Simples":
					if(!entradaDados[0].getText().equals(""))
					{
						SistemaBancario.setContaSimples(entradaDados[0].getText());
						JOptionPane.showMessageDialog(null,qualConta + " criada com sucesso!","Informativo sobre " + qualConta,JOptionPane.INFORMATION_MESSAGE);
						sucesso=true;
					}
					else JOptionPane.showMessageDialog(null,"Informe algum nome. Valor nulo é inválido!","Informativo sobre " + qualConta,JOptionPane.ERROR_MESSAGE);
					break;
				case "Conta Poupança":
					if(!entradaDados[0].getText().equals("") && !entradaDados[3].getText().equals(""))
					{	
						try
						{
							float floatNum = Float.parseFloat(entradaDados[3].getText());
							SistemaBancario.setContaPoupança(entradaDados[0].getText(), floatNum);
							JOptionPane.showMessageDialog(null,qualConta + " criada com sucesso!","Informativo sobre " + qualConta,JOptionPane.INFORMATION_MESSAGE);
							sucesso=true;
						}
						catch(NumberFormatException e)
						{
							JOptionPane.showMessageDialog(null,"Entrada inválida! Campo \"Taxa\" deve conter um valor inteiro/decimal","Informativo sobre " + qualConta,JOptionPane.ERROR_MESSAGE);
							System.err.println(e);
						}
					}
					else JOptionPane.showMessageDialog(null,"Preencha todos os campos!","Informativo sobre " + qualConta,JOptionPane.ERROR_MESSAGE);
					break;
				case "Conta Especial":
					if(!entradaDados[0].getText().equals("") && !entradaDados[2].getText().equals(""))
					{
						try
						{
							int intNum = Integer.parseInt(entradaDados[2].getText());
							SistemaBancario.setContaEspecial(entradaDados[0].getText(),intNum);
							JOptionPane.showMessageDialog(null,qualConta + " criada com sucesso!","Informativo sobre " + qualConta,JOptionPane.INFORMATION_MESSAGE);
							sucesso=true;
						}
						catch(NumberFormatException e)
						{
							JOptionPane.showMessageDialog(null,"Entrada inválida! Campo \"Limite\" deve conter um valor inteiro","Informativo sobre " + qualConta,JOptionPane.ERROR_MESSAGE);
							System.err.println(e);
						}
					}
					else JOptionPane.showMessageDialog(null,"Preencha todos os campos!","Informativo sobre " + qualConta,JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				if(sucesso)
					{
						jsource.setEnabled(true);
						dispose();
					}				
			}
		});
		
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
