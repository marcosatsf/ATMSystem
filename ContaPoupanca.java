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
public class ContaPoupanca extends Conta{
	private float taxaJuros;
    
    public ContaPoupanca(String nomeCorrentista, String numeroConta, float taxaJuros)
    {
        super(nomeCorrentista,numeroConta);
        setTaxaJuros(taxaJuros);
    }
    
    @Override
    public void sacar(double valor) throws ValorInsuficiente
    {
  	  if(valor <= getSaldo())
  	  {
  	      decSaldo(valor);
  	      System.out.println("Valor sacado: R$ " + valor + "\nSaldo atual: R$ " + getSaldo());          
  	  }
  	  else throw new ValorInsuficiente();
    }
    
    private void setTaxaJuros(float taxaJuros)
    {
        this.taxaJuros = taxaJuros;
    }
    
    public float getTaxaJuros()
    {
    	return taxaJuros;
    }
    
    public String printConta() 
    {
        return ("Tipo da conta: Poupança\n" + super.printConta() + "\nTaxa de Juros: " + getTaxaJuros() + "\n");
    }
    public void aplicaRendimento()
    {
    	double saldoTemp = getSaldo();
    	saldoTemp *= (getTaxaJuros()/100);
    	depositar(saldoTemp);
    }
    @Override
	protected String getTipoConta() {
		// TODO Auto-generated method stub
		return "Conta Poupança";
	}
}
