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
    private int getLimite()
    {
    	return limite;
    }
    @Override
    public void sacar(double valor)
    {
      if(valor <= (getSaldo() + limite))
      {
          decSaldo(valor);
          System.out.println("Valor sacado: R$ " + valor + "\nSaldo atual: R$ " + getSaldo());          
      }
      else System.out.println("Valor inválido para saque!");
    }
    public void printConta() 
    {
        System.out.printf("-----Infos da Conta------\nTipo de Conta: Conta Especial\n");
        super.printConta();
        System.out.println("Limite: " + getLimite());
    }
    public void cobrancaJuros(float quantJuros)
    {
    	double saldoCobranca = getSaldo();
    	if(saldoCobranca < 0)
    	{
    		saldoCobranca *= (quantJuros/100);
    		decSaldo(saldoCobranca);
    	}
    }
}
