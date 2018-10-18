package programa;

import javax.swing.*;
import java.awt.*;

public class ClienteJFrame extends JFrame{

	public ClienteJFrame()
	{
		super("Cliente");	
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(500,500);
		super.setVisible(true);
		super.setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
	}
}
