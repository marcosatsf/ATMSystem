package programa;


public abstract class Conta
{
  private String nomeCorrentista, senha,numeroConta;
  private double saldo;
  
  public Conta()
  {
		saldo = 0d;
	    senha = "0000";
  }
  public Conta(String nomeCorrentista, String numeroConta)
  {
    this();
    this.numeroConta = numeroConta;
    this.nomeCorrentista = nomeCorrentista;
  }
  
  public void sacar(double valor)
  {
      if(valor <= saldo)
      {
          decSaldo(valor);
          System.out.println("Valor sacado: R$ " + valor + "\nSaldo atual: R$ " + getSaldo());          
      }
      else System.out.println("Valor inválido para saque!");
  }
  
  public void decSaldo(double saldo)
  {
      this.saldo -= saldo; 
  }
  
  public void depositar(double valor)
  {
      saldo += valor;
  }
  
  public void setNumConta(String numeroConta) {
    this.numeroConta = numeroConta;
  }
  
  public String getNumConta() {
    return numeroConta;
  }
  
  public void setNomeCorrentista(String nomeCorrTemp) {
    nomeCorrentista = nomeCorrTemp;
  }
  
  public String getNomeCorrentista() {
    return nomeCorrentista;
  }
  
  public double getSaldo() {
    return saldo;
  }
  
  public void printConta() {
    System.out.println("Num. Conta: " + getNumConta() + "\nNome: " + getNomeCorrentista() + "\nSaldo: " + getSaldo());
  }
  
  public void alteraSenha(String senhaAntiga, String senhaNova)
  {
      if(senhaAntiga == senha)
      {
          senha = senhaNova;
          System.out.println("Senha alterada com sucesso!");
      }
      else System.out.println("Senha atual incorreta!");
  }
  public int checaSenha(String senhaAtual)
  {
	  if(senhaAtual.equals(senha)) return 1;
	  else return 0;
  }
}
