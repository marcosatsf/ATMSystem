package programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class ProgressoOperacao extends JFrame{

	public SwingWorker teste;
	public JProgressBar operando;
	public JLabel opText;
	public JButton confirm;
	public int tempo;
	
	public ProgressoOperacao(String opIndicativo, double valor,Dimension dimensaoFrame, JTextArea infoConta, Conta account) {
		// TODO Auto-generated constructor stub
		setSize(300, 150);
		setLayout(new GridLayout(3,1));
		setBackground(Color.ORANGE);
		
		this.setLocation((dimensaoFrame.width - this.getSize().width)/3, (dimensaoFrame.height - this.getSize().height)/2);
		
		operando = new JProgressBar();
		operando.setStringPainted(true);
		operando.setValue(0);
		operando.setSize(new Dimension(150, 30));
		opText = new JLabel("Foi " + opIndicativo + " R$ " + valor);
		opText.setFont(MenuFrame.bankFont);
		opText.setHorizontalAlignment(SwingConstants.CENTER);
		opText.setVisible(false);
		
		confirm = new JButton("Confirmar");
		confirm.setEnabled(false);
		
		add(opText);
		add(operando);
		add(confirm);
		
		tempo = 20;
		
		teste = new SwingWorker()
		{
			String texto = opText.getText();
			@Override
			protected Object doInBackground() throws Exception {
				// TODO Auto-generated method stub
				infoConta.setText("----Em processo de atualização----");
				for (int i = 1; i <= 100; i++) {
			           try
			           {
			        	   operando.setValue(i);
			        	   operando.setString(i + "%");
			               Thread.sleep(tempo);
			           } 
			           catch (InterruptedException e){
			        	   System.err.println(e);
			               e.printStackTrace();
			           }
			        }
				confirm.setEnabled(true);
				opText.setVisible(true);
				return null;
			}
	
		};
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				infoConta.setEnabled(true);
				infoConta.setText(account.printConta());
				dispose();
			}
		});
		
		setVisible(true);
	}
}
