/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 *
 * @author 17042284
 */
public class ContaEspecial extends Conta
{
    private int limite;
    
    public ContaEspecial(String nomeCorrentista, String numeroConta, int limite)
    {
        super(nomeCorrentista,numeroConta);
        setLimite(limite);
    }
    
    private void setLimite(int limite)
    {
        this.limite = limite;
    }
    
    public int getLimite()
    {
    	return limite;
    }
    
    @Override
    public void sacar(double valor) throws ValorInsuficiente
    {
      if(valor <= (getSaldo() + limite))
      {
          decSaldo(valor);
          System.out.println("Valor sacado: R$ " + valor + "\nSaldo atual: R$ " + getSaldo());          
      }
      else throw new ValorInsuficiente();
    }
    
    public String printConta() 
    {
        return ("Tipo da conta: Especial\n" + super.printConta() + "\nLimite: R$ " + getLimite() + "\n");
    }
    
    public void cobrancaJuros(float quantJuros)
    {
    	double saldoCobranca = getSaldo();
    	if(saldoCobranca < 0)
    	{
    		saldoCobranca *= -(quantJuros/100.0);
    		decSaldo(saldoCobranca);
    	}
    }
    @Override
	protected String getTipoConta() {
		// TODO Auto-generated method stub
		return "Conta Especial";
	}
}
