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
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ConfigConta extends JFrame{

	private JList colorList;
	private final String[] corLista = {
			"Branco", "Vermelho", "Magenta", "Laranja", "Verde", "Azul", "Amarelo","Rosa","Ciano","Cinza",
			"Cinza claro", "Cinza escuro"};
private final Color[] corListaChoose = {Color.WHITE,Color.RED, Color.MAGENTA, Color.ORANGE, Color.GREEN,Color.BLUE,Color.YELLOW,
			Color.PINK,Color.CYAN,Color.LIGHT_GRAY,Color.DARK_GRAY};
	private final String[] textVarSenha = {"Senha atual","Senha antiga"};
	
	public ConfigConta(Dimension dimensaoFrame, Conta account, JFrame jsource) {
		// TODO Auto-generated constructor stub
		super("Configuração da conta " + account.getNumConta());
		URL iconURL = getClass().getResource("iconMB.png");
		ImageIcon iconFrame = new ImageIcon(iconURL);
		super.setIconImage(iconFrame.getImage());
		super.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,5,10,5);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(400,240);
		super.setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		
		JPanel options = new JPanel(new FlowLayout());
		options.setBorder(MenuFrame.borderVis);
		options.setBackground(Color.ORANGE);
		JLabel whichOption = new JLabel();
		whichOption.setFont(MenuFrame.bankFont);
		
		JPanel accountPanel = new JPanel(new FlowLayout());
		accountPanel.setPreferredSize(new Dimension(230,180));
		accountPanel.setBorder(MenuFrame.borderVis);
		accountPanel.setBackground(Color.ORANGE);
		JLabel colorListText = new JLabel();
		colorListText.setFont(MenuFrame.bankFont);
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
				ConfigConta.this.getContentPane().setBackground(corListaChoose[colorList.getSelectedIndex()]);
			}
		});
		
		JPanel layoutPanel = new JPanel(new SpringLayout());
		layoutPanel.setBackground(Color.ORANGE);
		layoutPanel.setBorder(MenuFrame.borderVis);
		
		JPanel topText = new JPanel();
		topText.setBackground(new Color(186, 138, 82));
		topText.setAlignmentY(topText.getAlignmentY()/4);
		JLabel tipoConta = new JLabel("Configuração");
		tipoConta.setHorizontalAlignment(SwingConstants.CENTER);
		tipoConta.setFont(MenuFrame.bankFont.deriveFont(1, 20));
		topText.add(tipoConta);
		
		add(topText,BorderLayout.NORTH);
		
		JTextField entradaDados[] = new JTextField[2];
		for(int i=0;i<2;i++)
		{
			JLabel textoAtual = new JLabel(textVarSenha[i], JLabel.TRAILING);
			textoAtual.setFont(MenuFrame.bankFont);
			layoutPanel.add(textoAtual);
			entradaDados[i] = new JTextField(10);
			layoutPanel.add(entradaDados[i]);
		}
		
		SpringUtilities.makeCompactGrid(layoutPanel, 2, 2, 10, 10, 6, 6);
	
		whichOption.add(colorListText);
		whichOption.add(new JScrollPane(colorList));
		
		accountPanel.add(accountText);
		accountPanel.add(accountSelected);	
		
		add(whichAccountPanel, c);
		add(accountPanel, c);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(186, 138, 82));
		JButton set = new JButton("Criar");
		set.setAlignmentX(CENTER_ALIGNMENT);
		buttonPanel.setPreferredSize(new Dimension(50,50));
		
		buttonPanel.add(set);
		
		add(buttonPanel,BorderLayout.SOUTH);
		
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent event)
			{
				jsource.setEnabled(true);
				dispose();
			}
		});
		
	}

}
