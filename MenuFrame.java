package programa;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class MenuFrame extends JFrame{
	
	public Font bankFont;

	public MenuFrame(){
		super("Banco MBank");
		getContentPane().setLayout(null);
		GerenteJFrame subGerente = new GerenteJFrame();
		ClienteJFrame subCliente = new ClienteJFrame();
		

		//BufferedImage image;
		//image = ImageIO.read(new File("mbank.gif"));
		//Icon icon = new ImageIcon(image);
		URL url = this.getClass().getResource("mbank.gif");
		Icon myImgIcon = new ImageIcon(url);
		JLabel imageLbl = new JLabel(myImgIcon);
		imageLbl.setBounds(50, 30, 400, 100);
		add(imageLbl);
		
		//JLabel animatedGIF = new JLabel(new ImageIcon("mbank.gif"));
		//animatedGIF.setBounds(100,300,400,120);
		//add(animatedGIF);
		
		JLabel frontText = new JLabel("Bem-Vindo ao seu banco!");
		JLabel auxText = new JLabel("Escolha uma das opções abaixo: ");
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(500,500);
		super.setVisible(true);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
				
		bankFont = new Font("Trebuchet MS", Font.BOLD, 10);
		
		frontText.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		auxText.setFont(bankFont);
		frontText.setBounds(100,150,300,50);
		frontText.setHorizontalAlignment(SwingConstants.CENTER);
		
		auxText.setBounds(100,200,300,50);
		auxText.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(frontText);
		add(auxText);
		
		Button gerente = new Button("Gerente");
		Button cliente = new Button("Cliente");
		
		gerente.setBounds(200,250,100,50);
		cliente.setBounds(200,330,100,50);
		
		add(gerente);
		add(cliente);
		
		getContentPane().setBackground(Color.ORANGE);

		
		gerente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				subGerente.setSize(500,500);
				subGerente.setVisible(true);
				subGerente.setLocationRelativeTo(frontText);
				setVisible(false);
				//dispose();
			}
		});
		
		cliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				subCliente.setSize(500,500);
				subCliente.setVisible(true);
				subCliente.setLocationRelativeTo(frontText);
				setVisible(false);
				//dispose();
			}
		});
		//pack();
	}

}
