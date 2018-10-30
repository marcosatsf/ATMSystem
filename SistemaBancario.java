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
