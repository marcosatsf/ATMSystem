package programa;

import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;


public class MenuFrame extends JFrame{
	
	public static MenuFrame instancia=null;
	public static Font bankFont = new Font("Trebuchet MS", Font.BOLD, 14);
	public GridLayout gridLayout = new GridLayout(4,1,30,10);
	public Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
	
	private MenuFrame(){
		super("Banco MBank");
		URL iconURL = getClass().getResource("iconMB.png");
		ImageIcon iconFrame = new ImageIcon(iconURL);
		super.setIconImage(iconFrame.getImage());
		super.setLayout(new GridLayout(2,1));
		getContentPane().setBackground(Color.ORANGE);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(500,500);
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
				
		JPanel painelBanner = new JPanel(new BorderLayout());
		painelBanner.setBackground(Color.ORANGE);
		//painelBanner.setAlignmentY(BOTTOM_ALIGNMENT);
		/*
		 * Inicio da inserção do GIF
		 */		
		URL url = this.getClass().getResource("mbank.gif");
		Icon myImgIcon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(myImgIcon);
		imageLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		//imageLabel.setBounds(50, 30, 400, 100);
		//Fim
		JLabel frontText = new JLabel("Bem-Vindo ao seu banco!");
		frontText.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		frontText.setHorizontalAlignment(SwingConstants.CENTER);
		frontText.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel painel = new JPanel(new GridLayout(2,1));
		painel.setLayout(gridLayout);
		painel.setBackground(Color.ORANGE);
		painel.setPreferredSize(new Dimension(100,50));
		
		JPanel painelButton = new JPanel(new FlowLayout());
		painelButton.setBackground(Color.ORANGE);
		
		JLabel auxText = new JLabel("Escolha uma das opções abaixo: ");
		auxText.setFont(bankFont);
		auxText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton gerente = new JButton("Gerente");
		gerente.setPreferredSize(new Dimension(100,40));
		
		JButton cliente = new JButton("Cliente");
		cliente.setPreferredSize(new Dimension(100,40));
		
		painelBanner.add(frontText, BorderLayout.PAGE_END);
		painelBanner.add(imageLabel, BorderLayout.CENTER);
		add(painelBanner);
		
		painel.add(auxText);
		painelButton.add(gerente);
		painelButton.add(cliente);
		painel.add(painelButton);
		add(painel);
		
		gerente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				GerenteJFrame subGerente = new GerenteJFrame(dimensao, MenuFrame.this);
				setVisible(false);
				//dispose();
			}
		});
		
		cliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				ClienteJFrame subCliente = new ClienteJFrame(dimensao, MenuFrame.this);
				setVisible(false);
				//dispose();
			}
		});
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent event)
			{
				
				//X on close
			}
		});
		
		super.setVisible(true);
	}
	
	public static MenuFrame getMenuFrame()
	{
		if(instancia==null)
		{
			return new MenuFrame();
		}
		else return instancia;
	}

}
