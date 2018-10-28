package programa;

import java.util.Scanner;

public class SistemaBancario {
	public static final int tamanho = 20;
	private Scanner input = new Scanner(System.in);
	public static boolean hasCP=false,hasCE=false;
	
	private int subopcao, tentativasSenha, flagConta=0;
	private boolean loop=false;
    private double valorDin;
    private String senhaTemp, senhaNova, numeroC;
    private static Conta bancoDadosCliente[]=null;
    protected static int num=00;
    
    private SistemaBancario()
    {
    	
    }
    
    public void menuCliente()
    {
    	do
    	{
        	System.out.println("Insira o número da conta que deseja acessar: ");
            input.nextLine(); 
            numeroC = input.nextLine();
            flagConta=0;
        	for(int i=0; i<num; i++) if(bancoDadosCliente[i].getNumConta().equals(numeroC)) flagConta=1;
        	if(flagConta==0)
        	{
        		System.out.println("Não existe tal número de conta!\n");
        		break;
        	}
        	tentativasSenha = 3;
	        for(int j=0;j<num;j++)
	        {
	            if(bancoDadosCliente[j].getNumConta().equals(numeroC))
	            {
	            	input.nextLine();
	            	for(tentativasSenha = 3; tentativasSenha > 0; tentativasSenha--)
	            	{
	                    System.out.printf("Insira sua senha de quatro dígitos (" + tentativasSenha +  " tentativa(s) restante(s)): ");			                            
	                    senhaTemp = input.nextLine();
	                    if(bancoDadosCliente[j].checaSenha(senhaTemp) == 1)
	                    {
	                        do 
	                        {
	                        	System.out.printf("\nO que deseja fazer agora, " + bancoDadosCliente[j].getNomeCorrentista() + "?\n1.Realizar saque\n2.Realizar depósito\n3.Visualizar informações da conta\n4. Alterar senha\n0. Sair\nOpção: ");
	                            subopcao = input.nextInt();
	                            switch(subopcao)
	                            {
	                                  case 1:
	                                	  do
	                                	  {
	                                	  System.out.printf("Insira o valor que deseja sacar: ");
	                                	  valorDin = input.nextDouble();
											try {
												bancoDadosCliente[j].sacar(valorDin);
												loop=false;
											} catch (ValorInsuficiente e) {
												// TODO Auto-generated catch block
												System.err.println("Exception: " + e);
												e.printStackTrace();
												System.out.println("Valor insuficiente!");
												input.nextLine();
												loop=true;
											}
	                                	  }while(loop);
	                                      break;
	                                  case 2:
	                                	  System.out.printf("Insira o valor que deseja depositar: ");
	                                	  valorDin = input.nextDouble();
	                                      bancoDadosCliente[j].depositar(valorDin);
	                                      System.out.println("Depósito realizado com sucesso!\nSaldo atual: R$ " +  bancoDadosCliente[j].getSaldo());
	                                      break;
	                                  case 3:
	                                	  bancoDadosCliente[j].printConta();
	                                	  break;
	                                  case 4:
	                                	  System.out.printf("Digite a senha atual: ");
	                                	  input.nextLine();
	                                	  senhaTemp = input.nextLine();
	                                	  System.out.printf("Digite a nova senha: ");
	                                	  senhaNova = input.nextLine();
	                                	  bancoDadosCliente[j].alteraSenha(senhaTemp, senhaNova);
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
    public static void aplicarRend()
    {
    	for(int j=0;j< num;j++) if(bancoDadosCliente[j] instanceof ContaPoupanca) ((ContaPoupanca)bancoDadosCliente[j]).aplicaRendimento();
    }
    
    public static void cobrarJuros(float taxa) {
		// TODO Auto-generated method stub
    	for(int j=0;j< num;j++) if(bancoDadosCliente[j] instanceof ContaEspecial) ((ContaEspecial)bancoDadosCliente[j]).cobrancaJuros(taxa);
	}
    
    public static void setContaSimples(String nomePessoa)
    {
    	Conta[] banco = getInstanceContaArray();
    	banco[num] = new ContaSimples(nomePessoa, getNumConta());
        num++;
    }
    
    public static void setContaPoupança(String nomePessoa, float taxa)
    {
    	Conta[] banco = getInstanceContaArray();
    	banco[num] = new ContaPoupanca(nomePessoa, getNumConta(), taxa);
    	hasCP=true;
        num++;
    }
    
    public static void setContaEspecial(String nomePessoa, int limite)
    {
    	Conta[] banco = getInstanceContaArray();
    	banco[num] = new ContaEspecial(nomePessoa, getNumConta(), limite);
    	hasCE=true;
        num++;
    }
    
    public static String getNumConta()
    {
    	if(num < 10) return ("17040" + Integer.toString(num));
        else return ("1704" + Integer.toString(num));
    }
    
    public static Conta[] getInstanceContaArray()
    {
    	if(bancoDadosCliente==null)	bancoDadosCliente = new Conta[tamanho];
    	return bancoDadosCliente;
    }
}
