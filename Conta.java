package programa;


public abstract class Conta
{
  protected String nomeCorrentista, senha,numeroConta;
  protected double saldo;
  
  public Conta()
  {
		saldo = 0d;
	    senha = "0000";
  }
  public Conta(String nomeCorrentista, String numeroConta)
  {
    this();
    this.setNomeCorrentista(nomeCorrentista);
    this.setNumConta(numeroConta);
  }
  
  public abstract void sacar(double valor) throws ValorInsuficiente;
  
  protected void decSaldo(double saldo)
  {
      this.saldo -= saldo; 
  }
  
  public void depositar(double valor)
  {
      this.saldo += valor;
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
  
  public String printConta() {
    return ("Número conta: " + getNumConta() + "\nNome: " + getNomeCorrentista() + "\nSaldo: R$" + getSaldo());
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
  protected abstract String getTipoConta();
}
