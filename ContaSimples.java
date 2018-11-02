package programa;



public class ContaSimples extends Conta
{  
  public ContaSimples(String nomeCorrentista, String numeroConta)
  {
    super(nomeCorrentista,numeroConta);
  }
  public String printConta() {
	  return ("Tipo da conta: Simples\n"+  super.printConta());
  }
  @Override
  public void sacar(double valor) throws ValorInsuficiente
  {
	  if(valor <= getSaldo()) decSaldo(valor);
	  else throw new ValorInsuficiente();
  }
@Override
	protected String getTipoConta() {
		// TODO Auto-generated method stub
		return "Conta Simples";
	}
}
