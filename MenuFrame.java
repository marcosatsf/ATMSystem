package programa;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;


public class MenuFrame extends JFrame{
	
	public Font bankFont;
	public GridLayout gridLayout = new GridLayout(1,4);
	public Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
	
	public MenuFrame(){
		super("Banco MBank");
		super.setLayout(gridLayout);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(500,500);
		super.setVisible(true);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		this.setLocation((dimensao.width - this.getSize().width)/2, (dimensao.height - this.getSize().height)/2);
		
		UIManager.LookAndFeelInfo[] styles = UIManager.getInstalledLookAndFeels();
		try
		{
			UIManager.setLookAndFeel(styles[1].getClassName());
		}
		catch(Exception NotStyle)
		{
			NotStyle.printStackTrace();
		}
		
		getContentPane().setLayout(null);
		
		URL url = this.getClass().getResource("mbank.gif");
		Icon myImgIcon = new ImageIcon(url);
		JLabel imageLbl = new JLabel(myImgIcon);
		imageLbl.setBounds(50, 30, 400, 100);
		add(imageLbl);
		
		JLabel frontText = new JLabel("Bem-Vindo ao seu banco!");
		JLabel auxText = new JLabel("Escolha uma das opções abaixo: ");
				
		bankFont = new Font("Trebuchet MS", Font.BOLD, 10);
		
		frontText.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		auxText.setFont(bankFont);
		frontText.setBounds(100,150,300,50);
		frontText.setHorizontalAlignment(SwingConstants.CENTER);
		
		auxText.setBounds(100,200,300,50);
		auxText.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(frontText);
		add(auxText);
		
		JButton gerente = new JButton("Gerente");
		JButton cliente = new JButton("Cliente");
		
		gerente.setBounds(200,250,100,50);
		cliente.setBounds(200,330,100,50);
		
		add(gerente);
		add(cliente);
		
		getContentPane().setBackground(Color.ORANGE);

		
		gerente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				GerenteJFrame subGerente = new GerenteJFrame();
				subGerente.setLocationRelativeTo(frontText);
				setVisible(false);
				//dispose();
			}
		});
		
		cliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				ClienteJFrame subCliente = new ClienteJFrame();
				subCliente.setSize(500,500);
				subCliente.setVisible(true);
				subCliente.setLocationRelativeTo(frontText);
				setVisible(false);
				//dispose();
			}
		});
		//pack();
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent event)
			{
				
				//X on close
			}
		});
	}

}
