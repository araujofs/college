package locadora;

public abstract class Classificacao {

  abstract Double getValorLocacao(Integer diasAlugado);

  Integer getPontosAlugadorFrequente(Integer diasAlugado) {
    return 1;
  }

  abstract Integer getCodigoDoPreco();
}
