package programa;

public class SistemaBancario {
	public static final int tamanho = 20;
	public static boolean hasCP=false,hasCE=false;
	
    private static Conta bancoDadosCliente[]=null;
    protected static int num=00;
    
    private SistemaBancario(){    	
    }
    
    public static void aplicarRend()
    {
    	for(int j=0;j< num;j++) if(bancoDadosCliente[j] instanceof ContaPoupanca) ((ContaPoupanca)bancoDadosCliente[j]).aplicaRendimento();
    }
    
    public static void cobrarJuros(float taxa) {
		// TODO Auto-generated method stub
    	for(int j=0;j< num;j++) if(bancoDadosCliente[j] instanceof ContaEspecial) ((ContaEspecial)bancoDadosCliente[j]).cobrancaJuros(taxa);
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
