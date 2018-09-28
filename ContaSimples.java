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
}
