package programa;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

public class GerenteJFrame extends JFrame{
	
	private JComboBox createOptionsToSelect, visualizeOptionsToSelect;
	private final String[] managerOptions = {"Criação de contas:", "Visualização de contas:", "Aplicar rendimentos (apenas Contas Poupança)", "Cobrança de juros (apenas Contas Especiais)"};
	private final String[] createOptions = {"Conta Simples","Conta Especial","Conta Poupança"};
	private final String[] visualizeOptions = {"Visualizar uma conta do sistema","Visualizar todas as contas do sistema"};
	private final int panelHeight = 40;

	
	public GerenteJFrame(Dimension dimensaoFrame,JFrame jsource)
	{
		super("Gerente");
		URL iconURL = getClass().getResource("iconMB.png");
		ImageIcon iconFrame = new ImageIcon(iconURL);
		super.setIconImage(iconFrame.getImage());
		super.setLayout(new GridBagLayout());
		GridBagConstraints modifier = new GridBagConstraints();
		modifier.insets = new Insets(20,10,20,10);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(500,500);
		super.setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		//JPanel gridLayoutPanel = new JPanel(new GridLayout(4,1));		
		
		//criar contas
		
		JPanel createOptionSelectPanel = new JPanel();
		createOptionSelectPanel.setBackground(Color.ORANGE);
		createOptionSelectPanel.setMaximumSize(new Dimension(dimensaoFrame.width+panelHeight,panelHeight));
		
		TitledBorder borderPrefab1;
		borderPrefab1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefab1.setTitle("Criação de contas");
		borderPrefab1.setTitlePosition(TitledBorder.CENTER);
		borderPrefab1.setTitleFont(MenuFrame.bankFont);
		createOptionSelectPanel.setBorder(borderPrefab1);
		createOptionsToSelect = new JComboBox(createOptions);
		
		JButton createOptionSelectButton = new JButton("Selecionar");
		createOptionSelectButton.setPreferredSize(new Dimension(100,30));
	
		createOptionSelectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				GerenteJFrame.this.setEnabled(false);
				InstanciaContaFrame aux = new InstanciaContaFrame(GerenteJFrame.this.createOptionsToSelect.getSelectedItem().toString(), dimensaoFrame, GerenteJFrame.this);
			}
		});
		
		//visualizar contas
		
		JPanel visualizeOptionSelectPanel = new JPanel();
		visualizeOptionSelectPanel.setBackground(Color.ORANGE);
		visualizeOptionSelectPanel.setMaximumSize(new Dimension(dimensaoFrame.width+panelHeight,panelHeight));
		
		TitledBorder borderPrefab2;
		borderPrefab2 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefab2.setTitle("Visualizar contas");
		borderPrefab2.setTitlePosition(TitledBorder.CENTER);
		borderPrefab2.setTitleFont(MenuFrame.bankFont);
		visualizeOptionSelectPanel.setBorder(borderPrefab2);
		visualizeOptionsToSelect = new JComboBox(visualizeOptions);
		
		JButton visualizeOptionSelectButton = new JButton("Selecionar");
		visualizeOptionSelectButton.setPreferredSize(new Dimension(100,30));
		
		visualizeOptionSelectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				Conta[] teste = SistemaBancario.getInstanceContaArray();
				if(teste[0]!=null)
				{
					GerenteJFrame.this.setEnabled(false);
					VisualizadorFrame aux = new VisualizadorFrame(GerenteJFrame.this.visualizeOptionsToSelect.getSelectedItem().toString(), dimensaoFrame, GerenteJFrame.this);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Não existe contas suficientes. Crie pelo menos uma para utilizar esta função!","Falha na visualização",JOptionPane.WARNING_MESSAGE);
				}
			}
		});	
		
		//aplicar rendimento
		
		JPanel yieldAdd = new JPanel();
		yieldAdd.setBackground(Color.ORANGE);
		yieldAdd.setMaximumSize(new Dimension(dimensaoFrame.width+panelHeight,panelHeight));
		
		TitledBorder borderPrefab3;
		borderPrefab3 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefab3.setTitle("Aplicar rendimentos (apenas para conta Poupança)");
		borderPrefab3.setTitlePosition(TitledBorder.CENTER);
		borderPrefab3.setTitleFont(MenuFrame.bankFont);
		yieldAdd.setBorder(borderPrefab3);
		
		JButton yieldButton = new JButton("Aplicar");
		yieldButton.setPreferredSize(new Dimension(150,30));
		
		yieldButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if(SistemaBancario.hasCP)
				{
					SistemaBancario.aplicarRend();
					JOptionPane.showMessageDialog(null,"Foram aplicados os rendimentos em todas as contas poupanças do sistema!","Informativo sobre Conta Poupança",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Não existe conta poupança suficiente!","Informativo sobre Conta Poupança",JOptionPane.WARNING_MESSAGE);
				}
			}
		});	
		
		//cobrar juros
		
		JPanel chargeInterest = new JPanel();
		chargeInterest.setBackground(Color.ORANGE);
		chargeInterest.setMaximumSize(new Dimension(dimensaoFrame.width+panelHeight,panelHeight));
		
		TitledBorder borderPrefab4;
		borderPrefab4 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefab4.setTitle("Cobrar juros sobre contas em débito (apenas para conta Especial)");
		borderPrefab4.setTitlePosition(TitledBorder.CENTER);
		borderPrefab4.setTitleFont(MenuFrame.bankFont);
		chargeInterest.setBorder(borderPrefab4);
		
		JLabel chargeValueText = new JLabel("Valor da taxa: ");
		chargeValueText.setFont(MenuFrame.bankFont.deriveFont(1, 12));
		
		JTextField chargeValue = new JTextField(8);
		
		JButton chargeInterestButton = new JButton("Cobrar");
		chargeInterestButton.setPreferredSize(new Dimension(150,30));
		
		chargeInterestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if(SistemaBancario.hasCE)
				{
					try
					{
						float taxaNum = Float.parseFloat(chargeValue.toString());
						SistemaBancario.cobrarJuros(taxaNum);
						JOptionPane.showMessageDialog(null,"Foram cobrados juros sobre todas as contas especiais do sistema!","Informativo sobre Conta Especial",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Informe um valor válido!","Informativo sobre Conta Especial",JOptionPane.ERROR_MESSAGE);
						System.err.println(e);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Não existe conta especial suficiente!","Informativo sobre Conta Especial",JOptionPane.WARNING_MESSAGE);
				}
			}
		});	
		
		modifier.fill = GridBagConstraints.HORIZONTAL;
		modifier.weightx = 10;
		modifier.weighty = 15;
		modifier.gridx = 0;
		modifier.gridy = 0;
		
		createOptionSelectPanel.add(createOptionsToSelect);
		createOptionSelectPanel.add(createOptionSelectButton);
		//gridLayoutPanel.add(createOptionSelectPanel);
		add(createOptionSelectPanel,modifier);
		
		modifier.gridy = 1;
		
		visualizeOptionSelectPanel.add(visualizeOptionsToSelect);
		visualizeOptionSelectPanel.add(visualizeOptionSelectButton);
		//gridLayoutPanel.add(visualizeOptionSelectPanel);
		add(visualizeOptionSelectPanel,modifier);
		
		modifier.gridy = 2;
		
		yieldAdd.add(yieldButton);
		//gridLayoutPanel.add(yieldAdd);
		add(yieldAdd,modifier);
		
		modifier.gridy = 3;
		
		chargeInterest.add(chargeValueText);
		chargeInterest.add(chargeValue);
		chargeInterest.add(chargeInterestButton);
		//gridLayoutPanel.add(chargeInterest);
		add(chargeInterest,modifier);
		
		//add(gridLayoutPanel);
		
		
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent event)
			{
				jsource.setVisible(true);
				//X on close
			}
		});
		
		setVisible(true);
	}
}
