package programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VisualizadorFrame extends JFrame{

	private final String[] textVar = {"Nome: ", "Número: ", "Limite: ", "Taxa: "};
	private final int maxForms = textVar.length;
	public int c;
	public JTextArea accountSelected;

	public VisualizadorFrame(String qualVis, Dimension dimensaoFrame, GerenteJFrame jsource) {
		super("Visualização de contas");
		URL iconURL = getClass().getResource("iconMB.png");
		ImageIcon iconFrame = new ImageIcon(iconURL);
		super.setIconImage(iconFrame.getImage());
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setResizable(false);
		getContentPane().setBackground(new Color(186, 138, 82));
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		super.setLayout(new GridBagLayout());
		Conta[] banco = SistemaBancario.getInstanceContaArray();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,5,10,5);
		JPanel whichAccountPanel = new JPanel(new FlowLayout());
		whichAccountPanel.setBorder(MenuFrame.borderVis);
		whichAccountPanel.setBackground(Color.ORANGE);
		JLabel whichAccountText = new JLabel();
		whichAccountText.setFont(MenuFrame.bankFont);
		
		//"Visualizar uma conta do sistema","Visualizar todas as contas do sistema"
		switch(qualVis)
		{
		case "Visualizar uma conta do sistema":
			super.setSize(400,240);
			
			String[] numerosConta = new String[SistemaBancario.tamanho];
			for(int i=0;i<SistemaBancario.num;i++) numerosConta[i] = new String(banco[i].getNumConta());
			
			whichAccountPanel.setPreferredSize(new Dimension(140,180));
			whichAccountText.setText("Selecione a conta");
			
			JList whichAccount = new JList(numerosConta);
			whichAccount.setFixedCellWidth(130);
			whichAccount.setVisibleRowCount(6);
			whichAccount.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JPanel accountPanel = new JPanel(new FlowLayout());
			accountPanel.setPreferredSize(new Dimension(230,180));
			accountPanel.setBorder(MenuFrame.borderVis);
			accountPanel.setBackground(Color.ORANGE);
			
			JLabel accountText = new JLabel("Info da conta");
			accountText.setFont(MenuFrame.bankFont);
			accountSelected = new JTextArea(6,16);
			accountSelected.setBackground(new Color(186, 138, 82));
			//accountSelected.setEnabled(false);
			accountSelected.setFont(MenuFrame.bankFont);
			accountSelected.setLineWrap(true);
			accountSelected.setText("Escolha uma das contas para visualizar!");
			
			
			whichAccount.addListSelectionListener(
					new ListSelectionListener()
					{
						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							accountSelected.setText(banco[whichAccount.getSelectedIndex()].printConta());
						}
					}
					);
			whichAccountPanel.add(whichAccountText);
			whichAccountPanel.add(new JScrollPane(whichAccount));
			
			accountPanel.add(accountText);
			accountPanel.add(accountSelected);	
			
			add(whichAccountPanel, c);
			add(accountPanel, c);
			
			break;
		case "Visualizar todas as contas do sistema":
			super.setSize(250,400);
			whichAccountPanel.setPreferredSize(new Dimension(230,350));
			
			whichAccountText.setText("Conta(s) encontrada(s): " + SistemaBancario.num);
			accountSelected = new JTextArea(16,15);
			accountSelected.setBackground(new Color(186, 138, 82));
			accountSelected.setFont(MenuFrame.bankFont);
			accountSelected.setLineWrap(true);
			
			accountSelected.setText(banco[0].printConta());
			for(int i=1;i<SistemaBancario.num;i++)
			{
				accountSelected.append("\n----------------------------------\n");
				accountSelected.append(banco[i].printConta());
			}
			
			whichAccountPanel.add(whichAccountText);
			whichAccountPanel.add(new JScrollPane(accountSelected));
			
			add(whichAccountPanel, c);
			break;
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
