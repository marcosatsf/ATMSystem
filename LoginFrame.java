package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class LoginFrame extends JFrame{

	private int frameWidth = 500;
	private int frameHeight = 500;
	private int menuHeight = 40;
	
	public LoginFrame(Dimension dimensaoFrame, JFrame jsource, Conta account) {
		// TODO Auto-generated constructor stub
		super("Bem-vindo(a), " + account.getNomeCorrentista());
		URL iconURL = getClass().getResource("iconMB.png");
		ImageIcon iconFrame = new ImageIcon(iconURL);
		super.setIconImage(iconFrame.getImage());
		super.setLayout(new BorderLayout());
		JPanel accountMenu = new JPanel(new GridBagLayout());
		accountMenu.setPreferredSize(new Dimension(frameWidth,frameHeight-menuHeight));
		accountMenu.setBackground(Color.ORANGE);
		GridBagConstraints modifier = new GridBagConstraints();
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.setSize(frameWidth,frameHeight);
		super.setResizable(false);
		getContentPane().setBackground(Color.ORANGE);		
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		
		JPanel menuPanel = new JPanel(new BorderLayout());
		menuPanel.setAlignmentY(TOP_ALIGNMENT);
		//menuPanel.setBounds(0, 0, 500, 50);
		menuPanel.setPreferredSize(new Dimension(frameWidth,40));
		menuPanel.setBorder(MenuFrame.borderVis);
		menuPanel.setBackground(new Color(186, 138, 82));
		JLabel infoNome = new JLabel(account.getNomeCorrentista());
		infoNome.setFont(MenuFrame.bankFont.deriveFont(1, 15));
		JPanel menuButtons = new JPanel(new FlowLayout());
		menuButtons.setBackground(new Color(186, 138, 82));
		JButton config = new JButton("Configurações");
		JButton logout = new JButton("Sair");
		
		
		JPanel accountPanel = new JPanel(new FlowLayout());
		accountPanel.setPreferredSize(new Dimension(frameWidth,200));
		accountPanel.setBorder(MenuFrame.borderVis);
		accountPanel.setBackground(Color.ORANGE);
		TitledBorder borderPrefabInfo;
		borderPrefabInfo = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefabInfo.setTitle("Informações sobre a conta");
		borderPrefabInfo.setTitlePosition(TitledBorder.CENTER);
		borderPrefabInfo.setTitleFont(MenuFrame.bankFont);
		accountPanel.setBorder(borderPrefabInfo);
		JTextArea infoConta = new JTextArea(6,30);
		infoConta.setBackground(new Color(186, 138, 82));
		infoConta.setFont(MenuFrame.bankFont);
		infoConta.setLineWrap(true);
		infoConta.setText(account.printConta());
		
		
		JPanel withdrawPanel = new JPanel(new FlowLayout());
		withdrawPanel.setPreferredSize(new Dimension(frameWidth,80));
		withdrawPanel.setBorder(MenuFrame.borderVis);
		withdrawPanel.setBackground(Color.ORANGE);
		TitledBorder borderPrefabW;
		borderPrefabW = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefabW.setTitle("Realizar saque");
		borderPrefabW.setTitlePosition(TitledBorder.CENTER);
		borderPrefabW.setTitleFont(MenuFrame.bankFont);
		withdrawPanel.setBorder(borderPrefabW);
		JTextField withdraw = new JTextField(8);
		JButton whithdrawButton = new JButton("Sacar");
		JLabel quant1 = new JLabel("Quantidade: ");
		quant1.setFont(MenuFrame.bankFont.deriveFont(1, 12));
		
		
		
		JPanel depositPanel = new JPanel(new FlowLayout());
		depositPanel.setPreferredSize(new Dimension(frameWidth,80));
		depositPanel.setBorder(MenuFrame.borderVis);
		depositPanel.setBackground(Color.ORANGE);
		TitledBorder borderPrefabD;
		borderPrefabD = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefabD.setTitle("Realizar depósito");
		borderPrefabD.setTitlePosition(TitledBorder.CENTER);
		borderPrefabD.setTitleFont(MenuFrame.bankFont);
		depositPanel.setBorder(borderPrefabD);
		JTextField deposit = new JTextField(6);
		JButton depositButton = new JButton("Depositar");
		JLabel quant2 = new JLabel("Quantidade: ");
		quant2.setFont(MenuFrame.bankFont.deriveFont(1, 12));
		
		
		modifier.insets = new Insets(0,0,0,0);
		
		modifier.gridx = 0;
		modifier.gridy = 0;
		//modifier.weightx = 0.0;		
		
		menuPanel.add(infoNome, BorderLayout.WEST);
		menuButtons.add(config);
		menuButtons.add(logout);
		menuPanel.add(menuButtons, BorderLayout.EAST);
		add(menuPanel, BorderLayout.PAGE_START);
	
		
		modifier.insets = new Insets(10,0,10,0);
		modifier.fill = GridBagConstraints.HORIZONTAL;
		//modifier.fill = GridBagConstraints.NONE;
		//modifier.gridy = 0;
		//modifier.ipadx = 10;
		//modifier.ipady = 10;	
		
		accountPanel.add(infoConta);	
		accountMenu.add(accountPanel, modifier);
		
		modifier.gridy = 1;
		
		withdrawPanel.add(quant1);
		withdrawPanel.add(withdraw);
		withdrawPanel.add(whithdrawButton);
		accountMenu.add(withdrawPanel, modifier);
		
		modifier.gridy = 2;
		
		depositPanel.add(quant2);
		depositPanel.add(deposit);
		depositPanel.add(depositButton);
		accountMenu.add(depositPanel, modifier);
		
		add(accountMenu);
			
		
		whithdrawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				try
				{
					double sacarDouble = Double.parseDouble(withdraw.getText());
					account.sacar(sacarDouble);
					//JOptionPane.showMessageDialog(null,"","Informativo sobre Conta Especial",JOptionPane.INFORMATION_MESSAGE);
					ProgressoOperacao progress = new ProgressoOperacao("sacado", sacarDouble, dimensaoFrame);
					progress.teste.execute();
					infoConta.setText(account.printConta());
					LoginFrame.this.validate();
				}
				catch(ValorInsuficiente e)
				{
					JOptionPane.showMessageDialog(null,"Impossível sacar esta quantia!","Informativo sobre saque",JOptionPane.ERROR_MESSAGE);
					System.err.println(e);
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,"Informe um valor válido!","Informativo sobre saque",JOptionPane.WARNING_MESSAGE);
					System.err.println(e);
				}
			}
		});	
		
		depositButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				try
				{
					double depositarDouble = Double.parseDouble(deposit.getText());
					account.depositar(depositarDouble);
					//JOptionPane.showMessageDialog(null,"","Informativo sobre Conta Especial",JOptionPane.INFORMATION_MESSAGE);
					ProgressoOperacao progress = new ProgressoOperacao("depositado", depositarDouble, dimensaoFrame);
					progress.teste.execute();					
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,"Informe um valor válido!","Informativo sobre saque",JOptionPane.WARNING_MESSAGE);
					System.err.println(e);
				}
			}
		});
		
		logout.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "Deseja realmente deslogar da sua sessão, " + account.getNomeCorrentista() + "?", "Confirmar logoff",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.YES_OPTION)
				{
					dispose();
					jsource.setVisible(true);
				}
			}
		}
		);
		
		addWindowListener(new java.awt.event.WindowAdapter(){
			boolean notFinished=false;
			@Override
			public void windowClosing(java.awt.event.WindowEvent event)
			{
				JOptionPane.showMessageDialog(null, "Por favor, encerre a sessão clicando no botão abaixo(Sair)", "Tentativa de encerramento", JOptionPane.WARNING_MESSAGE);
				//X on close
			}
		});
		
		setVisible(true);
	}

}
