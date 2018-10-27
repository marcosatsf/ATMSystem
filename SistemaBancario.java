package programa;

import java.util.Scanner;

public class SistemaBancario {
	private static final int tamanho = 20;
	private Scanner input = new Scanner(System.in);
	
	private int limite, subopcao, tentativasSenha, flagNumConta=0, flagConta=0;
    private double valorDin;
    private float taxa;
    private String nomePessoa, senhaTemp, senhaNova, numeroC;
    protected static Conta cliente[];
    protected static int num=00;
    
    public void menuGerente()
    {
    	do
    	{
	    	 System.out.printf("\n1. Criar nova conta corrente simples;\n2. Criar nova conta corrente especial;\n3. Criar nova conta poupança;\n4. Visualizar informações de conta;\n5. Incrementar rendimentos;\n6. Realizar a cobrança de juros;\n7. Imprimir informações de clientes;\n0. Voltar\nOpção: ");
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
	                 System.out.printf("---Nova conta poupança---\nDigite o nome da nova conta: ");
	                 input.nextLine();
	                 nomePessoa = input.nextLine();
	                 if(num < 10) numeroC = "17040" + Integer.toString(num);
	                 else numeroC = "1704" + Integer.toString(num);
	                 System.out.printf("Digite a taxa de juros da conta: ");
	                 taxa = input.nextFloat();
	                 cliente[num] = new ContaPoupanca(nomePessoa, numeroC, taxa);
	                 System.out.println("Conta Poupança criada com sucesso!");
	                 num++;
	                 break;
	             case 4:
	                 System.out.printf("Insira o número da conta que deseja visualizar: ");
	                 input.nextLine();
	                 numeroC = input.nextLine();
	                 for(int i=0; i < num; i++)
	                 {
	                     if(cliente[i].getNumConta().equals(numeroC))
	                     {
	                         cliente[i].printConta();
	                         flagNumConta = -1;
	                         break;
	                     }
	                 }
	                 if(flagNumConta != -1) System.out.println("Não existe este número de conta!\n");
	                 flagNumConta = 0;
	                 break;
	             case 5:
	             	for(int j=0;j< num;j++)
	             		if(cliente[j] instanceof ContaPoupanca) ((ContaPoupanca)cliente[j]).aplicaRendimento();
	             	System.out.println("Foram aplicados os rendimentos em todas as contas poupanças existentes!");
	             	break;
	             case 6:
	             	System.out.printf("Insira o número da taxa que deseja cobrar: ");
	             	taxa = input.nextFloat();
	             	for(int j=0;j< num;j++)
	             		if(cliente[j] instanceof ContaEspecial) ((ContaEspecial)cliente[j]).cobrancaJuros(taxa);
	             	System.out.println("Foram aplicados os juros definidos em todas as contas especiais existentes!");
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
        	System.out.println("Insira o número da conta que deseja acessar: ");
            input.nextLine(); 
            numeroC = input.nextLine();
            flagConta=0;
        	for(int i=0; i<num; i++) if(cliente[i].getNumConta().equals(numeroC)) flagConta=1;
        	if(flagConta==0)
        	{
        		System.out.println("Não existe tal número de conta!\n");
        		break;
        	}
        	tentativasSenha = 3;
	        for(int j=0;j<num;j++)
	        {
	            if(cliente[j].getNumConta().equals(numeroC))
	            {
	            	input.nextLine();
	            	for(tentativasSenha = 3; tentativasSenha > 0; tentativasSenha--)
	            	{
	                    System.out.printf("Insira sua senha de quatro dígitos (" + tentativasSenha +  " tentativa(s) restante(s)): ");			                            
	                    senhaTemp = input.nextLine();
	                    if(cliente[j].checaSenha(senhaTemp) == 1)
	                    {
	                        do 
	                        {
	                        	System.out.printf("\nO que deseja fazer agora, " + cliente[j].getNomeCorrentista() + "?\n1.Realizar saque\n2.Realizar depósito\n3.Visualizar informações da conta\n4. Alterar senha\n0. Sair\nOpção: ");
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
	                                      System.out.println("Depósito realizado com sucesso!\nSaldo atual: R$ " +  cliente[j].getSaldo());
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
	                                  case 0:
	                                	  break;
	                            }
	                        }while(subopcao != 0);
	                        break;
	                    }
	                    else
	                	{
	                    	if(tentativasSenha > 1) System.out.println("Senha incorreta! Tente novamente...");
	                    	else System.out.println("Número de tentativas foram excedidas! ");
	                    	
	                	}
	            	}
	            	break;
	            }
	        }
    	}while(flagConta==0);
    }
    
    public void setContaSimples(String nomePessoa)
    {
        
        cliente[num] = new ContaSimples(nomePessoa, numeroC);
        //System.out.println("Conta Simples criada com sucesso!");
        num++;
    }
    
    public static String getNumConta()
    {
    	if(num < 10) return ("17040" + Integer.toString(num));
        else return ("1704" + Integer.toString(num));
    }
    
    public static Conta[] getInstanceContaArray()
    {
    	if(cliente==null)
    	{
    		return new Conta[tamanho];
    	}
    	else return cliente;
    }
}
