package locadora;

public class Familia extends Classificacao {

  @Override
  Double getValorLocacao(Integer diasAlugado) {
    return diasAlugado * 130.0;
  }

  @Override
  Integer getCodigoDoPreco() {
    return 1;
  }

}
