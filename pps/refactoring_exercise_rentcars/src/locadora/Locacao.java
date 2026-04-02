package locadora;

public class Locacao {
  private Alugavel alugavel;
  private int diasAlugado;

  public Locacao(Alugavel alugavel, int diasAlugado) {
    this.alugavel = alugavel;
    this.diasAlugado = diasAlugado;
  }

  public Alugavel getCarro() {
    return alugavel;
  }

  public int getDiasAlugado() {
    return diasAlugado;
  }

  public Double getValor() {
    return this.getCarro().getValorLocacao(diasAlugado);
  }

  public Integer getPontosAlugadorFrequente() {
    return this.getCarro().getPontosAlugadorFrequente(diasAlugado);
  }
}
