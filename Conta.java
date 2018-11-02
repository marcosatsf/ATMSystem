package programa;

import java.awt.Color;
import java.text.DecimalFormat;

public abstract class Conta
{
  protected String nomeCorrentista, senha,numeroConta;
  private double saldo;
  private Color cor, auxcor;
  
  public Conta()
  {
		saldo = 0d;
	    senha = "0000";
	    setCor(Color.ORANGE);
	    setAuxcor(new Color(186, 138, 82));
  }
  public Conta(String nomeCorrentista, String numeroConta)
  {
    this();
    this.setNomeCorrentista(nomeCorrentista);
    this.setNumConta(numeroConta);
  }
  
  public abstract void sacar(double valor) throws ValorInsuficiente;
  
  public Color getCor() {
	return cor;
}
public void setCor(Color cor) {
	this.cor = cor;
}
public Color getAuxcor() {
	return auxcor;
}
public void setAuxcor(Color auxcor) {
	this.auxcor = auxcor;
}
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
    return ("Número conta: " + getNumConta() + "\nNome: " + getNomeCorrentista() + "\nSaldo: R$" + String.format("%.2f", getSaldo()));
  }
  
  public void alteraSenha(String senhaAntiga, String senhaNova) throws NotTheSamePassword
  {
      if(senhaAntiga.equals(senha)) senha = senhaNova;
      else throw new NotTheSamePassword();
  }
  public int checaSenha(String senhaAtual)
  {
	  if(senhaAtual.equals(senha)) return 1;
	  else return 0;
  }
  protected abstract String getTipoConta();
}
