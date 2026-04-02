package locadora;

public interface Alugavel {
  public String getDescricao();

  public Integer getAno();

  public Double getValorLocacao(Integer diasAlugado);

  public Integer getPontosAlugadorFrequente(Integer diasAlugado);
}
