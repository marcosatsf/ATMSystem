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
    
    private void setTaxaJuros(float taxaJuros)
    {
        this.taxaJuros = taxaJuros;
    }
    
    private float getTaxaJuros()
    {
    	return taxaJuros;
    }
    
    public void printConta() 
    {
        System.out.printf("-----Infos da Conta------\nTipo de Conta: Conta Poupança\n");
        super.printConta();
        System.out.println("Taxa de Juros: " + getTaxaJuros());
    }
    public void aplicaRendimento()
    {
    	double saldoTemp = getSaldo();
    	saldoTemp *= (getTaxaJuros()/100);
    	depositar(saldoTemp);
    }
}
