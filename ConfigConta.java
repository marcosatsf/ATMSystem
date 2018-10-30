package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class ConfigConta extends JFrame{

	public JList colorList;
	public final String[] corLista = {
			"Branco", "Vermelho", "Magenta", "Laranja", "Verde", "Azul", "Amarelo","Rosa","Ciano","Cinza",
			"Cinza claro"};
	public final Color[] corListaChoose = {Color.WHITE,new Color(165, 0, 1),  Color.MAGENTA, Color.ORANGE, new Color(55, 141, 59),new Color(45, 77, 157),Color.YELLOW,
			Color.PINK,Color.CYAN,Color.GRAY,Color.LIGHT_GRAY};
	public final Color[] corListaChooseDark = {Color.LIGHT_GRAY,new Color(83, 0, 1), new Color(144, 13, 136), new Color(186, 138, 82),new Color(0, 90, 16), new Color(0, 0, 88),new Color(184, 153, 0),
			new Color(184, 0, 159), new Color(47, 102, 159), new Color(66, 5, 5),new Color(35, 70, 88)};
	public final String[] textVarSenha = {"Senha atual","Nova senha"};
	
	public JPanel accountPanel, layoutPanel, passPanel,buttonPanel;
	
	public ConfigConta(Dimension dimensaoFrame, Conta account, JFrame jsource, JPanel menuPanel, JPanel menuButtons, JPanel accountPanel2, JPanel withdrawPanel, JPanel depositPanel, JPanel accountMenu, JTextArea infoConta) {
		// TODO Auto-generated constructor stub
		super("Configuração da conta " + account.getNumConta());
		URL iconURL = getClass().getResource("iconMB.png");
		ImageIcon iconFrame = new ImageIcon(iconURL);
		super.setIconImage(iconFrame.getImage());
		super.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,5,10,5);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(500,240);
		super.setResizable(false);
		getContentPane().setBackground(account.getAuxcor());
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		
		//chgColor		
		accountPanel = new JPanel(new BorderLayout());
		accountPanel.setPreferredSize(new Dimension(230,180));
		accountPanel.setBorder(MenuFrame.borderVis);
		accountPanel.setBackground(account.getCor());
		JLabel colorListText = new JLabel();
		colorListText.setFont(MenuFrame.bankFont.deriveFont(1, 20));
		colorListText.setHorizontalAlignment(SwingConstants.CENTER);
		colorListText.setText("Selecione a cor");
		colorList = new JList(corLista);
		colorList.setVisibleRowCount(3);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton chgColor = new JButton("Mudar");
		chgColor.setPreferredSize(new Dimension(100,30));
		
		chgColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				ConfigConta.this.getContentPane().setBackground(corListaChooseDark[colorList.getSelectedIndex()]);
				ConfigConta.this.accountPanel.setBackground(corListaChoose[colorList.getSelectedIndex()]);
				ConfigConta.this.layoutPanel.setBackground(corListaChoose[colorList.getSelectedIndex()]);
				ConfigConta.this.passPanel.setBackground(corListaChoose[colorList.getSelectedIndex()]);
				ConfigConta.this.buttonPanel.setBackground(corListaChoose[colorList.getSelectedIndex()]);
				account.setCor(corListaChoose[colorList.getSelectedIndex()]);
				account.setAuxcor(corListaChooseDark[colorList.getSelectedIndex()]);
			}
		});
		
		//chgPassword
		layoutPanel = new JPanel(new BorderLayout());
		layoutPanel.setPreferredSize(new Dimension(230,180));
		layoutPanel.setBackground(account.getCor());
		layoutPanel.setBorder(MenuFrame.borderVis);
		
		passPanel = new JPanel(new SpringLayout());
		passPanel.setBackground(account.getCor());
		passPanel.setBorder(MenuFrame.borderVis);
		
		JLabel tipoConta = new JLabel("Alteração de senha");
		tipoConta.setHorizontalAlignment(SwingConstants.CENTER);
		tipoConta.setFont(MenuFrame.bankFont.deriveFont(1, 20));
		
		JPasswordField entradaDados[] = new JPasswordField[2];
		for(int i=0;i<2;i++)
		{
			JLabel textoAtual = new JLabel(textVarSenha[i], JLabel.TRAILING);
			textoAtual.setFont(MenuFrame.bankFont);
			passPanel.add(textoAtual);
			entradaDados[i] = new JPasswordField(10);
			passPanel.add(entradaDados[i]);
		}
		
		SpringUtilities.makeCompactGrid(passPanel, 2, 2, 10, 10, 6, 6);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(account.getCor());
		JButton changePass = new JButton("Alterar");
		changePass.setAlignmentX(CENTER_ALIGNMENT);
		buttonPanel.setPreferredSize(new Dimension(50,50));
		buttonPanel.add(changePass, BorderLayout.CENTER);
	
		accountPanel.add(colorListText, BorderLayout.PAGE_START);
		accountPanel.add(new JScrollPane(colorList), BorderLayout.CENTER);
		accountPanel.add(chgColor, BorderLayout.PAGE_END);
		
		layoutPanel.add(tipoConta, BorderLayout.PAGE_START);
		layoutPanel.add(passPanel, BorderLayout.CENTER);
		layoutPanel.add(buttonPanel, BorderLayout.PAGE_END);
		
		add(accountPanel, c);
		add(layoutPanel, c);
		
		changePass.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(!entradaDados[0].getText().equals("") || !entradaDados[1].getText().equals(""))
					{
						try
						{
							account.alteraSenha(entradaDados[0].getText(), entradaDados[1].getText());
							JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!","Informativo sobre mudança de senha",JOptionPane.INFORMATION_MESSAGE);
						}
						catch(NotTheSamePassword e)
						{
							JOptionPane.showMessageDialog(null,"Não foi possível alterar a senha pois a atual está incorreta!","Informativo sobre mudança de senha",JOptionPane.ERROR_MESSAGE);
							System.err.println(e);
						}
					}
					else JOptionPane.showMessageDialog(null,"Campo nulo encontrado, insira todas as informações!","Informativo sobre mudança de senha",JOptionPane.WARNING_MESSAGE);
				}
		
			}
		);
		
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent event)
			{
				jsource.setEnabled(true);
				menuPanel.setBackground(account.getAuxcor());
				menuButtons.setBackground(account.getAuxcor());
				accountPanel2.setBackground(account.getCor());
				withdrawPanel.setBackground(account.getCor());
				depositPanel.setBackground(account.getCor());
				infoConta.setBackground(account.getAuxcor());
				accountMenu.setBackground(account.getCor());
				//jsource.revalidate();
				//jsource.setVisible(true);
			}
		});
		
		setVisible(true);
	}

}
