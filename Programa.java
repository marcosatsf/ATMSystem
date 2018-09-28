package programa;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
	      
	    int opcao=0;
	      
	    do
	    {
	        System.out.println("\n-----Bem-vindo ao MBank-----\n1. Gerente\n2. Cliente\n");
			opcao = input.nextInt();
			switch(opcao)
			{
			    case 1:
	                menuGerente();		                
	                break;
	            case 2:
	            	menuCliente();
	            	break;
			}
	    }while(0 < opcao && opcao < 3);
	    input.close();
	}
}
