package programa;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ClienteJFrame extends JFrame{
	
	public GridLayout gridLayout = new GridLayout(4,1);
	public String[] list = {"img1.png","img2.png"};

	public ClienteJFrame(Dimension dimensaoFrame,JFrame jsource)
	{
		super("Sessão do cliente");
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
		
		//login
		
		JPanel loginPanelFull = new JPanel(new BorderLayout());
		loginPanelFull.setBackground(Color.ORANGE);
		JPanel loginPanel = new JPanel(new SpringLayout());
		loginPanel.setBackground(Color.ORANGE);
		
		TitledBorder borderPrefab1;
		borderPrefab1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefab1.setTitle("Faça o seu login");
		borderPrefab1.setTitleJustification(TitledBorder.CENTER);
		borderPrefab1.setTitlePosition(TitledBorder.CENTER);
		borderPrefab1.setTitleFont(MenuFrame.bankFont);
		loginPanel.setBorder(borderPrefab1);
		
		JLabel loginText = new JLabel("Conta: ");
		loginText.setFont(MenuFrame.bankFont.deriveFont(1, 12));
		
		JTextField conta = new JTextField(10);
		
		JLabel senhaText = new JLabel("Senha: ");
		senhaText.setFont(MenuFrame.bankFont.deriveFont(1, 12));
		
		JTextField senha = new JPasswordField(10);
		
		JButton logar = new JButton("Entrar");
		logar.setPreferredSize(new Dimension(150,30));
		
		logar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				boolean foundAcc=false;
				Conta[] banco = SistemaBancario.getInstanceContaArray();
				for(int i=0; i<SistemaBancario.num; i++)
				{
					if(banco[i].getNumConta().equals(conta.getText()))foundAcc=true;
					if(foundAcc)
					{
						if(banco[i].checaSenha(senha.getText())==1)
						{
							LoginFrame logged = new LoginFrame(dimensaoFrame, ClienteJFrame.this, banco[i]);
							setVisible(false);
							break;
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Verifique as informações digitadas!","Acesso negado",JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
				}
				if(!foundAcc) JOptionPane.showMessageDialog(null,"Esta conta não existe!","Impossível acessar",JOptionPane.ERROR_MESSAGE);
			}
		});	
		
		//aplicar rendimento
		
		JPanel yieldAdd = new JPanel(new FlowLayout());
		yieldAdd.setBackground(Color.ORANGE);
		yieldAdd.setMaximumSize(new Dimension(dimensaoFrame.width-30,160));
		
		TitledBorder borderPrefab3;
		borderPrefab3 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		borderPrefab3.setTitle("Informações");
		borderPrefab3.setTitleFont(MenuFrame.bankFont);
		yieldAdd.setBorder(borderPrefab3);
		
		
		//imagem.setMaximumSize(new Dimension(dimensaoFrame.width-50,150));
		
		/*
		Timer tm = new Timer(2000,new ActionListener() {
		
            @Override
            public void actionPerformed(ActionEvent e) {
            	int x = 0;
                SetImageSize(x, imagem);
                x += 1;
                if(x >= list.length )x = 0; 
            }
            public void SetImageSize(int i, JLabel imagem){
                ImageIcon icon = new ImageIcon(list[i]);
                Image img = icon.getImage();
                Image newImg = img.getScaledInstance(450, 150, Image.SCALE_SMOOTH);
                ImageIcon newImc = new ImageIcon(newImg);
                imagem.setIcon(newImc);
            }
        });*/
		
		//tm.start();
		
		//modifier.fill = GridBagConstraints.HORIZONTAL;
		modifier.weightx = 10;//difference between objects, x
		modifier.weighty = 5;//difference between objects, y
		modifier.gridx = 0;//cell containing object, x
		modifier.gridy = 0;//cell containing object, y
		
		loginPanel.add(loginText,modifier);
		loginPanel.add(conta,modifier);
		loginPanel.add(senhaText,modifier);
		loginPanel.add(senha,modifier);
		//gridLayoutPanel.add(chargeInterest);
		SpringUtilities.makeCompactGrid(loginPanel, 2, 2, 10, 10, 10, 20);//linhas,colunas,xinicial,yinicial,distanciax,distanciay
		loginPanelFull.add(loginPanel, BorderLayout.NORTH);
		loginPanelFull.add(logar, BorderLayout.SOUTH);
		
		add(loginPanelFull,modifier);
		
		modifier.gridy = 1;
		
		//ImageIcon teste = new ImageIcon("img1.png");
		ImageIcon icon = new ImageIcon("img1.png");
		Image img = icon.getImage();
		Icon myImgIcon = new ImageIcon(img);
		JLabel imagem = new JLabel(myImgIcon);
		
		
		yieldAdd.add(imagem);
		//gridLayoutPanel.add(yieldAdd);
		add(yieldAdd,modifier);
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
