package programa;

import java.util.Scanner;

public class SistemaBancario {
	private static final int tamanho = 20;
	Scanner input = new Scanner(System.in);
	
	int limite, num=00, subopcao, tentativasSenha, flagNumConta=0, flagConta=0;
    double valorDin;
    float taxa;
    String nomePessoa, senhaTemp, senhaNova, numeroC;
    Conta cliente[] = new Conta[tamanho];
    
    public void menuGerente()
    {
    	do
    	{
	    	 System.out.printf("\n1. Criar nova conta corrente simples;\n2. Criar nova conta corrente especial;\n3. Criar nova conta poupan�a;\n4. Visualizar informa��es de conta;\n5. Incrementar rendimentos;\n6. Realizar a cobran�a de juros\n7. Imprimir informa��es de clientes\nOp��o: ");
	         subopcao = input.nextInt();
	         switch(subopcao)
	         {
	             case 1:
	                 System.out.printf("---Nova conta simples---\nDigite o nome da nova conta: ");
	                 input.nextLine();
	                 nomePessoa = input.nextLine();
	                 if(num < 10) numeroC = "17040" + Integer.toString(num);
	                 else numeroC = "1704" + Integer.toString(num);
	                 cliente[num] = new ContaSimples(nomePessoa, numeroC);
	                 System.out.println("Conta Simples criada com sucesso!");
	                 num++;
	                 break;
	             case 2:
	                 System.out.printf("---Nova conta especial---\nDigite o nome da nova conta: ");
	                 input.nextLine();
	                 nomePessoa = input.nextLine();
	                 if(num < 10) numeroC = "17040" + Integer.toString(num);
	                 else numeroC = "1704" + Integer.toString(num);
	                 System.out.printf("Digite o limite estipulado: ");
	                 limite = input.nextInt();
	                 cliente[num] = new ContaEspecial(nomePessoa, numeroC, limite);
	                 System.out.println("Conta Especial criada com sucesso!");
	                 num++;
	                 break;
	             case 3:
	                 System.out.printf("---Nova conta poupan�a---\nDigite o nome da nova conta: ");
	                 input.nextLine();
	                 nomePessoa = input.nextLine();
	                 if(num < 10) numeroC = "17040" + Integer.toString(num);
	                 else numeroC = "1704" + Integer.toString(num);
	                 System.out.printf("Digite a taxa de juros da conta: ");
	                 taxa = input.nextFloat();
	                 cliente[num] = new ContaPoupanca(nomePessoa, numeroC, taxa);
	                 System.out.println("Conta Poupan�a criada com sucesso!");
	                 num++;
	                 break;
	             case 4:
	                 System.out.printf("Insira o n�mero da conta que deseja visualizar: ");
	                 input.nextLine();
	                 numeroC = input.nextLine();
	                 for(int i=0; i < num; i++)
	                 {
	                     if(cliente[i].getNumConta() == numeroC)
	                     {
	                         cliente[i].printConta();
	                         flagNumConta = -1;
	                         break;
	                     }
	                 }
	                 if(flagNumConta != -1) System.out.println("N�o existe este n�mero de conta!\n");
	                 flagNumConta = 0;
	                 break;
	             case 5:
	             	for(int j=0;j< num;j++)
	             		if(cliente[j] instanceof ContaPoupanca) ((ContaPoupanca)cliente[j]).aplicaRendimento();
	             	break;
	             case 6:
	             	System.out.printf("Insira o n�mero da taxa que deseja cobrar: ");
	             	taxa = input.nextFloat();
	             	for(int j=0;j< num;j++)
	             		if(cliente[j] instanceof ContaEspecial) ((ContaEspecial)cliente[j]).cobrancaJuros(taxa);
	             	break;
	             case 7:
	             	for(int j=0;j< num;j++) cliente[j].printConta();
	             	break;
	             case 0:
	            	 break;
	         }
    	}while(subopcao!=0);
    }
    
    public void menuCliente()
    {
    	do
    	{
        	System.out.println("Insira o n�mero da conta que deseja acessar: ");
            input.nextLine(); 
            numeroC = input.nextLine();
        	for(int i=0; i<num; i++) if(cliente[i].getNumConta().equals(numeroC)) flagConta=1;
        	if(!flagConta)
        	{
        		System.out.println("N�o existe tal n�mero de conta!");
        		break;
        	}
        	flagConta=0, tentativasSenha = 3;
	        for(int j=0;j<num;j++)
	        {
	            if(cliente[j].getNumConta().equals(numeroC))
	            {
	            	input.nextLine();
	            	for(tentativasSenha = 3; tentativasSenha > 0; tentativasSenha--)
	            	{
	                    System.out.printf("Insira sua senha de quatro d�gitos (" + tentativasSenha +  " tentativa(s) restante(s)): ");			                            
	                    senhaTemp = input.nextLine();
	                    if(cliente[j].checaSenha(senhaTemp) == 1)
	                    {
	                        do 
	                        {
	                        	System.out.printf("\nO que deseja fazer agora, " + cliente[j].getNomeCorrentista() + "?\n1.Realizar saque\n2.Realizar dep�sito\n3.Visualizar informa��es da conta\n4. Alterar senha\n5. Sair\nOp��o: ");
	                            subopcao = input.nextInt();
	                            switch(subopcao)
	                            {
	                                  case 1:
	                                	  System.out.printf("Insira o valor que deseja sacar: ");
	                                	  valorDin = input.nextDouble();
	                                      cliente[j].sacar(valorDin);
	                                      break;
	                                  case 2:
	                                	  System.out.printf("Insira o valor que deseja depositar: ");
	                                	  valorDin = input.nextDouble();
	                                      cliente[j].depositar(valorDin);
	                                      System.out.println("Dep�sito realizado com sucesso!\nSaldo atual: R$ " +  cliente[j].getSaldo());
	                                      break;
	                                  case 3:
	                                	  cliente[j].printConta();
	                                	  break;
	                                  case 4:
	                                	  System.out.printf("Digite a senha atual: ");
	                                	  input.nextLine();
	                                	  senhaTemp = input.nextLine();
	                                	  System.out.printf("Digite a nova senha: ");
	                                	  senhaNova = input.nextLine();
	                                	  cliente[j].alteraSenha(senhaTemp, senhaNova);
	                                	  break;
	                                  case 5:
	                                	  break;
	                            }
	                        }while(subopcao != 5);
	                        break;
	                    }
	                    else
	                	{
	                    	if(tentativasSenha > 1) System.out.println("Senha incorreta! Tente novamente...");
	                    	else System.out.println("N�mero de tentativas foram excedidas! ");
	                    	
	                	}
	            	}
	            	break;
	            }
	        }
    	}while(!flagConta);
    }
	
}