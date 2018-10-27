package programa;

import java.util.Scanner;
import javax.swing.*;

public class Programa {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		SistemaBancario menu = new SistemaBancario();
		
	    int opcao=0;
	    
	    MenuFrame programFrame = MenuFrame.getMenuFrame();
	    
	    do
	    {
	        System.out.println("\n-----Bem-vindo ao MBank-----\n1. Gerente\n2. Cliente\n");
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
