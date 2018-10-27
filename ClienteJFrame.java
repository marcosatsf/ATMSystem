package programa;

import javax.swing.*;
import java.awt.*;

public class ClienteJFrame extends JFrame{
	
	public GridLayout gridLayout = new GridLayout(4,1);

	public ClienteJFrame(Dimension dimensaoFrame,JFrame jsource)
	{
		super("Cliente");	
		
		super.setLayout(gridLayout);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(500,500);
		super.setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/2, (dimensaoFrame.height - this.getSize().height)/2);
		
		UIManager.LookAndFeelInfo[] styles = UIManager.getInstalledLookAndFeels();
		try
		{
			UIManager.setLookAndFeel(styles[1].getClassName());
		}
		catch(Exception NotStyle)
		{
			NotStyle.printStackTrace();
		}
		
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
