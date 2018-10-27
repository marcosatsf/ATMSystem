package programa;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GerenteJFrame extends JFrame{
	
	private JComboBox createOptionsToSelect, visualizeOptionsToSelect;
	private final String[] createOptions = {"Conta Simples","Conta Especial","Conta Poupança"};
	private final String[] visualizeOptions = {"Visualizar uma conta do sistema","Visualizar todas as contas do sistema"};
	
	public GerenteJFrame(Dimension dimensaoFrame,JFrame jsource)
	{
		super("Gerente");
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
				InstaciaContaFrame aux = new InstaciaContaFrame(GerenteJFrame.this.createOptionsToSelect.getSelectedItem().toString(), dimensaoFrame, GerenteJFrame.this);
				/*
				option.replaceAll("\\s+","");
				try {
					Object xyz = Class.forName(option).newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
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
				String option = GerenteJFrame.this.createOptionsToSelect.getSelectedItem().toString();
				
				
				
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
