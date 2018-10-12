package programa;



public class ContaSimples extends Conta
{  
  public ContaSimples(String nomeCorrentista, String numeroConta)
  {
    super(nomeCorrentista,numeroConta);
  }
  public void printConta() {
    System.out.printf("-----Infos da Conta------\nTipo de Conta: Conta Simples\n");
    super.printConta();
  }
  @Override
  public void sacar(double valor)
  {
	  if(valor <= getSaldo())
	  {
	      decSaldo(valor);
	      System.out.println("Valor sacado: R$ " + valor + "\nSaldo atual: R$ " + getSaldo());          
	  }
	  else System.out.println("Valor inválido para saque!");
  }
}
