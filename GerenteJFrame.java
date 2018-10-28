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

	
	public GerenteJFrame(Dimension dimensaoFrame,JFrame jsource)
	{
		super("Gerente");
		URL iconURL = getClass().getResource("iconMB.png");
		ImageIcon iconFrame = new ImageIcon(iconURL);
		super.setIconImage(iconFrame.getImage());
		super.setLayout(new FlowLayout());
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(500,500);
		super.setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		JPanel gridLayoutPanel = new JPanel(new GridLayout(4,1));
		
		
		JPanel createOptionSelectPanel = new JPanel(new FlowLayout());
		createOptionSelectPanel.setBackground(Color.ORANGE);
		createOptionSelectPanel.setMaximumSize(new Dimension(dimensaoFrame.width,40));
		
		TitledBorder createOptionSelectTitle;
		createOptionSelectTitle = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),"Criação de contas:");
		createOptionSelectTitle.setTitleFont(MenuFrame.bankFont);
		createOptionSelectPanel.setBorder(createOptionSelectTitle);
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
		
		
		
		JPanel visualizeOptionSelectPanel = new JPanel(new FlowLayout());
		visualizeOptionSelectPanel.setBackground(Color.ORANGE);
		visualizeOptionSelectPanel.setMaximumSize(new Dimension(dimensaoFrame.width,40));
		
		TitledBorder visualizeOptionSelectTitle;
		visualizeOptionSelectTitle = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),"Visualizar contas:");
		visualizeOptionSelectTitle.setTitleFont(MenuFrame.bankFont);
		visualizeOptionSelectPanel.setBorder(visualizeOptionSelectTitle);
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
		/*visualizeOptionsToSelect.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							
						}
					}
				}
				);
		
		*/
		
		
		createOptionSelectPanel.add(createOptionsToSelect);
		createOptionSelectPanel.add(createOptionSelectButton);
		gridLayoutPanel.add(createOptionSelectPanel);
		
		visualizeOptionSelectPanel.add(visualizeOptionsToSelect);
		visualizeOptionSelectPanel.add(visualizeOptionSelectButton);
		gridLayoutPanel.add(visualizeOptionSelectPanel);
		
		add(gridLayoutPanel);
		
		
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
