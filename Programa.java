package programa;

import java.util.Scanner;
import javax.swing.*;

public class Programa {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		SistemaBancario menu = new SistemaBancario();
		
	    int opcao=0;
	    
	    MenuFrame programFrame = new MenuFrame();
	    
	    do
	    {
			opcao = input.nextInt();
			switch(opcao)
			{
			    case 1:
	                menu.menuGerente();		                
	                break;
	            case 2:
	            	menu.menuCliente();
	            	break;
	            default:
	            	break;
			}
	    }while(0 < opcao && opcao < 3);
	    input.close();
	}
}
